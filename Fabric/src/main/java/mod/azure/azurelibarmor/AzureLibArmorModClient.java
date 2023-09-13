package mod.azure.azurelibarmor;

import mod.azure.azurelibarmor.network.AzureLibNetwork;
import net.fabricmc.api.ClientModInitializer;

public final class AzureLibArmorModClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		AzureLibNetwork.registerClientReceiverPackets();
	}
}
