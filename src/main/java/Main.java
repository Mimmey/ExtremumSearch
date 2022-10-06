import methods.ExtremumSearchMethod;
import methods.derivative.MyFunction;
import methods.derivative.chords.ChordsMethod;
import methods.derivative.newton.NewtonMethod;
import methods.non_derivative.golden_ratio.GoldenRatioMethod;
import methods.non_derivative.half_division.HalfDivisionMethod;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class Main {
    public static void main(String[] args) {
        UnivariateDifferentiableFunction function = new MyFunction();

        final double a = 3.0;
        final double b = 3.5;
        final double accuracy = 0.02;

        ExtremumSearchMethod halfDivisionMethod = new HalfDivisionMethod();
        ExtremumSearchMethod goldenRatioMethod = new GoldenRatioMethod();
        ExtremumSearchMethod chordsMethod = new ChordsMethod();
        ExtremumSearchMethod newtonMethod = new NewtonMethod();

        double halfDivisionMinPoint = halfDivisionMethod.findMinExtremumPoint(function, accuracy, a, b);
        double goldenRatioMinPoint = goldenRatioMethod.findMinExtremumPoint(function, accuracy, a, b);
        double chordsMinPoint = chordsMethod.findMinExtremumPoint(function, accuracy, a, b);
        double newtonMinPoint = newtonMethod.findMinExtremumPoint(function, accuracy, a, b);

        double halfDivisionMin = halfDivisionMethod.findMinExtremum(function, halfDivisionMinPoint);
        double goldenRatioMin = goldenRatioMethod.findMinExtremum(function, goldenRatioMinPoint);
        double chordsMin = chordsMethod.findMinExtremum(function, chordsMinPoint);
        double newtonMin = newtonMethod.findMinExtremum(function, newtonMinPoint);

        System.out.printf("Half division: (%f; %f)\n", halfDivisionMinPoint, halfDivisionMin);
        System.out.printf("Golden ratio: (%f; %f)\n", goldenRatioMinPoint, goldenRatioMin);
        System.out.printf("Chords: (%f; %f)\n", chordsMinPoint, chordsMin);
        System.out.printf("Newton: (%f; %f)\n", newtonMinPoint, newtonMin);
    }
}
