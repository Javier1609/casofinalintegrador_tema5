
package Informacion_cientifica;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Organizacion_de_documentos {

    public static void sortAndWriteLines(ArrayList<String> lines, String outputPath) throws IOException {
        Collections.sort(lines);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            for (String sortedLine : lines) {
                writer.write(sortedLine);
                writer.newLine();
            }
        }
    }

    public static void sortLines(String inputFilePath, String outputFilePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
        List<String> sortedLines = new ArrayList<>();
        for (String line : lines) {
            sortedLines.add(sortWordsInLine(line));
        }
        Files.write(Paths.get(outputFilePath), sortedLines);
    }

    public static String sortWordsInLine(String line) {
        String[] words = line.split("\\s+");
        Arrays.sort(words);
        return String.join(" ", words);
    }
}
