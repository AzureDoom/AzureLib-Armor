v3.0.20

### Fixes
- Fixed a crash with context on armors.

v3.0.19

### Changes
- Added logger to AutoGlowingTexture if its glow mask doesn't match the base texture size.
- Changes to AzAnimator to add support for stopping the animation timer
- Introduced setRenderEntry in AzRendererConfig.Builder to allow custom rendering logic during the render stage.
- Ported all AzArmor and Item Render related changes/fixes from the main source.
- Removed the need for AzIdentityRegistry#register to be called.
- Added `AzArmorTrimLayer` for rendering armor trims (Credit to ZsoltMolnarrr)
    - Supports single trim-pattern texture
    - Supports per pattern textures (like vanilla)
- Added alpha value to getDefaultRenderType

### Fixes
- Fixed an issue where broken JSON files would cause the game to fail to load properly, these are now auto-skipped and logged.