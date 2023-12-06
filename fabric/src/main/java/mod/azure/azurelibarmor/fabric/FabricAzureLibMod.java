package mod.azure.azurelibarmor.fabric;

import mod.azure.azurelibarmor.common.internal.common.AzureLib;
import net.fabricmc.api.ModInitializer;

public final class FabricAzureLibMod implements ModInitializer {

	@Override
	public void onInitialize() {
		AzureLib.initialize();
	}
}
