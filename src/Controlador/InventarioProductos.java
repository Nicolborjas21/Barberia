/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import ConsultasSQL.QuerysInventarioProductos;
import Vistas.MostrarInventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Josue
 */
public class InventarioProductos {
    
    
    // Establecer la conexión a la base de datos
    private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    private static final int filasxPagina = 20;   
    public static int NumeroPages(){
                String sql = ""; 
                sql = "SELECT count(*) from inventarioproductos";

            try{
                 Statement st = conexion.createStatement();

                ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int totalPages = (int) Math.ceil((double) rs.getInt(1) / filasxPagina);
                    return totalPages;
                } else {
                    return 0;
                }
            }catch (SQLException ex){
                Logger.getLogger(MostrarInventario.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }

        }
        
    public static void MostrarProductos(String buscar, int paginaActual, int totalPages){
        DefaultTableModel model = (DefaultTableModel)MostrarInventario.tblMostrarInventario.getModel();
        while (model.getRowCount() > 0 ){
                model.removeRow(0);
               
    }
    
            
            String sql = "SELECT * FROM inventarioproductos WHERE producto LIKE ('%" + buscar + "%') or tipo_producto LIKE ('%" + buscar + "%') ";
          
           
            if (buscar == null){
                 sql = QuerysInventarioProductos.LISTARINVENTARIO;
            } else {

               sql = "SELECT * FROM inventarioproductos WHERE producto LIKE ('%" + buscar + "%') ";
           
            }            
        
        String datos[] = new String[5];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
           
            int count = 1;
            while(rs.next()){
                datos[0] = count+"";
                datos[1] = rs.getString("producto");
                datos[2] = rs.getString("cantidad");
                datos[3] = rs.getString("precio");
                datos[4] = rs.getString( "id");
                model.addRow(datos);
                
                int totalRows = count - 1; // Restamos el encabezado de la tabla
                totalPages = NumeroPages();
                MostrarInventario.seguimiento.setText("Página " + paginaActual + " de " + totalPages);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                MostrarInventario.tblMostrarInventario.setModel(model);
                count++;
              
                
            }
           
        }catch (SQLException ex){
           Logger.getLogger(InventarioProductos.class.getName()).log(Level.SEVERE,null, ex);
            
        }
        
    }
    
    }

