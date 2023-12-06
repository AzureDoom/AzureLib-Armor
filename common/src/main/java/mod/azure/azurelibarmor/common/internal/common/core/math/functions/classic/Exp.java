package mod.azure.azurelibarmor.common.internal.common.core.math.functions.classic;

import mod.azure.azurelibarmor.common.internal.common.core.math.IValue;
import mod.azure.azurelibarmor.common.internal.common.core.math.functions.Function;

public class Exp extends Function {
	public Exp(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public int getRequiredArguments() {
		return 1;
	}

	@Override
	public double get() {
		return Math.exp(this.getArg(0));
	}
}
