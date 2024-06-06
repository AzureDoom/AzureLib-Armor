package mod.azure.azurelibarmor.neoforge.platform;

import mod.azure.azurelibarmor.common.internal.common.AzureLib;
import mod.azure.azurelibarmor.common.internal.common.network.AbstractPacket;
import mod.azure.azurelibarmor.common.platform.services.AzureLibNetwork;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import java.util.function.Consumer;

public class NeoForgeAzureLibNetwork implements AzureLibNetwork {

    private static PayloadRegistrar registrar = null;

    public static void init(IEventBus modBus) {
        modBus.addListener((Consumer<RegisterPayloadHandlersEvent>) event -> {
            registrar = event.registrar(AzureLib.MOD_ID);
            AzureLibNetwork.init();
            registrar = null;
        });
    }

    @Override
    public <B extends FriendlyByteBuf, P extends AbstractPacket> void registerPacketInternal(CustomPacketPayload.Type<P> payloadType, StreamCodec<B, P> codec, boolean isClientBound) {
        if (isClientBound) {
            registrar.playToClient(payloadType, (StreamCodec<FriendlyByteBuf, P>) codec,
                    (packet, context) -> packet.handle());
        } else {
            registrar.playToServer(payloadType, (StreamCodec<FriendlyByteBuf, P>) codec,
                    (packet, context) -> packet.handle());
        }
    }

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
