package mod.azure.azurelibarmor.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import mod.azure.azurelibarmor.common.internal.common.network.packet.AnimDataSyncPacket;
import mod.azure.azurelibarmor.common.internal.common.network.packet.AnimTriggerPacket;
import mod.azure.azurelibarmor.common.internal.common.network.packet.AzItemStackDispatchCommandPacket;

public final class ClientListener implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(AnimTriggerPacket.TYPE, (packet, context) -> packet.handle());
        ClientPlayNetworking.registerGlobalReceiver(AnimDataSyncPacket.TYPE, (packet, context) -> packet.handle());
        ClientPlayNetworking.registerGlobalReceiver(
            AzItemStackDispatchCommandPacket.TYPE,
            (packet, context) -> packet.handle()
        );
    }
}
