package mod.azure.azurelibarmor.neoforge.platform;

import mod.azure.azurelibarmor.common.internal.common.cache.AzureLibCache;
import mod.azure.azurelibarmor.platform.Services;
import mod.azure.azurelibarmor.platform.services.AzureLibInitializer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;

public class NeoForgeAzureLibInitializer implements AzureLibInitializer {
    @Override
    public void initialize() {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            AzureLibCache.registerReloadListener();
        }
        Services.NETWORK.registerClientReceiverPackets();
    }
}