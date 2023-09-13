package mod.azure.azurelibarmor.core.math.functions.rounding;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.Function;

public class Round extends Function {
	public Round(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public int getRequiredArguments() {
		return 1;
	}

	@Override
	public double get() {
		return Math.round(this.getArg(0));
	}
}
