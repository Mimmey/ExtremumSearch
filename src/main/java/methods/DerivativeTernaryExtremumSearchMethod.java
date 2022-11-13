package methods;

import methods.functions.TernaryDifferentiableFunction;
import methods.utils.ExtremumType;
import methods.utils.points.ThreeDimensionalPoint;
import methods.utils.points.extremum_points.FourDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;

import java.util.Optional;

public abstract class DerivativeTernaryExtremumSearchMethod extends TernaryExtremumSearchMethod {

    @Override
    public Optional<FourDimensionalExtremumPoint> findMinExtremumPoint(TernaryDifferentiableFunction function,
                                                                       double accuracy,
                                                                       ThreeDimensionalPoint startPoint) {
        FourDimensionalExtremumPoint extremumPoint = findExtremumPoint(function, accuracy, startPoint);

        if (extremumPoint.getType().equals(ExtremumType.MIN)) {
            return Optional.of(extremumPoint);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FourDimensionalExtremumPoint> findMaxExtremumPoint(TernaryDifferentiableFunction function,
                                                                       double accuracy,
                                                                       ThreeDimensionalPoint startPoint) {
        FourDimensionalExtremumPoint extremumPoint = findExtremumPoint(function, accuracy, startPoint);

        if (extremumPoint.getType().equals(ExtremumType.MAX)) {
            return Optional.of(extremumPoint);
        } else {
            return Optional.empty();
        }
    }

    public abstract FourDimensionalExtremumPoint findExtremumPoint(TernaryDifferentiableFunction function,
                                                                   double accuracy,
                                                                   ThreeDimensionalPoint startPoint);

    protected ExtremumType findExtremumType(TernaryDifferentiableFunction function,
                                            ThreeDimensionalPoint point) {
        ThreeDimensionalPoint secondGradient = new ThreeDimensionalPoint();

        DerivativeStructure functionInDerivativeView = function.value(
                new DerivativeStructure(3, 2, 0, point.getX()),
                new DerivativeStructure(3, 2, 1, point.getY()),
                new DerivativeStructure(3, 2, 2, point.getZ())
        );

        secondGradient.setX(functionInDerivativeView.getPartialDerivative(2, 0, 0));
        secondGradient.setY(functionInDerivativeView.getPartialDerivative(0, 2, 0));
        secondGradient.setZ(functionInDerivativeView.getPartialDerivative(0, 0, 2));

        double secondGradientValue = secondGradient.getX()
                + secondGradient.getY()
                + secondGradient.getZ();

        if (secondGradientValue > 0) {
            return ExtremumType.MIN;
        } else if (secondGradientValue < 0) {
            return ExtremumType.MAX;
        } else {
            return ExtremumType.UNKNOWN;
        }
    }
}
