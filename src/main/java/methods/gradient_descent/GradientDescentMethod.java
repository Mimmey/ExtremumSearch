package methods.gradient_descent;

import methods.TernaryExtremumSearchMethod;
import methods.UnivariateExtremumSearchMethod;
import methods.numerical_optimization.chords.ChordsMethod;
import methods.numerical_optimization.golden_ratio.GoldenRatioMethod;
import methods.numerical_optimization.half_division.HalfDivisionMethod;
import methods.numerical_optimization.newton.NewtonMethod;
import methods.utils.points.extremum_points.FourDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import methods.utils.points.ThreeDimensionalPoint;
import methods.functions.TernaryDifferentiableFunction;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GradientDescentMethod extends TernaryExtremumSearchMethod {

    @Override
    public FourDimensionalExtremumPoint findExtremumPoint(TernaryDifferentiableFunction function, double accuracy, ThreeDimensionalPoint startPoint) {
        double currentAccuracy = Integer.MAX_VALUE;
        ThreeDimensionalPoint oldPoint = startPoint;
        ThreeDimensionalPoint newPoint = new ThreeDimensionalPoint();

        while (currentAccuracy > accuracy) {
            ThreeDimensionalPoint gradient = new ThreeDimensionalPoint();
            DerivativeStructure functionInDerivativeView = function.value(
                    new DerivativeStructure(3, 1, 0, oldPoint.getX()),
                    new DerivativeStructure(3, 1, 1, oldPoint.getY()),
                    new DerivativeStructure(3, 1, 2, oldPoint.getZ())
            );

            gradient.setX(functionInDerivativeView.getPartialDerivative(1, 0, 0));
            gradient.setY(functionInDerivativeView.getPartialDerivative(0, 1, 0));
            gradient.setZ(functionInDerivativeView.getPartialDerivative(0, 0, 1));

            newPoint = new ThreeDimensionalPoint();

            double step = findStep(function, oldPoint, gradient);
            System.out.println("Lambda: " + step);

            newPoint.setX(oldPoint.getX() - step * gradient.getX());
            newPoint.setY(oldPoint.getY() - step * gradient.getY());
            newPoint.setZ(oldPoint.getZ() - step * gradient.getZ());

            currentAccuracy = Math.abs(function.value(newPoint) - function.value(oldPoint));
            oldPoint = newPoint;
        }

        return FourDimensionalExtremumPoint.of(
                newPoint.getX(),
                newPoint.getY(),
                newPoint.getZ(),
                function.value(newPoint),
                findExtremumType(function, startPoint));
    }

    private double findStep(TernaryDifferentiableFunction function,
                            ThreeDimensionalPoint point,
                            ThreeDimensionalPoint gradient) {

        UnivariateDifferentiableFunction stepOptimizationFunction =
                tryFindStepOptimizationFunction(function, point, gradient);

        UnivariateExtremumSearchMethod optimizationMethod = new GoldenRatioMethod();

        return optimizationMethod.findExtremumPoint(
                stepOptimizationFunction, 0.00001, 0, 0.01
        ).getX();
    }

    private UnivariateDifferentiableFunction tryFindStepOptimizationFunction(TernaryDifferentiableFunction function,
                                                                             ThreeDimensionalPoint point,
                                                                             ThreeDimensionalPoint gradient) {
        try {
            Class<?> stepOptimizationFunctionClass = FunctionsToOptimizationFunctions
                    .relationMap
                    .get(function.getClass());

            Constructor<?> constructor = stepOptimizationFunctionClass
                    .getConstructor(ThreeDimensionalPoint.class, ThreeDimensionalPoint.class);

            return (UnivariateDifferentiableFunction) constructor.newInstance(point, gradient);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
