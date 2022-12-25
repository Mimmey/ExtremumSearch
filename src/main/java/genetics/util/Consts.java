package genetics.util;

import java.util.List;

public class Consts {
    public static final int[][] field = new int[][] {
        {0, 2, 5, 7, 2},
        {2, 0, 4, 3, 6},
        {5, 4, 0, 6, 5},
        {7, 3, 6, 0, 3},
        {2, 6, 5, 3, 0}
    };

    public static List<Integer> gens = List.of(1, 2, 3, 4, 5);

    public static int populationLength = 4;
}
