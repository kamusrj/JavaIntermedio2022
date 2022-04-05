/*
 * Kamus Curso java Insafor 2022
 */
package intermedioT1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * @author Kamus
 */
public class Tarea01_ArchivoTxt {

    //Nota : hay que tener permisos de Administrador para crear un archivo en el disco local  "C:"
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Tarea01_ArchivoTxt at = new Tarea01_ArchivoTxt();

        for (int j = 1; j <= 1;) {
            try {
                System.out.println("******** Bienvenido ********");

                System.out.println("Selecione una opción");
                System.out.println("1 Crear Archivo txt");
                System.out.println("2 Leer Archivo txt");
                System.out.println("3 Finalizar");
                System.out.println("****************************\n");

                int op = Integer.parseInt(sc.next());

                switch (op) {
                    case 1:
                        at.escribirTxt(sc);
                        break;
                    case 2:
                        at.leerTxt(sc);
                        break;
                    case 3:
                        System.out.println("Finalizar\n");
                        j = 2;
                        break;
                    default:
                        System.out.println("opcion no valida");

                        break;
                }
            } catch (FileNotFoundException e) {
                System.out.println("\nArchivo no encontrado\n");
            } catch (NumberFormatException ne) {
                System.out.println("\ningrese solo dato numerico\n");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Accion finalizada, consulte errores\n");
                ProcessBuilder pb = new ProcessBuilder("clear");
            }
        }
    }

    public void escribirTxt(Scanner sc) throws IOException {
        BufferedWriter escribir = new BufferedWriter(new FileWriter("C:\\Excepciones.txt"));
        try {
            System.out.println("***** Ingrese cuanto nombres desea ingresar *****");
            int n = Integer.parseInt(sc.next());
            System.out.println("-------------------------------");

            for (int i = 1; i <= n; i++) {
                System.out.println("ingrese un nombre");
                escribir.write(sc.next());
                escribir.newLine();
            }
            escribir.flush();
            System.out.println("-------------------------------");
        } catch (NumberFormatException ne) {
            System.out.println("ingrese solo dato numerico\n");
        }
    }

    public void leerTxt(Scanner sc) throws IOException {
        BufferedReader leer = new BufferedReader(new FileReader("C:\\Excepciones.txt"));
        try {
            System.out.println("----------------------");
            String linea = leer.readLine();
            if (linea != null) {
                while (linea != null) {
                    System.out.println(linea);
                    linea = leer.readLine();
                }
            } else {
                System.out.println("Archivo sin datos ");
            }
            System.out.println("----------------------");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
    }
}
