package mod.azure.azurelibarmor.core.math.functions.utility;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.Function;
import mod.azure.azurelibarmor.core.utils.Interpolations;

public class Lerp extends Function {
	public Lerp(IValue[] values, String name) throws Exception {
		super(values, name);
	}

	@Override
	public int getRequiredArguments() {
		return 3;
	}

	@Override
	public double get() {
		return Interpolations.lerp(this.getArg(0), this.getArg(1), this.getArg(2));
	}
}
