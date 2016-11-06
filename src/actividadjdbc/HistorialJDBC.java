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

/**
 *
 * @author guti8
 */
public class HistorialJDBC {

    private Connection conexion; // Conexion con la base de datos.

    public void insertHistorial(Historial h) throws SQLException {
        sync();

        String consulta = "insert into historial  (evento, fecha,usuario) values (?,?,?)";

        PreparedStatement ps = conexion.prepareStatement(consulta);
        //ps.setInt(1, h.getIdHistorial());
        ps.setString(1, h.getEvento());
        ps.setString(2, h.getFecha());
        ps.setInt(3, h.getUsuario().getUsuario()); //historial -> usuario > empleadoUsuario
        //ps.setInt(5, h.getIdIncidencia().getIdIncidencia()); //historial -> id incidencia -> inidenciaId
        ps.executeUpdate();

        syncOff();

    }

    public List<Historial> selectLogin() throws SQLException {
        List<Historial> lista = new ArrayList<>();
        EmpleadoJDBC userSearch = new EmpleadoJDBC();
        sync();

        String consulta = "select fecha, usuario, evento from historial where evento = \"i\" and historial.usuario ='456' order by fecha desc limit 1;"; 
        
        
        Statement s = conexion.createStatement();
        ResultSet rs = s.executeQuery(consulta);
        
        while (rs.next()){
            Historial h0 = new Historial ();
            h0.setUsuario(userSearch.selectById(rs.getInt("usuario")).get(0));
            h0.setEvento(rs.getString("evento"));
            h0.setFecha(rs.getString("fecha"));
            lista.add(h0);
        }
        
        rs.close();
        s.close();
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

    void  mostrarHistorial(List<Historial> h) {
        
        for (Historial i : h){
            System.out.println(h);
        }
      
        
    }

}
