package methods.numerical_optimization.chords;

import lombok.AllArgsConstructor;
import methods.UnivariateExtremumSearchMethod;
import methods.util.points.extremum_points.TwoDimensionalExtremumPoint;
import methods.util.ExtremumType;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

import static java.lang.Math.abs;

@AllArgsConstructor
public class ChordsMethod extends UnivariateExtremumSearchMethod {

    @Override
    public TwoDimensionalExtremumPoint findExtremumPoint(UnivariateDifferentiableFunction function, double accuracy, double start, double end) {
        double xk = start;
        double derivativeInXk = function.value(new DerivativeStructure(1, 1, 0, xk)).getPartialDerivative(1);

        while (abs(derivativeInXk) >= accuracy) {
            xk = findXk(function, start, end);

            if (derivativeInXk <= 0) {
                start = xk;
            } else {
                end = xk;
            }

            derivativeInXk = function.value(new DerivativeStructure(1, 1, 0, xk)).getPartialDerivative(1);
        }

        ExtremumType type = findExtremumType(function, xk);
        return TwoDimensionalExtremumPoint.of(xk, function.value(xk), type);
    }

    private double findXk(UnivariateDifferentiableFunction function, double start, double end) {
        double derivativeInStart = function.value(new DerivativeStructure(1, 1, 0, start)).getPartialDerivative(1);
        double derivativeInEnd = function.value(new DerivativeStructure(1, 1, 0, end)).getPartialDerivative(1);

        return start
                - derivativeInStart
                / (derivativeInStart - derivativeInEnd)
                * (start - end);
    }
}
