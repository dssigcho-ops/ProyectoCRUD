

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <h1>Clase Reporte</h1>
 * Esta clase se encarga de la exportación de los registros de asistencia 
 * del personal de la universidad. Genera un archivo HTML estructurado
 * con los colores institucionales, listo para ser impreso o guardado como PDF.
 * * @author Grupo ESPE
 * @version 1.0
 * @since 2026-05-18
 */
public class Reporte {

    /**
     * Genera un reporte web imprimible en formato HTML basado en los datos actuales
     * almacenados en el sistema de persistencia.
     * * @param sistemaCrud Instancia del gestor de asistencia que contiene la lista de empleados.
     */
    public void generarReporte(SistemaCrud sistemaCrud) {
        // Forzamos al sistema CRUD a leer el archivo plano para tener los datos más recientes
        sistemaCrud.leerTXT(); 
        
        String reportFile = "Reporte_Asistencia_ESPE.html";
        
        try (FileWriter fw = new FileWriter(reportFile);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter writer = new PrintWriter(bw)) {
            
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang='es'>");
            writer.println("<head>");
            writer.println("    <meta charset='UTF-8'>");
            writer.println("    <title>Reporte de Asistencia ESPE</title>");
            writer.println("    <style>");
            writer.println("        body { font-family: Arial, sans-serif; margin: 40px; color: #333; }");
            writer.println("        .header { text-align: center; border-bottom: 3px solid #006633; padding-bottom: 10px; margin-bottom: 20px; }");
            writer.println("        .header h1 { color: #006633; margin: 0; font-size: 24px; }");
            writer.println("        .header p { margin: 5px 0 0 0; font-size: 14px; color: #666; }");
            writer.println("        table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            writer.println("        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }");
            writer.println("        th { background-color: #006633; color: white; }");
            writer.println("        tr:nth-child(even) { background-color: #f2f2f2; }");
            writer.println("        .footer { margin-top: 40px; text-align: center; font-size: 12px; color: #999; border-top: 1px solid #ddd; padding-top: 10px; }");
            writer.println("    </style>");
            writer.println("</head>");
            writer.println("<body>");
            
            writer.println("    <div class='header'>");
            writer.println("        <h1>UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE</h1>");
            writer.println("        <h2>REPORTE DE CONTROL DE ENTRADAS Y SALIDAS</h2>");
            writer.println("        <p><strong>Fecha de Generación:</strong> " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "</p>");
            writer.println("    </div>");
            
            writer.println("    <table>");
            writer.println("        <thead>");
            writer.println("            <tr>");
            writer.println("                <th>CÉDULA</th>");
            writer.println("                <th>NOMBRE</th>");
            writer.println("                <th>ENTRADA</th>");
            writer.println("                <th>SALIDA</th>");
            writer.println("            </tr>");
            writer.println("        </thead>");
            writer.println("        <tbody>");
            
            if (sistemaCrud.getListaEmpleados().isEmpty()) {
                writer.println("            <tr><td colspan='4' style='text-align:center;'>No existen registros de asistencia almacenados.</td></tr>");
            } else {
                for (Empleado emp : sistemaCrud.getListaEmpleados()) {
                    writer.println("            <tr>");
                    writer.println("                <td>" + emp.getCedula() + "</td>");
                    writer.println("                <td>" + emp.getNombre() + "</td>");
                    writer.println("                <td>" + emp.getHoraEntrada() + "</td>");
                    writer.println("                <td>" + emp.getHoraSalida() + "</td>");
                    writer.println("            </tr>");
                }
            }
            
            writer.println("        </tbody>");
            writer.println("    </table>");
            
            writer.println("    <div class='footer'>");
            writer.println("        <p>© 2026 Sistema de Gestión de Asistencia - ESPE. Todos los derechos reservados.</p>");
            writer.println("    </div>");
            
            writer.println("</body>");
            writer.println("</html>");
            
            writer.flush();
            bw.flush();
            
            System.out.println("¡Reporte generado con éxito como '" + reportFile + "'!");
            System.out.println("Nota: Abre este archivo en tu navegador y presiona Ctrl+P para guardarlo como PDF.");
            
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de reporte: " + e.getMessage());
        }
    }
}