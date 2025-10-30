package mod.azure.azurelibarmor.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import mod.azure.azurelibarmor.common.network.packet.AzItemStackDispatchCommandPacket;

public final class ClientListener implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(
            AzItemStackDispatchCommandPacket.TYPE,
            (packet, context) -> packet.handle()
        );
    }
}
