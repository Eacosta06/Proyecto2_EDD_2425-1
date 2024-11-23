package Proyecto;


import Estructuras.Arbol;
import Estructuras.HashTable;
import Estructuras.Nodo;
import java.io.*;
import org.graphstream.graph.Graph;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author maria
 */
public class Principal extends javax.swing.JFrame {
    Inicializar inicializar;
    Graph grafo;
    Arbol arbol;
    Nodo nodo;
    HashTable hash;
    Mensaje mensaje;
    Error error;
    InterfazSeleccion interfasSeleccion = null;

    public Principal(InterfazSeleccion interfazSeleccion) {
        initComponents();
        this.error = new Error();
        this.mensaje = new Mensaje();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        if (this.interfasSeleccion == null){
            this.interfasSeleccion = new InterfazSeleccion ();
        }
        else {this.interfasSeleccion = interfazSeleccion;
        
        }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Base = new javax.swing.JPanel();
        SeleccionarArchivo = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BaseLayout = new javax.swing.GroupLayout(Base);
        Base.setLayout(BaseLayout);
        BaseLayout.setHorizontalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SeleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BaseLayout.setVerticalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BaseLayout.createSequentialGroup()
                .addComponent(SeleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EstablecerValores(){
        arbol = this.inicializar.getArbol();
        hash = this.inicializar.getHash();
        grafo = this.inicializar.getGrafo();
    }
    
    private void SeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarArchivoActionPerformed
        // TODO add your handling code here:
        //Se obtiene el archivo del JFileChooser
        this.setVisible(false);
        String aux;
        String Json = "";
        try {
            //Se obtiene el archivo del selector de archivos
            File archivo = this.SeleccionarArchivo.getSelectedFile();
            
            if (archivo != null) {
                
                FileReader lectura = new FileReader(archivo);
                BufferedReader leer = new BufferedReader(lectura);
                
                while ((aux = leer.readLine()) != null){
                    Json += aux += "\n";
                }
                
                leer.close();
                
                try {
                    //Se ejecuta inicializar con el texto del Json
                    this.inicializar.Iniciar(Json);
                    this.setVisible(false);
                    
                    this.interfasSeleccion.setVisible(true);
                    this.dispose();
                    
                } catch (Exception e) {
                    this.error.mensaje_error(2);
                }
                
            } else {
                this.error.mensaje_error(1);
            }
            
        } catch (IOException ex) {
            this.setVisible(true);
        }
    }//GEN-LAST:event_SeleccionarArchivoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JFileChooser SeleccionarArchivo;
    // End of variables declaration//GEN-END:variables
}
