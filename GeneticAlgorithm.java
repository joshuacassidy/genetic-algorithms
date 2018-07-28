import java.util.Random;

public class GeneticAlgorithm {

    private Random random;

    public GeneticAlgorithm() {
        random = new Random();
    }

    public Population evolvePopulation(Population population) {
        Population newPopulation = new Population(population.size());

        for (int i = 0; i < population.size(); i++) {
            Individual individual1 = randomSelection(population);
            Individual individual2 = randomSelection(population);
            Individual newIndividual = crossover(individual1, individual2);
            newPopulation.saveIndividual(i, newIndividual);
        }

        for (int i = 0; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }
        return newPopulation;
    }

    private void mutate(Individual individual) {
        for (int i = 0; i < Constants.CHROMOSOME_LENGTH; i++) {
            if (Math.random() < Constants.MUTATION_RATE) {
                int gene = random.nextInt(2);
                individual.setGene(i, gene);
            }
        }
    }

    private Individual crossover(Individual individual1, Individual individual2) {
        Individual newIndividual = new Individual();

        for (int i = 0; i < Constants.CHROMOSOME_LENGTH; i++) {
            if (Math.random() < Constants.CROSSOVER_RATE) {
                newIndividual.setGene(i, individual1.getGene(i));
            } else {
                newIndividual.setGene(i, individual2.getGene(i));
            }
        }
        return newIndividual;
    }

    private Individual randomSelection(Population population) {
        Population newPopulation = new Population(Constants.TOURNAMENT_SIZE); // create pop with this size
        for (int i = 0; i < Constants.TOURNAMENT_SIZE; i++) {
            int randomIndex = random.nextInt(population.size());
            newPopulation.saveIndividual(i, population.getIndividual(randomIndex));
        }

        Individual fittestIndividual = newPopulation.getFittestIndividual();

        return fittestIndividual;

    }




}
