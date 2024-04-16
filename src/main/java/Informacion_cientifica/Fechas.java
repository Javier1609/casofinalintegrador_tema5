package Informacion_cientifica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Fechas {
    private static List<Date> fechas = new ArrayList<>();
    private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean validarFecha(String fecha) {
        try {
            formato.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void introducirFecha(String fecha) {
        if (validarFecha(fecha)) {
            try {
                Date fechaConvertida = formato.parse(fecha);
                fechas.add(fechaConvertida);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Formato de fecha incorrecto. Use dd/MM/yyyy.");
        }
    }

    public static void listarFechas() {
        Collections.sort(fechas);
        for (Date fecha : fechas) {
            System.out.println(formato.format(fecha));
        }
    }

    public static void main(String[] args) {
        // Introducir fechas
        introducirFecha("12/12/2022");
        introducirFecha("11/11/2021");
        introducirFecha("10/10/2023");

        // Listar fechas
        listarFechas();
    }
}