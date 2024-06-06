package mod.azure.azurelibarmor.neoforge.platform;

import mod.azure.azurelibarmor.common.platform.services.GeoRenderPhaseEventFactory;
import mod.azure.azurelibarmor.neoforge.event.NeoForgeGeoRenderPhaseEvent;

/**
 * @author Boston Vanseghi
 */
public class NeoForgeGeoRenderPhaseEventFactory implements GeoRenderPhaseEventFactory {

    @Override
    public GeoRenderPhaseEvent create() {
        return new NeoForgeGeoRenderPhaseEvent();
    }
}
