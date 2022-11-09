package methods;

import methods.util.points.extremum_points.TwoDimensionalExtremumPoint;
import methods.util.ExtremumType;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public abstract class UnivariateExtremumSearchMethod {

    public abstract TwoDimensionalExtremumPoint findExtremumPoint(UnivariateDifferentiableFunction function, double accuracy, double start, double end);

    protected ExtremumType findExtremumType(UnivariateDifferentiableFunction function, double x) {
        double secondDerivative = function.value(new DerivativeStructure(1, 2, 0, x)).getPartialDerivative(2);
        return secondDerivative > 0 ? ExtremumType.MIN : ExtremumType.MAX;
    }
}
