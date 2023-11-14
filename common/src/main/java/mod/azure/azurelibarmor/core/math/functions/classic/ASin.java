package mod.azure.azurelibarmor.core.math.functions.classic;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.Function;

/**
 * Absolute value function
 */
public class ASin extends Function {
	public ASin(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public int getRequiredArguments() {
		return 1;
	}

	@Override
	public double get() {
		return Math.asin(this.getArg(0));
	}
}
