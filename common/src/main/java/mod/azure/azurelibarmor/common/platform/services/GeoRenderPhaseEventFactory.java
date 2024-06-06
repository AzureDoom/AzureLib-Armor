package mod.azure.azurelibarmor.common.platform.services;

import mod.azure.azurelibarmor.common.internal.common.event.GeoRenderEvent;

public interface GeoRenderPhaseEventFactory {

    GeoRenderPhaseEvent create();

    interface GeoRenderPhaseEvent {

        boolean handle(GeoRenderEvent geoRenderEvent);
    }
}
