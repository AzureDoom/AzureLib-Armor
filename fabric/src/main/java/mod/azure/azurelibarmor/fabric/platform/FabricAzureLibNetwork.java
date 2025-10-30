package mod.azure.azurelibarmor.fabric.platform;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

import mod.azure.azurelibarmor.common.network.AbstractPacket;
import mod.azure.azurelibarmor.common.platform.services.AzureLibNetwork;

public class FabricAzureLibNetwork implements AzureLibNetwork {

    @Override
    public void sendToTrackingEntityAndSelf(AbstractPacket packet, Entity entityToTrack) {
        if (entityToTrack instanceof ServerPlayer pl)
            sendToPlayer(packet, pl);

        for (ServerPlayer player : PlayerLookup.tracking(entityToTrack)) {
            sendToPlayer(packet, player);
        }
    }

    @Override
    public void sendToEntitiesTrackingChunk(AbstractPacket packet, ServerLevel level, BlockPos blockPos) {
        for (ServerPlayer player : PlayerLookup.tracking(level, blockPos)) {
            sendToPlayer(packet, player);
        }
    }

    @Override
    public void sendToPlayer(AbstractPacket packet, ServerPlayer player) {
        ServerPlayNetworking.send(player, packet);
    }
}
