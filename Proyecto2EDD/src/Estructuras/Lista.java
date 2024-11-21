/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author maria
 */
public class Lista {
    private NodoLista primero;
    private NodoLista ultimo;
    private int size;

    public Lista() {
        this.primero = null;
        this.size = 0;
        this.ultimo = null;
        
    }

    public NodoLista getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    public NodoLista getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLista ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void agregarALaLista (String dato){
        NodoLista aux = new NodoLista (dato);
        if (this.primero== null){
            this.primero = aux;
            this.ultimo = aux;
        }
        else {
            this.ultimo.setPnext(aux);
            this.ultimo = aux;
        }
        this.size = this.size+1;
    }
}
