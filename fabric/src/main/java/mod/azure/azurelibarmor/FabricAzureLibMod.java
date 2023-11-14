package mod.azure.azurelibarmor;

import mod.azure.azurelibarmor.AzureLib;
import net.fabricmc.api.ModInitializer;

public final class FabricAzureLibMod implements ModInitializer {

	@Override
	public void onInitialize() {
		AzureLib.initialize();
	}
}
