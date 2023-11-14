package mod.azure.azurelibarmor.platform;

import mod.azure.azurelibarmor.event.FabricGeoRenderPhaseEvent;
import mod.azure.azurelibarmor.platform.services.GeoRenderPhaseEventFactory;

/**
 * @author Boston Vanseghi
 */
public class FabricGeoRenderPhaseEventFactory implements GeoRenderPhaseEventFactory {
    @Override
    public GeoRenderPhaseEvent create() {
        return new FabricGeoRenderPhaseEvent();
    }
}
