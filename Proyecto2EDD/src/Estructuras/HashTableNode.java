/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author maria
 */
public class HashTableNode {

    
   private HashTableNode siguiente;
   private Nodo nodoArbol;
   
   
    public HashTableNode(Nodo nodoArbol) {
        this.nodoArbol = nodoArbol;
    }
    public HashTableNode getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(HashTableNode siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getNodoArbol() {
        return nodoArbol;
    }

    public void setNodoArbol(Nodo nodoArbol) {
        this.nodoArbol = nodoArbol;
    }
    
}

