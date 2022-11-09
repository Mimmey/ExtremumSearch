package methods.gradient_descent;

import practice2.MyFunction;
import practice2.MyStepOptimizationFunction;

import java.util.Map;

public class FunctionsToOptimizationFunctions {
    public static final Map<Class<?>, Class<?>> relationMap = Map.ofEntries(Map.entry(MyFunction.class, MyStepOptimizationFunction.class));
}
