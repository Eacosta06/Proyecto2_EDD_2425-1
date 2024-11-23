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
    Graph grafo;
    Arbol arbol;
    Nodo nodo;
    HashTable hash;
    Lista weds;

    public Inicializar() {
    }
    
    public void NodosHijos(Nodo hijo_izq, String padre){
        Nodo aux = hijo_izq;
        while (aux != null){
            String name;
            name = this.Generacion(aux);
            Edge borde = grafo.addEdge(name+padre, name, padre);
        }
    }
    
    public String Generacion(Nodo persona){
        String generacion = null;
        String ohn = persona.gettInfo().getOhn();
        String nombre = persona.gettInfo().getNombre();
        if (ohn.equals("First")){
            generacion = nombre;
        } else if (ohn.equals("Second")){
            generacion = nombre+" II";
        } else if (ohn.equals("Third")){
            generacion = nombre+" III";
        } else {
            generacion = nombre+" IV";
        }
        return generacion;
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
            this.arbol = new Arbol();
            this.arbol.setNombre(casa);
            
            //Se crea la lista de parejas. Estas no pueden ser accedidas desde
            //el árbol genealógico por limitaciones de la estructura
            this.weds = new Lista();
            
            //Se debe crear un nuevo grafo
            System.setProperty("org.graphstream.ui", "swing");
            grafo = new MultiGraph(casa);
            
            JsonElement Json_nombres = iterable.get(casa);
            JsonArray l_nombres = Json_nombres.getAsJsonArray();
            
            //Se establece un grafo vacío.
            System.setProperty("org.graphstream.ui", "swing");
            //grafo = new MultiGraph(casa);
            
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
                    String ohn = null;
                    String bt = null;
                    String kta = null;
                    String ht = null;
                    String wt = null;
                    String oe = null;
                    String of = null;
                    String Notas = null;
                    String Destino = null;
                    Nodo bornto = null;
                    Nodo hijo_izq = null;
                    
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
                                    String[] Gen = l[2].split(" ");
                                    bornto = this.arbol.buscarYretornar(l[1], Gen[1], 1);
                                    if (bornto == null){
                                        bornto = this.arbol.buscarYretornar(l[1], Gen[1], 2);
                                    }
                                    */
                                }
                                
                            } else if (dato.equals("Known throughout as")){
                                kta = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Held title")){
                                ht = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Wed to")){
                                wt = Propiedades.get(dato).getAsString();
                                
                                
                            } else if (dato.equals("Of eyes")){
                                oe = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Of hair")){
                                of = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Notes")){
                                Notas = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Fate")){
                                Destino = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Father to")){
                                
                                //Se obtiene la lista de hijos como JsonArray
                                JsonElement Json_hijos = Propiedades.get(dato);
                                JsonArray l_hijos = Json_hijos.getAsJsonArray();
                                
                                Nodo hAnterior = null;
                                Nodo child;
                                
                                //Se obtiene el apellido de la persona
                                String[] Snombre = nombre.split(" ");
                                String apellido = Snombre[2];
                                String Hnombre;
                                
                                //Se recorre el JsonArray de hijos
                                for (int z = 0; z < l_hijos.size(); z++){
                                    //Se obtiene el nombre y se le agrega el apellido
                                    Hnombre = l_hijos.get(z).getAsString();
                                    Hnombre = Hnombre+" "+apellido;
                                    
                                    String generacion = null;
                                    Persona hijo;
                                    
                                    if (Hnombre.equals(nombre)){
                                        
                                        if (ohn.equals("First")){
                                            generacion = "Second";
                                        } else if (ohn.equals("Second")){
                                            generacion = "Third";
                                        } else if (ohn.equals("Third")){
                                            generacion = "Fourth";
                                        }
                                    } else {
                                        generacion = "First";
                                    }
                                    
                                    hijo = new Persona(Hnombre, generacion, null, null, null, null, null, null, null, null);
                                    child = new Nodo(hijo);
                                    
                                    if (hAnterior == null){
                                        //Se asigna child como el primer hijo
                                        hAnterior = child;
                                        hijo_izq = child;
                                    } else {
                                        //Se asigna child como un hijo derecho
                                        hAnterior.setHermanoDer(child);
                                        hAnterior = child;
                                    }
                                    
                                }
                            }
                            
                        }
                        
                    }
                    
                    if (this.arbol.esVacio()){
                        Persona person = new Persona(nombre, ohn, bt, kta, ht, wt, oe, of, Notas, Destino);
                        Nperson = new Nodo(person);
                        Nperson.setHijoIzq(hijo_izq);
                        this.arbol.setpRoot(Nperson);
                        Node nodo = grafo.addNode(nombre);
                    } else {
                        Nperson = this.arbol.buscarNombreOhn(nombre, bornto, ohn);
                        if (Nperson == null){
                            Persona person = new Persona(nombre, ohn, bt, kta, ht, wt, oe, of, Notas, Destino);
                            Nperson = new Nodo(person);
                            Nperson.setHijoIzq(hijo_izq);
                            Node nodo = grafo.addNode(this.Generacion(Nperson));
                            this.NodosHijos(hijo_izq, this.Generacion(Nperson));
                            this.arbol.AnadirHijo(bornto, Nperson);
                        } else {
                            Nperson.gettInfo().agregarData(ohn, bt, kta, ht, wt, oe, of, Notas, Destino);
                            Nperson.setHijoIzq(hijo_izq);
                            this.NodosHijos(hijo_izq, nombre);
                        }
                    }
                }
            }
            
            
        }
    }

    public Graph getGrafo() {
        return grafo;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public HashTable getHash() {
        return hash;
    }
    
    
    
}
