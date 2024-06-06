package mod.azure.azurelibarmor.fabric.platform;

import mod.azure.azurelibarmor.common.platform.services.GeoRenderPhaseEventFactory;
import mod.azure.azurelibarmor.fabric.event.FabricGeoRenderPhaseEvent;

/**
 * @author Boston Vanseghi
 */
public class FabricGeoRenderPhaseEventFactory implements GeoRenderPhaseEventFactory {

    @Override
    public GeoRenderPhaseEvent create() {
        return new FabricGeoRenderPhaseEvent();
    }
}
