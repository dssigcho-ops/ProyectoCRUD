


import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        // Crear objetos
        Empleado empleado = new Empleado();
        SistemaCRUD sistema = new SistemaCRUD();

        // Ingreso de datos
        System.out.println("===== REGISTRO PERSONAL ESPE =====");

        System.out.print("Ingrese cedula: ");
        empleado.setCedula(leer.nextLine());

        System.out.print("Ingrese nombre: ");
        empleado.setNombre(leer.nextLine());

        System.out.print("Ingrese direccion: ");
        empleado.setDireccion(leer.nextLine());

        System.out.print("Ingrese telefono: ");
        empleado.setTelefono(leer.nextLine());

        // Registrar hora entrada
        empleado.registrarEntrada();

        System.out.println("\nEntrada registrada correctamente");

        // Simulacion salida
        System.out.println("\nPresione ENTER para registrar salida...");
        leer.nextLine();

        // Registrar salida
        empleado.registrarSalida();

        // Mostrar datos
        empleado.mostrarDatos();

        // Guardar TXT
        sistema.guardarTXT(empleado);

    }

}

