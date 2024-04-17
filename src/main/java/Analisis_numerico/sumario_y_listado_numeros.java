package Analisis_numerico;

import java.util.ArrayList;
import java.util.List;

public class sumario_y_listado_numeros {

    public int calcularSumatoria(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + calcularSumatoria(n - 1);
        }
    }

    public List<Integer> listarNumeros(int inicio, int fin) {
        if (inicio > fin) {
            return new ArrayList<>();
        } else {
            List<Integer> lista = listarNumeros(inicio, fin - 1);
            lista.add(fin);
            return lista;
        }
    }

    public List<Integer> ordenarNumeros(int inicio, int fin) {
        List<Integer> numeros = listarNumeros(inicio, fin);
        ordenarNumerosRecursivo(numeros, 0, numeros.size() - 1);
        return numeros;
    }

    private void ordenarNumerosRecursivo(List<Integer> numeros, int inicio, int fin) {
        if (inicio < fin) {
            int pivotIndex = partition(numeros, inicio, fin);
            ordenarNumerosRecursivo(numeros, inicio, pivotIndex - 1);
            ordenarNumerosRecursivo(numeros, pivotIndex + 1, fin);
        }
    }

    private int partition(List<Integer> numeros, int inicio, int fin) {
        int pivot = numeros.get(fin);
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (numeros.get(j) < pivot) {
                i++;
                int temp = numeros.get(i);
                numeros.set(i, numeros.get(j));
                numeros.set(j, temp);
            }
        }
        int temp = numeros.get(i + 1);
        numeros.set(i + 1, numeros.get(fin));
        numeros.set(fin, temp);
        return i + 1;
    }
}