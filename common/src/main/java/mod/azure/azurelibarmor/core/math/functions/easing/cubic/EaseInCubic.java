package mod.azure.azurelibarmor.core.math.functions.easing.cubic;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.easing.EasingFunction;

public class EaseInCubic extends EasingFunction {

    public EaseInCubic(IValue[] values, String name) throws Exception {
        super(values, name);
    }

    @Override
    protected double ease(double t) {
        return t * t * t;
    }
}
