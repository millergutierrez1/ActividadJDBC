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
            EmpleadoJDBC eMonitor = new EmpleadoJDBC();
            IncidenciasJDBC iMonitor = new IncidenciasJDBC();
            HistorialJDBC hMonitor = new HistorialJDBC();

            Empleado e = new Empleado(123, "p@ssw0rd", "Jaime", "Corrales", 123456789);
            Empleado e1 = new Empleado(654, "p@ssw0rd", "Sebastian", "Sanchez", 987987987);
            Empleado e2 = new Empleado(456, "p@ssw0rd", "Miller", "Gutierrez", 654654654);
            Empleado e3 = new Empleado(789, "p@ssw0rd", "Anastasia", "Pozhidaeva", 987987987);
            Empleado e4 = new Empleado(987, "p@ssw0rd", "Margareth", "Avila", 654654654);
            Empleado e5 = new Empleado(951, "p@ssw0rd", "Lola", "Sanchez", 654654654);
            Empleado e6 = new Empleado(321, "p@ssw0rd", "Miller", "Hernandez", 654654654);
//
//            System.out.println("Insertando datos....");
//
//            eMonitor.insertEmpleado(e);
//            eMonitor.insertEmpleado(e1); // Llamo la funcion creada dentro de monitor.
//            eMonitor.insertEmpleado(e2); // Llamo la funcion creada dentro de monitor.
//            eMonitor.insertEmpleado(e3); // Llamo la funcion creada dentro de monitor. 
//            eMonitor.insertEmpleado(e4); // Llamo la funcion creada dentro de monitor. 
//            eMonitor.insertEmpleado(e5); // Llamo la funcion creada dentro de monitor. 
//            eMonitor.insertEmpleado(e6); // Llamo la funcion creada dentro de monitor. 
//            System.out.println("Empleados creados....");
//            System.out.println("----------------------------");
//            System.out.println("----------------------------");
            System.out.println("Login de usario 456 contrasena p@ssw0rd: ");
            eMonitor.login(456, "p@ssw0rd");
            //  Genera el login:
            Historial hi = new Historial("i", iMonitor.tiempo(), e2);
            hMonitor.insertHistorial(hi);

            System.out.println("");
//            Incidencia i = new Incidencia(1, iMonitor.tiempo(), "Sebastian", "Jaime", "No va el Internet", "urgente", e2);
//            Incidencia i2 = new Incidencia(2, iMonitor.tiempo(), "Sebastian", "Jaime", "No va la impresora", "urgente", e2);
//            Incidencia i3 = new Incidencia(3, iMonitor.tiempo(), "Miller", "Sebastian", "No le va la red.", "urgente", e2);
//            Incidencia i4 = new Incidencia(4, iMonitor.tiempo(), "Anastasia", "Jaime", "No le tira el ordenador.", "Normal", e3);
//            Incidencia i5 = new Incidencia(5, iMonitor.tiempo(), "Anastasia", "Miller", "NO va el wifi.", "Normal", e4);
//            Incidencia i6 = new Incidencia(6, iMonitor.tiempo(), "Anastasia", "Miller", "No le tira el ordenador.", "Normal", e3);
//            Incidencia i7 = new Incidencia(7, iMonitor.tiempo(), "Anastasia", "Sebastian", "El ordenador no enciende", "Normal", e3);
//            Incidencia i8 = new Incidencia(8, iMonitor.tiempo(), "Anastasia", "Sebastian", "El ordenador no enciende", "urgente", e3);
//            Incidencia i9 = new Incidencia(9, iMonitor.tiempo(), "Anastasia", "Sebastian", "El ordenador no enciende", "Normal", e3);
////            System.out.println("");
//            System.out.println("----------------------------");
//            System.out.println("----------------------------");
//            System.out.println("Creando Incidencias");
//            iMonitor.insertIncidencias(i);
//            iMonitor.insertIncidencias(i2);
//            iMonitor.insertIncidencias(i3);
//            iMonitor.insertIncidencias(i4);
//            iMonitor.insertIncidencias(i5);
//            iMonitor.insertIncidencias(i6);
//            iMonitor.insertIncidencias(i7);
//            System.out.println("Incidencias han sido creadas!!!");
//
            Historial h = new Historial("U", iMonitor.tiempo(), e2);
            Historial h1 = new Historial("U", iMonitor.tiempo(), e2);
            Historial h2 = new Historial("U", iMonitor.tiempo(), e2);
            Historial h3 = new Historial("C", iMonitor.tiempo(), e3);
            Historial h4 = new Historial("C", iMonitor.tiempo(), e);
            Historial h5 = new Historial("i", iMonitor.tiempo(), e);
            Historial h6 = new Historial("i", iMonitor.tiempo(), e1);

            System.out.println("----------------------------");
            System.out.println("----------------------------");
//            System.out.println("Creando Historial");
//            hMonitor.insertHistorial(h);
//            hMonitor.insertHistorial(h1);
//            hMonitor.insertHistorial(h2);
//            hMonitor.insertHistorial(h3);
//            hMonitor.insertHistorial(h4);
//            hMonitor.insertHistorial(h5);
//            hMonitor.insertHistorial(h6);
//            System.out.println("Creacion Exitosa!");

            System.out.println("----------------------------");
            System.out.println("----------------------------");

            System.out.println("Todas las incidencias: ");
            List<Incidencia> lista = iMonitor.selectAlli();
            iMonitor.mostrarIncidencia(lista);

            System.out.println("----------------");
            System.out.println("");
            System.out.println("MOstrar Incidencia por su id: ");
            List<Incidencia> lista2 = iMonitor.selectInById(pideEntero("Introduce el id incidencia: "));
            iMonitor.mostrarIncidencia(lista2);

            System.out.println("-------------");
            System.out.println("");
            System.out.println("Incidencia destino basada en un objeto e: ");
            System.out.println("Nombre de 'e': " + e.getNombre());
            List<Incidencia> lista3 = iMonitor.selectByDestino(e);
            iMonitor.mostrarIncidencia(lista3);

            System.out.println("-------------");
            System.out.println("");
            eMonitor.mostrarListaEmpleados();
            System.out.println("Incidencia por Origen:");
            List<Incidencia> lista4 = iMonitor.selectByOrigen(pidePalabra("Introduce nombre del usuario de Origen: "));
            iMonitor.mostrarIncidencia(lista4);
            System.out.println("");
            //utilizo el objeto monitor
            System.out.println("Listado de socios: ");
            System.out.println("--------------------");
            List<Empleado> misEmpleados = eMonitor.selectAllEmpleados();
            // Se crea un Arraylist mis empleados y se llama
            // el metodo deontro de monitor.selle
            
            eMonitor.mostrarListaEmpleados();
//            System.out.println("Mostrar empleado by ID: ");
//            monitor.mostrarEmpleado(555);

            int input = pideEntero("introduzca ID de usuario para eliminar: ");

            if (eMonitor.uExiste(input)) {
                eMonitor.deleteEmpleado(input);
            } else {
                System.out.println("usuario, no existente.");
            }

            input = pideEntero("introduzca ID de usuario a modificar: ");

            if (eMonitor.uExiste(input)) {
                eMonitor.UpdateEmpleado(input);
            } else {
                System.out.println("usuario, no existente.");
            }
            System.out.println("");
            System.out.println("Ultimo inicio de sesion del usario Miller : 456");
            List<Historial> listaH = hMonitor.selectLogin();
            hMonitor.mostrarHistorial(listaH);
            //monitor.mostrarListaEmpleados();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
