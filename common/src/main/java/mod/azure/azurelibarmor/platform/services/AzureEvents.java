package mod.azure.azurelibarmor.platform.services;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelibarmor.cache.object.BakedGeoModel;
import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import mod.azure.azurelibarmor.renderer.GeoItemRenderer;
import net.minecraft.client.renderer.MultiBufferSource;

public interface AzureEvents {
    /**
     * Fire the Armor.CompileRenderLayers event
     */
    void fireCompileArmorRenderLayers(GeoArmorRenderer<?> renderer);
    /**
     * Fire the Armor.Pre event
     */
    boolean fireArmorPreRender(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight);
    /**
     * Fire the Armor.Post event
     */
    void fireArmorPostRender(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight);

    /**
     * Fire the Item.CompileRenderLayers event
     */
    void fireCompileItemRenderLayers(GeoItemRenderer<?> renderer);
    /**
     * Fire the Item.Pre event
     */
    boolean fireItemPreRender(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight);
    /**
     * Fire the Item.Post event
     */
    void fireItemPostRender(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight);
}
