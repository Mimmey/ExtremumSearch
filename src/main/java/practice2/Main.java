package practice2;

import methods.gradient_descent.GradientDescentMethod;
import methods.util.points.extremum_points.FourDimensionalExtremumPoint;
import methods.util.points.ThreeDimensionalPoint;
import methods.functions.TernaryDifferentiableFunction;

public class Main {
    public static void main(String[] args) {
        TernaryDifferentiableFunction function = new MyFunction();

        final double accuracy = 0.05;
        final double step = 0.05;
        final ThreeDimensionalPoint startPoint = new ThreeDimensionalPoint(0, 0, 0);

        GradientDescentMethod gradientDescent = new GradientDescentMethod();

        FourDimensionalExtremumPoint extremumPoint = gradientDescent.findExtremumPoint(function, accuracy, startPoint, step);

        System.out.println("Gradient Descent: " +  extremumPoint);
    }
}
