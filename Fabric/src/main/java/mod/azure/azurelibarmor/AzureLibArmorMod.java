package mod.azure.azurelibarmor;

import net.fabricmc.api.ModInitializer;

public final class AzureLibArmorMod implements ModInitializer {

	public AzureLibArmorMod() {
	}

	@Override
	public void onInitialize() {
		AzureArmorLib.initialize();
	}
}
