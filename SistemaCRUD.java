


import java.io.FileWriter;
import java.io.IOException;

public class SistemaCRUD implements CRUD {

    // Atributo
    private String archivo = "personal.txt";

    // Constructor vacio
    public SistemaCRUD() {
    }

    // Getter
    public String getArchivo() {
        return archivo;
    }

    // Setter
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    // Metodo para guardar en TXT
    public void guardarTXT(Empleado empleado) {

        try {

            FileWriter escribir = new FileWriter(archivo, true);

            escribir.write(
                    empleado.getCedula() + "," +
                    empleado.getNombre() + "," +
                    empleado.getDireccion() + "," +
                    empleado.getTelefono() + "," +
                    empleado.getHoraEntrada() + "," +
                    empleado.getHoraSalida() + "\n"
            );

            escribir.close();

            System.out.println("Datos guardados correctamente");

        } catch (IOException e) {

            System.out.println("Error al guardar archivo");

        }

    }

    // Metodo para leer TXT
    public void leerTXT() {

        System.out.println("Leyendo archivo TXT...");

    }

    // CRUD

    @Override
    public void crear() {

        System.out.println("Empleado creado");

    }

    @Override
    public void leer() {

        System.out.println("Leyendo empleados");

    }

    @Override
    public void actualizar() {

        System.out.println("Empleado actualizado");

    }

    @Override
    public void eliminar() {

        System.out.println("Empleado eliminado");

    }

}

