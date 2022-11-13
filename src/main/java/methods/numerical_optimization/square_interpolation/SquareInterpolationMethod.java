package methods.numerical_optimization.square_interpolation;

import methods.DerivativeUnivariativeExtremumSearchMethod;
import methods.UnivariativeExtremumSearchMethod;
import methods.utils.ExtremumType;
import methods.utils.points.extremum_points.TwoDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

import java.util.Optional;

public class SquareInterpolationMethod extends DerivativeUnivariativeExtremumSearchMethod {

    @Override
    public TwoDimensionalExtremumPoint findExtremumPoint(UnivariateDifferentiableFunction function,
                                       double accuracy,
                                       double start,
                                       double end) {
        double aver = (start + end) / 2;

        while (end - start >= 2 * accuracy) {
            double parabolicExtremum = findParabolicExtremum(start, end, aver, function);

            if (parabolicExtremum >= aver) {
                start = aver;
            } else {
                end = aver;
            }

            aver = parabolicExtremum;
        }

        if (function.value(aver) < function.value(start)) {
            return TwoDimensionalExtremumPoint.of(aver, function.value(aver), ExtremumType.MIN);
        } else {
            return TwoDimensionalExtremumPoint.of(aver, function.value(aver), ExtremumType.MAX);
        }
    }

    private static double findParabolicExtremum(double aPoint, double bPoint, double averPoint,
                                                UnivariateDifferentiableFunction function) {
        double fA = function.value(aPoint);
        double fAver = function.value(averPoint);
        double fB = function.value(bPoint);

        double coefA = fA * (averPoint - bPoint)
                + fAver * (bPoint - aPoint)
                + fB * (aPoint - averPoint);

        double coefB = - 1 * (fA * (averPoint*averPoint - bPoint*bPoint)
                + fAver * (bPoint*bPoint - aPoint*aPoint)
                + fB * (aPoint*aPoint - averPoint*averPoint));

        return -1 * coefB / (2 * coefA);
    }
}
