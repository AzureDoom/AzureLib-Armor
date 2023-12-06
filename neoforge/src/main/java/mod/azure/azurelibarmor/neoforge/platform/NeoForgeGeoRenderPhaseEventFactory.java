package mod.azure.azurelibarmor.neoforge.platform;

import mod.azure.azurelibarmor.neoforge.event.NeoForgeGeoRenderPhaseEvent;
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
