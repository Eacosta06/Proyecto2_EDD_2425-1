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

    public Persona(String nombre, String ohn, String bt, String kta, String ht, String wt, String oe, String of, String Notas, String Destino) {
        this.nombre = nombre;
        this.ohn = ohn;
        this.bt = bt;
        this.kta = kta;
        this.ht = ht;
        this.wt = wt;
        this.oe = oe;
        this.of = of;
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
    private String of;
    private String Notas;
    private String Destino;
    
    /**
     * ohn = De su nombre ("Of his name")
     * bt = Nacido de ("Born to")
     * kta = Conocido como ("Known throughout as")
     * ht = Titulo ("Held title")
     * wt = Casado con ("Wed to")
     * oe = De ojos ("Of eyes")
     * of = De pelo ("Of hair")
     * Notas ("Notes")
     * Destino ("Fate")
     */
    
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nConocido como: " + this.kta ;
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

    public String getOf() {
        return of;
    }

    public void setOf(String of) {
        this.of = of;
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
    
    
}
