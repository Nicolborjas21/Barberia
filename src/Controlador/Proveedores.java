/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import ConsultasSQL.QuerysProveedores;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import Vistas.MostrarProveedores;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author 
 */
public class Proveedores {
    
    private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    
    public static void MostrarProvedores(String buscar){
        DefaultTableModel model = (DefaultTableModel)MostrarProveedores.tblMostrarProveedores.getModel();
        while(model.getRowCount() > 0 ){
                model.removeRow(0);
                
                
               /* 
                MostrarProveedores.tblMostrarProveedores.getColumnModel().getColumn(0).setMaxWidth(0);
                MostrarProveedores.tblMostrarProveedores.getColumnModel().getColumn(0).setMinWidth(0);
                MostrarProveedores.tblMostrarProveedores.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
                MostrarProveedores.tblMostrarProveedores.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
          */ }
            
            String sql = "";
            if(buscar.equals("")){
                sql = QuerysProveedores.LISTARPROVEEDORES;
                
            } 
            if (buscar == null){
                sql = QuerysProveedores.LISTARPROVEEDORES;
            }else {
                sql = "SELECT * FROM proveedores WHERE nombre LIKE ('%" + buscar + "%') or empresa LIKE ('%" + buscar + "%') ";
            }
            
        
        String datos[] = new String[6];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
           
            int count = 1;
            while(rs.next()){
                datos[0] = count+"";
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("empresa");
                datos[3] = rs.getString("rtn");
                datos[4] = rs.getString("telefono");
                datos[5] = rs.getString("direccion");
                model.addRow(datos);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                MostrarProveedores.tblMostrarProveedores.setModel(model);
                //MostrarProveedores.tblMostrarProveedores.getColumnModel().getColumn(4).setCellRenderer(tcr);
                count++;
                
                
                
            }
           // MOSTRARCARGO.tblCa.setModel(modelo);//la tabla se actualiza. HacerCalculos(r);
        }catch (SQLException ex){
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    
    public static boolean ValidarTelefon(String buscar){
            String sql = ""; 
            sql = "SELECT * FROM proveedores WHERE telefono=?";
        
        try{
             Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, buscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        }catch (SQLException ex){
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
    public static boolean ValidarRtn(String buscar){
            String sql = ""; 
            sql = "SELECT * FROM proveedores WHERE rtn=?";
        
        try{
             Statement st = conexion.createStatement();
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, buscar);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        }catch (SQLException ex){
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public static boolean Guardar(QuerysProveedores qp){
        String sql = QuerysProveedores.RegistraProveedor;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, qp.getNombre());
        ps.setString(2, qp.getEmpresa());
        ps.setString(3, qp.getRtn());
        ps.setString(4, qp.getTelefono());
        ps.setString(5, qp.getDireccion());
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean Editar(QuerysProveedores qp){
    
    String sql = QuerysProveedores.ACTUALIZARPROVEEDOR;
            try{
             ps =conexion.prepareStatement(sql);
             ps.setInt(0, qp.getId());
             ps.setString(1, qp.getNombre());
             ps.setString(2, qp.getEmpresa());
             ps.setString(3, qp.getRtn());
             ps.setString(4, qp.getTelefono());
             ps.setString(5, qp.getDireccion());
             
             ps.executeUpdate();
            }catch(SQLException ex){
            return true;
            }
        return false;
        
    
    }
}
