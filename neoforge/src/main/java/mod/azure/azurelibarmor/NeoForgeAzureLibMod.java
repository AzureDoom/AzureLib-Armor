package mod.azure.azurelibarmor;

import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
@Mod(AzureLib.MOD_ID)
public final class NeoForgeAzureLibMod {

    public static NeoForgeAzureLibMod instance;

    public NeoForgeAzureLibMod() {
        instance = this;
        AzureLib.initialize();
    }
}
