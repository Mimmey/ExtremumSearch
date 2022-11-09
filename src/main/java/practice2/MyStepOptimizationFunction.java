package practice2;

import lombok.AllArgsConstructor;
import methods.utils.points.ThreeDimensionalPoint;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

@AllArgsConstructor
public class MyStepOptimizationFunction implements UnivariateDifferentiableFunction {

    ThreeDimensionalPoint point;
    ThreeDimensionalPoint gradient;

    @Override
    public double value(double lambda) {
        return value(new DerivativeStructure(1, 1, 0, lambda)).getValue();
    }

    @Override
    public DerivativeStructure value(DerivativeStructure t) {
        DerivativeStructure x1 = t.multiply(gradient.getX()).multiply(-1).add(point.getX());
        DerivativeStructure x2 = t.multiply(gradient.getY()).multiply(-1).add(point.getY());
        DerivativeStructure x3 = t.multiply(gradient.getZ()).multiply(-1).add(point.getZ());

        DerivativeStructure firstComponent = x1.pow(2).multiply(2);
        DerivativeStructure secondComponent = x2.pow(3);
        DerivativeStructure thirdComponent = x3.pow(2);
        DerivativeStructure fourthComponent = x1.multiply(x2).multiply(-1);
        DerivativeStructure fifthComponent = x1.multiply(x3).multiply(2);
        DerivativeStructure sixthComponent = x2.multiply(-1);


        return firstComponent.add(secondComponent)
                .add(thirdComponent)
                .add(fourthComponent)
                .add(fifthComponent)
                .add(sixthComponent);
    }
}
