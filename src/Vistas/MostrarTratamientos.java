/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Conexion.Conexion;
import ConsultasSQL.QuerysTratamiento;

import Controlador.Tratamiento;
import static Vistas.IngresarTratamiento.JtListadoProductos;
import static Vistas.MostrarTratamientos.tblMostrarTratamiento;
import static Vistas.Mostrarmanicuraypedicura.totalPages;
import static Vistas.VerTratamiento.Label_Foto1;
import static Vistas.VerTratamiento.Label_Foto2;
import static Vistas.VerTratamiento.txtNombre;
import com.mysql.cj.jdbc.Blob;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Currency;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.RootPaneUI;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author PC
 */
public class MostrarTratamientos extends javax.swing.JPanel {
    
    private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    private int paginaActual = 1;
    public static int totalPages=Tratamiento.NumeroPages("", 20, "","") ;
    
    private DefaultTableModel model;
    private DefaultTableModel eliminadosModel;
    
    
    
    public MostrarTratamientos() throws IOException {
        initComponents();
        tblMostrarTratamiento.getTableHeader().setReorderingAllowed(false);
        Controlador.Tratamiento.MostrarTratamientos("", paginaActual, totalPages,Listadotipo.getModel().getSelectedItem().toString(),
               comEstado.getModel().getSelectedItem().toString() );
        PromptSupport.setPrompt("Buscar nombre de tratamiento por tipo", txtBusqueda1);
        
        
        
        
        
        // ocultar la columna 7 NombreProductos
        int columnIndex = 7; // Índice de la columna que deseas ocultar

        // Oculta la columna
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex).setMaxWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex).setMinWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex).setPreferredWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex).setResizable(false);
        
        // ocultar la columna 5 Foto1
        int columnIndex2 = 5; // Índice de la columna que deseas ocultar

        // Oculta la columna
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex2).setMaxWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex2).setMinWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex2).setPreferredWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex2).setResizable(false);
        
        // ocultar la columna 6 Foto2
        int columnIndex3 = 6; // Índice de la columna que deseas ocultar

        // Oculta la columna
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex3).setMaxWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex3).setMinWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex3).setPreferredWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex3).setResizable(false);
        
        // ocultar la columna 1 id
        int columnIndex4 = 1; // Índice de la columna que deseas ocultar

        // Oculta la columna
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex4).setMaxWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex4).setMinWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex4).setPreferredWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex4).setResizable(false);
        
        // ocultar la columna 1 id
        int columnIndex5 = 4; // Índice de la columna que deseas ocultar

        // Oculta la columna
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex5).setMaxWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex5).setMinWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex5).setPreferredWidth(0);
        tblMostrarTratamiento.getColumnModel().getColumn(columnIndex5).setResizable(false);
        
      
    }


   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        siguiente = new javax.swing.JButton();
        Previo = new javax.swing.JButton();
        seguimiento = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Listadoempleados = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrarTratamiento = new javax.swing.JTable();
        btnCrear2 = new javax.swing.JButton();
        txtBusqueda1 = new javax.swing.JTextField();
        siguiente1 = new javax.swing.JButton();
        Previo1 = new javax.swing.JButton();
        seguimiento1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Listadotipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        bntdeshabilitar = new javax.swing.JButton();
        comEstado = new javax.swing.JComboBox<>();

        btnCrear1.setBackground(new java.awt.Color(255, 253, 252));
        btnCrear1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCrear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnCrear1.setText("Agregar ");
        btnCrear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrear1ActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 253, 252));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        siguiente.setBackground(new java.awt.Color(253, 253, 252));
        siguiente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton_delante.png"))); // NOI18N
        siguiente.setBorder(null);
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        Previo.setBackground(new java.awt.Color(253, 253, 252));
        Previo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Previo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton_atras.png"))); // NOI18N
        Previo.setBorder(null);
        Previo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevioActionPerformed(evt);
            }
        });

        seguimiento.setText("Pagina: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.jpg"))); // NOI18N
        jLabel4.setText("Buscar ");

        Listadoempleados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Hombre", "Mujer" }));
        Listadoempleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListadoempleadosActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccionar Listado");

        jLabel6.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel6.setText("Listado de tipos de cortes de cabellos ");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ListaodologoBarberia (1).png"))); // NOI18N

        setBackground(new java.awt.Color(253, 253, 255));

        //hacer que la tabla no sea editabe
        tblMostrarTratamiento.setFocusable(false);
        tblMostrarTratamiento = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblMostrarTratamiento.setAutoCreateRowSorter(true);
        tblMostrarTratamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Id", "Nombre del tratamiento", "Tipo de Tratamiento", "Descripción", "Foto 1", "Foto 2", "Nombre de los productos", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMostrarTratamiento.setToolTipText("");
        tblMostrarTratamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMostrarTratamientoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMostrarTratamiento);

        btnCrear2.setBackground(new java.awt.Color(255, 253, 252));
        btnCrear2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCrear2.setForeground(new java.awt.Color(0, 0, 153));
        btnCrear2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregarN.jpg"))); // NOI18N
        btnCrear2.setText("Agregar ");
        btnCrear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrear2ActionPerformed(evt);
            }
        });

        txtBusqueda1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBusqueda1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusqueda1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusqueda1KeyTyped(evt);
            }
        });

        siguiente1.setBackground(new java.awt.Color(253, 253, 252));
        siguiente1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        siguiente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/adelanteN.jpg"))); // NOI18N
        siguiente1.setBorder(null);
        siguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguiente1ActionPerformed(evt);
            }
        });

        Previo1.setBackground(new java.awt.Color(253, 253, 252));
        Previo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Previo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/atrasN.jpg"))); // NOI18N
        Previo1.setBorder(null);
        Previo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Previo1ActionPerformed(evt);
            }
        });

        seguimiento1.setText("Pagina: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.jpg"))); // NOI18N
        jLabel5.setText("Buscar :");

        jLabel8.setBackground(new java.awt.Color(0, 0, 153));
        jLabel8.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Listado de tratamientos ");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ListaodologoBarberia (1).png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 253, 252));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 153));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editarN.jpg"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Listadotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "capilares", "faciales" }));
        Listadotipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListadotipoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Tipo de Tratamiento:");

        bntdeshabilitar.setBackground(new java.awt.Color(255, 253, 252));
        bntdeshabilitar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bntdeshabilitar.setForeground(new java.awt.Color(0, 0, 153));
        bntdeshabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/noveo3.png"))); // NOI18N
        bntdeshabilitar.setText("Deshabilitar");
        bntdeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntdeshabilitarActionPerformed(evt);
            }
        });

        comEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Activo", "Inactivo" }));
        comEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Previo1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seguimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(comEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(Listadotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bntdeshabilitar, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrear2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCrear2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bntdeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(Listadotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Previo1)
                            .addComponent(seguimiento1)))
                    .addComponent(siguiente1))
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusqueda1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusqueda1KeyReleased
String textoBusqueda = txtBusqueda1.getText();
 paginaActual=1;
    Controlador.Tratamiento.MostrarTratamientos(txtBusqueda1.getText(), paginaActual, totalPages,Listadotipo.getModel().getSelectedItem().toString(),
            comEstado.getModel().getSelectedItem().toString());
    if (textoBusqueda.length() <= 3) {// esta validacion es para dar un maximo de logitud del nombre que se puede aceptar en la caja de texto
            evt.consume();
        }
        
    }//GEN-LAST:event_txtBusqueda1KeyReleased

    private void siguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguiente1ActionPerformed

        
         totalPages = Controlador.Tratamiento.NumeroPages(txtBusqueda1.getText(), paginaActual,Listadotipo.getModel().getSelectedItem().toString(),
                 comEstado.getModel().getSelectedItem().toString());
        if (paginaActual < totalPages) {
            String textoBusqueda = txtBusqueda1.getText();
            paginaActual++;
            Controlador.Tratamiento.MostrarTratamientos(txtBusqueda1.getText(), paginaActual, totalPages,Listadotipo.getModel().getSelectedItem().toString(),
                    comEstado.getModel().getSelectedItem().toString());
        }
        
    }//GEN-LAST:event_siguiente1ActionPerformed

    private void Previo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Previo1ActionPerformed
 if (paginaActual > 1) {
            paginaActual--;
            String textoBusqueda = txtBusqueda1.getText();
            Controlador.Tratamiento.MostrarTratamientos(txtBusqueda1.getText(), paginaActual, totalPages,Listadotipo.getModel().getSelectedItem().toString(),
                    comEstado.getModel().getSelectedItem().toString());
        }
    }//GEN-LAST:event_Previo1ActionPerformed

    private void tblMostrarTratamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMostrarTratamientoMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int filaSeleccionada = tblMostrarTratamiento.getSelectedRow();
            if (filaSeleccionada >= 0) {
                String idTratamiento = (String) tblMostrarTratamiento.getValueAt(filaSeleccionada, 0); // Supongo que el ID está en la primera columna.
                VerTratamiento verTratamiento = null;
                try {
                    verTratamiento = new VerTratamiento(idTratamiento);
                } catch (IOException ex) {
                    //Logger.getLogger(MostrarCortes.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
                verTratamiento.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_tblMostrarTratamientoMouseClicked

    private void btnCrear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrear2ActionPerformed
        //Agregar un tratamiento
        IngresarTratamiento ingresarTratamiento = new IngresarTratamiento();
        ingresarTratamiento.setVisible(true);
        ingresarTratamiento.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnCrear2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //variable para seleccionar el producto de la lista de productos
        int fila = tblMostrarTratamiento.getSelectedRow();

        // try catch para ejecutar las validaciones
        try {
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "No se seleccionó ningún tratamiento",
                    "Error al editar", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método si no se seleccionó ningún producto
            }
            else{
                EditarTratamiento edt = new EditarTratamiento();
                edt.setVisible(true);
                edt.setLocationRelativeTo(null);
                Vistas.EditarTratamiento.txtNombre.setText(tblMostrarTratamiento.getValueAt(fila, 2).toString());
                Vistas.EditarTratamiento.cbxTipoTratamiento.setSelectedItem(tblMostrarTratamiento.getValueAt(fila, 3));
                Vistas.EditarTratamiento.txtDescripcion.setText(tblMostrarTratamiento.getValueAt(fila, 4).toString());

            }
        }
        catch (Exception e) {
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void ListadoempleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListadoempleadosActionPerformed

    }//GEN-LAST:event_ListadoempleadosActionPerformed

    private void PrevioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevioActionPerformed

    }//GEN-LAST:event_PrevioActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed

    }//GEN-LAST:event_siguienteActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased

    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCrear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrear1ActionPerformed

    }//GEN-LAST:event_btnCrear1ActionPerformed

    private void ListadotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListadotipoActionPerformed
    String  valor= Listadotipo.getModel().getSelectedItem().toString();
    String otrovalor = comEstado.getModel().getSelectedItem().toString();
    
     //String dpato = (String) jcomdepartamentos.getSelectedItem();
        if (valor!=null) {
            paginaActual=1;
             Controlador.Tratamiento.MostrarTratamientos(txtBusqueda1.getText(), paginaActual, totalPages,valor, otrovalor);
            
        }     // TODO add your handling code here:
    }//GEN-LAST:event_ListadotipoActionPerformed

    private void txtBusqueda1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusqueda1KeyTyped

        txtBusqueda1.setText(txtBusqueda1.getText().replaceAll("( )+", " "));
        if (txtBusqueda1.getText().length() == 0 && evt.getKeyChar() == ' ') {
                    evt.consume();
                }      
        
        
         char c = evt.getKeyChar();
         if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
         }
            int tam = txtBusqueda1.getText().length();
        if(tam>=15){
            evt.consume();
        }  else if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
                ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                ||(int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
                ||(int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=159
                ||(int)evt.getKeyChar()>=166 && (int)evt.getKeyChar()<=255){
             getToolkit().beep();
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusqueda1KeyTyped

    private void bntdeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntdeshabilitarActionPerformed
        //para eliminar de la tabla de la interfaz pero no de la base de datos 
    DefaultTableModel model = (DefaultTableModel) MostrarTratamientos.tblMostrarTratamiento.getModel();
    int[] filasSeleccionadas = tblMostrarTratamiento.getSelectedRows();

    // Obtén el número de la primera fila seleccionada
    int primerFilaSeleccionada = filasSeleccionadas[0];

    // Elimina las filas seleccionadas del JTable
    for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
        model.removeRow(filasSeleccionadas[i]);
    }

    // Ajusta la numeración en la primera columna de las filas restantes
    for (int i = primerFilaSeleccionada; i < model.getRowCount(); i++) {
        model.setValueAt(i + 1, i, 0); // La primera columna contiene la numeración
    }
 //quiero que al eliminar cada tratamiento se agregue a la tabla deshabilitados 

   
    }//GEN-LAST:event_bntdeshabilitarActionPerformed

    private void comEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEstadoActionPerformed
        String  valor= Listadotipo.getModel().getSelectedItem().toString();
    String otrovalor = comEstado.getModel().getSelectedItem().toString();
        if (valor!=null) {
            paginaActual=1;
             Controlador.Tratamiento.MostrarTratamientos(txtBusqueda1.getText(), paginaActual, totalPages,valor, otrovalor);
            
        }
    }//GEN-LAST:event_comEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Listadoempleados;
    public static javax.swing.JComboBox<String> Listadotipo;
    public static javax.swing.JButton Previo;
    public static javax.swing.JButton Previo1;
    public static javax.swing.JButton bntdeshabilitar;
    private javax.swing.JButton btnCrear1;
    private javax.swing.JButton btnCrear2;
    private javax.swing.JButton btnEliminar;
    public static javax.swing.JComboBox<String> comEstado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel seguimiento;
    public static javax.swing.JLabel seguimiento1;
    public static javax.swing.JButton siguiente;
    public static javax.swing.JButton siguiente1;
    public static javax.swing.JTable tblMostrarTratamiento;
    private javax.swing.JTextField txtBusqueda;
    public static javax.swing.JTextField txtBusqueda1;
    // End of variables declaration//GEN-END:variables
}
