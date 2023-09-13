package mod.azure.azurelibarmor.core.math.functions.classic;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.Function;

/**
 * Absolute value function
 */
public class ACos extends Function {
	public ACos(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public int getRequiredArguments() {
		return 1;
	}

	@Override
	public double get() {
		return Math.acos(this.getArg(0));
	}
}
