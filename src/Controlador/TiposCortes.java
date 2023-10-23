/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import ConsultasSQL.QuerysCortes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Blob;

/**
 *
 * @author Josue
 */
public class TiposCortes {
     private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    
    
    public static boolean Guardar(QuerysCortes qp){
        String sql = QuerysCortes.RegistraCortes;
        
        try{
        ps = conexion.prepareStatement(sql);
        ps.setString(1, qp.getNombre_cortr());
       Blob blob = conexion.createBlob();
            blob.setBytes(1, qp.getCorte());
            ps.setBlob(2, blob);
            blob.setBytes(1, qp.getCorte2());
            ps.setBlob(3, blob);
            blob.setBytes(1, qp.getCorte3());
            ps.setBlob(4, blob);
        ps.setDouble(5, qp.getPrecio());
        ps.setString(6, qp.getDescripcion());
        
        
        
        ps.executeUpdate();
        return true;
        } catch (SQLException ex){
            return false;
//            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
