public class Population {

    private Individual[] individuals;

    public Population(int populationSize) {
        this.individuals = new Individual[populationSize];
    }

    public void init() {
        for (int i = 0; i < individuals.length; i++) {
            Individual individual = new Individual();
            individual.generateIndiviual();
            saveIndividual(i, individual);
        }
    }

    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual getFittestIndividual() {
        Individual fittest = individuals[0];

        for (int i = 0; i < individuals.length; i++) {
            if (getIndividual(i).getFitness() >= fittest.getFitness()) {
                fittest = individuals[i];
            }
        }

        return fittest;

    }

    public int size() {
        return individuals.length;
    }

    public void saveIndividual(int index, Individual individual) {
        this.individuals[index] = individual;
    }


}
