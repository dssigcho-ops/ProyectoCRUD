

/**
 * <h1>Clase Empleado</h1>
 * Representa al personal trabajador de la universidad. Esta clase se extiende 
 * de {@link Persona}, implementando los pilares de <b>Herencia</b> y 
 * <b>Polimorfismo</b> al incorporar la lógica de horarios y el método mostrarDatos.
 * * @author Grupo ESPE
 * @version 1.0
 * @since 2026-05-18
 */
public class Empleado extends Persona {
    private String direccion;
    private String telefono;
    private String horaEntrada;
    private String horaSalida;

    /**
     * Constructor para registrar un Empleado con sus datos base e inicializar su estado.
     * @param cedula Cédula de identidad.
     * @param nombre Nombre completo.
     * @param direccion Dirección de domicilio.
     * @param telefono Teléfono de contacto.
     */
    public Empleado(String cedula, String nombre, String direccion, String telefono) {
        super(cedula, nombre);
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaEntrada = "No registrada";
        this.horaSalida = "No registrada";
    }

    /**
     * Asigna la marca de tiempo correspondiente al ingreso del empleado al campus.
     * @param hora Cadena con el formato de fecha y hora del sistema.
     */
    public void registrarEntrada(String hora) {
        this.horaEntrada = hora;
    }

    /**
     * Asigna la marca de tiempo correspondiente a la salida del empleado del campus.
     * @param hora Cadena con el formato de fecha y hora del sistema.
     */
    public void registrarSalida(String hora) {
        this.horaSalida = hora;
    }

    /**
     * Imprime de forma formateada en consola la totalidad de los datos del empleado, 
     * cumpliendo con el requerimiento de auditoría de asistencia.
     */
    public void mostrarDatos() {
        System.out.println("=====================================");
        System.out.println("CÉDULA: " + getCedula());
        System.out.println("NOMBRE: " + getNombre());
        System.out.println("DIRECCIÓN: " + direccion);
        System.out.println("TELÉFONO: " + telefono);
        System.out.println("HORA ENTRADA: " + horaEntrada);
        System.out.println("HORA SALIDA: " + horaSalida);
        System.out.println("=====================================");
    }

    public String getDireccion() { return direccion; }
    public void setDireccion(String newDireccion) { this.direccion = newDireccion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String newTelefono) { this.telefono = newTelefono; }
    public String getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(String newHoraEntrada) { this.horaEntrada = newHoraEntrada; }
    public String getHoraSalida() { return horaSalida; }
    public void setHoraSalida(String newHoraSalida) { this.horaSalida = newHoraSalida; }
}