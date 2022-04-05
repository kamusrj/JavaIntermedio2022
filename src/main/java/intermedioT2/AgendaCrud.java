/*
 * Kamus Curso java Insafor 2022
 */
package intermedioT2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * @author Kamus
 */
public class AgendaCrud {

    AgendaEntity ad = new AgendaEntity();
    HashMap<String, AgendaEntity> hm = new HashMap<String, AgendaEntity>();

//Crear
    public void llenar(Scanner sc) {
        try {

            System.out.println("************************************************");
            System.out.println("Ingrese informacion de Usuario");
            System.out.println("************************************************");
            System.out.println("ingrese dui");
            String dui = sc.next();
            System.out.println("ingrese telefono");
            String telefono = sc.next();
            System.out.println("ingrese nombre");
            String nombre = sc.next();
            System.out.println("ingrese salario");
            double salario = Double.parseDouble(sc.next());
            System.out.println("************************************************");

            hm.put(dui, new AgendaEntity(dui, telefono, nombre, salario));

            System.out.println("/*/*/*/*/*/*/*Datos del usuario*/*/*/*/*/*/*/*");
            for (AgendaEntity a : hm.values()) {
                System.out.println("************************************************");
                System.out.println("No Carnet: " + a.getDui());
                System.out.println("Apellido: " + a.getTelefono());
                System.out.println("Nombre: " + a.getNombre());
                System.out.println("Nombre: " + a.getSalario());
                System.out.println("************************************************");
            }
        } catch (NumberFormatException ne) {
            System.out.println("\ningrese solo dato numerico\n");
        } catch (Exception e) {

            System.out.println("Error  dos" + e.getMessage());

        }
    }

//read
    public void mostrar(String dui) {

        for (Map.Entry<String, AgendaEntity> entry : hm.entrySet()) {
            if (entry.getValue().getDui().equals(dui)) {
                try {
                    for (AgendaEntity a : hm.values()) {
                        System.out.println("/*/*/*/*/*/*/*Datos del usuario*/*/*/*/*/*/*/*");
                        System.out.println("**********************************************");
                        System.out.println("No Carnet: " + a.getDui());
                        System.out.println("Apellido: " + a.getTelefono());
                        System.out.println("Nombre: " + a.getNombre());
                        System.out.println("Nombre: " + a.getSalario());
                        System.out.println("************************************************");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Llave no encontrada");
            }
        }

    }
//Update

    void modificar(Scanner sc, String dui) {

        for (Map.Entry<String, AgendaEntity> entry : hm.entrySet()) {
            if (entry.getValue().getDui().equals(dui)) {
                try {
                    System.out.println("************************************************");
                    System.out.println("Ingrese informacion de Usuario");
                    System.out.println("************************************************");
                    System.out.println("ingrese dui");
                    String dui2 = sc.next();
                    System.out.println("ingrese telefono");
                    String telefono2 = sc.next();
                    System.out.println("ingrese nombre");
                    String nombre2 = sc.next();
                    System.out.println("ingrese salario");
                    double salario2 = Double.parseDouble(sc.next());
                    System.out.println("************************************************");

                    hm.replace(dui, new AgendaEntity(dui2, telefono2, nombre2, salario2));
                } catch (Exception e) {
                    System.out.println("no se pudo modificar");
                    e.printStackTrace();
                }
            }
        }
    }

// Delite
    public void eliminar(String dui) {
        for (Map.Entry<String, AgendaEntity> entry : hm.entrySet()) {
            if (entry.getValue().getDui().equals(dui)) {
                try {
                    hm.remove(entry.getKey());
                    System.out.println("------------------");
                    System.out.println("Usuario eliminado");
                    System.out.println("------------------");
                } catch (Exception e) {

                }
            }
        }
    }

}
