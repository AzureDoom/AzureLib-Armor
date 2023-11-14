package mod.azure.azurelibarmor.platform;

import mod.azure.azurelibarmor.cache.AzureLibCache;
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