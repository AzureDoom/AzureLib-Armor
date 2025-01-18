package mod.azure.azurelibarmor.rewrite.animation.event;

import mod.azure.azurelibarmor.core.keyframe.event.data.CustomInstructionKeyframeData;
import mod.azure.azurelibarmor.rewrite.animation.controller.AzAnimationController;
import mod.azure.azurelibarmor.rewrite.animation.controller.keyframe.AzKeyframeCallbacks;

/**
 * The {@link AzKeyframeEvent} specific to the {@link AzKeyframeCallbacks#customKeyframeHandler()}.<br>
 * Called when a custom instruction keyframe is encountered
 */
public class AzCustomInstructionKeyframeEvent<T> extends AzKeyframeEvent<T, CustomInstructionKeyframeData> {

    public AzCustomInstructionKeyframeEvent(
        T entity,
        double animationTick,
        AzAnimationController<T> controller,
        CustomInstructionKeyframeData customInstructionKeyframeData
    ) {
        super(entity, animationTick, controller, customInstructionKeyframeData);
    }

    /**
     * Get the {@link CustomInstructionKeyframeData} relevant to this event call
     */
    @Override
    public CustomInstructionKeyframeData getKeyframeData() {
        return super.getKeyframeData();
    }
}
