package methods;

import methods.utils.ExtremumType;
import methods.utils.points.extremum_points.FourDimensionalExtremumPoint;
import methods.utils.points.extremum_points.TwoDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import methods.utils.points.ThreeDimensionalPoint;
import methods.functions.TernaryDifferentiableFunction;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

import java.util.Optional;

public abstract class TernaryExtremumSearchMethod {

    public abstract Optional<FourDimensionalExtremumPoint> findMinExtremumPoint(TernaryDifferentiableFunction function,
                                                                                double accuracy,
                                                                                ThreeDimensionalPoint startPoint);

    public abstract Optional<FourDimensionalExtremumPoint> findMaxExtremumPoint(TernaryDifferentiableFunction function,
                                                                                double accuracy,
                                                                                ThreeDimensionalPoint startPoint);
}
