/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author esteacosta
 */
public class Arbol {

    private Nodo pRoot;
    private String nombre;

    public Arbol(String nombre) {
        this.nombre = nombre;
        this.pRoot = null;
    }

    public Nodo getpRoot() {
        return pRoot;
    }

    public void setpRoot(Nodo pRoot) {
        this.pRoot = pRoot;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean esVacio (){
        return pRoot == null;
        
    }
    public Nodo buscarNodo(String kta, Nodo root){
        if (root != null) {
            if (root.gettInfo().getKta().equalsIgnoreCase(kta)){
                return root;
            }
            Nodo respuesta =this.buscarNodo(kta,root.getHijoIzq());
            if (respuesta != null){
                return respuesta;
            }
            Nodo respuesta2 = this.buscarNodo(kta, root.getHermanoDer());
            if (respuesta != null){
                return respuesta2;
            }
        }
        return null;
    }
    
    public Nodo agregarNodo (Persona persona, String ktaPadre){
        Nodo nodoPersona = new Nodo(persona);
        if (this.esVacio()){
            pRoot = nodoPersona;
        }
        else{
            Nodo nodoPadre = buscarNodo(ktaPadre, pRoot);
            if (nodoPadre == null){
            JOptionPane.showMessageDialog(null, "Padre no encontrado");
        }
            else{
                if (nodoPadre.getHijoIzq()== null){
                    nodoPadre.setHijoIzq(nodoPersona);
                    nodoPersona.setPadre(nodoPadre);
                }
                else{
                    nodoPersona.setHermanoDer(nodoPadre.getHijoIzq());
                    nodoPadre.setHijoIzq(nodoPersona);
                    nodoPersona.setPadre(nodoPadre);
                }
            }
        }
        return nodoPersona;
    }
    public String listaAncestros(String kta){
        Nodo aux = buscarNodo(kta, pRoot);
        if (aux == null){
            JOptionPane.showMessageDialog(null, "Nodo no encontrado en el arbol");
            return "";
        }
        else{
            String auxiliar = "";
            while (aux != null){
                auxiliar += aux.gettInfo() + "\n";
                aux = aux.getPadre();   
            }
            return auxiliar;
        }
    }
    
    public String buscarPorNombreyMote (String nombreOMote){
        return this.buscarPorNombreyMote(nombreOMote.toLowerCase(), this.pRoot, "");
        
    }
    
    private String buscarPorNombreyMote(String nombreOMote, Nodo root, String resultado){
        if (root != null) {
            if (root.gettInfo().getKta().toLowerCase().contains(nombreOMote) || root.gettInfo().getNombre().toLowerCase().contains(nombreOMote)){
                resultado += root.gettInfo() + "\n";
            }
            resultado =this.buscarPorNombreyMote(nombreOMote,root.getHijoIzq(), resultado);
            
            resultado = this.buscarPorNombreyMote(nombreOMote,root.getHermanoDer(), resultado);
           
        }
        return resultado;
    }
}
