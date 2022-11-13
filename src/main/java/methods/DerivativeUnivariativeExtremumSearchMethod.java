package methods;

import methods.utils.ExtremumType;
import methods.utils.points.extremum_points.TwoDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

import java.util.Optional;

public abstract class DerivativeUnivariativeExtremumSearchMethod extends UnivariativeExtremumSearchMethod {

    @Override
    public Optional<TwoDimensionalExtremumPoint> findMinExtremumPoint(UnivariateDifferentiableFunction function,
                                                                      double accuracy,
                                                                      double start,
                                                                      double end) {
        TwoDimensionalExtremumPoint extremumPoint = findExtremumPoint(function, accuracy, start, end);

        if (extremumPoint.getType().equals(ExtremumType.MIN)) {
            return Optional.of(extremumPoint);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<TwoDimensionalExtremumPoint> findMaxExtremumPoint(UnivariateDifferentiableFunction function,
                                                                      double accuracy,
                                                                      double start,
                                                                      double end) {
        TwoDimensionalExtremumPoint extremumPoint = findExtremumPoint(function, accuracy, start, end);

        if (extremumPoint.getType().equals(ExtremumType.MAX)) {
            return Optional.of(extremumPoint);
        } else {
            return Optional.empty();
        }
    }

    protected abstract TwoDimensionalExtremumPoint findExtremumPoint(UnivariateDifferentiableFunction function,
                                                                  double accuracy,
                                                                  double start,
                                                                  double end);

    protected ExtremumType findExtremumType(UnivariateDifferentiableFunction function, double x) {
        double secondDerivative = function.value(
                new DerivativeStructure(1, 2, 0, x)
        ).getPartialDerivative(2);

        if (secondDerivative > 0) {
            return ExtremumType.MIN;
        } else if (secondDerivative < 0) {
            return ExtremumType.MAX;
        } else {
            return ExtremumType.UNKNOWN;
        }
    }
}
