package mod.azure.azurelibarmor.fabric.platform;

import mod.azure.azurelibarmor.fabric.event.FabricGeoRenderPhaseEvent;
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
