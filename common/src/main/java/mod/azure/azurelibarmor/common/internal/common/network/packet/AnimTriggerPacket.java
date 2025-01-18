package mod.azure.azurelibarmor.common.internal.common.network.packet;

import mod.azure.azurelibarmor.common.internal.common.network.AbstractPacket;
import mod.azure.azurelibarmor.common.platform.services.AzureLibNetwork;
import mod.azure.azurelibarmor.core.animatable.GeoAnimatable;
import mod.azure.azurelibarmor.core.animation.AnimatableManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

/**
 * Packet for syncing user-definable animations that can be triggered from the server
 */
@Deprecated(forRemoval = true)
public record AnimTriggerPacket(String syncableId, long instanceId, String controllerName,
                                String animName) implements AbstractPacket {
    public static final CustomPacketPayload.Type<AnimTriggerPacket> TYPE = new Type<>(
            AzureLibNetwork.ANIM_TRIGGER_SYNC_PACKET_ID);
    public static final StreamCodec<FriendlyByteBuf, AnimTriggerPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, AnimTriggerPacket::syncableId, ByteBufCodecs.VAR_LONG,
            AnimTriggerPacket::instanceId, ByteBufCodecs.STRING_UTF8, AnimTriggerPacket::controllerName,
            ByteBufCodecs.STRING_UTF8, AnimTriggerPacket::animName, AnimTriggerPacket::new);

    @Override
    public void handle() {
        GeoAnimatable animatable = AzureLibNetwork.getSyncedAnimatable(syncableId);

        if (animatable != null) {
            AnimatableManager<?> manager = animatable.getAnimatableInstanceCache().getManagerForId(instanceId);

            manager.tryTriggerAnimation(controllerName, animName);
        }
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
