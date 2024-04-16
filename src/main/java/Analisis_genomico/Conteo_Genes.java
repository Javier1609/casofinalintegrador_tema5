package Analisis_genomico;

public class Conteo_Genes {
    public static void generarCombinaciones(String combinacion, int n) {
        if (n == 0) {
            System.out.println(combinacion);
        } else {
            generarCombinaciones(combinacion + "A", n - 1);
            generarCombinaciones(combinacion + "a", n - 1);
        }
    }

    public static boolean validarNumeroGenes(int n) {
        return n > 0;
    }

    public static void main(String[] args) {
        int n = 3; // número de genes
        if (validarNumeroGenes(n)) {
            generarCombinaciones("", n);
        } else {
            System.out.println("Invalid number of genes.");
        }
    }
}