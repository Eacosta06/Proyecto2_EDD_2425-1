/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author maria
 */
public class NodoLista {
    private NodoLista pnext;
    private String datos;
    
    public NodoLista getPnext() {
        return pnext;
    }

    public void setPnext(NodoLista pnext) {
        this.pnext = pnext;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public NodoLista(String datos) {
        this.pnext = null;
        this.datos = datos;
    }
    
   
}
