package Analisis_genomico;

public class Combinaciones_geneticas {

    public static long calcularCombinacionesRecursivo(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            return calcularCombinacionesRecursivo(n - 1, k - 1) + calcularCombinacionesRecursivo(n - 1, k);
        }
    }

    public static long calcularCombinacionesIterativo(int n, int k) {
        long C[][] = new long[n + 1][k + 1];
        int i, j;

        for (i = 0; i <= n; i++) {
            for (j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                } else {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }

        return C[n][k];
    }
}