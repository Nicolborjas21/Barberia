/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import ConsultasSQL.QuerysTratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Blob;


/**
 *
 * @author Josue
 */
public class Tratamiento {
        private static Conexion con = new Conexion();
        private static Connection conexion = con.getConexion();
        private static PreparedStatement ps = null;

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
    
}


