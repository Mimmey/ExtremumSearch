package methods;

import methods.utils.points.extremum_points.TwoDimensionalExtremumPoint;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

import java.util.Optional;

public abstract class UnivariativeExtremumSearchMethod {

    public abstract Optional<TwoDimensionalExtremumPoint> findMinPoint(UnivariateDifferentiableFunction function,
                                                                               double accuracy,
                                                                               double start,
                                                                               double end);

    public abstract Optional<TwoDimensionalExtremumPoint> findMaxPoint(UnivariateDifferentiableFunction function,
                                                                               double accuracy,
                                                                               double start,
                                                                               double end);
}
