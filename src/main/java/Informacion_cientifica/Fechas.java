package Informacion_cientifica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fechas {

    private List<LocalDate> fechas = new ArrayList<>();

    public void agregarFecha(LocalDate fecha) {
        fechas.add(fecha);
    }

    public List<LocalDate> listarFechas() {
        fechas = mergeSort(fechas);
        return fechas;
    }

    private List<LocalDate> mergeSort(List<LocalDate> fechas) {
        if (fechas.size() <= 1) {
            return fechas;
        }
        int mid = fechas.size() / 2;
        List<LocalDate> left = mergeSort(new ArrayList<>(fechas.subList(0, mid)));
        List<LocalDate> right = mergeSort(new ArrayList<>(fechas.subList(mid, fechas.size())));
        return merge(left, right);
    }

    private List<LocalDate> merge(List<LocalDate> left, List<LocalDate> right) {
        List<LocalDate> merged = new ArrayList<>();
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