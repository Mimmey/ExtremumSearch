package methods.non_derivative.half_division;

import methods.non_derivative.NonDerivativeExtremumSearchMethod;
import org.apache.commons.math3.analysis.UnivariateFunction;

public class HalfDivisionMethod implements NonDerivativeExtremumSearchMethod {

    @Override
    public double findMinExtremumPoint(UnivariateFunction function, double accuracy, double start, double end) {
        while (end - start >= 2 * accuracy) {
            double x1 = (start + end - accuracy) / 2;
            double x2 = (start + end + accuracy) / 2;
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
}
