package Analisis_genomico;

public class Conteo_Genes {

    public static int countGenes(String dna, int index) {
        if (index > dna.length() - 3) {
            return 0;
        }

        String codon = dna.substring(index, index + 3);
        if (codon.equals("ATG")) {
            return 1 + countGenes(dna, index + 3);
        } else {
            return countGenes(dna, index + 1);
        }
    }
}