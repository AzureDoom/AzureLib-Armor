package mod.azure.azurelibarmor.core.math.functions.easing.expo;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.easing.EasingFunction;

public class EaseInExpo extends EasingFunction {

    public EaseInExpo(IValue[] values, String name) throws Exception {
        super(values, name);
    }

    @Override
    protected double ease(double t) {
        return t == 0 ? 0 : Math.pow(2, 10 * (t - 1));
    }
}
