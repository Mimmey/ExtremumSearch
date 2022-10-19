package methods.gradient_descent;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import practice2.ThreeDimensionalPoint;
import practice2.interfaces.TernarvariateDifferentiableFunction;

public class GradientDescentMethodImpl implements GradientDescentMethod {

    @Override
    public ThreeDimensionalPoint findExtremumPoint(TernarvariateDifferentiableFunction function, double accuracy, ThreeDimensionalPoint startPoint, double step) {
        double currentAccuracy = Integer.MAX_VALUE;
        ThreeDimensionalPoint oldPoint = startPoint;
        ThreeDimensionalPoint newPoint = new ThreeDimensionalPoint();

        while (currentAccuracy > accuracy) {
            ThreeDimensionalPoint gradient = new ThreeDimensionalPoint();
            DerivativeStructure functionInDerivativeView = function.value(
                    new DerivativeStructure(3, 1, 0, oldPoint.getX1()),
                    new DerivativeStructure(3, 1, 1, oldPoint.getX2()),
                    new DerivativeStructure(3, 1, 2, oldPoint.getX3())
            );

            gradient.setX1(functionInDerivativeView.getPartialDerivative(1, 0, 0));
            gradient.setX2(functionInDerivativeView.getPartialDerivative(0, 1, 0));
            gradient.setX3(functionInDerivativeView.getPartialDerivative(0, 0, 1));

            newPoint = new ThreeDimensionalPoint();

            newPoint.setX1(oldPoint.getX1() + step * gradient.getX1());
            newPoint.setX2(oldPoint.getX2() + step * gradient.getX2());
            newPoint.setX3(oldPoint.getX3() + step * gradient.getX3());

            double newAccuracy = Math.abs(function.value(newPoint) - function.value(oldPoint));

            if (newAccuracy >= currentAccuracy) {
                throw new IllegalArgumentException("Выбран слишком большой шаг");
            }

            currentAccuracy = newAccuracy;
            oldPoint = newPoint;
        }

        return newPoint;
    }
}
