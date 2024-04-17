package Analisis_numerico;

public class Potencias_y_maximos {
    public static double calcularPotencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente < 0) {
            return 1 / calcularPotencia(base, -exponente);
        } else {
            return base * calcularPotencia(base, exponente - 1);
        }
    }

    public static double encontrarMaximo(double[] datos) {
        return encontrarMaximo(datos, 0, datos[0]);
    }

    private static double encontrarMaximo(double[] datos, int index, double max) {

        if (index == datos.length) {
            return max;
        } else {
            if (datos[index] > max) {
                max = datos[index];
            }
            return encontrarMaximo(datos, index + 1, max);
        }
    }

    public static boolean validarDatos(double[] datos) {
        for (double dato : datos) {
            if (Double.isNaN(dato)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        double base = 2;
        int exponente = 3;
        System.out.println("Potencia: " + calcularPotencia(base, exponente));

        double[] datos = {1.2, 2.3, 3.4, 2.2, 1.1};
        if (validarDatos(datos)) {
            System.out.println("Valor máximo: " + encontrarMaximo(datos));
        } else {
            System.out.println("Invalid data.");
        }
    }
}