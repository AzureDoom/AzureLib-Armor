package mod.azure.azurelibarmor.rewrite.render.layer;

import mod.azure.azurelibarmor.rewrite.model.AzBone;
import mod.azure.azurelibarmor.rewrite.render.AzRendererPipelineContext;
import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorRendererPipelineContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.ArmorTrim;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.function.Function;

public class AzArmorTrimLayer<T> implements AzRenderLayer<T> {
    public final ResourceLocation textureBaseLocation;
    public final Function<ArmorTrim, ResourceLocation> texturePermutations;

    public AzArmorTrimLayer(ResourceLocation baseTexture) {
        this(baseTexture, true);
    }

    public AzArmorTrimLayer(ResourceLocation baseTexture, boolean supportPatterns) {
        this(baseTexture, supportPatterns
                ? (trim) -> {
                    var pattern = trim.pattern().value();
                    var material = trim.material().value();
                    var patternName = pattern.assetId().getPath();
                    return ResourceLocation.fromNamespaceAndPath(baseTexture.getNamespace(), baseTexture.getPath() + "_" + patternName + "_" + material.assetName());
                }
                : (trim) -> {
                    var material = trim.material().value();
                    return ResourceLocation.fromNamespaceAndPath(baseTexture.getNamespace(), baseTexture.getPath() + "_" + material.assetName());
                }
        );
    }

    public AzArmorTrimLayer(ResourceLocation baseTexture, Function<ArmorTrim, ResourceLocation> textureLocationPermutations) {
        this.textureBaseLocation = baseTexture;
        this.texturePermutations = textureLocationPermutations;
    }

    public void preRender(AzRendererPipelineContext<T> context) {
    }

    public void render(AzRendererPipelineContext<T> context) {
        var armorPipelineContext = (AzArmorRendererPipelineContext) context;
        var itemstack = armorPipelineContext.currentStack();
        if (itemstack == null) {
            return;
        }
        ArmorTrim armorTrim = itemstack.get(DataComponents.TRIM);
        if (armorTrim == null) {
            return;
        }

        var pattern = armorTrim.pattern().value();

        var bakery = Minecraft.getInstance().getModelManager();
        var armorTrimsAtlas = bakery.getAtlas(Sheets.ARMOR_TRIMS_SHEET); // Any way to get this from context?

        var renderPipeline = context.rendererPipeline();
        ResourceLocation trimLocation = texturePermutations.apply(armorTrim);

        TextureAtlasSprite sprite = armorTrimsAtlas.getSprite(trimLocation);
        var renderType = Sheets.armorTrimsSheet(pattern.decal());
        VertexConsumer vertexConsumer = sprite.wrap(context.multiBufferSource().getBuffer(renderType));

        if (context.renderType() != null) {
            RenderType prevRenderType = context.renderType();
            VertexConsumer prevVertexConsumer = context.vertexConsumer();
            context.setRenderType(renderType);
            context.setVertexConsumer(vertexConsumer);
            renderPipeline.reRender(context);
            context.setRenderType(prevRenderType);
            context.setVertexConsumer(prevVertexConsumer);
        }
    }

    @Override
    public void renderForBone(AzRendererPipelineContext<T> azRendererPipelineContext, AzBone azBone) {
    }
}
