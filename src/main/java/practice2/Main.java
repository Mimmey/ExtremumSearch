package practice2;

import methods.gradient_descent.GradientDescentMethodImpl;
import methods.gradient_descent.GradientDescentMethod;
import practice2.interfaces.TernarvariateDifferentiableFunction;

public class Main {
    public static void main(String[] args) {
        TernarvariateDifferentiableFunction function = new MyFunction();

        final double accuracy = 0.05;
        final double step = 0.05;
        final ThreeDimensionalPoint startPoint = new ThreeDimensionalPoint(0, 0, 0);

        GradientDescentMethod gradientDescent = new GradientDescentMethodImpl();

        ThreeDimensionalPoint extremumPoint = gradientDescent.findExtremumPoint(function, accuracy, startPoint, step);
        double extremum = gradientDescent.findExtremum(function, accuracy, startPoint, step);

        System.out.printf("Gradient Descent: x = %s; y = %s\n", extremumPoint, extremum);
    }
}
