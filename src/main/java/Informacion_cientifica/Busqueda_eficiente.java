package Informacion_cientifica;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Busqueda_eficiente {

    public boolean busquedaLineal(String rutaArchivo, String palabra) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains(palabra)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean busquedaBinaria(String rutaArchivo, String palabra) throws IOException {
        List<String> lineas = leerLineas(rutaArchivo);
        lineas = mergeSort(lineas);
        int indice = Collections.binarySearch(lineas, palabra);
        return indice >= 0;
    }

    private List<String> leerLineas(String rutaArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }

    private List<String> mergeSort(List<String> lineas) {
        if (lineas.size() <= 1) {
            return lineas;
        }
        int mid = lineas.size() / 2;
        List<String> left = mergeSort(new ArrayList<>(lineas.subList(0, mid)));
        List<String> right = mergeSort(new ArrayList<>(lineas.subList(mid, lineas.size())));
        return merge(left, right);
    }

    private List<String> merge(List<String> left, List<String> right) {
        List<String> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }
        while (i < left.size()) {
            merged.add(left.get(i++));
        }
        while (j < right.size()) {
            merged.add(right.get(j++));
        }
        return merged;
    }
}