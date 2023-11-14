package mod.azure.azurelibarmor.core.math.functions.classic;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.Function;

public class Pi extends Function {
	public Pi(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public double get() {
		return Math.PI;
	}
}
