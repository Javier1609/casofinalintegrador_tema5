package Analisis_numerico;

public class sumario_y_listado_numeros {
    public static int sumaNumeros(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sumaNumeros(n - 1);
        }
    }

    public static void listarNumeros(int inicio, int fin) {
        if (inicio > fin || inicio < 0 || fin < 0) {
            return;
        } else {
            System.out.println(inicio);
            listarNumeros(inicio + 1, fin);
        }
    }

    public static void main(String[] args) {
        int n = 0;
        if (n >= 0) {
            System.out.println("Suma de números naturales hasta " + n + ": " + sumaNumeros(n));
        } else {
            System.out.println("Invalid number.");
        }

        int inicio = 1;
        int fin = 10;
        if (inicio >= 0 && fin >= 0 && inicio <= fin) {
            System.out.println("Listado de números del " + inicio + " al " + fin + ":");
            listarNumeros(inicio, fin);
        } else {
            System.out.println("Invalid range.");
        }
    }
}