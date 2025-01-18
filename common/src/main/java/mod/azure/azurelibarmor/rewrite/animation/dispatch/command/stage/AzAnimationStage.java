package mod.azure.azurelibarmor.rewrite.animation.dispatch.command.stage;
import mod.azure.azurelibarmor.rewrite.animation.property.AzAnimationStageProperties;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record AzAnimationStage(
    String name,
    AzAnimationStageProperties properties
) {

    public static final StreamCodec<FriendlyByteBuf, AzAnimationStage> CODEC = StreamCodec.composite(
        ByteBufCodecs.STRING_UTF8,
        AzAnimationStage::name,
        AzAnimationStageProperties.CODEC,
        AzAnimationStage::properties,
        AzAnimationStage::new
    );

}
