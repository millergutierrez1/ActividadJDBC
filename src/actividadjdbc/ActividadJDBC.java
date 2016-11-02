/*
 *
 */
package actividadjdbc;

import static actividadjdbc.Herramientas.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
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

        try {
            EmpleadoJDBC monitor = new EmpleadoJDBC();
            IncidenciasJDBC monitor2 = new IncidenciasJDBC();

            Empleado e = new Empleado(123, "p@ssw0rd", "Jaime", "Corrales", 123456789);
            Empleado e1 = new Empleado(654, "p@ssw0rd", "Sebastian", "Sanchez", 987987987);

            Empleado e2 = new Empleado(456, "p@ssw0rd", "Miller", "Gutierrez", 654654654);
            Empleado e3 = new Empleado(789, "p@ssw0rd", "Anastasia", "Pozhidaeva", 987987987);

            Incidencia i = new Incidencia(1, monitor2.tiempo(), "Jaime", "Miller", "No le va el Chromebox.", "urgente", e);
            Incidencia i2 = new Incidencia(2, monitor2.tiempo(), "Sebastian", "Jaime", "No va la impresora", "urgente", e1);
            Incidencia i3 = new Incidencia(3, monitor2.tiempo(), "Miller", "Juan", "No le va la red.", "Baja", e2);
            Incidencia i4 = new Incidencia(4, monitor2.tiempo(), "Anastasia", "Jaime", "No le tira el ordenador.", "Normal", e3);

            List<Incidencia> lista = monitor2.selectAlli();

            monitor2.mostrarIncidencia(lista);

            List<Incidencia> lista2 = monitor2.selectInById(pideEntero("Id incidencia: "));

            monitor2.mostrarIncidencia(lista2);

            monitor.mostrarListaEmpleados();

            List<Incidencia> lista3 = monitor2.selectByDestino(e);

            monitor2.mostrarIncidencia(lista3);

            List<Incidencia> lista4 = monitor2.selectByOrigen(pidePalabra("Introduce nombre del usuario de Origen: "));

            monitor2.mostrarIncidencia(lista4);

//        System.out.println("Insertando datos....");
//        try {
//            monitor.insertEmpleado(e);
//            monitor.insertEmpleado(e1); // Llamo la funcion creada dentro de monitor.
//            monitor.insertEmpleado(e2); // Llamo la funcion creada dentro de monitor.
//            monitor.insertEmpleado(e3); // Llamo la funcion creada dentro de monitor. 
//
//            monitor2.insertIncidencias(i);
//            monitor2.insertIncidencias(i2);
//            monitor2.insertIncidencias(i3);
//            monitor2.insertIncidencias(i4);
//            System.out.println("Inserción de datos exitosa!");
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ActividadJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
            //utilizo el objeto monitor
            //System.out.println("Inserción de datos exitosa!");
//
//            System.out.println("Listado de socios: ");
//            System.out.println("--------------------");
//            List<Empleado> misEmpleados = monitor.selectAllEmpleados();
//            // Se crea un Arraylist mis empleados y se llama
//            // el metodo deontro de monitor.selle
//
//            monitor.mostrarListaEmpleados();
////            System.out.println("Mostrar empleadi by ID: ");
////            monitor.mostrarEmpleado(555);
//
//            int input = pideEntero("introduzca ID de usuario para eliminar: ");
//
//            if (monitor.uExiste(input)) {
//                monitor.deleteEmpleado(input);
//            } else {
//                System.out.println("usuario, no existente.");
//            }
//            /*
//             *
//             *
//             */
//            input = pideEntero("introduzca ID de usuario a modificar: ");
//
//            if (monitor.uExiste(input)) {
//                monitor.UpdateEmpleado(input);
//            } else {
//                System.out.println("usuario, no existente.");
//            }
//            //monitor.mostrarListaEmpleados();
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
        } catch (SQLException ex) {
            Logger.getLogger(ActividadJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
