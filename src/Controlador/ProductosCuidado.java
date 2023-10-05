/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import ConsultasSQL.QuerysProductosCuidados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductosCuidado {
    
     private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    
    
    public static boolean Guardar(QuerysProductosCuidados qp) {
    String sql = QuerysProductosCuidados.RegistraProducto; 

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, qp.getNombre());
            ps.setString(2, qp.getMarca());
            ps.setString(3, qp.getTamano());
            ps.setString(4, qp.getCategoria());
            ps.setString(5, qp.getDescripcion());

            ps.executeUpdate();
            return true; 
        } catch (SQLException ex) {
            Logger.getLogger(ProductosCuidado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
