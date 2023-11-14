package mod.azure.azurelibarmor.platform;

import mod.azure.azurelibarmor.network.AbstractPacket;
import mod.azure.azurelibarmor.network.packet.*;
import mod.azure.azurelibarmor.platform.services.AzureLibNetwork;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class FabricAzureLibNetwork implements AzureLibNetwork {

    private void handlePacket(Minecraft client, AbstractPacket packet) {
        client.execute(packet::handle);
    }

    @Override
    public void registerClientReceiverPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ANIM_DATA_SYNC_PACKET_ID, (client, $2, buf, $4) -> this.handlePacket(client, AnimDataSyncPacket.receive(buf)));
        ClientPlayNetworking.registerGlobalReceiver(ANIM_TRIGGER_SYNC_PACKET_ID, (client, $2, buf, $4) -> this.handlePacket(client, AnimTriggerPacket.receive(buf)));
    }

    public FriendlyByteBuf createFriendlyByteBuf() {
        return PacketByteBufs.create();
    }

    @Override
    public void sendToTrackingEntityAndSelf(AbstractPacket packet, Entity entityToTrack) {
        for (ServerPlayer trackingPlayer : PlayerLookup.tracking(entityToTrack)) {
            FriendlyByteBuf buf = createFriendlyByteBuf();
            packet.encode(buf);
            ServerPlayNetworking.send(trackingPlayer, packet.getPacketID(), buf);
        }

        if (entityToTrack instanceof ServerPlayer serverPlayer) {
            FriendlyByteBuf buf = createFriendlyByteBuf();
            packet.encode(buf);
            ServerPlayNetworking.send(serverPlayer, packet.getPacketID(), buf);
        }
    }

    @Override
    public void sendToEntitiesTrackingChunk(AbstractPacket packet, ServerLevel level, BlockPos blockPos) {
        for (ServerPlayer trackingPlayer : PlayerLookup.tracking(level, blockPos)) {
            FriendlyByteBuf buf = createFriendlyByteBuf();
            packet.encode(buf);
            ServerPlayNetworking.send(trackingPlayer, packet.getPacketID(), buf);
        }
    }
}
