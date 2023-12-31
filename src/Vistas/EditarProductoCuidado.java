/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.event.KeyEvent;
import ConsultasSQL.QuerysProductosCuidados;
import javax.swing.JOptionPane;
import Controlador.ProductosCuidado;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Bucardo
 */
public class EditarProductoCuidado extends javax.swing.JFrame {

    /**
     * Creates new form EditarProductoCuidado
     */
    public EditarProductoCuidado() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
         Id.setVisible(false);
         getContentPane().setBackground(Color.white);
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtNombreP = new javax.swing.JTextField();
        txtmarca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtTamano = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel1.setText("Editando Producto de Cuidado Personal");

        jLabel2.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel2.setText("Nombre del producto :");

        jLabel3.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel3.setText("Categoría :");

        jLabel4.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel4.setText("Descripción del Producto :");

        btnactualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar2.png"))); // NOI18N
        btnactualizar.setText("actualizar ");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar-r boton.png"))); // NOI18N
        btncancelar.setText("cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txtNombreP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNombreP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePKeyTyped(evt);
            }
        });

        txtmarca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtmarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmarcaKeyTyped(evt);
            }
        });

        txaDescripcion.setColumns(20);
        txaDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txaDescripcion.setLineWrap(true);
        txaDescripcion.setRows(5);
        txaDescripcion.setWrapStyleWord(true);
        txaDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txaDescripcion);

        jLabel5.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel5.setText("Tamaño :");

        txtTamano.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTamanoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jLabel6.setText("Marca :");

        Id.setEditable(false);
        Id.setEnabled(false);

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccione una categoría ", "cuidado corporal", "cuidado del cabello", "cuidado facial" }));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ListaodologoBarberia.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(130, 130, 130)
                                    .addComponent(btnactualizar)
                                    .addGap(140, 140, 140)
                                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel3))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtmarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(26, 26, 26)
                                                    .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(220, 220, 220)
                                    .addComponent(txtTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombrePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePKeyTyped
        // TODO add your handling code here:
        txtNombreP.setText(txtNombreP.getText().replaceAll("( )+", " "));
        if (txtNombreP.getText().length() == 0 && evt.getKeyChar() == ' ') {
                    evt.consume();
                }      
        
        
         char c = evt.getKeyChar();
         if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
         }
            int tam = txtNombreP.getText().length();
        if(tam>=30){
            evt.consume();
        }  else if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
                ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                ||(int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
                ||(int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=159
                ||(int)evt.getKeyChar()>=166 && (int)evt.getKeyChar()<=255){
             getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombrePKeyTyped

    private void txtmarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmarcaKeyTyped
        // TODO add your handling code here:
         txtmarca.setText(txtmarca.getText().replaceAll("( )+", " "));
        if (txtmarca.getText().length() == 0 && evt.getKeyChar() == ' ') {
                    evt.consume();
                }      
        
        
         char c = evt.getKeyChar();
         if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
         }
            int tam = txtmarca.getText().length();
        if(tam>=30){
            evt.consume();
        }  else if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
                ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                ||(int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
                ||(int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=159
                ||(int)evt.getKeyChar()>=166 && (int)evt.getKeyChar()<=255){
             getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtmarcaKeyTyped

    private void txtTamanoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTamanoKeyTyped
        // TODO add your handling code here:
        txtTamano.setText(txtTamano.getText().replaceAll("( )+", " "));
        if (txtTamano.getText().length() == 0 && evt.getKeyChar() == ' ') {
                    evt.consume();
                }      
            int tam = txtTamano.getText().length();
        if(tam>=30){
            evt.consume();
        }
    }//GEN-LAST:event_txtTamanoKeyTyped

    private void txaDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescripcionKeyTyped
        // TODO add your handling code here:
         txaDescripcion.setText(txaDescripcion.getText().replaceAll("( )+", " "));
        if (txaDescripcion.getText().length() == 0 && evt.getKeyChar() == ' ') {
                    evt.consume();
                }      
            int tam = txaDescripcion.getText().length();
        if(tam>=240){
            evt.consume();
        }
    }//GEN-LAST:event_txaDescripcionKeyTyped

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // TODO add your handling code here:
        String categoria = cbxCategoria.getSelectedItem().toString(); // que no este vacio, que solo seleccione 1
        if(categoria.equals("seleccione una categoría ")){
         JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna categoría", "Error de validación", JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método si el campo está vacío
        }
        
        
            String nombre = txtNombreP.getText().trim(); // Eliminar espacios en blanco al inicio y al final
        if (nombre.isEmpty()) {
          
            JOptionPane.showMessageDialog(this, "El nombre del producto no puede estar vacío", "Error de validación", JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método si el campo está vacío
        }
       
        String marca = txtmarca.getText().trim(); // Eliminar espacios en blanco al inicio y al final
        if (marca.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La marca del producto no puede estar vacío", "Error de validación", JOptionPane.INFORMATION_MESSAGE);
           
            return; // Salir del método si el campo está vacío
        }
        
        String tamano = txtTamano.getText().trim(); // Eliminar espacios en blanco al inicio y al final
        if (tamano.isEmpty()) {
             JOptionPane.showMessageDialog(this, "El tamaño del producto no puede estar vacío", "Error de validación", JOptionPane.INFORMATION_MESSAGE);
           
            return; // Salir del método si el campo está vacío
        }
        
          String descripcion =  txaDescripcion.getText().trim(); // Eliminar espacios en blanco al inicio y al final
        if (descripcion.isEmpty()) {
              JOptionPane.showMessageDialog(this, "La descripción del producto no puede estar vacía", "Error de validación", JOptionPane.INFORMATION_MESSAGE);
           
            return; // Salir del método si el campo está vacío
        }
        
       
          QuerysProductosCuidados querys = new QuerysProductosCuidados();
            querys.setNombre(nombre);
            querys.setMarca(marca);
            querys.setTamano(tamano);
            querys.setCategoria(categoria);
            querys.setDescripcion(descripcion);
            querys.setId(Integer.parseInt(Id.getText()));
            
             // Llamar al método Guardar de la clase Productos para guardar los datos
            if (ProductosCuidado. Editar(querys)) {
               
                JOptionPane.showMessageDialog(null, "Se ha modificado exitosamente un producto de cuidado ", "Modificacion exitosa", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                dispose();
                
                Controlador.ProductosCuidado.MostrarProductoCuidado("");
                
            } else {
                
                   JOptionPane.showMessageDialog(null, "hay un error, consulte con el Administrador de Sistema", "Error de base de datos", 
                    JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
         dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarProductoCuidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProductoCuidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProductoCuidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProductoCuidado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProductoCuidado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Id;
    private static volatile javax.swing.JButton btnactualizar;
    public static javax.swing.JButton btncancelar;
    public static javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea txaDescripcion;
    public static javax.swing.JTextField txtNombreP;
    public static javax.swing.JTextField txtTamano;
    public static javax.swing.JTextField txtmarca;
    // End of variables declaration//GEN-END:variables
}
