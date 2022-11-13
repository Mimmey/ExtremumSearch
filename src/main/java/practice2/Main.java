package practice2;

import methods.functions.TernaryDifferentiableFunction;
import methods.gradient_descent.GradientDescentMethod;
import methods.utils.ExtremumType;
import methods.utils.points.ThreeDimensionalPoint;
import methods.utils.points.extremum_points.FourDimensionalExtremumPoint;

public class Main {
    public static void main(String[] args) {
        TernaryDifferentiableFunction function = new MyFunction();

        final double accuracy = 0.005;
        final ThreeDimensionalPoint startPoint = new ThreeDimensionalPoint(0, 0, 0);

        GradientDescentMethod gradientDescent = new GradientDescentMethod();

        FourDimensionalExtremumPoint extremumPoint =
                gradientDescent.findMinExtremumPoint(function, accuracy, startPoint)
                        .orElse(FourDimensionalExtremumPoint.of(0, 0, 0, 0, ExtremumType.MIN));

        System.out.println("Gradient Descent: " +  extremumPoint);
    }
}
