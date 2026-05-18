

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase responsable de los respaldos de seguridad.
 */
public class Backup {
    
    public void crearBackup() {
        String origen = "asistencia_espe.txt";
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String destino = "backup_" + timestamp + ".txt";

        File fileOrigen = new File(origen);
        if (!fileOrigen.exists()) {
            System.out.println("No hay datos en el sistema para respaldar todavía.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileOrigen));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("¡Backup generado con éxito!: " + destino);
        } catch (IOException e) {
            System.out.println("Error al procesar el respaldo: " + e.getMessage());
        }
    }
}