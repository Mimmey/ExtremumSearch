package methods.utils.points;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreeDimensionalPoint {
    private double x;
    private double y;
    private double z;

    @Override
    public String toString() {
        return "(" + x + "; " + y + "; " + z + ")";
    }
}
