/*
 * Kamus Curso java Insafor 2022
 */
package intermedioT2;

/*
 * @author Kamus
 */
public class AgendaEntity {

    private String dui;
    private String telefono;
    private String nombre;
    private double salario;

    public AgendaEntity(String dui, String telefono, String nombre, double salario) {
        this.dui = dui;
        this.telefono = telefono;
        this.nombre = nombre;
        this.salario = salario;
    }

    public AgendaEntity() {
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
