package mod.azure.azurelibarmor.network.api;

import net.minecraft.resources.ResourceLocation;

public interface IPacket<T> {

    ResourceLocation getPacketId();

    T getPacketData();

    IPacketEncoder<T> getEncoder();

    IPacketDecoder<T> getDecoder();
}
