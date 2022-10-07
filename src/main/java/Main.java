import methods.MyFunction;
import methods.derivative.DerivativeExtremumSearchMethod;
import methods.derivative.chords.ChordsMethod;
import methods.derivative.newton.NewtonMethod;
import methods.non_derivative.NonDerivativeExtremumSearchMethod;
import methods.non_derivative.golden_ratio.GoldenRatioMethod;
import methods.non_derivative.half_division.HalfDivisionMethod;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class Main {
    public static void main(String[] args) {
        UnivariateDifferentiableFunction function = new MyFunction();

        final double a = 3.0;
        final double b = 3.5;
        final double accuracy = 0.02;

        NonDerivativeExtremumSearchMethod halfDivisionMethod = new HalfDivisionMethod();
        NonDerivativeExtremumSearchMethod goldenRatioMethod = new GoldenRatioMethod();
        DerivativeExtremumSearchMethod chordsMethod = new ChordsMethod();
        DerivativeExtremumSearchMethod newtonMethod = new NewtonMethod();

        double halfDivisionMinPoint = halfDivisionMethod.findMinExtremumPoint(function, accuracy, a, b);
        double goldenRatioMinPoint = goldenRatioMethod.findMinExtremumPoint(function, accuracy, a, b);
        double chordsMinPoint = chordsMethod.findExtremumPoint(function, accuracy, a, b);
        double newtonMinPoint = newtonMethod.findExtremumPoint(function, accuracy, a, b);

        double halfDivisionMin = halfDivisionMethod.findMinExtremum(function, accuracy, a, b);
        double goldenRatioMin = goldenRatioMethod.findMinExtremum(function, accuracy, a, b);
        double chordsMin = chordsMethod.findExtremum(function, accuracy, a, b);
        double newtonMin = newtonMethod.findExtremum(function, accuracy, a, b);

        System.out.printf("Half division: (%f; %f)\n", halfDivisionMinPoint, halfDivisionMin);
        System.out.printf("Golden ratio: (%f; %f)\n", goldenRatioMinPoint, goldenRatioMin);
        System.out.printf("Chords: (%f; %f)\n", chordsMinPoint, chordsMin);
        System.out.printf("Newton: (%f; %f)\n", newtonMinPoint, newtonMin);
    }
}
