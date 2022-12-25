package genetics;

import genetics.genome.Population;
import genetics.util.Consts;

public class Main {
    public static void main(String[] args) {
        Field field = Field.of(Consts.field);
        Population population = new Population(field, Consts.gens, Consts.populationLength);

        System.out.println("Starting population: " + population.getPopulation());

        for (int i = 0; i < 10; i++) {
            population.doCrossover();
        }

        System.out.println("Result population: " + population.getPopulation());
    }
}
