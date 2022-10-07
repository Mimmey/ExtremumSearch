package methods.derivative;

import methods.ExtremumSearchMethod;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public interface DerivativeExtremumSearchMethod extends ExtremumSearchMethod<UnivariateDifferentiableFunction> {

    double findExtremumPoint(UnivariateDifferentiableFunction function, double accuracy, double start, double end);

    default double findExtremum(UnivariateDifferentiableFunction function, double accuracy, double start, double end) {
        return function.value(findExtremumPoint(function, accuracy, start, end));
    }
}
