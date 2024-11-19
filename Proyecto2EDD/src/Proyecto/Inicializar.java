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
            
            //Debe crearse el nodo principal del árbol y el árbol
            //Se debe crear un nuevo grafo
            
            JsonElement Json_nombres = iterable.get(casa);
            JsonArray l_nombres = Json_nombres.getAsJsonArray();
            
            //Se establece un grafo vacío.
            System.setProperty("org.graphstream.ui", "swing");
            //grafo = new MultiGraph(casa);
            
            for (int i = 0; i < l_nombres.size(); i++){
                
                JsonObject Datos = l_nombres.get(i).getAsJsonObject();
                Set<String> personas = Datos.keySet();
                
                for (String persona : personas){
                    
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
