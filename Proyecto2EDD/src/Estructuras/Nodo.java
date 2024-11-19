/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author esteacosta
 */
public class Nodo {
    private Persona tInfo;
    private Nodo hijoIzq;
    private Nodo hermanoDer;
    private Nodo padre;
    

    public Nodo(Persona tInfo) {
        this.tInfo = tInfo;
        this.hijoIzq = null;
        this.hermanoDer = null;
        this.padre = null;
    }

    public Persona gettInfo() {
        return tInfo;
    }

    public void settInfo(Persona tInfo) {
        this.tInfo = tInfo;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getHermanoDer() {
        return hermanoDer;
    }

    public void setHermanoDer(Nodo hermanoDer) {
        this.hermanoDer = hermanoDer;
    }

    public Nodo getPadre() {
        return padre;
    }
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    
    
    
    
}
