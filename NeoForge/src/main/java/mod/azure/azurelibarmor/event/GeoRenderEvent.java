package mod.azure.azurelibarmor.event;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;

import mod.azure.azurelibarmor.cache.object.BakedGeoModel;
import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import mod.azure.azurelibarmor.renderer.GeoItemRenderer;
import mod.azure.azurelibarmor.renderer.GeoRenderer;
import mod.azure.azurelibarmor.renderer.layer.GeoRenderLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

/**
 * AzureLib events base-class for the various event stages of rendering.<br>
 * These are fired on the {@link net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus FORGE} mod bus
 */
public interface GeoRenderEvent {
	/**
	 * Returns the renderer for this event
	 * 
	 * @see mod.azure.azurelibarmor.renderer.GeoArmorRenderer GeoArmorRenderer
	 * @see mod.azure.azurelibarmor.animatable.GeoItem GeoItem
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
		 * Pre-render event for armor pieces being rendered by {@link GeoArmorRenderer}.<br>
		 * This event is called before rendering, but after {@link GeoRenderer#preRender}<br>
		 * <br>
		 * This event is {@link Cancelable}.<br>
		 * If the event is cancelled, the armor piece will not be rendered and the corresponding {@link Post} event will not be fired.
		 */
		@Cancelable
		public static class Pre extends Armor {
			private final PoseStack poseStack;
			private final BakedGeoModel model;
			private final MultiBufferSource bufferSource;
			private final float partialTick;
			private final int packedLight;

			public Pre(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
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
		 * Post-render event for armor pieces being rendered by {@link GeoEntityRenderer}.<br>
		 * This event is called after {@link GeoRenderer#postRender}
		 */
		public static class Post extends Armor {
			private final PoseStack poseStack;
			private final BakedGeoModel model;
			private final MultiBufferSource bufferSource;
			private final float partialTick;
			private final int packedLight;

			public Post(GeoArmorRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
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
		 * One-time event for a {@link GeoArmorRenderer} called on first initialisation.<br>
		 * Use this event to add render layers to the renderer as needed
		 */
		public static class CompileRenderLayers extends Armor {
			public CompileRenderLayers(GeoArmorRenderer<?> renderer) {
				super(renderer);
			}

			/**
			 * Adds a {@link GeoRenderLayer} to the renderer.<br>
			 * Type-safety is not checked here, so ensure that your layer is compatible with this animatable and renderer
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
		 * Pre-render event for armor being rendered by {@link GeoItemRenderer}.<br>
		 * This event is called before rendering, but after {@link GeoRenderer#preRender}<br>
		 * <br>
		 * This event is {@link Cancelable}.<br>
		 * If the event is cancelled, the ItemStack will not be rendered and the corresponding {@link Post} event will not be fired.
		 */
		@Cancelable
		public static class Pre extends Item {
			private final PoseStack poseStack;
			private final BakedGeoModel model;
			private final MultiBufferSource bufferSource;
			private final float partialTick;
			private final int packedLight;

			public Pre(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
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
		 * Post-render event for ItemStacks being rendered by {@link GeoItemRenderer}.<br>
		 * This event is called after {@link GeoRenderer#postRender}
		 */
		public static class Post extends Item {
			private final PoseStack poseStack;
			private final BakedGeoModel model;
			private final MultiBufferSource bufferSource;
			private final float partialTick;
			private final int packedLight;

			public Post(GeoItemRenderer<?> renderer, PoseStack poseStack, BakedGeoModel model, MultiBufferSource bufferSource, float partialTick, int packedLight) {
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
		 * One-time event for a {@link GeoItemRenderer} called on first initialisation.<br>
		 * Use this event to add render layers to the renderer as needed
		 */
		public static class CompileRenderLayers extends Item {
			public CompileRenderLayers(GeoItemRenderer<?> renderer) {
				super(renderer);
			}

			/**
			 * Adds a {@link GeoRenderLayer} to the renderer.<br>
			 * Type-safety is not checked here, so ensure that your layer is compatible with this animatable and renderer
			 */
			public void addLayer(GeoRenderLayer renderLayer) {
				getRenderer().addRenderLayer(renderLayer);
			}
		}
	}
}
