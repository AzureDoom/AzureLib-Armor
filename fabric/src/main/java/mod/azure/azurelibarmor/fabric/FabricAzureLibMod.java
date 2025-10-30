package mod.azure.azurelibarmor.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

import mod.azure.azurelibarmor.AzureLib;
import mod.azure.azurelibarmor.common.network.packet.AzItemStackDispatchCommandPacket;

public final class FabricAzureLibMod implements ModInitializer {

    @Override
    public void onInitialize() {
        AzureLib.initialize();
        PayloadTypeRegistry.playS2C()
            .register(AzItemStackDispatchCommandPacket.TYPE, AzItemStackDispatchCommandPacket.CODEC);
    }
}
