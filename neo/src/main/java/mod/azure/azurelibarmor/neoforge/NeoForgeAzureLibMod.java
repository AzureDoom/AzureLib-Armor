package mod.azure.azurelibarmor.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredRegister;

import mod.azure.azurelibarmor.AzureLib;
import mod.azure.azurelibarmor.common.network.packet.AzItemStackDispatchCommandPacket;

@Mod(AzureLib.MOD_ID)
public final class NeoForgeAzureLibMod {

    public static final DeferredRegister.DataComponents DATA_COMPONENTS_REGISTER = DeferredRegister
        .createDataComponents(
            AzureLib.MOD_ID
        );

    public NeoForgeAzureLibMod(IEventBus modEventBus) {
        AzureLib.initialize();
        DATA_COMPONENTS_REGISTER.register(modEventBus);
        modEventBus.addListener(this::registerMessages);
    }

    public void registerMessages(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(AzureLib.MOD_ID);
        registrar.playBidirectional(
            AzItemStackDispatchCommandPacket.TYPE,
            AzItemStackDispatchCommandPacket.CODEC,
            (msg, ctx) -> msg.handle()
        );
    }
}
