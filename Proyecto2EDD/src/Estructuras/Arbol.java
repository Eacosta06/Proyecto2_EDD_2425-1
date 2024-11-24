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

    public boolean esVacio() {
        return pRoot == null;

    }

    public Nodo buscarNodo(String kta, Nodo root) {
        if (root != null) {
            if (root.gettInfo().getKta().equalsIgnoreCase(kta) || root.gettInfo().getWt().equalsIgnoreCase(kta)){
                return root;
            }
            Nodo respuesta = this.buscarNodo(kta, root.getHijoIzq());
            if (respuesta != null) {
                return respuesta;
            }
            Nodo respuesta2 = this.buscarNodo(kta, root.getHermanoDer());
            if (respuesta2 != null) {
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
            if (respuesta2 != null){
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
            if (respuesta2 != null){
                return respuesta2;
            }
        }
        return null;
    }
    
    public Nodo agregarNodo (Persona persona, String ktaPadre){
        Nodo nodoPersona = new Nodo(persona);
        if (this.esVacio()) {
            pRoot = nodoPersona;
        } else {
            Nodo nodoPadre = buscarNodo(ktaPadre, pRoot);
            if (nodoPadre == null) {
                JOptionPane.showMessageDialog(null, "Padre no encontrado");
            } else {
                if (nodoPadre.getHijoIzq() == null) {
                    nodoPadre.setHijoIzq(nodoPersona);
                    nodoPersona.setPadre(nodoPadre);
                } else {
                    nodoPersona.setHermanoDer(nodoPadre.getHijoIzq());
                    nodoPadre.setHijoIzq(nodoPersona);
                    nodoPersona.setPadre(nodoPadre);
                }
            }
        }
        return nodoPersona;
    }

    public String listaAncestros(String kta) {
        Nodo aux = buscarNodo(kta, pRoot);
        if (aux == null) {
            JOptionPane.showMessageDialog(null, "Nodo no encontrado en el arbol");
            return "";
        } else {
            String auxiliar = "";
            while (aux != null) {
                auxiliar += aux.gettInfo() + "\n";
                aux = aux.getPadre();
            }
            return auxiliar;
        }
    }

    public Lista buscarPorNombreyMote(String nombreOMote) {
        return this.buscarPorNombreyMote(nombreOMote.toLowerCase(), this.pRoot, new Lista());

    }

    private Lista buscarPorNombreyMote(String nombreOMote, Nodo root, Lista resultado) {
        if (root != null) {
            if (root.gettInfo().getKta().toLowerCase().contains(nombreOMote) || root.gettInfo().getNombre().toLowerCase().contains(nombreOMote)) {
                resultado.agregarALaLista(root.gettInfo().getKta());
            }
            resultado = this.buscarPorNombreyMote(nombreOMote, root.getHijoIzq(), resultado);

            resultado = this.buscarPorNombreyMote(nombreOMote, root.getHermanoDer(), resultado);

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

    public Lista buscarPorTitulo(String titulo) {
        return this.buscarPorTitulo(titulo, this.pRoot, new Lista());

    }

    private Lista buscarPorTitulo(String titulo, Nodo root, Lista resultado) {
        if (root != null) {
            if (root.gettInfo().getHt().equalsIgnoreCase(titulo)) {
                resultado.agregarALaLista(root.gettInfo().getKta());
            }
            resultado = this.buscarPorTitulo(titulo, root.getHijoIzq(), resultado);

            resultado = this.buscarPorTitulo(titulo, root.getHermanoDer(), resultado);

        }
        return resultado;
    }

    public String buscarGeneracion(int generacion) {
        return this.buscarGeneracion(generacion, this.pRoot, "", 1);

    }

    private String buscarGeneracion(int generacion, Nodo root, String resultado, int contador) {

        if (root != null) {
            if (generacion == contador) {
                resultado += root.gettInfo() + "\n\n";
            }
            resultado = this.buscarGeneracion(generacion, root.getHijoIzq(), resultado, contador + 1);

            resultado = this.buscarGeneracion(generacion, root.getHermanoDer(), resultado, contador + 1);

        }
        return resultado;
    }

    public Lista buscarPorNombre(String nombre) {
        return this.buscarPorNombre(nombre.toLowerCase(), this.pRoot, new Lista());

    }

    private Lista buscarPorNombre(String nombre, Nodo root, Lista resultado) {
        if (root != null) {
            if (root.gettInfo().getNombre().toLowerCase().contains(nombre)) {
                resultado.agregarALaLista(root.gettInfo().getNombre() + " " + root.gettInfo().getOhn());
            }
            resultado = this.buscarPorNombre(nombre, root.getHijoIzq(), resultado);

            resultado = this.buscarPorNombre(nombre, root.getHermanoDer(), resultado);

        }
        return resultado;
    }
    
      public Nodo buscarPorNombreyPosicion(String nombre, String Ohn) {
        return this.buscarPorNombreyPosicion(nombre.toLowerCase(), this.pRoot);

    }

    private Nodo buscarPorNombreyPosicion(String nombre, Nodo root) {
        if (root != null) {
            if (root.gettInfo().getKta().toLowerCase().contains(nombre) && root.gettInfo().getNombre().toLowerCase().contains(nombre)) {
                return pRoot;
            }
            Nodo resultado = this.buscarNodo(nombre, root.getHijoIzq());
            resultado = this.buscarPorNombreyPosicion(nombre, root.getHijoIzq());
            
            if (resultado != null){
                return resultado;
            }
            Nodo resultado2 = this.buscarNodo(nombre, root.getHermanoDer());
            resultado2 = this.buscarPorNombreyPosicion(nombre, root.getHermanoDer());
            
            if (resultado2 != null){
                return resultado;
            }
        }
        return null;
    }

    private void crearGrafo (Nodo root, boolean primeraLlamada){
        if (root != null && !primeraLlamada){
            //Agregar el nodo al grafo de graphstream
            crearGrafo(root.getHijoIzq());
            crearGrafo(root.getHermanoDer());
            
        }
    }
    
    public void crearGrafo (Nodo root){
        //limpiar el grafo de graphstream y reiniciarlo para que se cree uno nuevo a partir de los nodos
        crearGrafo(root, false);
    }
    
    
    
    
}
