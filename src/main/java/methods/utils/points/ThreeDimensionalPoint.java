package methods.utils.points;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ThreeDimensionalPoint {
    private double x;
    private double y;
    private double z;

    public static ThreeDimensionalPoint of(double x, double y, double z) {
        return new ThreeDimensionalPoint(x, y, z);
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + "; " + z + ")";
    }
}
