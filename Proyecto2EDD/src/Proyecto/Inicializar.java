/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import org.graphstream.graph.*;
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

    public Inicializar() {
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
            
            //Se debe crear un nuevo grafo
            
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
                    
                    //Array hijos;
                    
                    for (int j = 0; j < l_datos.size(); j++){
                        
                        JsonObject Propiedades = l_datos.get(j).getAsJsonObject();
                        Set<String> properties = Propiedades.keySet();
                        
                        
                        for (String dato : properties){
                            
                            //Se obtienen los datos del JsonObject y se
                            //establecen a las variables declaradas
                            if (dato.equals("Of his name")){
                                ohn = Propiedades.get(dato).getAsString();
                                
                            } else if (dato.equals("Born to")){
                                bt = Propiedades.get(dato).getAsString();
                                
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
                                
                                //Se itera la lista y se pasan los nombres a
                                // un array de Strings
                                
                            }
                            
                            
                        }
                        
                       
                    }
                    
                    if (this.arbol.esVacio()){
                        Persona person = new Persona(nombre, ohn, bt, kta, ht, wt, oe, of, Notas, Destino);
                        Nperson = new Nodo(person);
                        this.arbol.setpRoot(Nperson);
                    } else {
                        
                    }
                }
            }
            
            
        }
    }
    
    public Graph retornar_grafo(){
        return grafo;
    }
    
    public Arbol retornar_arbol(){
        return arbol;
    }
    
}
