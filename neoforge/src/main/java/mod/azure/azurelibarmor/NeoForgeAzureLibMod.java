package mod.azure.azurelibarmor;

import net.neoforged.fml.common.Mod;

@Mod(AzureLib.MOD_ID)
public final class NeoForgeAzureLibMod {
    public static NeoForgeAzureLibMod instance;

    public NeoForgeAzureLibMod() {
        instance = this;
        AzureLib.initialize();
    }
}
