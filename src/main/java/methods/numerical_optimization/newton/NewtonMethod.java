package methods.numerical_optimization.newton;

import methods.UnivariateExtremumSearchMethod;
import methods.utils.points.extremum_points.TwoDimensionalExtremumPoint;
import methods.utils.ExtremumType;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

import static java.lang.Math.abs;

public class NewtonMethod extends UnivariateExtremumSearchMethod {

    @Override
    public TwoDimensionalExtremumPoint findExtremumPoint(UnivariateDifferentiableFunction function,
                                                         double accuracy,
                                                         double start,
                                                         double end) {
        double xk = start;

        double derivativeInXk = function.value(
                new DerivativeStructure(1, 1, 0, xk)
        ).getPartialDerivative(1);

        while (abs(derivativeInXk) >= accuracy) {
            xk = findXk(function, xk);

            derivativeInXk = function.value(
                    new DerivativeStructure(1, 1, 0, xk)
            ).getPartialDerivative(1);
        }

        ExtremumType type = findExtremumType(function, start);
        return TwoDimensionalExtremumPoint.of(xk, function.value(xk), type);
    }

    private double findXk(UnivariateDifferentiableFunction function, double xkPrev) {
        double firstDerivative = function.value(
                new DerivativeStructure(1, 1, 0, xkPrev)
        ).getPartialDerivative(1);

        double secondDerivative = function.value(
                new DerivativeStructure(1, 2, 0, xkPrev)
        ).getPartialDerivative(2);

        return xkPrev - firstDerivative / secondDerivative;
    }
}
