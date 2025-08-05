package mod.azure.azurelibarmor.rewrite.animation.dispatch.command.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import mod.azure.azurelibarmor.rewrite.animation.dispatch.command.stage.AzAnimationStage;
import mod.azure.azurelibarmor.rewrite.animation.easing.AzEasingTypes;
import mod.azure.azurelibarmor.rewrite.animation.play_behavior.AzPlayBehaviors;
import mod.azure.azurelibarmor.rewrite.animation.property.AzAnimationStageProperties;

public class AzAnimationSequenceBuilder {

    private final List<AzAnimationStage> stages;

    public AzAnimationSequenceBuilder() {
        this.stages = new ArrayList<>();
    }

    public AzAnimationSequenceBuilder queue(String animationName) {
        stages.add(new AzAnimationStage(animationName, AzAnimationStageProperties.EMPTY));
        return this;
    }

    public AzAnimationSequenceBuilder queue(
        String animationName,
        UnaryOperator<AzAnimationStageProperties> builderUnaryOperator
    ) {
        var properties = builderUnaryOperator.apply(AzAnimationStageProperties.EMPTY);
        stages.add(new AzAnimationStage(animationName, properties));
        return this;
    }

    public AzAnimationSequence build() {
        return new AzAnimationSequence(stages);
    }
}
