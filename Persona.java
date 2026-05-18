

/**
 * <h1>Clase Abstracta Persona</h1>
 * Define los atributos fundamentales y comunes de cualquier ciudadano
 * dentro del sistema universitario (Cédula y Nombre).
 * Aplica el pilar de <b>Abstracción</b> y <b>Encapsulamiento</b>.
 * * @author Grupo ESPE
 * @version 1.0
 * @since 2026-05-18
 */
public abstract class Persona {
    private String cedula;
    private String nombre;

    /**
     * Constructor para inicializar una nueva Persona.
     * @param cedula Número de cédula de identidad del individuo.
     * @param nombre Nombre y apellido completos.
     */
    public Persona(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String newCedula) { this.cedula = newCedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String newNombre) { this.nombre = newNombre; }
}