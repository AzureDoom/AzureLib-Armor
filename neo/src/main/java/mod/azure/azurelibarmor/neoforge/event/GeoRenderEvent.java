package mod.azure.azurelibarmor.neoforge.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import org.jetbrains.annotations.Nullable;

import mod.azure.azurelibarmor.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelibarmor.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelibarmor.common.api.client.renderer.layer.GeoRenderLayer;
import mod.azure.azurelibarmor.common.api.common.animatable.GeoItem;
import mod.azure.azurelibarmor.common.internal.client.renderer.GeoRenderer;
import mod.azure.azurelibarmor.common.internal.common.cache.object.BakedGeoModel;

@Deprecated(forRemoval = true)
public interface GeoRenderEvent {

    /**
     * Returns the renderer for this event
     *
     * @see GeoArmorRenderer GeoArmorRenderer
     * @see GeoItem GeoItem
     */
    GeoRenderer<?> getRenderer();

    /**
     * Renderer events for armor pieces being rendered by {@link GeoArmorRenderer}
     */
    abstract class Armor extends Event implements GeoRenderEvent {

        private final GeoArmorRenderer<?> renderer;

        public Armor(GeoArmorRenderer<?> renderer) {
            this.renderer = renderer;
        }

        /**
         * Returns the renderer for this event
         */
        @Override
        public GeoArmorRenderer<?> getRenderer() {
            return this.renderer;
        }

        /**
         * Shortcut method for retrieving the entity being rendered
         */
        @Nullable
        public net.minecraft.world.entity.Entity getEntity() {
            return getRenderer().getCurrentEntity();
        }

        /**
         * Shortcut method for retrieving the ItemStack relevant to the armor piece being rendered
         */
        @Nullable
        public ItemStack getItemStack() {
            return getRenderer().getCurrentStack();
        }

        /**
         * Shortcut method for retrieving the equipped slot of the armor piece being rendered
         */
        @Nullable
        public EquipmentSlot getEquipmentSlot() {
            return getRenderer().getCurrentSlot();
        }

        /**
         * Pre-render event for armor pieces being rendered by {@link GeoArmorRenderer}
         * <p>
         * This event is called before rendering, but after {@link GeoRenderer#preRender}
         * <p>
         * This event is Cancelable<br>
         * If the event is cancelled, the armor piece will not be rendered and the corresponding {@link Post} event will
         * not be fired.
         */
        public static class Pre extends Armor implements ICancellableEvent {

            private final PoseStack poseStack;

            private final BakedGeoModel model;

            private final MultiBufferSource bufferSource;

            private final float partialTick;

            private final int packedLight;

            public Pre(
                GeoArmorRenderer<?> renderer,
                PoseStack poseStack,
                BakedGeoModel model,
                MultiBufferSource bufferSource,
                float partialTick,
                int packedLight
            ) {
                super(renderer);

                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /**
         * <p>
         * This event is called after {@link GeoRenderer#postRender}
         */
        public static class Post extends Armor {

            private final PoseStack poseStack;

            private final BakedGeoModel model;

            private final MultiBufferSource bufferSource;

            private final float partialTick;

            private final int packedLight;

            public Post(
                GeoArmorRenderer<?> renderer,
                PoseStack poseStack,
                BakedGeoModel model,
                MultiBufferSource bufferSource,
                float partialTick,
                int packedLight
            ) {
                super(renderer);

                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /**
         * One-time event for a {@link GeoArmorRenderer} called on first initialisation
         * <p>
         * Use this event to add render layers to the renderer as needed
         */
        public static class CompileRenderLayers extends Armor {

            public CompileRenderLayers(GeoArmorRenderer<?> renderer) {
                super(renderer);
            }

            /**
             * Adds a {@link GeoRenderLayer} to the renderer
             * <p>
             * Type-safety is not checked here, so ensure that your layer is compatible with this animatable and
             * renderer
             */
            public void addLayer(GeoRenderLayer renderLayer) {
                getRenderer().addRenderLayer(renderLayer);
            }
        }
    }

    /**
     * Renderer events for {@link ItemStack Items} being rendered by {@link GeoItemRenderer}
     */
    abstract class Item extends Event implements GeoRenderEvent {

        private final GeoItemRenderer<?> renderer;

        public Item(GeoItemRenderer<?> renderer) {
            this.renderer = renderer;
        }

        /**
         * Returns the renderer for this event
         */
        @Override
        public GeoItemRenderer<?> getRenderer() {
            return this.renderer;
        }

        /**
         * Shortcut method for retrieving the ItemStack being rendered
         */
        public ItemStack getItemStack() {
            return getRenderer().getCurrentItemStack();
        }

        /**
         * Pre-render event for armor being rendered by {@link GeoItemRenderer}
         * <p>
         * This event is called before rendering, but after {@link GeoRenderer#preRender}
         * <p>
         * This event is Cancelable<br>
         * If the event is cancelled, the ItemStack will not be rendered and the corresponding {@link Post} event will
         * not be fired.
         */
        public static class Pre extends Item implements ICancellableEvent {

            private final PoseStack poseStack;

            private final BakedGeoModel model;

            private final MultiBufferSource bufferSource;

            private final float partialTick;

            private final int packedLight;

            public Pre(
                GeoItemRenderer<?> renderer,
                PoseStack poseStack,
                BakedGeoModel model,
                MultiBufferSource bufferSource,
                float partialTick,
                int packedLight
            ) {
                super(renderer);

                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /**
         * Post-render event for ItemStacks being rendered by {@link GeoItemRenderer}
         * <p>
         * This event is called after {@link GeoRenderer#postRender}
         */
        public static class Post extends Item {

            private final PoseStack poseStack;

            private final BakedGeoModel model;

            private final MultiBufferSource bufferSource;

            private final float partialTick;

            private final int packedLight;

            public Post(
                GeoItemRenderer<?> renderer,
                PoseStack poseStack,
                BakedGeoModel model,
                MultiBufferSource bufferSource,
                float partialTick,
                int packedLight
            ) {
                super(renderer);

                this.poseStack = poseStack;
                this.model = model;
                this.bufferSource = bufferSource;
                this.partialTick = partialTick;
                this.packedLight = packedLight;
            }

            public PoseStack getPoseStack() {
                return this.poseStack;
            }

            public BakedGeoModel getModel() {
                return this.model;
            }

            public MultiBufferSource getBufferSource() {
                return this.bufferSource;
            }

            public float getPartialTick() {
                return this.partialTick;
            }

            public int getPackedLight() {
                return this.packedLight;
            }
        }

        /**
         * One-time event for a {@link GeoItemRenderer} called on first initialisation
         * <p>
         * Use this event to add render layers to the renderer as needed
         */
        public static class CompileRenderLayers extends Item {

            public CompileRenderLayers(GeoItemRenderer<?> renderer) {
                super(renderer);
            }

            /**
             * Adds a {@link GeoRenderLayer} to the renderer
             * <p>
             * Type-safety is not checked here, so ensure that your layer is compatible with this animatable and
             * renderer
             */
            public void addLayer(GeoRenderLayer renderLayer) {
                getRenderer().addRenderLayer(renderLayer);
            }
        }
    }
}
