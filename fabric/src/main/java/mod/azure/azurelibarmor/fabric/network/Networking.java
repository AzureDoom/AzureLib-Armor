package mod.azure.azurelibarmor.fabric.network;

import java.util.function.BiConsumer;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import io.netty.buffer.Unpooled;
import mod.azure.azurelibarmor.fabric.network.api.IClientPacket;
import mod.azure.azurelibarmor.common.internal.common.network.api.IPacket;
import mod.azure.azurelibarmor.common.internal.common.network.api.IPacketEncoder;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public final class Networking {

    public static final Marker MARKER = MarkerManager.getMarker("Network");

    public static void sendClientPacket(ServerPlayer target, IClientPacket<?> packet) {
        dispatch(packet, (packetId, buffer) -> ServerPlayNetworking.send(target, packetId, buffer));
    }

    private static <T> void dispatch(IPacket<T> packet, BiConsumer<ResourceLocation, FriendlyByteBuf> dispatcher) {
        ResourceLocation packetId = packet.getPacketId();
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        IPacketEncoder<T> encoder = packet.getEncoder();
        T data = packet.getPacketData();
        encoder.encode(data, buffer);
        dispatcher.accept(packetId, buffer);
    }
}
