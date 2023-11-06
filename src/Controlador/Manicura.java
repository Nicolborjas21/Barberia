/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import ConsultasSQL.QuerysManicura;
import java.sql.Blob;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author Josue
 */
public class Manicura {
    private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    
    public static boolean Guardar(QuerysManicura qp) {
        String sql = QuerysManicura.RegistraManicura;

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, qp.getEstilo());
            ps.setDouble(2, qp.getPrecio());
            ps.setString(3, qp.getTecnica());
            
            Blob blob1 = conexion.createBlob();       
            blob1.setBytes(1, qp.getFoto());
            ps.setBlob(4, blob1);
            
            Blob blob2 = conexion.createBlob();
            blob2.setBytes(1, qp.getFoto1());
            ps.setBlob(5, blob2);
            
            ps.setString(6, qp.getEsmaltado());
            ps.setString(7, qp.getDescripcion());

            int rowsAffected = ps.executeUpdate();
            
            // Verifica si se insertaron registros con éxito
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Imprime la excepción para depuración
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // Imprime la excepción para depuración
            }
        }
    }
    public static boolean Editar(QuerysManicura qp){
    
    String sql = QuerysManicura.ActualizarManicura;
            try{
             ps =conexion.prepareStatement(sql);
             ps.setInt(1, qp.getId());
            ps.setString(2, qp.getEstilo());
            ps.setDouble(3, qp.getPrecio());
            ps.setString(4, qp.getTecnica());
            
            Blob blob1 = conexion.createBlob();       
            blob1.setBytes(1, qp.getFoto());
            ps.setBlob(5, blob1);
            
            Blob blob2 = conexion.createBlob();
            blob2.setBytes(1, qp.getFoto1());
            ps.setBlob(6, blob2);
            
            ps.setString(7, qp.getEsmaltado());
            ps.setString(8, qp.getDescripcion());

            int rowsAffected = ps.executeUpdate();
            
            // Verifica si se insertaron registros con éxito
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Imprime la excepción para depuración
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // Imprime la excepción para depuración
            }
        }
    }
}
