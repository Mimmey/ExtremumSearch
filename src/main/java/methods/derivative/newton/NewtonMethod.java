package methods.derivative.newton;

import methods.derivative.DerivativeExtremumSearchMethod;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

import static java.lang.Math.abs;

public class NewtonMethod implements DerivativeExtremumSearchMethod {

    @Override
    public double findExtremumPoint(UnivariateDifferentiableFunction function, double accuracy, double start, double end) {
        double xk = start;
        double derivativeInXk = function.value(new DerivativeStructure(1, 1, 0, xk)).getPartialDerivative(1);

        while (abs(derivativeInXk) >= accuracy) {
            xk = findXk(function, xk);
            derivativeInXk = function.value(new DerivativeStructure(1, 1, 0, xk)).getPartialDerivative(1);
        }

        return xk;
    }

    private double findXk(UnivariateDifferentiableFunction function, double xkPrev) {
        double firstDerivative = function.value(new DerivativeStructure(1, 1, 0, xkPrev)).getPartialDerivative(1);
        double secondDerivative = function.value(new DerivativeStructure(1, 2, 0, xkPrev)).getPartialDerivative(2);

        return xkPrev - firstDerivative / secondDerivative;
    }
}
