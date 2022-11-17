package methods;

import methods.utils.ExtremumType;
import methods.utils.points.extremum_points.TwoDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

import java.util.Optional;

public abstract class DerivativeUnivariativeExtremumSearchMethod extends UnivariativeExtremumSearchMethod {

    @Override
    public Optional<TwoDimensionalExtremumPoint> findMinPoint(UnivariateDifferentiableFunction function,
                                                                      double accuracy,
                                                                      double start,
                                                                      double end) {
        Optional<TwoDimensionalExtremumPoint> point = findMinExtremumPoint(function, accuracy, start, end);

        if (point.isEmpty()) {
           if (function.value(end) < function.value(start)) {
               return Optional.of(TwoDimensionalExtremumPoint.of(end, function.value(end), ExtremumType.MIN));
           }

           return Optional.of(TwoDimensionalExtremumPoint.of(start, function.value(start), ExtremumType.MIN));
        }

        if (function.value(start) < point.get().getY()) {
            return Optional.of(TwoDimensionalExtremumPoint.of(start, function.value(start), ExtremumType.MIN));
        }

        if (function.value(end) < point.get().getY()) {
            return Optional.of(TwoDimensionalExtremumPoint.of(end, function.value(end), ExtremumType.MIN));
        }

        return point;
    }

    public Optional<TwoDimensionalExtremumPoint> findMinExtremumPoint(UnivariateDifferentiableFunction function,
                                                                      double accuracy,
                                                                      double start,
                                                                      double end) {
        TwoDimensionalExtremumPoint extremumPoint = findExtremumPoint(function, accuracy, start, end);

        if (extremumPoint.getType().equals(ExtremumType.MIN) && extremumPoint.getX() >= start && extremumPoint.getX() <= end) {
            return Optional.of(extremumPoint);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<TwoDimensionalExtremumPoint> findMaxPoint(UnivariateDifferentiableFunction function,
                                                              double accuracy,
                                                              double start,
                                                              double end) {
        Optional<TwoDimensionalExtremumPoint> point = findMaxExtremumPoint(function, accuracy, start, end);

        if (point.isEmpty()) {
            if (function.value(start) < function.value(end)) {
                return Optional.of(TwoDimensionalExtremumPoint.of(end, function.value(end), ExtremumType.MAX));
            }

            return Optional.of(TwoDimensionalExtremumPoint.of(start, function.value(start), ExtremumType.MAX));
        }

        if (function.value(start) > point.get().getY()) {
            return Optional.of(TwoDimensionalExtremumPoint.of(start, function.value(start), ExtremumType.MAX));
        }

        if (function.value(end) > point.get().getY()) {
            return Optional.of(TwoDimensionalExtremumPoint.of(end, function.value(end), ExtremumType.MAX));
        }

        return point;
    }

    public Optional<TwoDimensionalExtremumPoint> findMaxExtremumPoint(UnivariateDifferentiableFunction function,
                                                                      double accuracy,
                                                                      double start,
                                                                      double end) {
        TwoDimensionalExtremumPoint extremumPoint = findExtremumPoint(function, accuracy, start, end);

        if (extremumPoint.getType().equals(ExtremumType.MAX) && extremumPoint.getX() >= start && extremumPoint.getX() <= end) {
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
