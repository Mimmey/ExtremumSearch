package genetics.genome;

import genetics.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Genome implements Comparable<Genome> {
    private final Field field;
    private final List<Integer> genome;

    public int getValue() {
        int value = field.getDistance(genome.get(0), genome.get(genome.size() - 1));


        for (int i = 1; i < genome.size(); i++) {
            value += field.getDistance(genome.get(i), genome.get(i - 1));
        }

        return value;
    }

    @Override
    public int compareTo(Genome o) {
        if (this.getValue() == o.getValue()) {
            for (int i = 0; i < genome.size(); i++) {
                if (this.genome.get(i).equals(o.genome.get(i))) {
                    continue;
                }

                return this.genome.get(i) > o.genome.get(i) ? 1 : -1;
            }

            return 0;
        }

        return this.getValue() > o.getValue() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Genome: " + genome.toString() + ", Value: " + this.getValue();
    }
}
