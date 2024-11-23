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

    public Arbol() {
        this.nombre = "";
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
    
    public Nodo buscarNombreOhn(String nombre, Nodo root, String ohn){
        if (root != null) {
            if (root.gettInfo().getNombre().equalsIgnoreCase(nombre) & root.gettInfo().getOhn().equalsIgnoreCase(ohn)){
                return root;
            }
            Nodo respuesta =this.buscarNombreOhn(nombre,root.getHijoIzq(), ohn);
            if (respuesta != null){
                return respuesta;
            }
            Nodo respuesta2 = this.buscarNombreOhn(nombre, root.getHermanoDer(), ohn);
            if (respuesta != null){
                return respuesta2;
            }
        }
        return null;
    }
    
    public Nodo buscarKtaOhn(String kta, Nodo root, String ohn){
        if (root != null) {
            if (root.gettInfo().getKta().equalsIgnoreCase(kta) & root.gettInfo().getOhn().equalsIgnoreCase(ohn)){
                return root;
            }
            Nodo respuesta =this.buscarKtaOhn(kta,root.getHijoIzq(), ohn);
            if (respuesta != null){
                return respuesta;
            }
            Nodo respuesta2 = this.buscarKtaOhn(kta, root.getHermanoDer(), ohn);
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
    
    public Lista buscarPorNombreyMote (String nombreOMote){
        return this.buscarPorNombreyMote(nombreOMote.toLowerCase(), this.pRoot,new Lista () );
        
    }
    
    private Lista buscarPorNombreyMote(String nombreOMote, Nodo root, Lista resultado){
        if (root != null) {
            if (root.gettInfo().getKta().toLowerCase().contains(nombreOMote) || root.gettInfo().getNombre().toLowerCase().contains(nombreOMote)){
                resultado.agregarALaLista(root.gettInfo().getKta());
            }
            resultado =this.buscarPorNombreyMote(nombreOMote,root.getHijoIzq(), resultado);
            
            resultado = this.buscarPorNombreyMote(nombreOMote,root.getHermanoDer(), resultado);
           
        }
        return resultado;
    }
    
    public Lista buscarPorTitulo (String titulo){
        return this.buscarPorTitulo(titulo, this.pRoot, new Lista());
        
    }
    
    private Lista buscarPorTitulo(String titulo, Nodo root, Lista resultado){
        if (root != null) {
            if (root.gettInfo().getHt().equalsIgnoreCase(titulo)){
                resultado.agregarALaLista(root.gettInfo().getKta());
            }
            resultado =this.buscarPorTitulo(titulo,root.getHijoIzq(), resultado);
            
            resultado = this.buscarPorTitulo(titulo,root.getHermanoDer(), resultado);
           
        }
        return resultado;
    }
    
    public Nodo buscarYretornar(String name, String ohn, int n){
        Nodo encontrado;
        if (pRoot == null){
            return null;
        }
        if (n == 1){
            encontrado = this.buscarNombreOhn(name, pRoot, ohn);
        } else {
            encontrado = this.buscarKtaOhn(name, pRoot, ohn);
        }
        
        return encontrado;
    }
    
    public void AnadirHijo(Nodo root, Nodo persona){
        Nodo aux = root.getHijoIzq();
        while (aux.getHermanoDer() != null){
            aux = aux.getHermanoDer();
        }
        aux.setHermanoDer(persona);
    }

}