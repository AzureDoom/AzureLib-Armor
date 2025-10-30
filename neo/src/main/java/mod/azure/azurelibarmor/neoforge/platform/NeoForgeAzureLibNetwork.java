package mod.azure.azurelibarmor.neoforge.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;
import net.neoforged.neoforge.network.PacketDistributor;

import mod.azure.azurelibarmor.common.network.AbstractPacket;
import mod.azure.azurelibarmor.common.platform.services.AzureLibNetwork;

public class NeoForgeAzureLibNetwork implements AzureLibNetwork {

    @Override
    public void sendToTrackingEntityAndSelf(AbstractPacket packet, Entity entityToTrack) {
        PacketDistributor.sendToPlayersTrackingEntityAndSelf(entityToTrack, packet);
    }

    @Override
    public void sendToEntitiesTrackingChunk(AbstractPacket packet, ServerLevel level, BlockPos blockPos) {
        PacketDistributor.sendToPlayersTrackingChunk(level, new ChunkPos(blockPos), packet);
    }

    @Override
    public void sendToPlayer(AbstractPacket packet, ServerPlayer player) {
        PacketDistributor.sendToPlayer(player, packet);
    }
}
