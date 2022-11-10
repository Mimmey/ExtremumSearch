package methods.numerical_optimization.golden_ratio;

import methods.UnivariativeExtremumSearchMethod;
import methods.utils.points.extremum_points.TwoDimensionalExtremumPoint;
import methods.utils.ExtremumType;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class GoldenRatioMethod extends UnivariativeExtremumSearchMethod {

    @Override
    public TwoDimensionalExtremumPoint findExtremumPoint(UnivariateDifferentiableFunction function,
                                                         double accuracy,
                                                         double start,
                                                         double end) {
        ExtremumType extremumType = findExtremumType(function, start);
        return extremumType.equals(ExtremumType.MAX)
                ? findMaxExtremumPoint(function, accuracy, start, end)
                : findMinExtremumPoint(function, accuracy, start, end);
    }

    private TwoDimensionalExtremumPoint findMinExtremumPoint(UnivariateDifferentiableFunction function,
                                                             double accuracy,
                                                             double start,
                                                             double end) {
        while (end - start >= 2 * accuracy) {
            double x1 = start + 0.382 * (end - start);
            double x2 = start + 0.618 * (end - start);
            double y1 = function.value(x1);
            double y2 = function.value(x2);

            if (y1 > y2) {
                start = x1;
            } else {
                end = x2;
            }
        }

        double xFound = (start + end) / 2;

        return TwoDimensionalExtremumPoint.of(xFound, function.value(xFound), ExtremumType.MIN);
    }

    public TwoDimensionalExtremumPoint findMaxExtremumPoint(UnivariateDifferentiableFunction function,
                                                            double accuracy,
                                                            double start,
                                                            double end) {
        while (end - start >= 2 * accuracy) {
            double x1 = start + 0.382 * (end - start);
            double x2 = start + 0.618 * (end - start);
            double y1 = function.value(x1);
            double y2 = function.value(x2);

            if (y1 < y2) {
                start = x1;
            } else {
                end = x2;
            }
        }

        double xFound = (start + end) / 2;

        return TwoDimensionalExtremumPoint.of(xFound, function.value(xFound), ExtremumType.MAX);
    }
}
