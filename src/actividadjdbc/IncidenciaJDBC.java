/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadjdbc;

import static actividadjdbc.Herramientas.pideEntero;
import static actividadjdbc.Herramientas.pidePalabra;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public void deleteEmpleado(Empleado e) throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        sync();
        String dropUser = "drop user ?";
        PreparedStatement dropParameter = conexion.prepareStatement(dropUser);

    }

    public void updateEmpleadoContrasena() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        sync();
        String UpdateContrasena = "update empleado set contrasena= ? where usuario = ?";
        PreparedStatement updateParametro = conexion.prepareStatement(UpdateContrasena);
        int seleccion = pideEntero("Introduce usuario para cambiar su contraseña: ");
        updateParametro.setInt(2, seleccion);
        updateParametro.setString(1, pidePalabra("Nueva contraseña para el usuario: "));
        updateParametro.executeUpdate();

        syncOff();

    }

    public boolean uExiste(int usuario) throws SQLException {

        sync();
        String selectUser = "select * from empleado where usuario= ?";

        PreparedStatement consulta = conexion.prepareStatement(selectUser);
        consulta.setInt(1, usuario);
        ResultSet resultado = consulta.executeQuery();

        // iteracion para obtener resultados:
        boolean existe = resultado.next();
        resultado.close();
        consulta.close();
        syncOff();

        return existe;
    }

    public void UpdateEmpleado(int usuario) throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        sync();
        String updateUsuario = "update empleado set usuario= ? ,contrasena= ? , nombre= ?, apellido= ?,telefono= ? where usuario= ?";
        PreparedStatement updateParametro = conexion.prepareStatement(updateUsuario);
        updateParametro.setInt(6, usuario);
        int input = pideEntero("Introduce nuevo Usuario(recuerda que son dígitos numéricos): ");
        updateParametro.setInt(1, input);
        updateParametro.setString(2, pidePalabra("Introduce nueva Contraseña: "));
        updateParametro.setString(3, pidePalabra("Introduce un nuevo Nombre: "));
        updateParametro.setString(4, pidePalabra("Introduce un nuevo Apellido: "));
        updateParametro.setInt(5, pideEntero("Introduce un nuevo teléfono: "));

        updateParametro.executeUpdate();

        mostrarEmpleado(input);

        syncOff();
    }

    public void mostrarEmpleado(int usuario) throws SQLException {

        List<Empleado> listaEmpleados = selectById(usuario);
        for (Empleado e : listaEmpleados) {
            System.out.println(e); // Recorro array.
        }

    }

    public void mostrarListaEmpleados() throws SQLException {

        // Utilizo selecAllEmpleados, para generar una nueva instancia de
        // la DB
        List<Empleado> listaEmpleados = selectAllEmpleados();

        for (Empleado e : listaEmpleados) {
            System.out.println(e); // Recorro array.
        }

    }

    public List<Empleado> selectById(int usuario) throws SQLException {
        List<Empleado> lista = new ArrayList<>();

        sync();
        String selectUser = "select * from empleado where usuario= ?";

        PreparedStatement consulta = conexion.prepareStatement(selectUser);
        consulta.setInt(1, usuario);
        ResultSet resultado = consulta.executeQuery();

        // iteracion para obtener resultados:
        while (resultado.next()) {
            Empleado e = new Empleado(); // guardo la informacion de la iteracion.
            e.setUsuario(resultado.getInt("usuario"));
            e.setContrasena(resultado.getString("contrasena"));
            e.setNombre(resultado.getString("nombre"));
            e.setApellido(resultado.getString("apellido"));
            e.setTelefono(resultado.getInt("telefono"));
            lista.add(e); //añado instancia de iteracion.
        }

        resultado.close();
        consulta.close();
        syncOff();

        return lista;

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
