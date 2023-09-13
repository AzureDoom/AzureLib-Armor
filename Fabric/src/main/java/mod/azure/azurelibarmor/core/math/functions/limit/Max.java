package mod.azure.azurelibarmor.core.math.functions.limit;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.Function;

public class Max extends Function {
	public Max(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public int getRequiredArguments() {
		return 2;
	}

	@Override
	public double get() {
		return Math.max(this.getArg(0), this.getArg(1));
	}
}
