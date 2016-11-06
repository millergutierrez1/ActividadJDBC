/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadjdbc;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author guti8
 */
public class Historial {
    
    private int idHistorial;
    private String evento;
    private String fecha;
    private Empleado usuario;
    private Incidencia idIncidencia;

    
    public Historial (){
        evento = "";
        fecha = "";
        usuario = new Empleado();
        idIncidencia = new Incidencia();
        
    }

    public Historial(int idHistorial, String evento, String fecha, Empleado usuario, Incidencia idIncidencia) {
        this.idHistorial = idHistorial;
        this.evento = evento;
        this.fecha = fecha;
        this.usuario = usuario;
        this.idIncidencia = idIncidencia;
    }

    public Historial(String evento, String fecha, Empleado usuario) {
        this.evento = evento;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Historial(int idHistorial, String evento, String fecha, Empleado usuario) {
        this.idHistorial = idHistorial;
        this.evento = evento;
        this.fecha = fecha;
        this.usuario = usuario;
    }
    
    

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public Incidencia getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Incidencia idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    @Override
    public String toString() {
        return "Historial{" +  ", evento=" + evento + ", fecha=" + fecha + ", usuario=" + usuario.getNombre() + ",}'";
    }


    
    
    
    
}
