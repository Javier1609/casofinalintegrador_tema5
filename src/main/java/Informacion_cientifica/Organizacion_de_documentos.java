package Informacion_cientifica;

import java.io.*;
import java.util.*;

public class Organizacion_de_documentos {
    public static void ordenarArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }

        try {
            // Leer el archivo
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));

            // Almacenar las líneas en una lista
            List<String> lineas = new ArrayList<>();
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            reader.close();

            // Ordenar la lista
            Collections.sort(lineas);

            // Escribir la lista ordenada en un nuevo archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter("archivo_ordenado.txt"));
            for (String lineaOrdenada : lineas) {
                writer.write(lineaOrdenada);
                writer.newLine();
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer o escribir el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ordenarArchivo("ruta_al_archivo.txt");
    }
}