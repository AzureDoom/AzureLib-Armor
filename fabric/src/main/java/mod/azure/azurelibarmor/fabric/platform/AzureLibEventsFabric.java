package mod.azure.azurelibarmor.fabric.platform;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelibarmor.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelibarmor.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelibarmor.common.internal.common.cache.object.BakedGeoModel;
import mod.azure.azurelibarmor.fabric.event.GeoRenderEvent;
import mod.azure.azurelibarmor.platform.services.AzureEvents;
import net.minecraft.client.renderer.MultiBufferSource;

public class AzureLibEventsFabric implements AzureEvents {
    /**
     * Fire the {@link GeoRenderEvent.Armor.CompileRenderLayers} event
     */
    @Override
    public void fireCompileArmorRenderLayers(GeoArmorRenderer<?> renderer) {
        GeoRenderEvent.Armor.CompileRenderLayers.EVENT.invoker().handle(new GeoRenderEvent.Armor.CompileRenderLayers(renderer));
    }

    /**
     * Fire the {@link GeoRenderEvent.Armor.Pre} event
     */
    @Override
    public boolean fireArmorPreRender(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return GeoRenderEvent.Armor.Pre.EVENT.invoker().handle(new GeoRenderEvent.Armor.Pre(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }

    /**
     * Fire the {@link GeoRenderEvent.Armor.Post} event
     */
    @Override
    public void fireArmorPostRender(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        GeoRenderEvent.Armor.Post.EVENT.invoker().handle(new GeoRenderEvent.Armor.Post(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }

    /**
     * Fire the {@link GeoRenderEvent.Item.CompileRenderLayers} event
     */
    @Override
    public void fireCompileItemRenderLayers(GeoItemRenderer<?> renderer) {
        GeoRenderEvent.Item.CompileRenderLayers.EVENT.invoker().handle(new GeoRenderEvent.Item.CompileRenderLayers(renderer));
    }

    /**
     * Fire the {@link GeoRenderEvent.Item.Pre} event
     */
    @Override
    public boolean fireItemPreRender(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return GeoRenderEvent.Item.Pre.EVENT.invoker().handle(new GeoRenderEvent.Item.Pre(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }

    /**
     * Fire the {@link GeoRenderEvent.Item.Post} event
     */
    @Override
    public void fireItemPostRender(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        GeoRenderEvent.Item.Post.EVENT.invoker().handle(new GeoRenderEvent.Item.Post(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }
}