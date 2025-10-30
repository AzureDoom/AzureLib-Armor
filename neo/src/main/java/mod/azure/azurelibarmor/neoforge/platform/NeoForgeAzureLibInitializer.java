package mod.azure.azurelibarmor.neoforge.platform;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;

import mod.azure.azurelibarmor.common.cache.AzureLibCache;
import mod.azure.azurelibarmor.common.platform.services.AzureLibInitializer;

public class NeoForgeAzureLibInitializer implements AzureLibInitializer {

    @Override
    public void initialize() {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            AzureLibCache.registerReloadListener();
        }
    }
}
