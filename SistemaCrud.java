

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Clase SistemaCrud</h1>
 * Esta clase implementa la interfaz {@link CRUD} y se encarga de centralizar
 * la lógica de negocio para el control de asistencia del personal de la ESPE.
 * Gestiona el almacenamiento persistente en archivos de texto plano (.txt).
 * * @author Grupo ESPE
 * @version 1.0
 * @since 2026-05-18
 */
public class SistemaCrud implements CRUD {
    /** Ruta o nombre del archivo de texto plano donde se almacena la información. */
    private String archivo;
    
    /** Lista dinámica en memoria que guarda los objetos de tipo Empleado. */
    private List<Empleado> listaEmpleados = new ArrayList<>();
    
    /** Objeto Scanner estático para la lectura de datos por consola. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Constructor por defecto de la clase SistemaCrud.
     * Define el archivo base de almacenamiento y carga de manera automática 
     * los registros previos en memoria.
     */
    public SistemaCrud() {
        this.archivo = "asistencia_espe.txt";
        leerTXT();
    }

    /**
     * Escribe y vuelca toda la información contenida en la lista dinámica 
     * al archivo físico de texto plano.
     */
    public void guardarTXT() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (Empleado emp : listaEmpleados) {
                writer.println(emp.getCedula() + "," + emp.getNombre() + "," + emp.getDireccion() + "," + 
                               emp.getTelefono() + "," + emp.getHoraEntrada() + "," + emp.getHoraSalida());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo txt.");
        }
    }

    /**
     * Lee línea por línea el archivo de texto plano, deserializa los datos
     * y reconstruye los objetos de tipo Empleado dentro de la lista en memoria.
     */
    public void leerTXT() {
        File file = new File(archivo);
        if (!file.exists()) return;
        
        listaEmpleados.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] d = linea.split(",");
                if (d.length == 6) {
                    Empleado emp = new Empleado(d[0], d[1], d[2], d[3]);
                    emp.registrarEntrada(d[4]);
                    emp.registrarSalida(d[5]);
                    listaEmpleados.add(emp);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo txt.");
        }
    }

    /**
     * Operación <b>Crear (Create)</b> del CRUD.
     * Registra la entrada del personal capturando la hora exacta del sistema.
     * Si la cédula es nueva, solicita el ingreso de datos filiatorios adicionales.
     */
    @Override
    public void crear() {
        System.out.println("\n--- REGISTRAR ENTRADA (CREAR) ---");
        System.out.print("Ingrese Cédula: ");
        String cedula = scanner.nextLine();
        
        Empleado emp = buscarEmpleado(cedula);
        if (emp == null) {
            System.out.print("Ingrese Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese Dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Ingrese Teléfono: ");
            String telefono = scanner.nextLine();
            
            emp = new Empleado(cedula, nombre, direccion, telefono);
            listaEmpleados.add(emp);
        }
        
        String hora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        emp.registrarEntrada(hora);
        guardarTXT();
        System.out.println("¡Entrada registrada con éxito a las " + hora + "!");
    }

    /**
     * Operación <b>Leer (Read)</b> del CRUD.
     * Busca a un empleado mediante su cédula de identidad y despliega su información en consola.
     */
    @Override
    public void leer() {
        System.out.println("\n--- CONSULTAR EMPLEADO (LEER) ---");
        System.out.print("Ingrese Cédula: ");
        String cedula = scanner.nextLine();
        
        Empleado emp = buscarEmpleado(cedula);
        if (emp != null) {
            emp.mostrarDatos();
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    /**
     * Operación <b>Actualizar (Update)</b> del CRUD.
     * Registra la salida de un empleado, calcula la hora del sistema y genera la 
     * impresión completa e inmediata de todos sus datos personales y tiempos de asistencia.
     */
    @Override
    public void actualizar() {
        System.out.println("\n--- REGISTRAR SALIDA (ACTUALIZAR) ---");
        System.out.print("Ingrese Cédula: ");
        String cedula = scanner.nextLine();
        
        Empleado emp = buscarEmpleado(cedula);
        if (emp != null) {
            String hora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            emp.registrarSalida(hora);
            guardarTXT();
            
            System.out.println("\n>>> TICKET IMPRESO DE SALIDA <<<");
            emp.mostrarDatos();
        } else {
            System.out.println("Error: No se encontró registro de entrada para esa cédula.");
        }
    }

    /**
     * Operación <b>Eliminar (Delete)</b> del CRUD.
     * Remueve permanentemente el registro de asistencia seleccionado de la lista y actualiza el archivo.
     */
    @Override
    public void eliminar() {
        System.out.println("\n--- ELIMINAR REGISTRO ---");
        System.out.print("Ingrese Cédula a eliminar: ");
        String cedula = scanner.nextLine();
        
        Empleado emp = buscarEmpleado(cedula);
        if (emp != null) {
            listaEmpleados.remove(emp);
            guardarTXT();
            System.out.println("Registro eliminado correctamente.");
        } else {
            System.out.println("No se encontró el registro.");
        }
    }

    /**
     * Método de búsqueda secuencial interno.
     * * @param cedula Cédula del empleado a buscar.
     * @return El objeto {@link Empleado} si coincide la búsqueda; de lo contrario, devuelve null.
     */
    private Empleado buscarEmpleado(String cedula) {
        for (Empleado e : listaEmpleados) {
            if (e.getCedula().equals(cedula)) return e;
        }
        return null;
    }

    /**
     * Obtiene la lista interna de empleados actualmente cargada en memoria.
     * * @return Colección List conteniendo los objetos Empleado.
     */
    public List<Empleado> getListaEmpleados() { 
        return this.listaEmpleados; 
    }

    /**
     * Obtiene el nombre del archivo de texto asignado para guardar la persistencia.
     * * @return String con la ruta o nombre de archivo.
     */
    public String getArchivo() { 
        return archivo; 
    }
    
    /**
     * Permite modificar dinámicamente el destino del archivo plano del sistema.
     * * @param newArchivo Nuevo nombre o ruta para el archivo .txt
     */
    public void setArchivo(String newArchivo) { 
        this.archivo = newArchivo; 
    }
}