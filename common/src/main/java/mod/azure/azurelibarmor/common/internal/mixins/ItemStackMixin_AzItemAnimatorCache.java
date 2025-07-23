package mod.azure.azurelibarmor.common.internal.mixins;

import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import mod.azure.azurelibarmor.common.internal.common.AzureLib;
import mod.azure.azurelibarmor.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelibarmor.rewrite.animation.AzAnimator;
import mod.azure.azurelibarmor.rewrite.animation.AzAnimatorAccessor;
import mod.azure.azurelibarmor.rewrite.animation.cache.AzIdentifiableItemStackAnimatorCache;
import mod.azure.azurelibarmor.rewrite.animation.impl.AzItemAnimator;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin_AzItemAnimatorCache implements AzAnimatorAccessor<ItemStack> {

    @Override
    public void setAnimator(@Nullable AzAnimator<ItemStack> animator) {
        var itemStack = AzureLibUtil.<ItemStack>self(this);
        AzIdentifiableItemStackAnimatorCache.getInstance().add(itemStack, (AzItemAnimator) animator);
    }

    @Override
    public @Nullable AzAnimator<ItemStack> getAnimatorOrNull() {
        var self = AzureLibUtil.<ItemStack>self(this);
        var uuid = self.getComponents().get(AzureLib.AZ_ID.get());
        return AzIdentifiableItemStackAnimatorCache.getInstance().getOrNull(uuid);
    }
}
