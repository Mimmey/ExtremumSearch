package methods.gradient_descent;

import methods.TernaryExtremumSearchMethod;
import methods.util.points.extremum_points.FourDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import methods.util.points.ThreeDimensionalPoint;
import methods.functions.TernaryDifferentiableFunction;

public class GradientDescentMethod extends TernaryExtremumSearchMethod {

    @Override
    public FourDimensionalExtremumPoint findExtremumPoint(TernaryDifferentiableFunction function, double accuracy, ThreeDimensionalPoint startPoint, double step) {
        double currentAccuracy = Integer.MAX_VALUE;
        ThreeDimensionalPoint oldPoint = startPoint;
        ThreeDimensionalPoint newPoint = new ThreeDimensionalPoint();

        while (currentAccuracy > accuracy) {
            ThreeDimensionalPoint gradient = new ThreeDimensionalPoint();
            DerivativeStructure functionInDerivativeView = function.value(
                    new DerivativeStructure(3, 1, 0, oldPoint.getX()),
                    new DerivativeStructure(3, 1, 1, oldPoint.getY()),
                    new DerivativeStructure(3, 1, 2, oldPoint.getZ())
            );

            gradient.setX(functionInDerivativeView.getPartialDerivative(1, 0, 0));
            gradient.setY(functionInDerivativeView.getPartialDerivative(0, 1, 0));
            gradient.setZ(functionInDerivativeView.getPartialDerivative(0, 0, 1));

            newPoint = new ThreeDimensionalPoint();

            newPoint.setX(oldPoint.getX() + step * gradient.getX());
            newPoint.setY(oldPoint.getY() + step * gradient.getY());
            newPoint.setZ(oldPoint.getZ() + step * gradient.getZ());

            double newAccuracy = Math.abs(function.value(newPoint) - function.value(oldPoint));

            if (newAccuracy >= currentAccuracy) {
                throw new IllegalArgumentException("Выбран слишком большой шаг");
            }

            currentAccuracy = newAccuracy;
            oldPoint = newPoint;
        }

        return FourDimensionalExtremumPoint.of(
                newPoint.getX(),
                newPoint.getY(),
                newPoint.getZ(),
                function.value(newPoint),
                findExtremumType(function, startPoint));
    }
}
