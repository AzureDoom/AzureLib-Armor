package mod.azure.azurelibarmor.neoforge.network;

import net.neoforged.neoforge.network.NetworkRegistry;
import net.neoforged.neoforge.network.PlayNetworkDirection;
import net.neoforged.neoforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import mod.azure.azurelibarmor.common.internal.common.AzureLib;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public final class Networking {

    public static final Marker MARKER = MarkerManager.getMarker("Network");
    private static final String NETWORK_VERSION = "2.0.0";
    private static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(AzureLib.MOD_ID, "network_channel"))
            .networkProtocolVersion(() -> NETWORK_VERSION)
            .clientAcceptedVersions(NETWORK_VERSION::equals)
            .serverAcceptedVersions(NETWORK_VERSION::equals)
            .simpleChannel();

    public static void sendClientPacket(ServerPlayer target, IPacket<?> packet) {
        CHANNEL.sendTo(packet, target.connection.connection, PlayNetworkDirection.PLAY_TO_CLIENT);
    }
}
