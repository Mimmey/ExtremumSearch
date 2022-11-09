package practice2;

import methods.gradient_descent.GradientDescentMethod;
import methods.utils.points.extremum_points.FourDimensionalExtremumPoint;
import methods.utils.points.ThreeDimensionalPoint;
import methods.functions.TernaryDifferentiableFunction;

public class Main {
    public static void main(String[] args) {
        TernaryDifferentiableFunction function = new MyFunction();

        final double accuracy = 0.005;
        final ThreeDimensionalPoint startPoint = new ThreeDimensionalPoint(0, 0, 0);

        GradientDescentMethod gradientDescent = new GradientDescentMethod();

        FourDimensionalExtremumPoint extremumPoint =
                gradientDescent.findExtremumPoint(function, accuracy, startPoint);

        System.out.println("Gradient Descent: " +  extremumPoint);
    }
}
