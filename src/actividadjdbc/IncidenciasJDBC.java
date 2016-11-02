/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadjdbc;

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
public class IncidenciasJDBC {

    private Connection conexion;

    private void sync() throws SQLException { //Genero Conexion on Mysql.
        String url = "jdbc:mysql://localhost:3306/jdbc_gestion_incidencias"; // Inicia conexion.
        String usr = "root"; //usuario 
        String pass = "Root123**"; //psswd
        conexion = DriverManager.getConnection(url, usr, pass);

    }

    private void syncOff() throws SQLException {
        conexion.close();
    }

    void mostrarIncidencia(List<Incidencia> i) {
        List<Incidencia> lista;
        for (Incidencia Lista : i) {

            System.out.println(i); // Recorro array.
        }
    }

    public String tiempo() {

        java.util.Date localtime = new java.util.Date();
        String fecha = localtime.toString();
        return fecha;

    }

    public void insertIncidencias(Incidencia i) throws SQLException {
        sync();

        String insert = "insert into incidencias values (?,?,?,?,?,?,?)";
        PreparedStatement insertParametros = conexion.prepareStatement(insert);

        insertParametros.setInt(1, i.getIdIncidencia());
        insertParametros.setString(2, i.getFecha());
        insertParametros.setString(3, i.getOrigen());
        insertParametros.setString(4, i.getDestino());
        insertParametros.setString(5, i.getDescripcion());
        insertParametros.setString(6, i.getPrioridad());
        insertParametros.setInt(7, i.getIdEmpleado().getUsuario());
        // private Empleado idEmpleado -> Por ende puedo buscar el usuario directamentee
        insertParametros.executeUpdate();
        syncOff();

    }

    public List<Incidencia> selectAlli() throws SQLException {
        List<Incidencia> list = new ArrayList<>();
        EmpleadoJDBC userSearch = new EmpleadoJDBC();// instancio EmpleadoJDBC para
        //llamar a la funcion selectById y poder buscar el Usuario -> idEmpleado

        sync();

        String consulta = "select * from incidencia";
        Statement s = conexion.createStatement();
        ResultSet rs = s.executeQuery(consulta);

        while (rs.next()) {
            Incidencia i = new Incidencia();

            i.setIdIncidencia(rs.getInt("idincidencia"));
            i.setFecha(rs.getString("fecha"));
            i.setOrigen(rs.getString("origen"));
            i.setDestino(rs.getString("destino"));
            i.setDescripcion(rs.getString("descripcion"));
            i.setPrioridad(rs.getString("prioridad"));

            //userSearch (EmpleadoJDBC) buscoID de empleado y tomo la posicion 0
            // Que deberia retornar el usuario.
            i.setIdEmpleado(userSearch.selectById(rs.getInt("idempleado")).get(0));
            list.add(i);
        }

        s.close();
        rs.close();
        syncOff();

        return list;

    }

    public List<Incidencia> selectInById(int idIncidencia) throws SQLException {
        List<Incidencia> lista = new ArrayList<>();
        EmpleadoJDBC userSearch = new EmpleadoJDBC();
        //llamar a la funcion selectById y poder buscar el Usuario -> idEmpleado
        sync();
        String consulta = "select * from incidencia where idincidencia= ?";

        PreparedStatement pr = conexion.prepareStatement(consulta);

        pr.setInt(1, idIncidencia);

        ResultSet rs = pr.executeQuery();

        while (rs.next()) {
            Incidencia i = new Incidencia();
            i.setIdIncidencia(rs.getInt("idincidencia"));
            i.setFecha(rs.getString("fecha"));
            i.setOrigen(rs.getString("origen"));
            i.setDestino(rs.getString("destino"));
            i.setDescripcion(rs.getString("descripcion"));
            i.setPrioridad(rs.getString("prioridad"));
            // 
            i.setIdEmpleado(userSearch.selectById(rs.getInt("idempleado")).get(0));
            lista.add(i);
        }

        pr.close();
        rs.close();
        syncOff();

        return lista;

    }

    public List<Incidencia> selectByDestino(Empleado e) {
        List<Incidencia> lista = new ArrayList<>();
        EmpleadoJDBC userSearch = new EmpleadoJDBC();

        try {
            sync();
            String consulta = "select * from incidencia where destino= ?";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, e.getNombre());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Incidencia i = new Incidencia();
                i.setIdIncidencia(rs.getInt("idincidencia"));
                i.setFecha(rs.getString("fecha"));
                i.setOrigen(rs.getString("origen"));
                i.setDestino(rs.getString("destino"));
                i.setDescripcion(rs.getString("descripcion"));
                i.setPrioridad(rs.getString("prioridad"));
                // 
                i.setIdEmpleado(userSearch.selectById(rs.getInt("idempleado")).get(0));
                lista.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IncidenciasJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public List<Incidencia> selectByOrigen(String nombre) {
        List<Incidencia> lista = new ArrayList<>();
        EmpleadoJDBC userSearch = new EmpleadoJDBC();

        try {
            sync();
            String consulta = "select * from incidencia where origen= ?";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Incidencia i = new Incidencia();
                i.setIdIncidencia(rs.getInt("idincidencia"));
                i.setFecha(rs.getString("fecha"));
                i.setOrigen(rs.getString("origen"));
                i.setDestino(rs.getString("destino"));
                i.setDescripcion(rs.getString("descripcion"));
                i.setPrioridad(rs.getString("prioridad"));
                // 
                i.setIdEmpleado(userSearch.selectById(rs.getInt("idempleado")).get(0));
                lista.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IncidenciasJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
