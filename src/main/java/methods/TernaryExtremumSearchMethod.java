package methods;

import methods.utils.ExtremumType;
import methods.utils.points.extremum_points.FourDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import methods.utils.points.ThreeDimensionalPoint;
import methods.functions.TernaryDifferentiableFunction;

public abstract class TernaryExtremumSearchMethod {

    public abstract FourDimensionalExtremumPoint findExtremumPoint(TernaryDifferentiableFunction function,
                                                                   double accuracy,
                                                                   ThreeDimensionalPoint startPoint,
                                                                   double step);

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
