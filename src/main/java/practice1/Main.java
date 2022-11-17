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

    final static double DUMMY = -1000.0;

    public static void main(String[] args) {
        UnivariateDifferentiableFunction function = new MyFunction();

        final double a = 3.0;
        final double b = 3.5;
        final double accuracy = 0.1;

        UnivariativeExtremumSearchMethod halfDivisionMethod = new HalfDivisionMethod();
        UnivariativeExtremumSearchMethod goldenRatioMethod = new GoldenRatioMethod();
        UnivariativeExtremumSearchMethod chordsMethod = new ChordsMethod();
        UnivariativeExtremumSearchMethod newtonMethod = new NewtonMethod();
        UnivariativeExtremumSearchMethod squareInterpolationMethod = new SquareInterpolationMethod();

        TwoDimensionalExtremumPoint halfDivisionExtremumPoint =
                halfDivisionMethod.findMinPoint(function, accuracy, a, b)
                        .orElse(TwoDimensionalExtremumPoint.of(DUMMY, DUMMY, ExtremumType.UNKNOWN));

        TwoDimensionalExtremumPoint goldenRatioExtremumPoint =
                goldenRatioMethod.findMinPoint(function, accuracy, a, b)
                        .orElse(TwoDimensionalExtremumPoint.of(DUMMY, DUMMY, ExtremumType.UNKNOWN));

        TwoDimensionalExtremumPoint chordsExtremumPoint =
                chordsMethod.findMinPoint(function, accuracy, a, b)
                        .orElse(TwoDimensionalExtremumPoint.of(DUMMY, DUMMY, ExtremumType.UNKNOWN));

        TwoDimensionalExtremumPoint newtonExtremumPoint =
                newtonMethod.findMinPoint(function, accuracy, a, b)
                        .orElse(TwoDimensionalExtremumPoint.of(DUMMY, DUMMY, ExtremumType.UNKNOWN));

        TwoDimensionalExtremumPoint squareInterpolationExtremumPoint =
                squareInterpolationMethod.findMinPoint(function, accuracy, a, b)
                        .orElse(TwoDimensionalExtremumPoint.of(DUMMY, DUMMY, ExtremumType.UNKNOWN));

        System.out.println("Half division: " + halfDivisionExtremumPoint.toString());
        System.out.println("Golden ratio: " + goldenRatioExtremumPoint.toString());
        System.out.println("Chords: " + chordsExtremumPoint.toString());
        System.out.println("Newton: " + newtonExtremumPoint.toString());
        System.out.println("Square interpolation: " + squareInterpolationExtremumPoint.toString());
    }
}
