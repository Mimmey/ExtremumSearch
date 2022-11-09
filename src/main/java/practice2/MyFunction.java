package practice2;

import methods.util.points.ThreeDimensionalPoint;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import methods.util.interfaces.TernarvariateDifferentiableFunction;

public class MyFunction implements TernarvariateDifferentiableFunction {

    @Override
    public double value(ThreeDimensionalPoint point) {
        return value(new DerivativeStructure(3, 1, 0, point.getX()),
                new DerivativeStructure(3, 1, 1, point.getY()),
                new DerivativeStructure(3, 1, 2, point.getZ())).getValue();
    }

    @Override
    public DerivativeStructure value(DerivativeStructure x1, DerivativeStructure x2, DerivativeStructure x3) {
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