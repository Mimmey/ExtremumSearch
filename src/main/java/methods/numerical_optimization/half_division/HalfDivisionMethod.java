package methods.numerical_optimization.half_division;

import methods.UnivariateExtremumSearchMethod;
import methods.utils.points.extremum_points.TwoDimensionalExtremumPoint;
import methods.utils.ExtremumType;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class HalfDivisionMethod extends UnivariateExtremumSearchMethod {

    @Override
    public TwoDimensionalExtremumPoint findExtremumPoint(UnivariateDifferentiableFunction function,
                                                         double accuracy,
                                                         double start,
                                                         double end) {
        ExtremumType extremumType = findExtremumType(function, start);
        return extremumType.equals(ExtremumType.MIN)
                ? findMinExtremumPoint(function, accuracy, start, end)
                : findMaxExtremumPoint(function, accuracy, start, end);
    }

    public TwoDimensionalExtremumPoint findMinExtremumPoint(UnivariateDifferentiableFunction function,
                                                            double accuracy,
                                                            double start,
                                                            double end) {
        while (end - start >= 2 * accuracy) {
            double x1 = (start + end - accuracy) / 2;
            double x2 = (start + end + accuracy) / 2;
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
            double x1 = (start + end - accuracy) / 2;
            double x2 = (start + end + accuracy) / 2;
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
