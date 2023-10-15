/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Conexion.Conexion;
// import Modelos.ModeloProveedores;
import java.util.ArrayList;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.*;
import Clases.Proveedor;
import Conexion.ModeloProveedores;
import static Vistas.MostrarCompras.totalPages;
import javax.swing.JTextField;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;



/**
 *
 * @author PC
 */
public class IngresarCompra extends javax.swing.JFrame {
    public int numeroDeFilas;
    Conexion enlace = new Conexion();
    Connection conection = enlace.getConexion();
    
    //Variables para calcular el total de la factura
    //para poner publico el nombre del proveedor
    static  String proveedorSeleccionadoNombre;
    private int paginaActual = 1;
    
  

   
    public IngresarCompra(int numeroDeFilas) {
        initComponents();
        this.numeroDeFilas = numeroDeFilas; // Almacena el número de filas en una variable de instancia
        // Configura el valor del campo txt_Id
        txt_Id.setText(String.valueOf(numeroDeFilas + 1));
        
        //para llenar el id y el nombre del proveedor al boton de seleccion desplegable
        llenarProveedor();
        
      // Obtener la fecha actual
    Calendar calendario = Calendar.getInstance();
    Date fechaActual = calendario.getTime();

    // Restar 2 meses a la fecha actual
    calendario.add(Calendar.MONTH, -2);
    Date fechaMinima = calendario.getTime();

    // Establecer la fecha máxima y mínima seleccionable en el componente Fecha
    Fecha.setMaxSelectableDate(fechaActual);
    Fecha.setMinSelectableDate(fechaMinima);
        
        //Inicializando la variable para calcular el total de la factura
        //totalFactura = 0.0;     
          DefaultTableModel model = (DefaultTableModel) tblProductosCompras.getModel();

        model.addTableModelListener(e -> {
            calcularTotalFactura();
        });

    }  
    
    
 
    //metodo para poder traer el id y el nombre del proveedor
    public void llenarProveedor(){
        ModeloProveedores modProv = new ModeloProveedores();
        ArrayList<Proveedor> listaProveedores = modProv.getProveedor();
        int proveedorSeleccionadoId = 0;
        proveedorSeleccionadoNombre = "Nose";
        
        Proveedores.removeAllItems();
        
        for(int i = 0; i < listaProveedores.size(); i++ ){
            Proveedores.addItem(new Proveedor(listaProveedores.get(i).getId(),
                    listaProveedores.get(i).getNombre()));
            
            int indiceSeleccionado = Proveedores.getSelectedIndex();
            
            if (indiceSeleccionado == i) {
                // Guardar el ID del proveedor seleccionado
                proveedorSeleccionadoId = listaProveedores.get(i).getId();
                proveedorSeleccionadoNombre = listaProveedores.get(i).getNombre();
            }
        }    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Proveedores = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnAgregar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductosCompras = new javax.swing.JTable();
        Fecha = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        numeroFactura = new javax.swing.JFormattedTextField();
        CAI = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnEliminarP = new javax.swing.JButton();
        txt_Id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Ingresar Compra");

        jLabel2.setText("No. de Factura");

        jLabel4.setText("Proveedor:");

        Proveedores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedoresActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha");

        jLabel6.setText("CAI:");

        jLabel9.setText("Productos: ");

        btnAgregar.setBackground(new java.awt.Color(253, 253, 253));
        btnAgregar.setText("Agregar producto");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblProductosCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del producto", "Marca", "Presentación", "Cantidad", "Precio", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProductosCompras);

        Fecha.setToolTipText("");
        Fecha.setDateFormatString("yyyy/MM/dd");
        Fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FechaKeyTyped(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(253, 253, 253));
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(253, 253, 253));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        try {
            numeroFactura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        numeroFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroFacturaActionPerformed(evt);
            }
        });
        numeroFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroFacturaKeyTyped(evt);
            }
        });

        try {
            CAI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#UU#U#-##U#U#-U###UU-U##U#U-U#UU#U-#U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CAIActionPerformed(evt);
            }
        });
        CAI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CAIKeyTyped(evt);
            }
        });

        btnEliminarP.setText("Eliminar producto");
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });

        txt_Id.setEditable(false);

        jLabel3.setText("Total: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(numeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(88, 88, 88)
                        .addComponent(CAI, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(53, 53, 53)
                        .addComponent(Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel1)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(506, 506, 506)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarP)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(numeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarP)
                    .addComponent(jLabel9))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CAI.getAccessibleContext().setAccessibleParent(CAI);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblProductosCompras.getModel();
        int selectedRow = tblProductosCompras.getSelectedRow();

        if (selectedRow != -1) {
            // Si hay una fila seleccionada, elimina solo esa fila
            model.removeRow(selectedRow);
        } else {
            // Si no hay fila seleccionada, preguntar al usuario si quiere borrar todo
            int response = JOptionPane.showConfirmDialog(null, "¿Desea eliminar todas las filas?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                // Si el usuario elige "Sí", elimina todas las filas
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
            } else if (response == JOptionPane.NO_OPTION) {
                // Si el usuario elige "No", informar que debe seleccionar una fila para eliminar
                JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            // Si el usuario elige "No" o cierra la ventana de confirmación, no se hace nada.
        }
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        //Envia al usuario a la ventana para agregar producto
        ProductoParaCompra prod = new ProductoParaCompra();
        prod.setVisible(true);
        prod.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        // TODO add your handling code here:
        //cambiar el color del boton al salir
        //btnAgregar.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btnAgregarMouseExited

    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseEntered
        // TODO add your handling code here:
        //cambiar el color del boton
        //btnAgregar.setBackground(new Color(42, 126, 126));
    }//GEN-LAST:event_btnAgregarMouseEntered

    private void CAIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CAIKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CAIKeyTyped

    private void CAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CAIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CAIActionPerformed

    private void numeroFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroFacturaKeyTyped
        // TODO add your handling code here:
        char validar= evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_numeroFacturaKeyTyped

    private void numeroFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroFacturaActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProveedoresActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        //Guardar factura en la base de datos
        //variable que guarda la fecha
        String fcha = ((JTextField)Fecha.getDateEditor().getUiComponent()).getText();
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tblProductosCompras.getModel();
        String TipoDeCompra ="Al contado";
        //validaciones
        if(numeroFactura.getText().equals("   -   -  -   ") || CAI.getText().equals("      -      -      -      -      -  " )||Fecha.getDate()==(null))
        {
            JOptionPane.showMessageDialog(null,"Hay datos vacios","Error al guardar factura",JOptionPane.WARNING_MESSAGE);
        }else if(numeroFactura.getText().equals("000-000-00-000")){
            JOptionPane.showMessageDialog(null,"datos de numero de factura","Error al guardar factura",JOptionPane.WARNING_MESSAGE);
        }else if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay registros en la tabla para guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                PreparedStatement guardarCP = conection.prepareStatement("INSERT INTO comprasproductos(numeroFactura,cai,proveedor,tipoDeCompra,fecha,total)VALUES(?,?,?,?,?,?)");
                guardarCP.setString(1,numeroFactura.getText());
                guardarCP.setString(2,CAI.getText());
                Proveedor proveedorSeleccionado = (Proveedor) Proveedores.getSelectedItem();
                if (proveedorSeleccionado != null) {
                    int proveedorSeleccionadoId = proveedorSeleccionado.getId();
                    guardarCP.setInt(3, proveedorSeleccionadoId);
                }
                guardarCP.setString(4,TipoDeCompra);
                guardarCP.setString(5, fcha);
                guardarCP.setDouble(6,totalFactura);
                guardarCP.executeUpdate();
                for (int i = 0; i < model.getRowCount(); i++) {
                    // Obtener los datos de la fila actual
                    int idCompra = Integer.parseInt(txt_Id.getText());
                    String producto = model.getValueAt(i, 0).toString();
                    String Marca = model.getValueAt(i, 1).toString();
                    String presentacion = model.getValueAt(i, 2).toString();
                    int cantidad = Integer.parseInt(model.getValueAt(i, 3).toString());
                    double precio = Double.parseDouble(model.getValueAt(i, 4).toString());

                    try {
                        PreparedStatement guardarDC = conection.prepareStatement("INSERT INTO detallecompra(idCompra,producto,cantidad,tipoProducto,precio)VALUES(?,?,?,?,?)");
                        // Insertar los datos en la base de datos (personaliza la sentencia SQL)
                        guardarDC.setInt(1, idCompra);
                        guardarDC.setString(2, producto);
                        guardarDC.setInt(3, cantidad);
                        guardarDC.setString(4, presentacion);
                        guardarDC.setDouble(5, precio);
                        guardarDC.executeUpdate();
                        //this.dispose();
                        JOptionPane.showMessageDialog(null, "Factura guardada");
                        Controlador.ComprasProducto.MostrarCompras("", paginaActual, totalPages);
                        // Limpia la tabla después de guardar los registros
                        model.setRowCount(0);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al guardar el registro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        PreparedStatement guardarIP = conection.prepareStatement("INSERT INTO inventarioproductos(Producto,Marca,tipoProducto,Cantidad,Precio)VALUES(?,?,?,?,?)");
                        // Insertar los datos en la base de datos (personaliza la sentencia SQL)
                        guardarIP.setString(1, producto);
                        guardarIP.setString(2, Marca);
                        guardarIP.setString(3, presentacion);
                        guardarIP.setInt(4, cantidad);
                        guardarIP.setDouble(5, precio);
                        guardarIP.executeUpdate();
                        this.dispose();
                        Controlador.ComprasProducto.MostrarCompras("", paginaActual, totalPages);
                        // Limpia la tabla después de guardar los registros
                        model.setRowCount(0);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al guardar el registro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null,"error al registrar la factura Ya existe una factura con estos datos"+e,"No se guardo la factura",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        // TODO add your handling code here:
        //cambiar el color del boton
        //btnGuardar.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void FechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FechaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaKeyTyped
    private double totalFactura = 0.0;

    private void calcularTotalFactura() {
        DefaultTableModel model = (DefaultTableModel) tblProductosCompras.getModel();
        totalFactura = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) {
            double subtotal = Double.parseDouble(model.getValueAt(i, 5).toString());
            totalFactura += subtotal;
        }

        jLabel3.setText("Total: " + totalFactura);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CAI;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JComboBox Proveedores;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JFormattedTextField numeroFactura;
    public static javax.swing.JTable tblProductosCompras;
    public static javax.swing.JTextField txt_Id;
    // End of variables declaration//GEN-END:variables

   
}
