package mod.azure.azurelibarmor.neoforge.platform;

import mod.azure.azurelibarmor.common.internal.common.AzureLib;
import mod.azure.azurelibarmor.common.internal.common.network.AbstractPacket;
import mod.azure.azurelibarmor.common.internal.common.network.packet.AnimDataSyncPacket;
import mod.azure.azurelibarmor.common.internal.common.network.packet.AnimTriggerPacket;
import mod.azure.azurelibarmor.platform.services.AzureLibNetwork;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.NetworkEvent;
import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.simple.SimpleChannel;

public class NeoForgeAzureLibNetwork implements AzureLibNetwork {
    private static final String VER = "1";
    private static final SimpleChannel PACKET_CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(AzureLib.MOD_ID, "main"), () -> VER, VER::equals, VER::equals);

    private void handlePacket(AbstractPacket packet, NetworkEvent.Context context) {
        NetworkEvent.Context handler = context;
        context.enqueueWork(packet::handle);
        context.setPacketHandled(true);
    }

    @Override
    public void registerClientReceiverPackets() {
        int id = 0;
        PACKET_CHANNEL.registerMessage(id++, AnimDataSyncPacket.class, AnimDataSyncPacket::encode, AnimDataSyncPacket::receive, this::handlePacket);
        PACKET_CHANNEL.registerMessage(id++, AnimTriggerPacket.class, AnimTriggerPacket::encode, AnimTriggerPacket::receive, this::handlePacket);
    }

    @Override
    public void sendToTrackingEntityAndSelf(AbstractPacket packet, Entity entityToTrack) {
        send(packet, PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entityToTrack));
    }

    @Override
    public void sendToEntitiesTrackingChunk(AbstractPacket packet, ServerLevel level, BlockPos blockPos) {
        send(packet, PacketDistributor.TRACKING_CHUNK.with(() -> level.getChunkAt(blockPos)));
    }

    /**
     * Send a packet using AzureLib's packet channel
     */
    public static <M> void send(M packet, PacketDistributor.PacketTarget distributor) {
        PACKET_CHANNEL.send(distributor, packet);
    }
}
