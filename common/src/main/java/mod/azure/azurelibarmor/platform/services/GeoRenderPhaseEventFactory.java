package mod.azure.azurelibarmor.platform.services;

import mod.azure.azurelibarmor.event.GeoRenderEvent;

public interface GeoRenderPhaseEventFactory {

    interface GeoRenderPhaseEvent {
        boolean handle(GeoRenderEvent geoRenderEvent);
    }

    GeoRenderPhaseEvent create();
}
