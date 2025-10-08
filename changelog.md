v3.0.19

### Changes
- Added `AzArmorTrimLayer` for rendering armor trims
     - Supports single trim-pattern texture
     - Supports per pattern textures (like vanilla)

v3.0.18

### Changes
- Added new utility methods in ClientUtils.
    - getCurrentAnimationController(); Allows you to get the controller of the animated object.
    - getCurrentAnimationTick(); Allows you to get the current tick of the current animation.
    - getCurrentAnimationLength(); Allows you to get the length of the current animation.

### Fixes
- Fixed an issue where NeoForge would kill itself on packets.