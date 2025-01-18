package mod.azure.azurelibarmor.fabric;

import mod.azure.azurelibarmor.common.internal.common.AzureLib;
import mod.azure.azurelibarmor.common.internal.common.network.packet.AnimDataSyncPacket;
import mod.azure.azurelibarmor.common.internal.common.network.packet.AnimTriggerPacket;
import mod.azure.azurelibarmor.common.internal.common.network.packet.AzItemStackDispatchCommandPacket;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public final class FabricAzureLibMod implements ModInitializer {

    @Override
    public void onInitialize() {
        AzureLib.initialize();
        PayloadTypeRegistry.playS2C().register(AnimTriggerPacket.TYPE, AnimTriggerPacket.CODEC);
        PayloadTypeRegistry.playS2C().register(AnimDataSyncPacket.TYPE, AnimDataSyncPacket.CODEC);
        PayloadTypeRegistry.playS2C()
                .register(AzItemStackDispatchCommandPacket.TYPE, AzItemStackDispatchCommandPacket.CODEC);
    }
}
