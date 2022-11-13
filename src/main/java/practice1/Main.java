package practice1;

import methods.UnivariativeExtremumSearchMethod;
import methods.numerical_optimization.chords.ChordsMethod;
import methods.numerical_optimization.newton.NewtonMethod;
import methods.numerical_optimization.golden_ratio.GoldenRatioMethod;
import methods.numerical_optimization.half_division.HalfDivisionMethod;
import methods.numerical_optimization.square_interpolation.SquareInterpolationMethod;
import methods.utils.ExtremumType;
import methods.utils.points.extremum_points.TwoDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class Main {
    public static void main(String[] args) {
        UnivariateDifferentiableFunction function = new MyFunction();

        final double dummyNoPointPresent = -1000;
        final double a = 3.0;
        final double b = 3.5;
        final double accuracy = 0.1;

        UnivariativeExtremumSearchMethod halfDivisionMethod = new HalfDivisionMethod();
        UnivariativeExtremumSearchMethod goldenRatioMethod = new GoldenRatioMethod();
        UnivariativeExtremumSearchMethod chordsMethod = new ChordsMethod();
        UnivariativeExtremumSearchMethod newtonMethod = new NewtonMethod();
        UnivariativeExtremumSearchMethod squareInterpolationMethod = new SquareInterpolationMethod();

        TwoDimensionalExtremumPoint halfDivisionExtremumPoint =
                halfDivisionMethod.findMinExtremumPoint(function, accuracy, a, b)
                        .orElse(TwoDimensionalExtremumPoint.of(dummyNoPointPresent, dummyNoPointPresent, ExtremumType.UNKNOWN));

        TwoDimensionalExtremumPoint goldenRatioExtremumPoint =
                goldenRatioMethod.findMinExtremumPoint(function, accuracy, a, b)
                        .orElse(TwoDimensionalExtremumPoint.of(dummyNoPointPresent, dummyNoPointPresent, ExtremumType.UNKNOWN));

        TwoDimensionalExtremumPoint chordsExtremumPoint =
                chordsMethod.findMinExtremumPoint(function, accuracy, a, b)
                        .orElse(TwoDimensionalExtremumPoint.of(dummyNoPointPresent, dummyNoPointPresent, ExtremumType.UNKNOWN));

        TwoDimensionalExtremumPoint newtonExtremumPoint =
                newtonMethod.findMinExtremumPoint(function, accuracy, a, b)
                        .orElse(TwoDimensionalExtremumPoint.of(dummyNoPointPresent, dummyNoPointPresent, ExtremumType.UNKNOWN));

        TwoDimensionalExtremumPoint squareInterpolationExtremumPoint =
                squareInterpolationMethod.findMinExtremumPoint(function, accuracy, a, b)
                        .orElse(TwoDimensionalExtremumPoint.of(dummyNoPointPresent, dummyNoPointPresent, ExtremumType.UNKNOWN));

        System.out.println("Half division: " + halfDivisionExtremumPoint.toString());
        System.out.println("Golden ratio: " + goldenRatioExtremumPoint.toString());
        System.out.println("Chords: " + chordsExtremumPoint.toString());
        System.out.println("Newton: " + newtonExtremumPoint.toString());
        System.out.println("Square interpolation: " + squareInterpolationExtremumPoint.toString());
    }
}
