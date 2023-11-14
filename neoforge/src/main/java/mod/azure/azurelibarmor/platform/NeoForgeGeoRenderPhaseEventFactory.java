package mod.azure.azurelibarmor.platform;

import mod.azure.azurelibarmor.event.NeoForgeGeoRenderPhaseEvent;
import mod.azure.azurelibarmor.platform.services.GeoRenderPhaseEventFactory;

/**
 * @author Boston Vanseghi
 */
public class NeoForgeGeoRenderPhaseEventFactory implements GeoRenderPhaseEventFactory {
    @Override
    public GeoRenderPhaseEvent create() {
        return new NeoForgeGeoRenderPhaseEvent();
    }
}
