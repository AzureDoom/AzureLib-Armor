package mod.azure.azurelibarmor.event;

import mod.azure.azurelibarmor.renderer.GeoRenderer;
import mod.azure.azurelibarmor.animatable.GeoItem;
import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;

/**
 * AzureLib events base-class for the various event stages of rendering.<br>
 */
public interface GeoRenderEvent {
	/**
	 * Returns the renderer for this event
	 * @see mod.azure.azurelibarmor.renderer.DynamicGeoEntityRenderer DynamicGeoEntityRenderer
	 * @see GeoArmorRenderer GeoArmorRenderer
	 * @see mod.azure.azurelibarmor.renderer.GeoBlockRenderer GeoBlockRenderer
	 * @see mod.azure.azurelibarmor.renderer.GeoEntityRenderer GeoEntityRenderer
	 * @see GeoItem GeoItem
	 * @see mod.azure.azurelibarmor.renderer.GeoObjectRenderer GeoObjectRenderer
	 * @see mod.azure.azurelibarmor.renderer.GeoReplacedEntityRenderer GeoReplacedEntityRenderer
	 */
	GeoRenderer<?> getRenderer();
}
