/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadjdbc;

/**
 *
 * @author guti8
 */
public class Empleado {
    
    private int usuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private int telefono;

    public Empleado(int usuario, String contrasena, String nombre, String apellido, int telefono) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    public Empleado(){
        contrasena = "p@ssw0rd";
        nombre = "John";
        apellido = "Doe";
        
        
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    
}
