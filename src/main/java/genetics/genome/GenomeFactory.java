package genetics.genome;

import genetics.Field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenomeFactory {

    public static Genome generateGenome(Field field, List<Integer> gens) {
        List<Integer> modifiedGens = new ArrayList<>(gens);
        Collections.shuffle(modifiedGens);
        return new Genome(field, Collections.unmodifiableList(modifiedGens));
    }
}
