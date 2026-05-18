

public class Persona {

    // Atributos
    protected String cedula;
    protected String nombre;

    // Constructor vacio
    public Persona() {
    }

    // Constructor con parametros
    public Persona(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    // Getter de cedula
    public String getCedula() {
        return cedula;
    }

    // Setter de cedula
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    // Getter de nombre
    public String getNombre() {
        return nombre;
    }

    // Setter de nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

