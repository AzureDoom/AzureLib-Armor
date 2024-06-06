package mod.azure.azurelibarmor.common.platform.services;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import mod.azure.azurelibarmor.common.internal.common.AzureLib;
import mod.azure.azurelibarmor.common.internal.common.animatable.SingletonGeoAnimatable;
import mod.azure.azurelibarmor.common.internal.common.network.AbstractPacket;
import mod.azure.azurelibarmor.common.internal.common.network.packet.AnimDataSyncPacket;
import mod.azure.azurelibarmor.common.internal.common.network.packet.AnimTriggerPacket;
import mod.azure.azurelibarmor.common.platform.Services;
import mod.azure.azurelibarmor.core.animatable.GeoAnimatable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public interface AzureLibNetwork {

    ResourceLocation ANIM_DATA_SYNC_PACKET_ID = AzureLib.modResource("anim_data_sync");

    ResourceLocation ANIM_TRIGGER_SYNC_PACKET_ID = AzureLib.modResource("anim_trigger_sync");

    ResourceLocation ENTITY_ANIM_DATA_SYNC_PACKET_ID = AzureLib.modResource("entity_anim_data_sync");

    ResourceLocation ENTITY_ANIM_TRIGGER_SYNC_PACKET_ID = AzureLib.modResource("entity_anim_trigger_sync");

    ResourceLocation BLOCK_ENTITY_ANIM_DATA_SYNC_PACKET_ID = AzureLib.modResource("block_entity_anim_data_sync");

    ResourceLocation BLOCK_ENTITY_ANIM_TRIGGER_SYNC_PACKET_ID = AzureLib.modResource("block_entity_anim_trigger_sync");

    ResourceLocation CONFIG_PACKET_ID = AzureLib.modResource("config_packet");

    Map<String, GeoAnimatable> SYNCED_ANIMATABLES = new Object2ObjectOpenHashMap<>();

    static void init() {
        registerPacket(AnimTriggerPacket.TYPE, AnimTriggerPacket.CODEC);
        registerPacket(AnimDataSyncPacket.TYPE, AnimDataSyncPacket.CODEC);
    }

    private static <B extends FriendlyByteBuf, P extends AbstractPacket> void registerPacket(CustomPacketPayload.Type<P> payloadType, StreamCodec<B, P> codec) {
        Services.NETWORK.registerPacketInternal(payloadType, codec, true);
    }

    static void sendWithCallback(AbstractPacket packet, IPacketCallback callback) {
        callback.onReadyToSend(packet);
    }

    /**
     * Gets a registered synced {@link GeoAnimatable} object by name
     *
     * @param className the className
     */
    @Nullable
    static GeoAnimatable getSyncedAnimatable(String className) {
        GeoAnimatable animatable = SYNCED_ANIMATABLES.get(className);

        if (animatable == null)
            AzureLib.LOGGER.error("Attempting to retrieve unregistered synced animatable! ({})", className);

        return animatable;
    }

    <B extends FriendlyByteBuf, P extends AbstractPacket> void registerPacketInternal(CustomPacketPayload.Type<P> payloadType, StreamCodec<B, P> codec, boolean isClientBound);

    /**
     * Registers a synced {@link GeoAnimatable} object for networking support.<br>
     * It is recommended that you don't call this directly, instead implementing and calling
     * {@link SingletonGeoAnimatable#registerSyncedAnimatable}
     */
    default void registerSyncedAnimatable(GeoAnimatable animatable) {
        synchronized (this) {
            GeoAnimatable existing = SYNCED_ANIMATABLES.put(animatable.getClass().toString(), animatable);

            if (existing == null)
                AzureLib.LOGGER.debug("Registered SyncedAnimatable for {}", animatable.getClass());
        }
    }

    void sendToTrackingEntityAndSelf(AbstractPacket packet, Entity entityToTrack);

    void sendToEntitiesTrackingChunk(AbstractPacket packet, ServerLevel level, BlockPos blockPos);

    void sendToPlayer(AbstractPacket packet, ServerPlayer player);

    interface IPacketCallback {

        void onReadyToSend(AbstractPacket packetToSend);
    }
}
