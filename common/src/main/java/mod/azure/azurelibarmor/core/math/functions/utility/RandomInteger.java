package mod.azure.azurelibarmor.core.math.functions.utility;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.Function;

public class RandomInteger extends Function {
	public java.util.Random random;

	public RandomInteger(IValue[] values, String name) throws Exception {
		super(values, name);

		this.random = new java.util.Random();
	}

	@Override
	public int getRequiredArguments() {
		return 2;
	}

	@Override
	public double get() {
		double min = Math.ceil(this.getArg(0));
		double max = Math.floor(this.getArg(1));
		return Math.floor(Math.random() * (max - min) + min);
	}
}
