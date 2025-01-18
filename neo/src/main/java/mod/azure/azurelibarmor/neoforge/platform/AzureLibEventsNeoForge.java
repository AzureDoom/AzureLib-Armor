package mod.azure.azurelibarmor.neoforge.platform;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelibarmor.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelibarmor.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelibarmor.common.internal.common.cache.object.BakedGeoModel;
import mod.azure.azurelibarmor.common.platform.services.AzureEvents;
import mod.azure.azurelibarmor.neoforge.event.GeoRenderEvent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.neoforged.neoforge.common.NeoForge;

@Deprecated(forRemoval = true)
public class AzureLibEventsNeoForge implements AzureEvents {
    /**
     * Fire the {@link GeoRenderEvent.Armor.CompileRenderLayers} event
     */
    @Override
    public void fireCompileArmorRenderLayers(GeoArmorRenderer<?> renderer) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Armor.CompileRenderLayers(renderer));
    }

    /**
     * Fire the {@link GeoRenderEvent.Armor.Pre} event
     */
    @Override
    public boolean fireArmorPreRender(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return !NeoForge.EVENT_BUS.post(new GeoRenderEvent.Armor.Pre(renderer, poseStack, model, bufferSource, partialTick, packedLight)).isCanceled();
    }

    /**
     * Fire the {@link GeoRenderEvent.Armor.Post} event
     */
    @Override
    public void fireArmorPostRender(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Armor.Post(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }

    /**
     * Fire the {@link GeoRenderEvent.Item.CompileRenderLayers} event
     */
    @Override
    public void fireCompileItemRenderLayers(GeoItemRenderer<?> renderer) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Item.CompileRenderLayers(renderer));
    }

    /**
     * Fire the {@link GeoRenderEvent.Item.Pre} event
     */
    @Override
    public boolean fireItemPreRender(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        return !NeoForge.EVENT_BUS.post(new GeoRenderEvent.Item.Pre(renderer, poseStack, model, bufferSource, partialTick, packedLight)).isCanceled();
    }

    /**
     * Fire the {@link GeoRenderEvent.Item.Post} event
     */
    @Override
    public void fireItemPostRender(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
        NeoForge.EVENT_BUS.post(new GeoRenderEvent.Item.Post(renderer, poseStack, model, bufferSource, partialTick, packedLight));
    }
}
