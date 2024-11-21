/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto;

import Estructuras.Arbol;
import Estructuras.HashTable;
import Estructuras.Nodo;
import Estructuras.Persona;

/**
 *
 * @author maria
 */
public class InterfazSeleccion extends javax.swing.JFrame {
    
    public static HashTable tabla = new HashTable (57);
    public static Arbol arbol = new Arbol ();
    
    /**
     * Creates new form InterfazSeleccion
     */
    public InterfazSeleccion() {
        initComponents();
        Persona persona1 = new Persona ("Hola", "amarillo", "azul", "Chao", "morado", "rojo", "rosado", "blanco", "", "");
        Persona persona2 = new Persona ("aHelloo", "verde", "gris", "chaito", "morado", "", "", "", "", "");
        Persona persona3 = new Persona ("Holaaa", "azul", "negro", "hello", "blanco", "", "", "", "", "");
        Persona persona4 = new Persona ("epa", "gris", "dorado", "epaaaaa", "plateado", "", "", "", "", "");
        Nodo nodoPersona1 = arbol.agregarNodo(persona1, "");
        Nodo nodoPersona2 = arbol.agregarNodo(persona2, "Chao");
        Nodo nodoPersona3 = arbol.agregarNodo(persona3, "Chao");
        Nodo nodoPersona4 = arbol.agregarNodo(persona4, "hello");;
        tabla.agregarElemento(nodoPersona1);
        tabla.agregarElemento(nodoPersona2);
        tabla.agregarElemento(nodoPersona3);
        tabla.agregarElemento(nodoPersona4);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Base = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BuscarNombre = new javax.swing.JButton();
        buscarTitulo = new javax.swing.JButton();
        MostrarAntepasados = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel1.setText("Arbol Genealogico");
        Base.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        BuscarNombre.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        BuscarNombre.setText("Buscar por nombre");
        BuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarNombreActionPerformed(evt);
            }
        });
        Base.add(BuscarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        buscarTitulo.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        buscarTitulo.setText("Buscar por titulo");
        buscarTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTituloActionPerformed(evt);
            }
        });
        Base.add(buscarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        MostrarAntepasados.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        MostrarAntepasados.setText("Mostrar Antepasados");
        Base.add(MostrarAntepasados, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        jButton2.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jButton2.setText("Buscar una generacion");
        Base.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNombreActionPerformed
        // TODO add your handling code here:
        InterfazBuscarNombre interfaz = new InterfazBuscarNombre(this);
        interfaz.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BuscarNombreActionPerformed

    private void buscarTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTituloActionPerformed
        // TODO add your handling code here:
        InterfazTitulo interfaz = new InterfazTitulo(this);
        interfaz.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buscarTituloActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazSeleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazSeleccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JButton BuscarNombre;
    private javax.swing.JButton MostrarAntepasados;
    private javax.swing.JButton buscarTitulo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
