package methods.util.points.extremum_points;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import methods.util.ExtremumType;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TwoDimensionalExtremumPoint {
    double x;
    double y;
    ExtremumType type;

    public static TwoDimensionalExtremumPoint of(double x, double y, ExtremumType type) {
        return new TwoDimensionalExtremumPoint(x, y, ExtremumType.valueOf(type.name()));
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + "), extremum type = " + type;
    }
}
