/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto;

import Estructuras.Arbol;
import Estructuras.HashTable;
import Estructuras.Nodo;
import Estructuras.Persona;

/**
 *
 * @author esteacosta
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona persona1 = new Persona ("Hola", "amarillo", "azul", "Chao", "erde", "rojo", "rosado", "blanco", "", "");
        Persona persona2 = new Persona ("aHelloo", "verde", "gris", "chaito", "morado", "", "", "", "", "");
        Persona persona3 = new Persona ("Holaaa", "azul", "negro", "hello", "blanco", "", "", "", "", "");
        Persona persona4 = new Persona ("epa", "gris", "dorado", "epaaaaa", "plateado", "", "", "", "", "");
        Arbol arbol1 = new Arbol ();
        Nodo nodoPersona1 = arbol1.agregarNodo(persona1, "");
        Nodo nodoPersona2 = arbol1.agregarNodo(persona2, "Chao");
        Nodo nodoPersona3 = arbol1.agregarNodo(persona3, "Chao");
        Nodo nodoPersona4 = arbol1.agregarNodo(persona4, "hello");
        HashTable nuevaTabla = new HashTable (2);
        nuevaTabla.agregarElemento(nodoPersona1);
        nuevaTabla.agregarElemento(nodoPersona2);
        nuevaTabla.agregarElemento(nodoPersona3);
        nuevaTabla.agregarElemento(nodoPersona4);
        System.out.println(arbol1.buscarPorNombreyMote("hello"));
        
    }
    
}
