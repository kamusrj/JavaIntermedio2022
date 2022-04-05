/*
 * Kamus Curso java Insafor 2022
 */
package intermedioT5;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * @author Kamus
 */


public class Conexion {

    private String db = "proyectos";
    private String user = "Edutech";
    private String pass = "practicaEdu";
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://proyectos.coehxub0jkfc.us-east-2.rds.amazonaws.com:5432/" + db;

    public void cargarDriver() {
        try {
            Class.forName(driver);
            System.out.println("Driver  cargado");
        } catch (Exception e) {
            System.out.println("Driver no cargado");
        }
    }
    public Connection conectarBaseDatos() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa a la base de datos: " + user + " tabla: eh_motursa");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Conexion Fallida" + e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args) {
        Conexion cn = new Conexion();
     //   cn.cargarDriver();
      //  cn.conectarBaseDatos();

    }
}
