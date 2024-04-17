import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import Analisis_genomico.*;
import Analisis_numerico.*;
import Optimizacion_de_procesos.*;
import Informacion_cientifica.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame(" Sistema Interactivo de Análisis Genómico y Organización de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300); // Aumentamos el tamaño del JFrame

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("INTERFAZ DE USUARIO PARA LOS INVESTIGADORES");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Agrega espacio entre los componentes

        String[] options = {
                "Conteo de genes",
                "Combinaciones genéticas recursivas",
                "Combinaciones genéticas iterativas",
                "Calcular potencias y encontrar máximo",
                "Calcular sumatoria",
                "Ordenar documento (A-Z)",
                "Busqueda de palabras",
                "Agregar fecha",
                "Listar fechas",
                "Algoritmo quicksort (ascendente)",
                "Algoritmo quicksort (descendente)"
        };

        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setMaximumSize(comboBox.getPreferredSize()); // Para evitar que el JComboBox se estire para llenar todo el ancho del panel
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(comboBox);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Agrega espacio entre los componentes

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Cambiamos a FlowLayout con alineación central
        JButton confirmButton = new JButton("Confirmar");
        buttonPanel.add(confirmButton);
        JButton exitButton = new JButton("Salir");
        buttonPanel.add(exitButton);
        panel.add(buttonPanel);

        Fechas gestionFechas = new Fechas();
        Optimizacion_de_algoritmos mejoraAlgoritmos = new Optimizacion_de_algoritmos();
        Conteo_Genes conteoGenes = new Conteo_Genes();
        Combinaciones_geneticas combinacionesGeneticas = new Combinaciones_geneticas();

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                switch (selectedOption) {

                    case "Conteo de genes":
                        List<String> dnas = Arrays.asList("AGTCGAGTCTAGCTAGCTAGCATG", "AGTAGTAGT", "AGTCGAGT");
                        for (int i = 0; i < dnas.size(); i++) {
                            System.out.println("Cadena de ADN " + (i + 1) + ": " + dnas.get(i));
                            int count = Conteo_Genes.countGenes(dnas.get(i), 0);
                            System.out.println("Número de genes en la cadena de ADN " + (i + 1) + ": " + count);
                        }
                        break;

                    case "Combinaciones genéticas recursivas":
                        String nString = JOptionPane.showInputDialog("Ingrese el valor de n:");
                        String kString = JOptionPane.showInputDialog("Ingrese el valor de k:");
                        int n = Integer.parseInt(nString);
                        int k = Integer.parseInt(kString);
                        long combinacionesRecursivas = combinacionesGeneticas.calcularCombinacionesRecursivo(n, k);
                        JOptionPane.showMessageDialog(null, "Las combinaciones genéticas recursivas son: " + combinacionesRecursivas);
                        break;

                    case "Combinaciones genéticas iterativas":
                        String nStringIterativo = JOptionPane.showInputDialog("Ingrese el valor de n:");
                        String kStringIterativo = JOptionPane.showInputDialog("Ingrese el valor de k:");
                        int nIterativo = Integer.parseInt(nStringIterativo);
                        int kIterativo = Integer.parseInt(kStringIterativo);
                        long combinacionesIterativas = combinacionesGeneticas.calcularCombinacionesIterativo(nIterativo, kIterativo);
                        JOptionPane.showMessageDialog(null, "Las combinaciones genéticas iterativas son: " + combinacionesIterativas);
                        break;

                    case "Calcular potencias y encontrar máximo":
                        String base1String = JOptionPane.showInputDialog("Ingrese la primera base:");
                        String exponente1String = JOptionPane.showInputDialog("Ingrese el primer exponente:");
                        String base2String = JOptionPane.showInputDialog("Ingrese la segunda base:");
                        String exponente2String = JOptionPane.showInputDialog("Ingrese el segundo exponente:");
                        String base3String = JOptionPane.showInputDialog("Ingrese la tercera base:");
                        String exponente3String = JOptionPane.showInputDialog("Ingrese el tercer exponente:");
                        int base1 = Integer.parseInt(base1String);
                        int exponente1 = Integer.parseInt(exponente1String);
                        int base2 = Integer.parseInt(base2String);
                        int exponente2 = Integer.parseInt(exponente2String);
                        int base3 = Integer.parseInt(base3String);
                        int exponente3 = Integer.parseInt(exponente3String);
                        Potencias_y_maximos calculoPotenciasMaximos = new Potencias_y_maximos();
                        int resultado1 = calculoPotenciasMaximos.calcularPotencia(base1, exponente1);
                        int resultado2 = calculoPotenciasMaximos.calcularPotencia(base2, exponente2);
                        int resultado3 = calculoPotenciasMaximos.calcularPotencia(base3, exponente3);
                        int maximo = calculoPotenciasMaximos.encontrarMaximo(Arrays.asList(resultado1, resultado2, resultado3));
                        JOptionPane.showMessageDialog(null, "Los valores de las tres potencias son: " + resultado1 + ", " + resultado2 + ", " + resultado3 + "\nEl valor máximo entre las tres potencias es: " + maximo);
                        break;

                    case "Calcular sumatoria":
                        String nStringSumatoria = JOptionPane.showInputDialog("Ingrese el valor de n:");
                        int nSumatoria = Integer.parseInt(nStringSumatoria);
                        sumario_y_listado_numeros sumatoriaListadoNumeros = new sumario_y_listado_numeros();
                        int resultadoSumatoria = sumatoriaListadoNumeros.calcularSumatoria(nSumatoria);
                        JOptionPane.showMessageDialog(null, "El resultado de la sumatoria es: " + resultadoSumatoria);
                        String inicioString = JOptionPane.showInputDialog("Ingrese el valor de inicio del rango:");
                        String finString = JOptionPane.showInputDialog("Ingrese el valor de fin del rango:");
                        int inicio = Integer.parseInt(inicioString);
                        int fin = Integer.parseInt(finString);
                        List<Integer> numeros = sumatoriaListadoNumeros.listarNumeros(inicio, fin);
                        JOptionPane.showMessageDialog(null, "Los números en el rango dado son: " + numeros);
                        break;

                    case "Agregar fecha":
                        LocalDate randomDate = LocalDate.ofEpochDay(new Random().nextInt(365 * 50));
                        gestionFechas.agregarFecha(randomDate);
                        System.out.println("Fecha agregada: " + randomDate);
                        break;

                    case "Listar fechas":
                        List<LocalDate> fechas = gestionFechas.listarFechas();
                        StringBuilder fechasStr = new StringBuilder("Listado de fechas agregadas:\n");
                        for (LocalDate fecha : fechas) {
                            fechasStr.append(fecha).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, fechasStr.toString());
                        break;

                    case "Ordenar documento (A-Z)":
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setFileFilter(new FileFilter() {
                            public boolean accept(File f) {
                                return f.getName().toLowerCase().endsWith(".txt") || f.isDirectory();
                            }

                            public String getDescription() {
                                return "Archivos de texto";
                            }
                        });
                        int returnValue = fileChooser.showOpenDialog(null);
                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            try {
                                List<String> linesBeforeSorting = Files.readAllLines(selectedFile.toPath());
                                JOptionPane.showMessageDialog(null, "Contenido del archivo antes de ordenar:\n" + String.join("\n", linesBeforeSorting));

                                List<String> sortedLines = new ArrayList<>();
                                for (String line : linesBeforeSorting) {
                                    sortedLines.add(Organizacion_de_documentos.sortWordsInLine(line));
                                }
                                Files.write(selectedFile.toPath(), sortedLines);

                                List<String> linesAfterSorting = Files.readAllLines(selectedFile.toPath());
                                JOptionPane.showMessageDialog(null, "Contenido del archivo después de ordenar:\n" + String.join("\n", linesAfterSorting));
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Error al ordenar el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;

                    case "Busqueda de palabras":
                        boolean seguirBuscando = true;
                        do {
                            JFileChooser fileChooserBuscarPalabras = new JFileChooser();
                            fileChooserBuscarPalabras.setFileFilter(new FileFilter() {
                                public boolean accept(File f) {
                                    return f.getName().toLowerCase().endsWith(".txt") || f.isDirectory();
                                }

                                public String getDescription() {
                                    return "Archivos de texto";
                                }
                            });
                            int returnValueBuscarPalabras = fileChooserBuscarPalabras.showOpenDialog(null);
                            if (returnValueBuscarPalabras == JFileChooser.APPROVE_OPTION) {
                                File selectedFile = fileChooserBuscarPalabras.getSelectedFile();
                                String palabra = JOptionPane.showInputDialog("Ingrese la palabra que está buscando:");
                                try {
                                    BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                                    String linea;
                                    int numLinea = 0;
                                    boolean palabraEncontrada = false;
                                    while ((linea = reader.readLine()) != null) {
                                        numLinea++;
                                        int index = linea.indexOf(palabra);
                                        if (index != -1) {
                                            palabraEncontrada = true;
                                            JOptionPane.showMessageDialog(null, "La palabra '" + palabra + "' se encontró en la línea " + numLinea + ", posición " + (index + 1));
                                            break;
                                        }
                                    }
                                    reader.close();
                                    if (!palabraEncontrada) {
                                        throw new Exception("La palabra que está buscando, no se encuentra en este archivo");
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea seguir buscando palabras?", "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (opcion == JOptionPane.NO_OPTION) {
                                seguirBuscando = false;
                            }
                        } while (seguirBuscando);
                        break;

                    case "Algoritmo quicksort (ascendente)":
                        int[] arrAsc = new Random().ints(10, 0, 100).toArray();
                        System.out.println("\nArray original: " + Arrays.toString(arrAsc));
                        mejoraAlgoritmos.quickSort(arrAsc, 0, arrAsc.length - 1, true);
                        System.out.println("\nArray ordenado: " + Arrays.toString(arrAsc));
                        break;

                    case "Algoritmo quicksort (descendente)":
                        int[] arrDesc = new Random().ints(10, 0, 100).toArray();
                        System.out.println("\nArray original: " + Arrays.toString(arrDesc));
                        mejoraAlgoritmos.quickSort(arrDesc, 0, arrDesc.length - 1, false);
                        System.out.println("\nArray ordenado: " + Arrays.toString(arrDesc));
                        break;
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}