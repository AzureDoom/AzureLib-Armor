/**
 * This class is a fork of the matching class found in the Geckolib repository. Original source:
 * https://github.com/bernie-g/geckolib Copyright © 2024 Bernie-G. Licensed under the MIT License.
 * https://github.com/bernie-g/geckolib/blob/main/LICENSE
 */
package mod.azure.azurelibarmor.core.molang.functions;

import mod.azure.azurelibarmor.core.math.IValue;
import mod.azure.azurelibarmor.core.math.functions.Function;
import mod.azure.azurelibarmor.core.math.functions.classic.Cos;

/**
 * Replacement function for {@link Cos}, operating in degrees rather than radians.
 */
public class CosDegrees extends Function {

    public CosDegrees(IValue[] values, String name) throws Exception {
        super(values, name);
    }

    @Override
    public int getRequiredArguments() {
        return 1;
    }

    @Override
    public double get() {
        return Math.cos(this.getArg(0) / 180 * Math.PI);
    }
}
