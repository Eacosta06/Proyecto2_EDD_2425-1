/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author esteacosta
 */
public class HashTable {

    private HashTableNode[] tabla;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.tabla = new HashTableNode[size];

    }

    public HashTableNode[] getTabla() {
        return tabla;
    }

    public void setTabla(HashTableNode[] tabla) {
        this.tabla = tabla;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void agregarElemento(Nodo nodoArbol) {
        HashTableNode nuevoNodo = new HashTableNode(nodoArbol);
        int posicion = hashFunction(nodoArbol.gettInfo().getKta());
        int posicionFinal = posicion % this.size;
        if (this.tabla[posicionFinal] == null) {
            this.tabla[posicionFinal] = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(this.tabla[posicionFinal]);
            this.tabla[posicionFinal] = nuevoNodo;
        }

    }

    public int hashFunction(String kta) {
        int total = 0;
        for (int i = 0; i < kta.length(); i++) {
            total += (int) kta.charAt(i);
        }
        return total;
    }

    public Nodo buscarPorKta(String kta) {
        int posicion = hashFunction(kta);
        int posicionFinal = posicion % this.size;
        HashTableNode aux = this.tabla[posicionFinal];
        while (aux != null) {
            if (aux.getNodoArbol().gettInfo().getKta().equalsIgnoreCase(kta)) {
                return aux.getNodoArbol();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
    

}
