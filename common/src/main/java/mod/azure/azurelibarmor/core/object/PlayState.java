/**
 * This class is a fork of the matching class found in the Geckolib repository.
 * Original source: https://github.com/bernie-g/geckolib
 * Copyright © 2024 Bernie-G.
 * Licensed under the MIT License.
 * https://github.com/bernie-g/geckolib/blob/main/LICENSE
 */
package mod.azure.azurelibarmor.core.object;

import mod.azure.azurelibarmor.core.animation.AnimationController;

/**
 * State enum to define whether an {@link AnimationController} should continue or stop
 */
public enum PlayState {
	CONTINUE,
	STOP
}
