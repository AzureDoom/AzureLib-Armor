package mod.azure.azurelibarmor.mixin;

import mod.azure.azurelibarmor.animatable.GeoItem;
import mod.azure.azurelibarmor.animatable.client.RenderProvider;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.ClientHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientHooks.class)
public class ClientHooksMixin {

    @Inject(method = "getArmorModel", at = @At("RETURN"), remap = false, cancellable = true)
    private static void injectAzureArmors(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot slot, HumanoidModel<?> _default, CallbackInfoReturnable<Model> cir) {
        if (itemStack.getItem() instanceof GeoItem)
            cir.setReturnValue((Model) RenderProvider.of(itemStack).getGenericArmorModel(entityLiving, itemStack, slot, (HumanoidModel<LivingEntity>) _default));
    }
}
