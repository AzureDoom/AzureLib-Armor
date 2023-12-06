package mod.azure.azurelibarmor.common.internal.common.network.packet;

import mod.azure.azurelibarmor.common.api.common.animatable.SingletonGeoAnimatable;
import mod.azure.azurelibarmor.common.internal.common.core.animatable.GeoAnimatable;
import mod.azure.azurelibarmor.common.internal.common.network.AbstractPacket;
import mod.azure.azurelibarmor.common.internal.common.network.SerializableDataTicket;
import mod.azure.azurelibarmor.common.internal.common.constant.DataTickets;
import mod.azure.azurelibarmor.platform.services.AzureLibNetwork;
import mod.azure.azurelibarmor.common.api.client.helper.ClientUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

/**
 * Packet for syncing user-definable animation data for
 * {@link SingletonGeoAnimatable} instances
 */
public class AnimDataSyncPacket<D> extends AbstractPacket {
	private final String syncableId;
	private final long instanceId;
	private final SerializableDataTicket<D> dataTicket;
	private final D data;

	public AnimDataSyncPacket(String syncableId, long instanceId, SerializableDataTicket<D> dataTicket, D data) {
		this.syncableId = syncableId;
		this.instanceId = instanceId;
		this.dataTicket = dataTicket;
		this.data = data;
	}

	@Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeUtf(this.syncableId);
        buf.writeVarLong(this.instanceId);
        buf.writeUtf(this.dataTicket.id());
        this.dataTicket.encode(this.data, buf);
    }

	@Override
	public ResourceLocation getPacketID() {
		return AzureLibNetwork.ANIM_DATA_SYNC_PACKET_ID;
	}

	public static <D> AnimDataSyncPacket<D> receive(FriendlyByteBuf buf) {
		String syncableId = buf.readUtf();
		long instanceID = buf.readVarLong();
		SerializableDataTicket<D> dataTicket = (SerializableDataTicket<D>) DataTickets.byName(buf.readUtf());
		D data = dataTicket.decode(buf);

		return new AnimDataSyncPacket<>(syncableId, instanceID, dataTicket, data);
    }

	@Override
	public void handle() {
		GeoAnimatable animatable = AzureLibNetwork.getSyncedAnimatable(syncableId);

		if (animatable instanceof SingletonGeoAnimatable singleton) {
			singleton.setAnimData(ClientUtils.getClientPlayer(), instanceId, dataTicket, data);
		}
	}
}
