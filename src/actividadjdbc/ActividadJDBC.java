/*
 *
 */
package actividadjdbc;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guti8
 */
public class ActividadJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IncidenciaJDBC monitor = new IncidenciaJDBC();
        
        //Empleado e = new Empleado(123,"pss","Test","Apellido",123456789);
        Empleado e1 = new Empleado(654,"pss","Test","Apellido",123456789);
       
        Empleado e2 = new Empleado(456,"pss","Miller","Gutierrez",654654654);
        Empleado e3 = new Empleado(789,"pss","Anastasia","Pozhidaeva",987987987);
        try {
            System.out.println("Insertando datos....");
            monitor.insertEmpleado(e1); // Llamo la funcion creada dentro de monitor. 
            monitor.insertEmpleado(e2); // Llamo la funcion creada dentro de monitor. 
            monitor.insertEmpleado(e3); // Llamo la funcion creada dentro de monitor. 
        //  utilizo el objeto monitor
            System.out.println("Inserción de datos exitosa!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        
        
    }

}
