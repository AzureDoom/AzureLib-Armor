package mod.azure.azurelibarmor.neoforge;

import mod.azure.azurelibarmor.common.internal.common.AzureLib;
import net.neoforged.fml.common.Mod;

@Mod(AzureLib.MOD_ID)
public final class NeoForgeAzureLibMod {
    public static NeoForgeAzureLibMod instance;

    public NeoForgeAzureLibMod() {
        instance = this;
        AzureLib.initialize();
    }
}
