/*
 * Kamus Curso java Insafor 2022
 */
package intermedioT2;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @author Kamus
 */
public class AgendaVista {
    
    public static void main(String[] args) {
        AgendaCrud ag = new AgendaCrud();
        Scanner sc = new Scanner(System.in);
        
        int operacion = 0;
        System.out.println("*********** Bienvenido ***********\n");
        for (int i = 0; i <= 1;) {
            try {
                System.out.println("********************************");
                System.out.println("ingrese operacion");
                System.out.println("1  Crear ");
                System.out.println("2  Consultar ");
                System.out.println("3  modificar ");
                System.out.println("4  eliminar ");
                System.out.println("5  finalizar ");
                System.out.println("********************************");
                operacion = Integer.parseInt(sc.next());
                
                switch (operacion) {
                    case 1:
                        
                        ag.llenar(sc);
                        
                        break;
                    case 2:
                        System.out.println("igrese id");
                        String id = sc.next();
                        ag.mostrar(id);
                        
                        break;
                    case 3:
                        System.out.println("igrese id");
                        id = sc.next();
                        ag.modificar(sc, id);
                        
                        break;
                    case 4:
                        System.out.println("igrese id");
                        id = sc.next();
                        ag.eliminar(id);
                        
                        break;
                    case 5:
                        i += 3;
                        break;
                    default:
                        System.out.println("opcion no valida");
                    
                }
            } catch (InputMismatchException e) {
                System.out.println("\ningrese solo dato numerico\n");
                i += 3;
            } catch (NumberFormatException ne) {
                System.out.println("\ningrese solo dato numerico\n");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Accion finalizada, consulte errores\n");
                
            }
            
        }
    }
}
