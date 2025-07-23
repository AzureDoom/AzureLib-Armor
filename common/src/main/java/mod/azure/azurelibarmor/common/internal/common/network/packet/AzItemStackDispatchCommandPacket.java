package mod.azure.azurelibarmor.common.internal.common.network.packet;

import net.minecraft.core.UUIDUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import mod.azure.azurelibarmor.common.internal.common.network.AbstractPacket;
import mod.azure.azurelibarmor.common.platform.services.AzureLibNetwork;
import mod.azure.azurelibarmor.rewrite.animation.cache.AzIdentifiableItemStackAnimatorCache;
import mod.azure.azurelibarmor.rewrite.animation.dispatch.AzDispatchSide;
import mod.azure.azurelibarmor.rewrite.animation.dispatch.command.AzCommand;

public record AzItemStackDispatchCommandPacket(
    UUID itemStackId,
    AzCommand dispatchCommand
) implements AbstractPacket {

    public static final CustomPacketPayload.Type<AzItemStackDispatchCommandPacket> TYPE =
        new CustomPacketPayload.Type<>(
            AzureLibNetwork.AZ_ITEM_STACK_DISPATCH_COMMAND_SYNC_PACKET_ID
        );

    public static final StreamCodec<FriendlyByteBuf, AzItemStackDispatchCommandPacket> CODEC = StreamCodec.composite(
        UUIDUtil.STREAM_CODEC,
        AzItemStackDispatchCommandPacket::itemStackId,
        AzCommand.CODEC,
        AzItemStackDispatchCommandPacket::dispatchCommand,
        AzItemStackDispatchCommandPacket::new
    );

    public void handle() {
        var animator = AzIdentifiableItemStackAnimatorCache.getInstance().getOrNull(itemStackId);

        if (animator != null) {
            dispatchCommand.actions().forEach(action -> action.handle(AzDispatchSide.SERVER, animator));
        }
    }

    @Override
    public @NotNull CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
