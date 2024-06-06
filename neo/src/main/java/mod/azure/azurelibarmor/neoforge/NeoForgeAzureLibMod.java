package mod.azure.azurelibarmor.neoforge;

import mod.azure.azurelibarmor.common.internal.common.AzureLib;
import mod.azure.azurelibarmor.neoforge.platform.NeoForgeAzureLibNetwork;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(AzureLib.MOD_ID)
public final class NeoForgeAzureLibMod {

    public static final DeferredRegister.DataComponents DATA_COMPONENTS_REGISTER = DeferredRegister.createDataComponents(
            AzureLib.MOD_ID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM,
            AzureLib.MOD_ID);

    public NeoForgeAzureLibMod(IEventBus modEventBus) {
        AzureLib.initialize();
        NeoForgeAzureLibNetwork.init(modEventBus);
        DATA_COMPONENTS_REGISTER.register(modEventBus);
    }
}
