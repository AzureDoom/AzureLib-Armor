package mod.azure.azurelibarmor.common.internal.common.loading.object;

import mod.azure.azurelibarmor.core.animation.Animation;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Container object that holds a deserialized map of {@link Animation Animations}.<br>
 * Kept as a unique object so that it can be registered as a {@link com.google.gson.JsonDeserializer deserializer} for
 * {@link com.google.gson.Gson Gson}
 */
public record BakedAnimations(
        Map<String, Animation> animations,
        Map<String, ResourceLocation> includes
) {

    /**
     * Gets an {@link Animation} by its name, if present
     */
    @Nullable
    public Animation getAnimation(String name) {
        return animations.get(name);
    }

}
