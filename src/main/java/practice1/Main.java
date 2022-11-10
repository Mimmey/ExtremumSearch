package practice1;

import methods.UnivariativeExtremumSearchMethod;
import methods.numerical_optimization.chords.ChordsMethod;
import methods.numerical_optimization.newton.NewtonMethod;
import methods.numerical_optimization.golden_ratio.GoldenRatioMethod;
import methods.numerical_optimization.half_division.HalfDivisionMethod;
import methods.utils.points.extremum_points.TwoDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class Main {
    public static void main(String[] args) {
        UnivariateDifferentiableFunction function = new MyFunction();

        final double a = 3.0;
        final double b = 3.5;
        final double accuracy = 0.02;

        UnivariativeExtremumSearchMethod halfDivisionMethod = new HalfDivisionMethod();
        UnivariativeExtremumSearchMethod goldenRatioMethod = new GoldenRatioMethod();
        UnivariativeExtremumSearchMethod chordsMethod = new ChordsMethod();
        UnivariativeExtremumSearchMethod newtonMethod = new NewtonMethod();

        TwoDimensionalExtremumPoint halfDivisionExtremumPoint =
                halfDivisionMethod.findExtremumPoint(function, accuracy, a, b);

        TwoDimensionalExtremumPoint goldenRatioExtremumPoint =
                goldenRatioMethod.findExtremumPoint(function, accuracy, a, b);

        TwoDimensionalExtremumPoint chordsExtremumPoint =
                chordsMethod.findExtremumPoint(function, accuracy, a, b);

        TwoDimensionalExtremumPoint newtonExtremumPoint =
                newtonMethod.findExtremumPoint(function, accuracy, a, b);

        System.out.println("Half division: " + halfDivisionExtremumPoint.toString());
        System.out.println("Golden ratio: " + goldenRatioExtremumPoint.toString());
        System.out.println("Chords: " + chordsExtremumPoint.toString());
        System.out.println("Newton: " + newtonExtremumPoint.toString());
    }
}
