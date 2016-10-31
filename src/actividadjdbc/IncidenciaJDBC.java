/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadjdbc;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guti8
 */
public class IncidenciaJDBC {

    private Connection conexion; // Conexion con la base de datos.

    public void insertEmpleado(Empleado e) throws SQLException {
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

    public void updateEmpleadoContrasena(Empleado e) throws SQLException {

        sync();
        String updateUsuario = "update empleado set contrasena= ? where usuario = ?";
        PreparedStatement updateParametro = conexion.prepareStatement(updateUsuario);
        updateParametro.setString(1, e.getContrasena());
        updateParametro.executeUpdate();
        syncOff();
                


    }

    public List<Empleado> selectAllEmpleados() throws SQLException {
        sync();
        List<Empleado> lista = new ArrayList<>();
        String query = "select * from empleado";
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery(query);

        while (resultado.next()) {
            Empleado nuevoE = new Empleado();
            nuevoE.setUsuario(resultado.getInt("usuario"));
            nuevoE.setContrasena(resultado.getString("contrasena"));
            nuevoE.setNombre(resultado.getString("nombre"));
            nuevoE.setApellido(resultado.getString("apellido"));
            nuevoE.setTelefono(resultado.getInt("telefono"));
            lista.add(nuevoE);

        }

        resultado.close();
        consulta.close();
        syncOff();
        return lista;
    }

    private void sync() throws SQLException { //Genero Conexion on Mysql.
        String url = "jdbc:mysql://localhost:3306/jdbc_gestion_incidencias"; // Inicia conexion.
        String usr = "root"; //usuario 
        String pass = "Root123**"; //psswd
        conexion = DriverManager.getConnection(url, usr, pass);

    }

    private void syncOff() throws SQLException {
        conexion.close();
    }

}
