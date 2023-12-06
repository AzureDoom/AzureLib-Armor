package mod.azure.azurelibarmor.common.internal.common.core.math.functions.classic;

import mod.azure.azurelibarmor.common.internal.common.core.math.IValue;
import mod.azure.azurelibarmor.common.internal.common.core.math.functions.Function;

public class Pi extends Function {
	public Pi(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public double get() {
		return Math.PI;
	}
}
