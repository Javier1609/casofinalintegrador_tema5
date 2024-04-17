package Analisis_numerico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Potencias_y_maximos {

    public int calcularPotencia(int base, int exponente) {
        int resultado = 1;
        while (exponente != 0) {
            resultado *= base;
            --exponente;
        }
        return resultado;
    }

    public int encontrarMaximo(List<Integer> numeros) {
        int maximo = numeros.get(0);
        for (int numero : numeros) {
            if (numero > maximo) {
                maximo = numero;
            }
        }
        return maximo;
    }

    public List<Integer> ordenarNumeros(List<Integer> numeros) {
        if (numeros.size() <= 1) {
            return numeros;
        }
        List<Integer> izquierda = new ArrayList<>();
        List<Integer> derecha = new ArrayList<>();
        int pivot = numeros.get(numeros.size() / 2);
        for (int num : numeros) {
            if (num < pivot) {
                izquierda.add(num);
            } else if (num > pivot) {
                derecha.add(num);
            }
        }
        izquierda = ordenarNumeros(izquierda);
        derecha = ordenarNumeros(derecha);
        izquierda.add(pivot);
        izquierda.addAll(derecha);
        return izquierda;
    }

    public int calcularPotenciasYEncontrarMaximo(int base1, int exponente1, int base2, int exponente2, int base3, int exponente3) {
        int resultado1 = calcularPotencia(base1, exponente1);
        int resultado2 = calcularPotencia(base2, exponente2);
        int resultado3 = calcularPotencia(base3, exponente3);

        List<Integer> resultados = Arrays.asList(resultado1, resultado2, resultado3);

        return encontrarMaximo(resultados);
    }
}