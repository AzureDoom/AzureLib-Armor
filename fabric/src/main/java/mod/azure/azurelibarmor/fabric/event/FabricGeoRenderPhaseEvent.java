package mod.azure.azurelibarmor.fabric.event;

import mod.azure.azurelibarmor.common.internal.common.event.GeoRenderEvent;
import mod.azure.azurelibarmor.common.platform.services.GeoRenderPhaseEventFactory;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

/**
 * @author Boston Vanseghi
 */
public class FabricGeoRenderPhaseEvent implements GeoRenderPhaseEventFactory.GeoRenderPhaseEvent {

    private final Event<Listener> event = EventFactory.createArrayBacked(
            Listener.class,
            event -> true,
            listeners -> event -> {
                for (Listener listener : listeners) {
                    if (!listener.handle(event))
                        return false;
                }

                return true;
            }
    );

    @Override
    public boolean handle(GeoRenderEvent geoRenderEvent) {
        return this.event.invoker().handle(geoRenderEvent);
    }

    @FunctionalInterface
    interface Listener {

        boolean handle(GeoRenderEvent event);
    }
}
