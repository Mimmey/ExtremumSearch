package methods.functions;

import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.exception.DimensionMismatchException;

public interface TernaryDifferentiableFunction extends TernaryFunction {
    DerivativeStructure value(DerivativeStructure var1, DerivativeStructure var2, DerivativeStructure var3) throws DimensionMismatchException;
}
