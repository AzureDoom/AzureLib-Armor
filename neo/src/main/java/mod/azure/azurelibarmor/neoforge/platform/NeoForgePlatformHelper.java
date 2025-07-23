package mod.azure.azurelibarmor.neoforge.platform;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLLoader;

import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import mod.azure.azurelibarmor.common.platform.services.IPlatformHelper;
import mod.azure.azurelibarmor.neoforge.NeoForgeAzureLibMod;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Forge";
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public Path getGameDir() {
        return FMLLoader.getGamePath();
    }

    @Override
    public boolean isServerEnvironment() {
        return FMLEnvironment.dist.isDedicatedServer();
    }

    @Override
    public boolean isEnvironmentClient() {
        return FMLEnvironment.dist.isClient();
    }

    @Override
    public <T> Supplier<DataComponentType<T>> registerDataComponent(
        String id,
        UnaryOperator<DataComponentType.Builder<T>> builder
    ) {
        return NeoForgeAzureLibMod.DATA_COMPONENTS_REGISTER.registerComponentType(id, builder);
    }
}
