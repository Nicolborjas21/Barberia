/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import Vistas.MostrarCompras;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

//Dentro del metodo publico se realiza la conexion a la base de datos para las compras
public class ComprasProducto {
    private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    private static final int filasxPagina = 20;   
        public static int NumeroPages(){
                String sql = ""; 
                sql = "SELECT count(*) from comprasproductos";

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
                Logger.getLogger(ComprasProducto.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }

        }
    
    public static void MostrarCompras(String buscar, int paginaActual, int totalPages){
        DefaultTableModel model = (DefaultTableModel)MostrarCompras.tblMostrarCompras.getModel();
           while(model.getRowCount() > 0 ){
            model.removeRow(0);
        }
        String sql = "";
                if (buscar.isEmpty()) {
                sql = "SELECT CP.id, CP.numeroFactura, CP.cai, P.empresa, CP.tipoDeCompra, CP.fecha FROM comprasproductos AS CP JOIN provedores AS P ON CP.proveedor = P.id WHERE CP.fecha LIKE '%" + buscar + "%' or "+" P.empresa LIKE '%" + buscar + "%' or "+"CP.numeroFactura LIKE'%" + buscar + "%' limit " + filasxPagina + " offset " + (paginaActual - 1) * filasxPagina;
                } else {
                sql = "SELECT CP.id, CP.numeroFactura, CP.cai, P.empresa, CP.tipoDeCompra, CP.fecha FROM comprasproductos AS CP JOIN provedores AS P ON CP.proveedor = P.id WHERE CP.fecha LIKE '%" + buscar + "%' or "+"P.empresa LIKE '%" + buscar + "%' or "+"CP.numeroFactura LIKE'%" + buscar + "%'";
                }
 
        
        String datos[] = new String[6];
        
        try{
        
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                datos[0] = rs.getString("CP.numeroFactura");
                datos[1] = rs.getString("CP.cai");
                datos[2] = rs.getString("P.empresa");
                datos[3] = rs.getString("CP.tipoDeCompra");
                datos[4] = rs.getString("CP.fecha");
                datos[5] = rs.getString("CP.id");
                model.addRow(datos);
                totalPages = NumeroPages();
                MostrarCompras.seguimiento.setText("Página " + paginaActual + " de " + totalPages);
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(SwingConstants.RIGHT);
                MostrarCompras.tblMostrarCompras.setModel(model);
                
            }
           
        }catch (SQLException ex){
            Logger.getLogger(ComprasProducto.class.getName()).log(Level.SEVERE, null, ex);
            
        }
            
    }

    public static Object getItemAt(int selectedIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
