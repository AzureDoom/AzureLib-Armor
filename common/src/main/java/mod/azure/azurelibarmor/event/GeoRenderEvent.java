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
	 * @see GeoArmorRenderer GeoArmorRenderer
	 * @see GeoItem GeoItem
	 */
	GeoRenderer<?> getRenderer();
}
