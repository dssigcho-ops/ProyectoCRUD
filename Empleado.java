
import java.time.LocalTime;

public class Empleado extends Persona {

    // Atributos
    private String direccion;
    private String telefono;
    private String horaEntrada;
    private String horaSalida;

    // Constructor vacio
    public Empleado() {
    }

    // Constructor con parametros
    public Empleado(String cedula, String nombre, String direccion, String telefono) {
        super(cedula, nombre);
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getter y Setter direccion
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Getter y Setter telefono
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Getter y Setter horaEntrada
    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    // Getter y Setter horaSalida
    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    // Metodo para registrar entrada
    public void registrarEntrada() {
        horaEntrada = LocalTime.now().toString();
    }

    // Metodo para registrar salida
    public void registrarSalida() {
        horaSalida = LocalTime.now().toString();
    }

    // Metodo para mostrar datos
    public void mostrarDatos() {

        System.out.println("===== DATOS DEL EMPLEADO =====");
        System.out.println("Cedula: " + getCedula());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Direccion: " + direccion);
        System.out.println("Telefono: " + telefono);
        System.out.println("Hora Entrada: " + horaEntrada);
        System.out.println("Hora Salida: " + horaSalida);

    }

}

