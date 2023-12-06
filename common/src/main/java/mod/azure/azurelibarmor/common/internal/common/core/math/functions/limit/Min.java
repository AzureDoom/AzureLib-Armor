package mod.azure.azurelibarmor.common.internal.common.core.math.functions.limit;

import mod.azure.azurelibarmor.common.internal.common.core.math.IValue;
import mod.azure.azurelibarmor.common.internal.common.core.math.functions.Function;

public class Min extends Function {
	public Min(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public int getRequiredArguments() {
		return 2;
	}

	@Override
	public double get() {
		return Math.min(this.getArg(0), this.getArg(1));
	}
}
