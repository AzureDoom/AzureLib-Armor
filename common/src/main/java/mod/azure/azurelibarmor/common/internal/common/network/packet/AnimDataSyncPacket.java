package mod.azure.azurelibarmor.common.internal.common.network.packet;

import mod.azure.azurelibarmor.common.api.client.helper.ClientUtils;
import mod.azure.azurelibarmor.common.internal.common.animatable.SingletonGeoAnimatable;
import mod.azure.azurelibarmor.common.internal.common.network.AbstractPacket;
import mod.azure.azurelibarmor.common.internal.common.network.SerializableDataTicket;
import mod.azure.azurelibarmor.common.platform.services.AzureLibNetwork;
import mod.azure.azurelibarmor.core.animatable.GeoAnimatable;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

/**
 * Packet for syncing user-definable animation data for {@link SingletonGeoAnimatable} instances
 */
public record AnimDataSyncPacket<D>(String syncableId, long instanceId, SerializableDataTicket<D> dataTicket,
                                    D data) implements AbstractPacket {

    public static final CustomPacketPayload.Type<AnimDataSyncPacket<?>> TYPE = new Type<>(
            AzureLibNetwork.ANIM_DATA_SYNC_PACKET_ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, AnimDataSyncPacket<?>> CODEC = StreamCodec.of(
            (buf, packet) -> {
                SerializableDataTicket.STREAM_CODEC.encode(buf, packet.dataTicket);
                buf.writeUtf(packet.syncableId);
                buf.writeVarLong(packet.instanceId);
                ((StreamCodec) packet.dataTicket.streamCodec()).encode(buf, packet.data);
            }, buf -> {
                final SerializableDataTicket dataTicket = SerializableDataTicket.STREAM_CODEC.decode(buf);

                return new AnimDataSyncPacket<>(buf.readUtf(), buf.readVarLong(), dataTicket,
                        dataTicket.streamCodec().decode(buf));
            });

    @Override
    public void handle() {
        GeoAnimatable animatable = AzureLibNetwork.getSyncedAnimatable(syncableId);

        if (animatable instanceof SingletonGeoAnimatable singleton) {
            singleton.setAnimData(ClientUtils.getClientPlayer(), instanceId, dataTicket, data);
        }
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
