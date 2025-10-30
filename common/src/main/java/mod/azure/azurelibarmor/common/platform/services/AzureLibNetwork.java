package mod.azure.azurelibarmor.common.platform.services;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

import mod.azure.azurelibarmor.AzureLib;
import mod.azure.azurelibarmor.common.network.AbstractPacket;

public interface AzureLibNetwork {

    ResourceLocation AZ_ITEM_STACK_DISPATCH_COMMAND_SYNC_PACKET_ID = AzureLib.modResource(
        "az_item_stack_dispatch_command_sync"
    );

    void sendToTrackingEntityAndSelf(AbstractPacket packet, Entity entityToTrack);

    void sendToEntitiesTrackingChunk(AbstractPacket packet, ServerLevel level, BlockPos blockPos);

    void sendToPlayer(AbstractPacket packet, ServerPlayer player);
}
