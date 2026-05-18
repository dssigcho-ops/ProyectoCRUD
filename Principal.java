

import java.util.Scanner;

/**
 * <h1>Clase Principal</h1>
 * Punto de entrada del programa (Main). Contiene la inicialización de los 
 * módulos lógicos y el menú de navegación interactivo por consola para 
 * interactuar con el sistema de control de asistencia de la ESPE.
 * * @author Grupo ESPE
 * @version 1.0
 * @since 2026-05-18
 */
public class Principal {
    /** Objeto Scanner estático para la lectura de opciones del menú por consola. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Método de arranque global de la aplicación. Gestiona el ciclo de vida
     * del menú principal y redirige las acciones del usuario hacia el CRUD, 
     * el módulo de Reportes o el módulo de Backups.
     * * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SistemaCrud sistema = new SistemaCrud();
        Backup gestorBackup = new Backup();
        Reporte gestorReporte = new Reporte();
        int opcion;

        do {
            System.out.println("\n====== MENÚ CONTROL ASISTENCIA ESPE ======");
            System.out.println("1. Marcar ENTRADA (Crear/Modificar)");
            System.out.println("2. Marcar SALIDA (Actualizar e Imprimir)");
            System.out.println("3. Consultar Registro de Empleado (Leer)");
            System.out.println("4. Eliminar Asistencia (Eliminar)");
            System.out.println("5. Generar Reporte Entrada/Salida HTML Imprimible");
            System.out.println("6. Respaldar Sistema (Backup con Fecha/Hora)");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> sistema.crear();
                    case 2 -> sistema.actualizar();
                    case 3 -> sistema.leer();
                    case 4 -> sistema.eliminar();
                    case 5 -> gestorReporte.generarReporte(sistema);
                    case 6 -> gestorBackup.crearBackup();
                    case 7 -> System.out.println("Finalizando la aplicación...");
                    default -> System.out.println("Opción no disponible.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, introduce un número entero válido.");
                opcion = 0;
            }
        } while (opcion != 7);
    }
}