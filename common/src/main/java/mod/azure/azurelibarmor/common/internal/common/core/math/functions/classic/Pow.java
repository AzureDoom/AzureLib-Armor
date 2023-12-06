package mod.azure.azurelibarmor.common.internal.common.core.math.functions.classic;

import mod.azure.azurelibarmor.common.internal.common.core.math.IValue;
import mod.azure.azurelibarmor.common.internal.common.core.math.functions.Function;

public class Pow extends Function {
	public Pow(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public int getRequiredArguments() {
		return 2;
	}

	@Override
	public double get() {
		return Math.pow(this.getArg(0), this.getArg(1));
	}
}
