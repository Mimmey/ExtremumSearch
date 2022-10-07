package methods.non_derivative;

import methods.ExtremumSearchMethod;
import org.apache.commons.math3.analysis.UnivariateFunction;

public interface NonDerivativeExtremumSearchMethod extends ExtremumSearchMethod<UnivariateFunction> {

    double findMinExtremumPoint(UnivariateFunction function, double accuracy, double start, double end);

    default double findMinExtremum(UnivariateFunction function, double accuracy, double start, double end) {
        return function.value(findMinExtremumPoint(function, accuracy, start, end));
    }

    double findMaxExtremumPoint(UnivariateFunction function, double accuracy, double start, double end);

    default double findMaxExtremum(UnivariateFunction function, double accuracy, double start, double end) {
        return function.value(findMaxExtremumPoint(function, accuracy, start, end));
    }
}
