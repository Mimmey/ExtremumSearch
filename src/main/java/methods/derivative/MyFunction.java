package methods.derivative;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class MyFunction implements UnivariateDifferentiableFunction {

    @Override
    public double value(double x) {
        return value(new DerivativeStructure(1, 1, x)).getValue();
    }

    @Override
    public DerivativeStructure value(DerivativeStructure t) {
        DerivativeStructure firstComponent = t.pow(2).multiply(5);
        DerivativeStructure secondComponent = t.pow(5.0 / 4).multiply(-8);
        DerivativeStructure thirdComponent = t.multiply(-20);

        return firstComponent.add(secondComponent).add(thirdComponent);
    }
}