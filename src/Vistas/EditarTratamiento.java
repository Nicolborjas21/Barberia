/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Conexion.Conexion;
import ConsultasSQL.QuerysTratamiento;
import javax.swing.DefaultListModel;
import Controlador.Tratamiento;
import static Vistas.VerTratamiento.tTratamiento;
import static Vistas.VerTratamiento.txtProductos;
import com.mysql.cj.jdbc.Blob;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;

/**
 *
 * @author PC
 */
public class EditarTratamiento extends javax.swing.JFrame {
    private String idTratamiento;
    private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    public static BufferedImage Foto1Image;
    public static BufferedImage Foto2Image;
    public EditarTratamiento(String idTratamiento) throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        this.idTratamiento = idTratamiento;
        // Aquí deberías usar el ID para cargar los datos del corte en los componentes visuales (por ejemplo, lblNombre, lblPrecio, etc.).
        cargarDatosDelTratamiento();
    }
    
    private EditarTratamiento() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    private void cargarDatosDelTratamiento() {
        
        try {
            
             // Cargar la consulta SQL desde el archivo 'QuerysCortes'.
            String consultaSQL = QuerysTratamiento.VerFoto;
        
            // Crear una sentencia preparada con la consulta SQL.
            PreparedStatement ps = conexion.prepareStatement(consultaSQL);
            ps.setString(1, idTratamiento); 
        
            // Ejecutar la consulta y obtener el resultado.
            var rs = ps.executeQuery();
        
            if(rs.next()){
                Blob Foto1Blob = (Blob) rs.getBlob("Foto1");
                Blob Foto2Blob = (Blob) rs.getBlob("Foto2");
            
                InputStream foto1Stream = Foto1Blob.getBinaryStream();
                InputStream foto2Stream = Foto2Blob.getBinaryStream();
            
                Foto1Image = ImageIO.read(foto1Stream);
                Foto2Image = ImageIO.read(foto2Stream);
            
           
                // Tamaño fijo para las imágenes
                int imagenAncho = 200; // Ancho deseado en píxeles
                int imagenAlto = 200; // Alto deseado en píxeles
            
                if (Foto1Image != null) {
                    Foto1Image = resizeImage(Foto1Image, imagenAncho, imagenAlto);
                    Label_Foto1.setIcon(new ImageIcon(Foto1Image));
                    Label_Foto1.setText(""); // Borra cualquier texto previo
                } else {
                    Label_Foto1.setText("<html><div style='text-align: center;'>No hay imagen<br>disponible</div></html>");
                    Label_Foto1.setForeground(Color.RED);
                }
                if (Foto2Image != null) {
                    Foto2Image = resizeImage(Foto2Image, imagenAncho, imagenAlto);
                    Label_Foto2.setIcon(new ImageIcon(Foto2Image));
                    Label_Foto2.setText(""); // Borra cualquier texto previo
                } else {
                    Label_Foto2.setText("<html><div style='text-align: center;'>No hay imagen<br>disponible</div></html>");
                    Label_Foto2.setForeground(Color.RED);
                }
            }
            // Cierra los recursos (ResultSet, PreparedStatement).
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    public BufferedImage getFoto1Image() {
        return Foto1Image;
    }
    
    public BufferedImage getFoto2Image() {
        return Foto2Image;
    }
    
    // Método para redimensionar la imagen a un tamaño específico
    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics.dispose();
        return resizedImage;
    }

    /**
     * Creates new form EditarTratamiento
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        Label_Foto1 = new javax.swing.JLabel();
        Label_Foto2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxTipoTratamiento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JtListadoProductos = new javax.swing.JList<>();
        BtnAgregarListado = new javax.swing.JButton();
        BtnLimpiarListado = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Editar tratamiento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 200, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Nombre del tratamiento:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Descripción:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 230, -1));

        btnGuardar.setBackground(new java.awt.Color(249, 253, 250));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(249, 253, 250));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 570, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Fotos:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 230, 100));

        Label_Foto1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Label_Foto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Foto1.setText("Foto 1");
        Label_Foto1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Label_Foto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_Foto1MouseClicked(evt);
            }
        });
        jPanel1.add(Label_Foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 190, 180));

        Label_Foto2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Label_Foto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Foto2.setText("Foto 2");
        Label_Foto2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Label_Foto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_Foto2MouseClicked(evt);
            }
        });
        jPanel1.add(Label_Foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 190, 180));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Tipo de tratamiento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        cbxTipoTratamiento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbxTipoTratamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "a", "b", "c", "d", "e", "f" }));
        jPanel1.add(cbxTipoTratamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 230, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ListaodologoBarberia.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 120, 100));

        JtListadoProductos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(JtListadoProductos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 230, 190));

        BtnAgregarListado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/añadir.png"))); // NOI18N
        BtnAgregarListado.setText("Agregar");
        BtnAgregarListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarListadoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregarListado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, -1, 40));

        BtnLimpiarListado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelarr.png"))); // NOI18N
        BtnLimpiarListado.setText("Limpiar");
        BtnLimpiarListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarListadoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnLimpiarListado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, -1, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Listado:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        txtNombre.setText(txtNombre.getText().replaceAll("( )+", " "));
        if (txtNombre.getText().length() == 0 && evt.getKeyChar() == ' ') {
            evt.consume();
        }

        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
        int tam = txtNombre.getText().length();
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
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String foto = Label_Foto1.getText().trim();
        String foto1 = Label_Foto2.getText().trim();
        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del tratamiento no puede estar vacío", "Error de validación", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si el campo está vacío
        }

        String TipoTratamiento = cbxTipoTratamiento.getSelectedItem().toString(); // que no este vacio, que solo seleccione 1
        if(TipoTratamiento.equals("seleccione un tratamiento")){
            JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna tratamiento", "Error de validación", JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método si el campo está vacío
        }

        String direccion = txtDescripcion.getText().trim();

        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía", "Error de validación", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si el campo está vacío
        }

        if (!direccion.matches("[a-zA-Z0-9áéíóúñÁÉÍÓÚÑ][a-zA-Z0-9 áéíóúñÁÉÍÓÚÑü.:;,-]+")) {
            if (direccion.length() > 0) {
                JOptionPane.showMessageDialog(null, "Alguno de los caracteres que ingresó en la descripción no es válido", "Error de validación", JOptionPane.WARNING_MESSAGE);
                return; // Salir del método
            }
        }

        // Validación de la imagen

        QuerysTratamiento querys = new QuerysTratamiento();
        querys.setNombre(nombre);
        querys.setDescripcion(direccion);
        querys.setTipoTratamiento(TipoTratamiento);
        DefaultListModel<String> listModel = (DefaultListModel<String>) JtListadoProductos.getModel();
        int listSize = listModel.getSize();

        if (listSize > 0) {
            StringBuilder productos = new StringBuilder();

            // Itera a través de los elementos del JList y concaténalos en la cadena "productos"
            for (int i = 0; i < listSize; i++) {
                String producto = listModel.getElementAt(i);
                productos.append(producto);

                // Agrega una coma y un espacio si no es el último elemento
                if (i < listSize - 1) {
                    productos.append(", ");
                }

            }
            querys.setNomreProductos(productos.toString());
            listModel.clear();
        }

        byte[] imagenBytes = obtenerBytesDeImagen(foto);
        byte[] imageBytes = obtenerBytesDeImage(foto1);
        if (imagenBytes != null) {
            querys.setFoto1(imagenBytes);
            if(imageBytes != null){
                querys.setFoto2(imageBytes);
                if (Tratamiento.Guardar(querys)) {
                    JOptionPane.showMessageDialog(null, "Nuevo tratamiento ingresado exitosamente");
                    this.dispose();
                    Tratamiento.MostrarTratamientos();
                } else {
                    JOptionPane.showMessageDialog(null, "Algo falló, consulte con el administrador del sistema", "Error al guardar", JOptionPane.OK_OPTION);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private byte[] obtenerBytesDeImagen(String rutaImagen) {
   
    File archivoImagen = new File(rutaImagen);
    
    // Verificar si el archivo de imagen existe
   if (!archivoImagen.exists()) {
        JOptionPane.showMessageDialog(null, "Debe selecionar una imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return null; // Retorna null si el archivo no existe
    }

    // Continuar con la carga de la imagen
    try {
        FileInputStream fis = new FileInputStream(archivoImagen);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        return bos.toByteArray();
    } catch (IOException e) {
        e.printStackTrace();
        return null; // Retorna null si hay un error al cargar la imagen
    }
}
    
     private byte[] obtenerBytesDeImage(String rutaImagen) {
   
    File archivoImagen = new File(rutaImagen);
    
    // Verificar si el archivo de imagen existe
   if (!archivoImagen.exists()) {
        JOptionPane.showMessageDialog(null, "Debe selecionar una imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return null; // Retorna null si el archivo no existe
    }

    // Continuar con la carga de la imagen
    try {
        FileInputStream fis = new FileInputStream(archivoImagen);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        return bos.toByteArray();
    } catch (IOException e) {
        e.printStackTrace();
        return null; // Retorna null si hay un error al cargar la imagen
    }
}
     private byte[] obtenerByteDeImagen (String rutaImagen) {
   
    File archivoImagen = new File(rutaImagen);
    
    // Verificar si el archivo de imagen existe
   if (!archivoImagen.exists()) {
        JOptionPane.showMessageDialog(null, "Debe selecionar una imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
        return null; // Retorna null si el archivo no existe
    }

    // Continuar con la carga de la imagen
    try {
        FileInputStream fis = new FileInputStream(archivoImagen);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        return bos.toByteArray();
    } catch (IOException e) {
        e.printStackTrace();
        return null; // Retorna null si hay un error al cargar la imagen
    }
}
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped

        txtDescripcion.setText(txtDescripcion.getText().replaceAll("( )+", " "));
        if (txtDescripcion.getText().length() == 0 && evt.getKeyChar() == ' ') {
            evt.consume();
        }

        char c = evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
        }
        int tam = txtDescripcion.getText().length();
        if(tam>=180){
            evt.consume();
        }  else if((int)evt.getKeyChar()>32 && (int)evt.getKeyChar()<=47
            ||(int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
            ||(int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96
            ||(int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=159
            ||(int)evt.getKeyChar()>=166 && (int)evt.getKeyChar()<=255){
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void Label_Foto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_Foto1MouseClicked

        JFileChooser se = new JFileChooser();

        // Agregar un filtro para seleccionar solo archivos PNG
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes PNG", "jpg");
        se.setFileFilter(filter);

        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);

        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                File archivoSeleccionado = se.getSelectedFile();

                if (archivoSeleccionado != null) {
                    String ruaImagen = archivoSeleccionado.getAbsolutePath();
                    byte[] imagenBytes = obtenerBytesDeImagen(ruaImagen);

                    if (imagenBytes != null) {
                        ImageIcon icono = new ImageIcon(imagenBytes);
                        Image imagen = icono.getImage();

                        // Redimensionar la imagen para ajustar al tamaño del Label_Foto
                        int ancho = Label_Foto1.getWidth();
                        int alto = Label_Foto1.getHeight();
                        Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

                        // Crear un nuevo ImageIcon con la imagen redimensionada
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

                        // Mostrar la imagen en el componente Label_Foto
                        Label_Foto1.setIcon(iconoRedimensionado);
                        Label_Foto1.setText(ruaImagen); // Actualiza el texto del Label con la ruta
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_Label_Foto1MouseClicked

    private void Label_Foto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_Foto2MouseClicked

        JFileChooser se = new JFileChooser();

        // Agregar un filtro para seleccionar solo archivos PNG
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes PNG", "jpg");
        se.setFileFilter(filter);

        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);

        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                File archivoSeleccionado = se.getSelectedFile();

                if (archivoSeleccionado != null) {
                    String rutImagen = archivoSeleccionado.getAbsolutePath();
                    byte[] imageBytes = obtenerBytesDeImagen(rutImagen);

                    if (imageBytes != null) {
                        ImageIcon icono = new ImageIcon(imageBytes);
                        Image imagen = icono.getImage();

                        // Redimensionar la imagen para ajustar al tamaño del Label_Foto
                        int ancho = Label_Foto2.getWidth();
                        int alto = Label_Foto2.getHeight();
                        Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

                        // Crear un nuevo ImageIcon con la imagen redimensionada
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

                        // Mostrar la imagen en el componente Label_Foto
                        Label_Foto2.setIcon(iconoRedimensionado);
                        Label_Foto2.setText(rutImagen); // Actualiza el texto del Label con la ruta
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen", "Error de validación", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_Label_Foto2MouseClicked

        public static void agregarProductoAListado(String nombreProducto) {
            DefaultListModel<String> listModel = (DefaultListModel<String>) JtListadoProductos.getModel();
            listModel.addElement(nombreProducto);
            JtListadoProductos.setModel(listModel);
        }    
    
    private void BtnAgregarListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarListadoActionPerformed
        ProductoParaTratamiento prod = new ProductoParaTratamiento();
        prod.setVisible(true);
        prod.setLocationRelativeTo(null);
    }//GEN-LAST:event_BtnAgregarListadoActionPerformed

    private void BtnLimpiarListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarListadoActionPerformed
        DefaultListModel<String> listModel = (DefaultListModel<String>) JtListadoProductos.getModel();
        listModel.clear();
    }//GEN-LAST:event_BtnLimpiarListadoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

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
            java.util.logging.Logger.getLogger(EditarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarTratamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarTratamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarListado;
    private javax.swing.JButton BtnLimpiarListado;
    public static javax.swing.JList<String> JtListadoProductos;
    public static javax.swing.JLabel Label_Foto1;
    public static javax.swing.JLabel Label_Foto2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    public static javax.swing.JComboBox<String> cbxTipoTratamiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextArea txtDescripcion;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
