package mod.azure.azurelibarmor.fabric;

import mod.azure.azurelibarmor.common.platform.services.AzureLibNetwork;
import net.fabricmc.api.ClientModInitializer;

public final class ClientListener implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AzureLibNetwork.init();
    }
}
