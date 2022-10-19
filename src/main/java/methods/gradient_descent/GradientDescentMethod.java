package methods.gradient_descent;

import methods.TernarvariateExtremumSearchMethod;
import practice2.ThreeDimensionalPoint;
import practice2.interfaces.TernarvariateDifferentiableFunction;

public interface GradientDescentMethod extends TernarvariateExtremumSearchMethod<TernarvariateDifferentiableFunction> {

    ThreeDimensionalPoint findExtremumPoint(TernarvariateDifferentiableFunction function, double accuracy, ThreeDimensionalPoint startPoint, double step);

    default double findExtremum(TernarvariateDifferentiableFunction function, double accuracy, ThreeDimensionalPoint startPoint, double step) {
        ThreeDimensionalPoint extremumPoint = findExtremumPoint(function, accuracy, startPoint, step);

        return function.value(extremumPoint);
    }
}
