/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import ConsultasSQL.QuerysTratamiento;
import Vistas.MostrarTratamientos;
//import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Blob;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.JOptionPane;
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
        private static final int filasxPagina = 20;
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
                ps.setString(7,qp.getEstado());

                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                return false;
                // Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
            } 
         }
    public static int NumeroPages(String buscar,int paginaActual, String estado, String otro) {
        String textoEstado = "";
        String texttoOtro = "";
            if(estado.equals("Todos")){
                textoEstado = "";
            }if(estado.equals("capilares")){
                 textoEstado = " tipoTratamiento= 'capilares' and ";
            }
            if(estado.equals("faciales")){
                 textoEstado = " tipoTratamiento = 'faciales' and ";
            }
            
             if(otro.equals("Todos")){
                texttoOtro = "";
            }if(otro.equals("Activo")){
                 texttoOtro = " estado= 'Activo' and ";
            }
            if(otro.equals("Inactivo")){
                 texttoOtro = " estado = 'Inactivo' and ";
            }
           
            String sql = "";
             if (buscar.isEmpty()) {
            buscar = "";
            //sql = "SELECT count(*) from tratamientos";
            sql = "SELECT count(*) from tratamientos WHERE "+textoEstado+" "+texttoOtro+" (nombre like '%"+buscar+"%')";

        } else {

            sql = "SELECT count(*) from tratamientos WHERE "+textoEstado+" "+texttoOtro+" (nombre like '%"+buscar+"%')";

        }
            
            
           
            
        try{
            Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int totalPages = (int) Math.ceil((double) rs.getInt(1) / filasxPagina);
                return totalPages;
            } else {
                return 1;
            }
        }catch (SQLException ex){
            Logger.getLogger(Tratamiento.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void MostrarTratamientos(String buscar, int paginaActual, int totalPages,String estado, String otro){
        DefaultTableModel model = (DefaultTableModel)MostrarTratamientos.tblMostrarTratamiento.getModel();
        String texttoOtro="";
        String textoEstado = "";
            if(estado.equals("Todos")){
                textoEstado = "";
            }if(estado.equals("capilares")){
                 textoEstado = " tipoTratamiento = 'capilares' and ";
            }
            if(estado.equals("faciales")){
                 textoEstado = " tipoTratamiento = 'faciales' and ";
            }
            
            if(otro.equals("Todos")){
                texttoOtro = "";
            }if(otro.equals("Activo")){
                 texttoOtro = " estado= 'Activo' and ";
            }
            if(otro.equals("Inactivo")){
                 texttoOtro = " estado = 'Inactivo' and ";
            }
           
         while (model.getRowCount() > 0) {
            model.removeRow(0);
            
              MostrarTratamientos.tblMostrarTratamiento.getColumnModel().getColumn(1).setMaxWidth(0);
           MostrarTratamientos.tblMostrarTratamiento.getColumnModel().getColumn(1).setMinWidth(0);
            MostrarTratamientos.tblMostrarTratamiento.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
            MostrarTratamientos.tblMostrarTratamiento.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
            
           MostrarTratamientos.tblMostrarTratamiento.getColumnModel().getColumn(4).setMaxWidth(0);
           MostrarTratamientos.tblMostrarTratamiento.getColumnModel().getColumn(4).setMinWidth(0);
            MostrarTratamientos.tblMostrarTratamiento.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
            MostrarTratamientos.tblMostrarTratamiento.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
            
            MostrarTratamientos.tblMostrarTratamiento.getColumnModel().getColumn(5).setMaxWidth(0);
           MostrarTratamientos.tblMostrarTratamiento.getColumnModel().getColumn(5).setMinWidth(0);
            MostrarTratamientos.tblMostrarTratamiento.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
            MostrarTratamientos.tblMostrarTratamiento.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
            
               MostrarTratamientos.tblMostrarTratamiento.getColumnModel().getColumn(6).setMaxWidth(0);
           MostrarTratamientos.tblMostrarTratamiento.getColumnModel().getColumn(6).setMinWidth(0);
            MostrarTratamientos.tblMostrarTratamiento.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            MostrarTratamientos.tblMostrarTratamiento.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
             
            MostrarTratamientos.tblMostrarTratamiento.getColumnModel().getColumn(7).setMaxWidth(0);
           MostrarTratamientos.tblMostrarTratamiento.getColumnModel().getColumn(7).setMinWidth(0);
            MostrarTratamientos.tblMostrarTratamiento.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
            MostrarTratamientos.tblMostrarTratamiento.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
            
        }
         
         
             String sql= "";
         
        if (buscar.isEmpty()){
            sql = "select * from tratamientos WHERE "+textoEstado+" "+texttoOtro+" nombre like ('%" + buscar + "%') limit " +
                    filasxPagina + " offset " + (paginaActual - 1) * filasxPagina;
            MostrarTratamientos.siguiente1.setVisible(true);
            MostrarTratamientos.Previo1.setVisible(true);
            MostrarTratamientos.seguimiento1.setVisible(true);
        } else {
            //sql = "select * from tratamientos WHERE "+textoEstado+" nombre like '%" + buscar + "%'";
            sql = "select * from tratamientos WHERE "+textoEstado+" "+texttoOtro+" nombre like ('%" + buscar + "%') limit " +
                    filasxPagina + " offset " + (paginaActual - 1) * filasxPagina;
            MostrarTratamientos.siguiente1.setVisible(true);
            MostrarTratamientos.Previo1.setVisible(true);
            MostrarTratamientos.seguimiento1.setVisible(true);
            
        }
     
         
       
            
     

       
            
        String datos[] = new String[9];
        try{
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            int count = 0;
            if (paginaActual == 1) {
                count = 1;
            } else {
                for (int i = 1; i < paginaActual; i++) {
                    count += 20;
                }
                count += 1;
            }
            
           
            while(rs.next()){
                datos[0] = count+"";
                datos[1] = rs.getString("id");
                datos[2] = rs.getString("Nombre");
                datos[3] = rs.getString("tipoTratamiento");
                datos[4] = rs.getString("Descripcion");
                datos[5] = rs.getString("Foto1");
                datos[6] = rs.getString("Foto2");
                datos[7] = rs.getString("NombreProductos");
                datos[8] = rs.getString("estado");
                model.addRow(datos);
                //MostrarEmpleados.tblMostrarEmpleados.getColumnModel().getColumn(4).setCellRenderer(tcr);
                count++;
            }
            int totalRows = count - 1;
            totalPages = (NumeroPages(buscar,1,estado, otro) == 0 && model.getRowCount() >= 0) ? 1 : NumeroPages(buscar,1,estado, otro);
             MostrarTratamientos.seguimiento1.setText("Página " + paginaActual + " de " + totalPages);
             paginaActual = model.getRowCount() == 0 ? 0 : paginaActual;
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        
            tcr.setHorizontalAlignment(SwingConstants.RIGHT);
            MostrarTratamientos.tblMostrarTratamiento.setModel(model);
            
                
        }catch (SQLException ex){
            Logger.getLogger(Tratamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


