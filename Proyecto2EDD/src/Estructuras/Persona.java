/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author esteacosta
 */
public class Persona {

    public Persona(String nombre, String ohn, String bt, String kta, String ht, String wt, String oe, String oh, String Notas, String Destino) {
        this.nombre = nombre;
        this.ohn = ohn;
        this.bt = bt;
        this.kta = kta;
        this.ht = ht;
        this.wt = wt;
        this.oe = oe;
        this.oh = oh;
        this.Notas = Notas;
        this.Destino = Destino;
    }
    private String nombre;
    private String ohn;
    private String bt;
    private String kta;
    private String ht;
    private String wt;
    private String oe;
    private String oh;
    private String Notas;
    private String Destino;
    
    /**
     * ohn = De su nombre ("Of his name")
     * bt = Nacido de ("Born to")
     * kta = Conocido como ("Known throughout as")
     * ht = Titulo ("Held title")
     * wt = Casado con ("Wed to")
     * oe = De ojos ("Of eyes")
     * oh = De pelo ("Of hair")
     * Notas ("Notes")
     * Destino ("Fate")
     */
    
    @Override
    public String toString() {
        return "Name: " + this.nombre + "\nNickname: " + this.kta + "\nIs the: " + this.ohn + " with his name in the family" + "\nHeld Title: " + this.ht+
                "\nEye Color: " + this.oe + "\nHair color: " + this.oh + "\nHis father is: " + this.bt + "\nMarried to: " + this.wt; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOhn() {
        return ohn;
    }

    public void setOhn(String ohn) {
        this.ohn = ohn;
    }

    public String getBt() {
        return bt;
    }

    public void setBt(String bt) {
        this.bt = bt;
    }

    public String getKta() {
        return kta;
    }

    public void setKta(String kta) {
        this.kta = kta;
    }

    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht;
    }

    public String getWt() {
        return wt;
    }

    public void setWt(String wt) {
        this.wt = wt;
    }

    public String getOe() {
        return oe;
    }

    public void setOe(String oe) {
        this.oe = oe;
    }

    public String getOh() {
        return oh;
    }

    public void setOh(String oh) {
        this.oh = oh;
    }

    public String getNotas() {
        return Notas;
    }

    public void setNotas(String Notas) {
        this.Notas = Notas;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }
    
    public void agregarData(String ohn, String bt, String kta, String ht, String wt, String oe, String oh, String Notas, String Destino){
        this.ohn = ohn;
        this.bt = bt;
        this.kta = kta;
        this.ht = ht;
        this.wt = wt;
        this.oe = oe;
        this.oh = oh;
        this.Notas = Notas;
        this.Destino = Destino;
    }
}
