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
public class Incidencia {
    
    private int idIncidencia;
    private String fecha;
    private String origen;
    private String destino;
    private String descripcion;
    private String prioridad;
    private Empleado idEmpleado;

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    
    
    public Incidencia(){
        fecha = "";
        origen = "John";
        destino = "Jeff";
        descripcion = " Esta roto.";
        prioridad = "Urgente";
    }

    public Incidencia(int idIncidencia, String fecha, String origen, String destino, String descripcion, String prioridad, Empleado idEmpleado) {
        this.idIncidencia = idIncidencia;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.idEmpleado = idEmpleado;
    }

 
    
    

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Incidencia{" + "idIncidencia=" + idIncidencia + ", fecha=" + fecha + ", origen=" + origen + ", destino=" + destino + ", descripcion=" + descripcion + ", prioridad=" + prioridad + ", idEmpleado=" + idEmpleado.getUsuario() + '}';
    }
    
    
           
    
}
