/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import ConsultasSQL.QuerysClientes;
//import Conexion.Conexion;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


import ConsultasSQL.QuerysClientes;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandra Suárez
 */
public class Clientes {
    private static Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;
    
    public static boolean Guardar(QuerysClientes qp){
    String sql= QuerysClientes.RegistrarClientes;
    try{
        ps = conexion.prepareStatement(sql);
       ps.setString(1,qp.getNombre());
       ps.setString(2,qp.getApellido());
       ps.setString(3,qp.getTelefono());
       ps.setString(4,qp.getDireccion());
       ps.setString(5,qp.getFechaNacimiento());
       ps.setString(6,qp.getFechaRegistro());
        
        
        ps.executeUpdate();
       return true;
       
        
              
    } catch (SQLException ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
        return false;
    }
    }   
}
