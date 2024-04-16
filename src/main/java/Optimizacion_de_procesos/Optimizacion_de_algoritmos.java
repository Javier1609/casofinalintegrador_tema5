package Optimizacion_de_procesos;

import java.io.*;
import java.util.*;

public class Optimizacion_de_algoritmos {
    public static List<String> leerArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
            return Collections.emptyList();
        }

        List<String> lineas = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return lineas;
    }

    public static boolean busquedaLineal(List<String> lineas, String palabra) {
        for (String linea : lineas) {
            if (linea.contains(palabra)) {
                return true;
            }
        }
        return false;
    }

    public static boolean busquedaBinaria(List<String> lineas, String palabra) {
        Collections.sort(lineas);
        int inicio = 0;
        int fin = lineas.size() - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            int res = palabra.compareTo(lineas.get(medio));

            // Check if word is present at mid
            if (res == 0) {
                return true;
            }

            // If word greater, ignore left half
            if (res > 0) {
                inicio = medio + 1;
            }

            // If word is smaller, ignore right half
            else {
                fin = medio - 1;
            }
        }
        return false;
    }

    public static Map<String, Boolean> busquedaMultiple(List<String> lineas, List<String> palabras) {
        Map<String, Boolean> resultados = new HashMap<>();
        for (String palabra : palabras) {
            boolean encontrado = busquedaLineal(lineas, palabra);
            resultados.put(palabra, encontrado);
        }
        return resultados;
    }

    public static int contarFrecuencia(List<String> lineas, String palabra) {
        int count = 0;
        for (String linea : lineas) {
            if (linea.contains(palabra)) {
                count++;
            }
        }
        return count;
    }

    public static List<String> buscarPorLetraInicial(List<String> lineas, char letra) {
        List<String> resultados = new ArrayList<>();
        for (String linea : lineas) {
            if (linea.charAt(0) == letra) {
                resultados.add(linea);
            }
        }
        return resultados;
    }

    public static void main(String[] args) {
        List<String> lineas = leerArchivo("ruta_al_archivo.txt");
        if (lineas.isEmpty()) {
            return;
        }

        String palabra = "palabra_a_buscar";

        // Búsqueda lineal
        boolean encontradoLineal = busquedaLineal(lineas, palabra);
        System.out.println("Búsqueda lineal: " + (encontradoLineal ? "Encontrado" : "No encontrado"));

        // Búsqueda binaria
        boolean encontradoBinario = busquedaBinaria(lineas, palabra);
        System.out.println("Búsqueda binaria: " + (encontradoBinario ? "Encontrado" : "No encontrado"));

        // Búsqueda múltiple
        List<String> palabras = Arrays.asList("palabra1", "palabra2", "palabra3");
        Map<String, Boolean> resultados = busquedaMultiple(lineas, palabras);
        System.out.println("Resultados de la búsqueda múltiple: " + resultados);

        // Contar frecuencia
        int frecuencia = contarFrecuencia(lineas, palabra);
        System.out.println("Frecuencia de '" + palabra + "': " + frecuencia);

        // Buscar por letra inicial
        List<String> lineasConA = buscarPorLetraInicial(lineas, 'A');
        System.out.println("Líneas que comienzan con 'A': " + lineasConA);
    }
}