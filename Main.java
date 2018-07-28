import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        GeneticAlgorithm geneticAlgorithms = new GeneticAlgorithm();

        Population population = new Population(100);
        population.init();

        int generationCounter = 0;

        while (generationCounter != Constants.SIMULATION_LENGTH) {
            System.out.println("Generation " + generationCounter + " the fittest individual is: " + population.getFittestIndividual().getFitness() + "\n");
            System.out.println(population.getFittestIndividual());
            population = geneticAlgorithms.evolvePopulation(population);
            generationCounter++;

        }

        System.out.println("\n\n"+population.getFittestIndividual());
        System.out.println(convertGenesToDoubles());
    }


    public static double convertGenesToDoubles() {
        int[] genes = {0, 1, 1};
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
        return geneInDouble;

    }

}
