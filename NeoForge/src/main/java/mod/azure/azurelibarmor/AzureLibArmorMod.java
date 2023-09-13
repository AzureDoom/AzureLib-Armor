package mod.azure.azurelibarmor;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
@Mod(AzureArmorLib.MOD_ID)
public final class AzureLibArmorMod {

	public static AzureLibArmorMod instance;

	public AzureLibArmorMod() {
		instance = this;
		AzureArmorLib.initialize();
	}
}
