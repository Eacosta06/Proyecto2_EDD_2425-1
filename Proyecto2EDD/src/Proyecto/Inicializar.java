/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import com.google.gson.*;
import java.util.Set;
import Estructuras.*;

/**
 *
 * @author esteacosta
 * 
 * En este archivo se encuentra el algoritmo de inicialización
 * que lee el archivo JSON con la librería GSON de Google
 * para convertirlo en el árbol genealógico.
 */
public class Inicializar {

    Lista weds;

    public Inicializar() {
    }
    
    /*public void NodosHijos(Nodo hijo_izq, String padre, String wed){
        Nodo aux = hijo_izq;
        while (aux != null){
            String name;
            name = this.Generacion(aux);
            Edge borde = grafo.addEdge(name+" & "+padre, padre, name);
            if (wed != null){
                Edge borde2 = grafo.addEdge(name+" & "+wed, wed, name);
            }
        }
    }*/
    
    public String Generacion(Nodo persona){
        String generacion = null;
        String ohn = persona.gettInfo().getOhn();
        String nombre = persona.gettInfo().getNombre();
        if (ohn.contains("First")){
            generacion = nombre;
        } else if (ohn.contains("Second")){
            generacion = nombre+" II";
        } else if (ohn.contains("Third")){
            generacion = nombre+" III";
        } else {
            generacion = nombre+" IV";
        }
        return generacion;
    }
    
    public NodoLista BuscarLista(String wed){
        NodoLista aux;
        aux = this.weds.getPrimero();
        boolean encontrado = false;
        while (aux != null && !encontrado){
            if (aux.getDatos().contains(wed)) {
                encontrado = true;
            } else {
                aux = aux.getPnext();
            }
        }
        return aux;
    }
    
    public void Iniciar(String JsonString){
        
        //Se crea la instancia de la librería Gson de Google
        Gson gson = new Gson();
        
        JsonElement json = gson.fromJson(JsonString, JsonElement.class);
        JsonObject iterable = json.getAsJsonObject();

        //Se hace una lista de las casas. En este caso sería solo una
        Set<String> casas = iterable.keySet();
        
        for (String casa : casas){
            
            //Se crea el el árbol genealógico vacío
            InterfazSeleccion.arbol = new Arbol();
            InterfazSeleccion.arbol.setNombre(casa);
            
            //Se crea la lista de parejas. Estas no pueden ser accedidas desde
            //el árbol genealógico por limitaciones de la estructura
            this.weds = new Lista();
            
            //Se debe crear un nuevo grafo
            //System.setProperty("org.graphstream.ui", "swing");
            //grafo = new MultiGraph(casa);
            
            JsonElement Json_nombres = iterable.get(casa);
            JsonArray l_nombres = Json_nombres.getAsJsonArray();
            
            for (int i = 0; i < l_nombres.size(); i++){
                
                JsonObject Datos = l_nombres.get(i).getAsJsonObject();
                Set<String> personas = Datos.keySet();
                
                for (String nombre : personas){
                    
                    Nodo Nperson;
                    
                    // Obtiene la lista json de datos de la persona y la
                    // convierte a un array
                    JsonElement Json_datos = Datos.get(nombre);
                    JsonArray l_datos = Json_datos.getAsJsonArray();
                    
                    //Se declaran los String de los datos de la persona
                    String ohn = "×";
                    String bt = "×";
                    String kta = "×";
                    String ht = "×";
                    String wt = "×";
                    String oe = "×";
                    String of = "×";
                    String Notas = "×";
                    String Destino = "×";
                    Nodo bornto = null;
                    Nodo hijo_izq = null;
                    NodoLista wed;
                    
                    //Se recorren todos los datos de la persona
                    for (int j = 0; j < l_datos.size(); j++){
                        
                        JsonObject Propiedades = l_datos.get(j).getAsJsonObject();
                        Set<String> properties = Propiedades.keySet();
                        
                        //Se obtienen los datos usando las llaves y se asignan
                        for (String dato : properties){
                            
                            //Se obtienen los datos del JsonObject y se
                            //establecen a las variables declaradas
                            if (dato.equals("Of his name")){
                                ohn = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Born to")){
                                bt = Propiedades.get(dato).getAsString();
                                //Se comprueba que se conozca el padre
                                
                                if (!bt.equals("[Unknown]")){
                                    //Se separa el string obtenido en un array
                                    /*
                                    String[] l = bt.split(", ");
                                    //Se separa el string 2
                                    String[] Gen = l[1].split(" ");
                                    bornto = this.arbol.buscarYretornar(l[0], Gen[0], 1);
                                    if (bornto == null){
                                        bornto = this.arbol.buscarYretornar(l[0], Gen[0], 2);
                                    }
                                    */
                                }
                                
                            } else if (dato.equals("Known throughout as")){
                                kta = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Held title")){
                                ht = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Wed to")){
                                wt = Propiedades.get(dato).getAsString();
                                
                                //Se revisa que la lista de casados no sea vacía
                                if (this.weds.getPrimero() == null){
                                    this.weds.agregarALaLista(wt);
                                    //Node node = grafo.addNode(wt);
                                    //node.setAttribute("ui.label", wt);
                                } else {
                                    wed = this.BuscarLista(wt);
                                    if (wed == null){
                                        this.weds.agregarALaLista(wt);
                                        //Node node = grafo.addNode(wt);
                                        //node.setAttribute("ui.label", wt);
                                    }
                                }
                                
                            } else if (dato.equals("Of eyes")){
                                oe = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Of hair")){
                                of = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Notes")){
                                Notas = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Fate")){
                                Destino = Propiedades.get(dato).getAsString();
                                
                            }
                            
                        }
                        
                    }
                    if (kta.equalsIgnoreCase("×")){
                        kta = nombre + ", " + ohn + " of his name";
                    }
                    Nodo nuevoNodo =null;
                    Persona person = new Persona(nombre, ohn, bt, kta, ht, wt, oe, of, Notas, Destino);
                    if (InterfazSeleccion.arbol.esVacio()){
                    nuevoNodo = InterfazSeleccion.arbol.agregarNodo(person, "");
                    
                    }
                    else {

                       nuevoNodo = InterfazSeleccion.arbol.agregarNodo(person, bt);
                    }
                    if (nuevoNodo != null){
                        InterfazSeleccion.tabla.agregarElemento(nuevoNodo);
                    }
                    
                    /*if (InterfazSeleccion.arbol.esVacio()){
                        //Node node = grafo.addNode(nombre);
                        //node.setAttribute("ui.label", nombre);
                    } else {
                        Nperson = InterfazSeleccion.arbol.buscarNombreOhn(nombre, InterfazSeleccion.arbol.getpRoot(), ohn);
                        if (Nperson == null){
                            /*Node node = grafo.addNode(this.Generacion(Nperson));
                            node.setAttribute("ui.label", this.Generacion(Nperson));
                            this.NodosHijos(hijo_izq, this.Generacion(Nperson), wt);
                        } else {
                            //this.NodosHijos(hijo_izq, nombre, wt);
                        }
                    }*/
                }
            }
            
            
        }
    }


    
    
}
