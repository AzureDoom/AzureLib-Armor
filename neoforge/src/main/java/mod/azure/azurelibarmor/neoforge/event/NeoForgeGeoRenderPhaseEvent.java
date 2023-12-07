package mod.azure.azurelibarmor.neoforge.event;

import mod.azure.azurelibarmor.common.api.common.event.GeoRenderEvent;
import mod.azure.azurelibarmor.platform.services.GeoRenderPhaseEventFactory;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.common.NeoForge;

/**
 * @author Boston Vanseghi
 */
public class NeoForgeGeoRenderPhaseEvent implements GeoRenderPhaseEventFactory.GeoRenderPhaseEvent {

    // TODO: Move this.
    static class NeoForgeGeoRenderEvent extends Event implements ICancellableEvent {
        private final GeoRenderEvent geoRenderEvent;

        public NeoForgeGeoRenderEvent(GeoRenderEvent geoRenderEvent) {
            this.geoRenderEvent = geoRenderEvent;
        }

        public GeoRenderEvent getGeoRenderEvent() {
            return this.geoRenderEvent;
        }
    }

    @Override
    public boolean handle(GeoRenderEvent geoRenderEvent) {
        return NeoForge.EVENT_BUS.post(new NeoForgeGeoRenderEvent(geoRenderEvent)).hasResult();
    }
}