package mod.azure.azurelibarmor.common.internal.common.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;

import mod.azure.azurelibarmor.common.internal.common.constant.DataTickets;
import mod.azure.azurelibarmor.common.internal.common.loading.object.BakedModelFactory;
import mod.azure.azurelibarmor.common.internal.common.network.SerializableDataTicket;
import mod.azure.azurelibarmor.core.animatable.GeoAnimatable;
import mod.azure.azurelibarmor.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelibarmor.core.animatable.instance.InstancedAnimatableInstanceCache;
import mod.azure.azurelibarmor.core.animatable.instance.SingletonAnimatableInstanceCache;
import mod.azure.azurelibarmor.core.animation.Animation;
import mod.azure.azurelibarmor.core.animation.EasingType;
import mod.azure.azurelibarmor.core.object.DataTicket;

/**
 * Helper class for various azurelibarmor-specific functions.
 */
public record AzureLibUtil() {

    public static <T> T self(Object object) {
        return (T) object;
    }

    /**
     * Creates a new AnimatableInstanceCache for the given animatable object
     *
     * @param animatable The animatable object
     */
    public static AnimatableInstanceCache createInstanceCache(GeoAnimatable animatable) {
        AnimatableInstanceCache cache = animatable.animatableCacheOverride();

        return cache != null
            ? cache
            : createInstanceCache(
                animatable,
                !(animatable instanceof Entity) && !(animatable instanceof BlockEntity)
            );
    }

    /**
     * Creates a new AnimatableInstanceCache for the given animatable object. <br>
     * Recommended to use {@link AzureLibUtil#createInstanceCache(GeoAnimatable)} unless you know what you're doing.
     *
     * @param animatable      The animatable object
     * @param singletonObject Whether the object is a singleton/flyweight object, and uses ints to differentiate
     *                        animatable instances
     */
    public static AnimatableInstanceCache createInstanceCache(GeoAnimatable animatable, boolean singletonObject) {
        AnimatableInstanceCache cache = animatable.animatableCacheOverride();

        if (cache != null)
            return cache;

        return singletonObject
            ? new SingletonAnimatableInstanceCache(
                animatable
            )
            : new InstancedAnimatableInstanceCache(animatable);
    }

    /**
     * Register a custom {@link Animation.LoopType} with azurelibarmor, allowing for dynamic handling of post-animation
     * looping.<br>
     * <b><u>MUST be called during mod construct</u></b><br>
     *
     * @param name     The name of the {@code LoopType} handler
     * @param loopType The {@code LoopType} implementation to use for the given name
     */
    public static synchronized Animation.LoopType addCustomLoopType(String name, Animation.LoopType loopType) {
        return Animation.LoopType.register(name, loopType);
    }

    /**
     * Register a custom {@link EasingType} with azurelibarmor, allowing for dynamic handling of animation transitions
     * and curves.<br>
     * <b><u>MUST be called during mod construct</u></b><br>
     *
     * @param name       The name of the {@code EasingType} handler
     * @param easingType The {@code EasingType} implementation to use for the given name
     */
    public static synchronized EasingType addCustomEasingType(String name, EasingType easingType) {
        return EasingType.register(name, easingType);
    }

    /**
     * Register a custom {@link BakedModelFactory} with azurelibarmor, allowing for dynamic handling of geo model
     * loading.<br>
     * <b><u>MUST be called during mod construct</u></b><br>
     *
     * @param namespace The namespace (modid) to register the factory for
     * @param factory   The factory responsible for model loading under the given namespace
     */
    public static synchronized void addCustomBakedModelFactory(String namespace, BakedModelFactory factory) {
        BakedModelFactory.register(namespace, factory);
    }

    /**
     * Register a custom {@link SerializableDataTicket} with azurelibarmor for handling custom data transmission.<br>
     * NOTE: You do not need to register non-serializable {@link DataTicket DataTickets}.
     *
     * @param dataTicket The SerializableDataTicket to register
     * @return The dataTicket you passed in
     */
    public static synchronized <D> SerializableDataTicket<D> addDataTicket(SerializableDataTicket<D> dataTicket) {
        return DataTickets.registerSerializable(dataTicket);
    }

}
