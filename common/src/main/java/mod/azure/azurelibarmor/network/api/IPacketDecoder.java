package mod.azure.azurelibarmor.network.api;

import net.minecraft.network.FriendlyByteBuf;

@FunctionalInterface
public interface IPacketDecoder<T> {

    T decode(FriendlyByteBuf buffer);
}
