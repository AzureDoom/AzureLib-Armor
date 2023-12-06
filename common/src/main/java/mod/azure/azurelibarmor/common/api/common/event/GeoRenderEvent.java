package mod.azure.azurelibarmor.common.api.common.event;

import mod.azure.azurelibarmor.common.internal.client.renderer.GeoRenderer;
import mod.azure.azurelibarmor.common.api.common.animatable.GeoItem;
import mod.azure.azurelibarmor.common.api.client.renderer.GeoArmorRenderer;

/**
 * AzureLib events base-class for the various event stages of rendering.<br>
 */
public interface GeoRenderEvent {
	/**
	 * Returns the renderer for this event
	 * @see GeoArmorRenderer GeoArmorRenderer
	 * @see GeoItem GeoItem
	 */
	GeoRenderer<?> getRenderer();
}
