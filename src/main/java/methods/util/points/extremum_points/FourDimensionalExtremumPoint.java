package methods.util.points.extremum_points;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import methods.util.ExtremumType;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FourDimensionalExtremumPoint {
    double x;
    double y;
    double z;
    double w;
    ExtremumType type;

    public static FourDimensionalExtremumPoint of(double x, double y, double z, double w, ExtremumType type) {
        return new FourDimensionalExtremumPoint(x, y, z, w, ExtremumType.valueOf(type.name()));
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + "; " + z + "; " + w +"), extremum type = " + type;
    }
}
