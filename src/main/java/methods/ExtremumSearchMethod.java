package methods;

import org.apache.commons.math3.analysis.UnivariateFunction;

public interface ExtremumSearchMethod <T extends UnivariateFunction> {
    double findMinExtremumPoint(T function, double accuracy, double start, double end);

    default double findMinExtremum(T function, double extremumPoint) {
        return function.value(extremumPoint);
    }
}
