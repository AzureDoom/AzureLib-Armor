package mod.azure.azurelibarmor;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.azure.azurelibarmor.cache.AzureLibCache;
import mod.azure.azurelibarmor.network.AzureLibNetwork;

/**
 * Base class for AzureLib!<br>
 * Hello World!<br>
 * There's not much to really see here, but feel free to stay a while and have a snack or something.
 * @see mod.azure.azurelibarmor.util.AzureLibUtil
 */
public class AzureArmorLib {
	public static final String MOD_ID = "azurelibarmor";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static volatile boolean hasInitialized;

	synchronized public static void initialize() {
		if (!hasInitialized) {
			DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> AzureLibCache::registerReloadListener);
			AzureLibNetwork.init();
		}

		hasInitialized = true;
	}
}
