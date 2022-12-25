package genetics;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Field {
    public final int[][] field;

    public static Field of(int[][] field) {
        return new Field(field);
    }

    public int getDistance(int d1, int d2) {
        return field[d1 - 1][d2 - 1];
    }
}
