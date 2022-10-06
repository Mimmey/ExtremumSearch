import methods.ExtremumSearchMethod;
import methods.derivative.MyFunction;
import methods.derivative.chords.ChordsMethod;
import methods.derivative.newton.NewtonMethod;
import methods.non_derivative.golden_ratio.GoldenRatioMethod;
import methods.non_derivative.half_division.HalfDivisionMethod;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class Main {
    public static void main(String[] args) {
        UnivariateFunction functionNonDifferentiableView = x -> 5 * Math.pow(x, 2) - 8 * Math.pow(x, 5.0 / 4) - 20 * x;
        UnivariateDifferentiableFunction functionDifferentiableView = new MyFunction();

        double a = 3.0;
        double b = 3.5;
        double accuracy = 0.02;

        ExtremumSearchMethod halfDivisionMethod = new HalfDivisionMethod();
        ExtremumSearchMethod goldenRatioMethod = new GoldenRatioMethod();
        ExtremumSearchMethod chordsMethod = new ChordsMethod();
        ExtremumSearchMethod newtonMethod = new NewtonMethod();

        double halfDivisionMinPoint = halfDivisionMethod.findMinExtremumPoint(functionNonDifferentiableView, accuracy, a, b);
        double goldenRatioMinPoint = goldenRatioMethod.findMinExtremumPoint(functionNonDifferentiableView, accuracy, a, b);
        double chordsMinPoint = chordsMethod.findMinExtremumPoint(functionDifferentiableView, accuracy, a, b);
        double newtonMinPoint = newtonMethod.findMinExtremumPoint(functionDifferentiableView, accuracy, a, b);

        double halfDivisionMin = halfDivisionMethod.findMinExtremum(functionNonDifferentiableView, halfDivisionMinPoint);
        double goldenRatioMin = goldenRatioMethod.findMinExtremum(functionNonDifferentiableView, goldenRatioMinPoint);
        double chordsMin = chordsMethod.findMinExtremum(functionNonDifferentiableView, chordsMinPoint);
        double newtonMin = newtonMethod.findMinExtremum(functionNonDifferentiableView, newtonMinPoint);

        System.out.printf("Half division: (%f; %f)\n", halfDivisionMinPoint, halfDivisionMin);
        System.out.printf("Golden ratio: (%f; %f)\n", goldenRatioMinPoint, goldenRatioMin);
        System.out.printf("Chords: (%f; %f)\n", chordsMinPoint, chordsMin);
        System.out.printf("Newton: (%f; %f)\n", newtonMinPoint, newtonMin);
    }
}
