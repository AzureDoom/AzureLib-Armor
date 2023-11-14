package mod.azure.azurelibarmor;

import mod.azure.azurelibarmor.platform.Services;
import net.fabricmc.api.ClientModInitializer;

public final class ClientListener implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Services.NETWORK.registerClientReceiverPackets();
    }
}
