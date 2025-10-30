package mod.azure.azurelibarmor.common.animation.dispatch.command.action.impl.controller;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

import mod.azure.azurelibarmor.AzureLib;
import mod.azure.azurelibarmor.common.animation.AzAnimator;
import mod.azure.azurelibarmor.common.animation.dispatch.AzDispatchSide;
import mod.azure.azurelibarmor.common.animation.dispatch.command.action.AzAction;

public record AzControllerSetTransitionSpeedAction(
    String controllerName,
    float transitionSpeed
) implements AzAction {

    public static final StreamCodec<FriendlyByteBuf, AzControllerSetTransitionSpeedAction> CODEC = StreamCodec
        .composite(
            ByteBufCodecs.STRING_UTF8,
            AzControllerSetTransitionSpeedAction::controllerName,
            ByteBufCodecs.FLOAT,
            AzControllerSetTransitionSpeedAction::transitionSpeed,
            AzControllerSetTransitionSpeedAction::new
        );

    public static final ResourceLocation RESOURCE_LOCATION = AzureLib.modResource("controller/set_transition_speed");

    @Override
    public void handle(AzDispatchSide originSide, AzAnimator<?, ?> animator) {
        var controller = animator.getAnimationControllerContainer().getOrNull(controllerName);

        if (controller != null) {
            controller.setAnimationProperties(controller.animationProperties().withTransitionLength(transitionSpeed));
        }
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return RESOURCE_LOCATION;
    }
}
