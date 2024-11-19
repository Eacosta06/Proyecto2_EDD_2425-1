/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto;

import Estructuras.Arbol;
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
        Persona persona1 = new Persona ("Hola", "", "", "Chao", "", "", "", "", "", "");
        Persona persona2 = new Persona ("Holis", "", "", "chaito", "", "", "", "", "", "");
        Persona persona3 = new Persona ("Holaaa", "", "", "hello", "", "", "", "", "", "");
        Persona persona4 = new Persona ("epa", "", "", "epaaaaa", "", "", "", "", "", "");
        Arbol arbol1 = new Arbol ("arbol Genealogico");
        arbol1.agregarNodo(persona1, "");
        arbol1.agregarNodo(persona2, "Chao");
        arbol1.agregarNodo(persona3, "Chao");
        arbol1.agregarNodo(persona4, "hello");
        System.out.println(arbol1.listaAncestros("epaaaaa"));
        
    }
    
}
