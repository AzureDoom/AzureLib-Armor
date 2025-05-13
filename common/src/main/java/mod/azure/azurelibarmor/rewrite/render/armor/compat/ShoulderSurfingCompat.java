package mod.azure.azurelibarmor.rewrite.render.armor.compat;

import com.github.exopandora.shouldersurfing.api.client.ShoulderSurfing;
import mod.azure.azurelibarmor.common.platform.Services;

import java.util.function.Supplier;

public class ShoulderSurfingCompat {
	private static Supplier<Float> alphaSupplier = () -> 1.0F;
	private static boolean isLoaded = false;

	public static void init() {
		if (Services.PLATFORM.isModLoaded("shouldersurfing")) {
			isLoaded = true;
			alphaSupplier = () -> ShoulderSurfing.getInstance().getCameraEntityRenderer().getCameraEntityAlpha();
		}
	}

	public static boolean isLoaded() {
		return isLoaded;
	}

	public static float getAlpha() {
		return alphaSupplier.get();
	}
}
