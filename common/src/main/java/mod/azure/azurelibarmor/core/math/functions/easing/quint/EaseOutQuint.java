package mod.azure.azurelibarmor.core.math.functions.easing.quint;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.easing.EasingFunction;

public class EaseOutQuint extends EasingFunction {

    public EaseOutQuint(IValue[] values, String name) throws Exception {
        super(values, name);
    }

    @Override
    protected double ease(double t) {
        return 1 - Math.pow(1 - t, 5);
    }
}
