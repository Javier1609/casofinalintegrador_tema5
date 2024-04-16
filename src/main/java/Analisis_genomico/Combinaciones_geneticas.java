package Analisis_genomico;

public class Combinaciones_geneticas {
    public static int countGenes(String dna) {
        if (dna.isEmpty()) {
            return 0;
        } else {
            int index = dna.indexOf("ATG");
            if (index != -1) {
                return 1 + countGenes(dna.substring(index + 3));
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        String dna = "ATGCGTATGAGCTAGCATG";
        System.out.println("Number of genes: " + countGenes(dna));
    }
}