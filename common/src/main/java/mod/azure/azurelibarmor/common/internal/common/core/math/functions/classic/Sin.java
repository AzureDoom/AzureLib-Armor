package mod.azure.azurelibarmor.common.internal.common.core.math.functions.classic;

import mod.azure.azurelibarmor.common.internal.common.core.math.IValue;
import mod.azure.azurelibarmor.common.internal.common.core.math.functions.Function;

public class Sin extends Function {
	public Sin(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public int getRequiredArguments() {
		return 1;
	}

	@Override
	public double get() {
		return Math.sin(this.getArg(0));
	}
}
