package genetics.genome;

import genetics.Field;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Population {
    private final Field field;
    private final List<Integer> gens;
    private final int populationLength;

    @Getter
    private final TreeSet<Genome> population;

    public Population(Field field, List<Integer> gens, int populationLength) {
        this.field = field;
        this.gens = gens;
        this.populationLength = populationLength;
        TreeSet<Genome> population = new TreeSet<>();

        while (population.size() < populationLength) {
            population.add(GenomeFactory.generateGenome(field, gens));
        }

        this.population = population;
    }

    public void doCrossover() {
        System.out.println("Population: " + population);

        int firstParentIndex = ThreadLocalRandom.current().nextInt(populationLength);
        int secondParentIndex = ThreadLocalRandom.current().nextInt(populationLength);

        while (firstParentIndex == secondParentIndex) {
            secondParentIndex = ThreadLocalRandom.current().nextInt(populationLength);
        }

        Genome firstParent = findParent(firstParentIndex);
        Genome secondParent = findParent(secondParentIndex);

        System.out.println("Parents: " + firstParent + ", " + secondParent);

        List<Genome> children = crossover(firstParent, secondParent);

        System.out.println("Children: " + children);

        population.add(children.get(0));
        population.add(children.get(1));

        while (population.size() > populationLength) {
            population.pollLast();
        }
    }

    private Genome findParent(int index) {
        Iterator<Genome> iter = population.iterator();
        for (int i = 0; i < index; i++) {
            iter.next();
        }
        return iter.next();
    }

    private List<Genome> crossover(Genome g1, Genome g2) {
        assert g1.getGenome().size() == g2.getGenome().size();

        List<Integer> delimiterPositions = generateDelimiters();
        int firstDelimiterPosition = delimiterPositions.get(0);
        int secondDelimiterPosition = delimiterPositions.get(1);

        System.out.println("Delimiters: " + firstDelimiterPosition + ", " + secondDelimiterPosition);

        List<Integer> firstChildGenome = new ArrayList<>(Collections.nCopies(gens.size(), 0));
        List<Integer> secondChildGenome = new ArrayList<>(Collections.nCopies(gens.size(), 0));

        for (int i = firstDelimiterPosition; i <= secondDelimiterPosition; i++) {
            firstChildGenome.set(i, g2.getGenome().get(i));
            secondChildGenome.set(i, g1.getGenome().get(i));
        }

        fillGenome(g1.getGenome(), firstChildGenome, firstDelimiterPosition, secondDelimiterPosition);
        fillGenome(g2.getGenome(), secondChildGenome, firstDelimiterPosition, secondDelimiterPosition);

        Genome firstChild = new Genome(field, firstChildGenome);
        Genome secondChild = new Genome(field, secondChildGenome);

        List<Genome> children = new ArrayList<>();

        children.add(firstChild);
        children.add(secondChild);

        return children;
    }

    private List<Integer> generateDelimiters() {
        int firstDelimiterPosition = generateDelimiterPosition();

        while (firstDelimiterPosition == gens.size() - 1) {
            firstDelimiterPosition = generateDelimiterPosition();
        }

        int secondDelimiterPosition = generateDelimiterPosition();

        while (secondDelimiterPosition == firstDelimiterPosition) {
            secondDelimiterPosition = generateDelimiterPosition();
        }

        List<Integer> positions = new ArrayList<>();
        positions.add(Math.min(firstDelimiterPosition, secondDelimiterPosition));
        positions.add(Math.max(firstDelimiterPosition, secondDelimiterPosition));

        return positions;
    }

    private int generateDelimiterPosition() {
        return ThreadLocalRandom.current().nextInt(gens.size());
    }

    private void fillGenome(List<Integer> parentGenome, List<Integer> childGenome,
                            int firstDelimiterPosition, int secondDelimiterPosition) {
        int childIterator = firstDelimiterPosition == 0 ? (secondDelimiterPosition + 1) % gens.size() : 0;
        int parentIterator = firstDelimiterPosition + 1;

        do {
            if (!childGenome.contains(parentGenome.get(parentIterator))) {
                childGenome.set(childIterator, parentGenome.get(parentIterator));

                if (childIterator == (firstDelimiterPosition - 1) % gens.size()) {
                    childIterator = (secondDelimiterPosition + 1) % gens.size();
                } else {
                    childIterator = (childIterator + 1) % gens.size();
                }
            }
            parentIterator = (parentIterator + 1) % gens.size();
        } while (parentIterator != firstDelimiterPosition + 1);
    }
}
