import java.util.Arrays;
import java.util.Random;

public class Individual {

    private int[] genes;
    private int fitness;
    private Random random;

    public Individual() {
        this.genes = new int[Constants.CHROMOSOME_LENGTH];
        this.random = new Random();
    }

    public void generateIndiviual() {
        for (int i = 0; i < Constants.CHROMOSOME_LENGTH; i++) {
            int gene = random.nextInt(2);
            genes[i] = gene;
        }
    }

    public double f(double x) {
        return Math.sin(x) * 6;
    }

    public double getFitness() {
        double genesToDouble = convertGenesToDoubles();

        return f(genesToDouble);
    }

    public double convertGenesToDoubles() {
        int base = 1;

        for (int i = 0; i < genes.length/2; i++) {
            int temp = genes[i];
            genes[i] = genes[genes.length-i-1];
            genes[genes.length-i-1] = temp;
        }

        double geneInDouble = 0;
        for (int i = 0; i < genes.length; i++) {
            if (genes[i] == 1) {
                geneInDouble += base;
            }

            base = base*2;
        }
        return geneInDouble/100;

    }
    public int getGene(int index) {
        return this.genes[index];
    }

    public void setGene(int index, int value) {
        this.genes[index] = value;
        fitness = 0;
    }

    @Override
    public String toString() {

        String str = "Chromosome: " + convertGenesToDoubles() + " Has the genes: ";
        for (int i = 0; i < Constants.CHROMOSOME_LENGTH; i++) {
            str+=getGene(i);
        }
        return str;
    }
}
