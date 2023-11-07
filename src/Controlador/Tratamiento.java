/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import ConsultasSQL.QuerysTratamiento;
//import static Controlador.TiposCortes.NumeroPages;
import Vistas.MostrarCortes;
import Vistas.MostrarTratamientos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.html.HTML.Attribute.ID;


/**
 *
 * @author Josue
 */
public class Tratamiento {
    private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;

    // Declarar una variable para establecer el tamaño de la página (número de elementos a mostrar por página)
    public static final int PAGE_SIZE = 5;
    // Declarar una variable para almacenar el número de página actual
    public static int currentPage = 1;
    // Declarar una variable para almacenar el número total de páginas
    public static int totalPages = 1;


    public static boolean Guardar(QuerysTratamiento qp){
        String sql = QuerysTratamiento.RegistroTratamiento;

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, qp.getNombre());
            ps.setString(2, qp.getTipoTratamiento());
            ps.setString(3, qp.getDescripcion());
            Blob blob1 = conexion.createBlob();
            blob1.setBytes(1, qp.getFoto1());
            ps.setBlob(4, blob1);
            
            Blob blob2 = conexion.createBlob();
            blob2.setBytes(1, qp.getFoto2());
            ps.setBlob(5, blob2);

            ps.setString(6, qp.getNomreProductos());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
            // Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public static void MostrarTratamientos(){
        DefaultTableModel model = (DefaultTableModel)MostrarTratamientos.tblMostrarTratamiento.getModel();
        
            
        String sql = QuerysTratamiento.ListarTratamiento;

       
            
        String datos[] = new String[8];
        try{
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            int count = 1;
            
            
           
            while(rs.next()){
                datos[0] = count+"";
                datos[1] = rs.getString("id");
                datos[2] = rs.getString("Nombre");
                datos[3] = rs.getString("tipoTratamiento");
                datos[4] = rs.getString("Descripcion");
                datos[5] = rs.getString("Foto1");
                datos[6] = rs.getString("Foto2");
                datos[7] = rs.getString("NombreProductos");
                model.addRow(datos);
                //MostrarEmpleados.tblMostrarEmpleados.getColumnModel().getColumn(4).setCellRenderer(tcr);
                count++;
            }
            MostrarTratamientos.tblMostrarTratamiento.setModel(model);
            
                
        }catch (SQLException ex){
            Logger.getLogger(Tratamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}


