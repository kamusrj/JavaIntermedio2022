/*
 * Kamus Curso java Insafor 2022
 */
package intermedioT5;

import java.sql.*;

/*
 * @author Kamus
 */
public class MotursaDAO extends Conexion {

    //C.R.U.D.
//------------------------------------------------------------------------------------------
// Create 

    public int guardar(EHMotursa em) {
        int flag = 0;
        PreparedStatement ps = null;
        Connection conn = conectarBaseDatos();
        try {
            String query = "insert into public.eh_motursa \n"
                    + "(no_nit,nombre,direccion,telefono,salario_mensual,descuento_renta)\n"
                    + "VALUES(?,?,?,?,?,?);";

            ps = conn.prepareStatement(query);

            ps.setString(1, em.getNoNit());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getDireccion());
            ps.setString(4, em.getTelefono());
            ps.setDouble(5, em.getSalarioMensual());
            ps.setDouble(6, em.getDecuentoRenta());

            flag = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("error" + ex.getMessage() + "\n Sql error: " + ex.getSQLState());
            }
        }
        return flag;
    }
//-----------------------------------------------------------------------------------------------
//Read

    public EHMotursa consultar(String noNit) {
        Statement stmt = null;
        ResultSet rs = null;
        EHMotursa em = null;
        Connection conn = conectarBaseDatos();
        try {
            String query = "select* from public.eh_motursa where no_nit= '" + noNit + "' ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                em = new EHMotursa();
                em.setNoNit(rs.getString(1));
                em.setNombre(rs.getString(2));
                em.setDireccion(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setSalarioMensual(rs.getDouble(5));
                em.setDecuentoRenta(rs.getDouble(6));
            }
        } catch (SQLException ex) {
            ex.getMessage();
            System.out.println("Error 1: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error 2: " + ex.getMessage());
            }
        }
        return em;
    }
//------------------------------------------------------------------------------------------
//Update

    public int modificar(EHMotursa em) {
        int flag = 0;
        PreparedStatement ps = null;
        Connection conn = conectarBaseDatos();
        try {
            String query = " UPDATE public.eh_motursa set nombre=?,direccion=?,telefono=?,"
                    + "salario_mensual=?,descuento_renta=? where no_nit=?";
            ps = conn.prepareStatement(query);

            ps.setString(1, em.getNombre());
            ps.setString(2, em.getDireccion());
            ps.setString(3, em.getTelefono());
            ps.setDouble(4, em.getSalarioMensual());
            ps.setDouble(5, em.getDecuentoRenta());
            ps.setString(6, em.getNoNit());

            flag = ps.executeUpdate();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            System.out.println("Error datos null" + ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error  Sql:" + ex.getMessage());
            } catch (NullPointerException ex) {
                ex.printStackTrace();
                System.out.println("Error Null:" + ex.getMessage());
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        return flag;
    }
//------------------------------------------------------------------------------------------
//Delite 

    public int eliminar(String noNit) {
        int flag = 0;
        PreparedStatement ps = null;
        Connection conn = conectarBaseDatos();

        try {
            String query = "Delete from public.eh_motursa where no_nit = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, noNit);
            flag = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();
            System.out.println("Error2" + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error " + ex.getMessage());
            }
        }
        return flag;
    }

}
