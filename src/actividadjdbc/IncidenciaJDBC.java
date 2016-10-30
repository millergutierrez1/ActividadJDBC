/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author guti8
 */
public class IncidenciaJDBC {
    
    private Connection conexion; // Conexion con la base de datos.
    
    public void insertEmpleado(Empleado e) throws SQLException{ 
        // me pasan un Empleado
        
        sync();
        
        String insert = "insert into empleado values(?,?,?,?,?)";
        PreparedStatement consultaParametro = conexion.prepareStatement(insert);
        consultaParametro.setInt(1, e.getUsuario()); // Le decimos que pille Empleado e usuario int
        consultaParametro.setString(2, e.getContrasena());
        consultaParametro.setString(3, e.getNombre());
        consultaParametro.setString(4, e.getApellido());
        consultaParametro.setInt(5, e.getTelefono());
        
        consultaParametro.executeUpdate(); // genera la consulta a la base de datos.
        syncOff(); // Desconecta
                

        
        
    }
    
    private void sync() throws SQLException{ //Genero Conexion on Mysql.
        String url = "jdbc:mysql://localhost:3306/jdbc_gestion_incidencias";
        String usr = "root";
        String pass = "Root123**";
        conexion = DriverManager.getConnection(url, usr, pass);
                
    }
    
    private void syncOff() throws SQLException{
        conexion.close();
    }    
    
}
