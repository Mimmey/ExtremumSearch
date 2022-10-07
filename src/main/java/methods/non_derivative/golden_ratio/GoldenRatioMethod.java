package methods.non_derivative.golden_ratio;

import methods.non_derivative.NonDerivativeExtremumSearchMethod;
import org.apache.commons.math3.analysis.UnivariateFunction;

public class GoldenRatioMethod implements NonDerivativeExtremumSearchMethod {

    @Override
    public double findMinExtremumPoint(UnivariateFunction function, double accuracy, double start, double end) {
        while (end - start >= 2 * accuracy) {
            double x1 = start + 0.382 * (end - start);
            double x2 = start + 0.618 * (end - start);
            double y1 = function.value(x1);
            double y2 = function.value(x2);

            if (y1 > y2) {
                start = x1;
            } else {
                end = x2;
            }
        }

        return (start + end) / 2;
    }

    public double findMaxExtremumPoint(UnivariateFunction function, double accuracy, double start, double end) {
        while (end - start >= 2 * accuracy) {
            double x1 = start + 0.382 * (end - start);
            double x2 = start + 0.618 * (end - start);
            double y1 = function.value(x1);
            double y2 = function.value(x2);

            if (y1 < y2) {
                start = x1;
            } else {
                end = x2;
            }
        }

        return (start + end) / 2;
    }
}
