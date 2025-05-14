v3.0.10

- Adds builder support for Alpha, fixing shader issue from previous update. Thanks daedelus_dev for the fix!
- Fixes scale not working for builders.
- Adds scale builders with context of the entity being rendered.

v3.0.9

- Adds Shoulder Surfing support for armor.

v3.0.8

- Now properly hide player outlayers on equipping armor.

v3.0.7

- Fixed AzID being copied to a new stack on menu creation, now ensures each item stack has it's own Az_ID.

v3.0.6

- Added support for AzAutoGlowlayer to support the glowing effect.
- Fixed MolangParser not being public, allowing easier registeration of custom Molang queries.
- Fixed MolangQueries#normalize not being public.
- Added full support for Bedrock lerp_mode easings/catmullRom.
- Added log for when missing _glowmask texture when using auto glow layer.
- Fixes animated textures being broken.
- Fixes animated textures not working with glowmask layers.

v3.0.5

- Fixes https://github.com/Sinytra/ItemAssetExporterMod/issues/4

v3.0.4

- Add CustomModelData support to AzArmorRendererRegistry - RazorPlay01
- Fixes missing NeoForge forge mixin update

v3.0.3

- Adds support for q.* Molang.
- Fixes useNewOffset for items not working when used.
- Implement preRenderEntry and postRenderEntry call backs to RenderConfigs, allowing you to inject code into the preRender and postRender stages.
- Implement getRenderType to RenderConfigs, as to make changing the render type easier.

v3.0.2

- Fixes a packet issue with calling cancelAll on an AzCommand from the server.

v3.0.1

- Fixed a missing method update for AzureLibCache for the new model/animation loading system.
- Fixed a missing mixin for item renders.

v3.0.0

- Rewrite Item animation system. See guide for converting here: https://moddedmc.wiki/en/project/azurelib/docs/updating/items
    - Fixes issue with Item animations not working the first time due to missing NBT tag check.
    - No longer have to supply a cache.
    - No longer have to use a GeoItem interface.
    - "Item" rendering/animating is now considered "ItemStack" rendering/animating.
    - No longer register the render in the Item.
        - This is done in your clients onInitializeClient for Fabric and NeoForges FMLClientSetupEvent using AzItemRendererRegistry#register.
- Rewrite Armor animation system. See guide for converting here: https://moddedmc.wiki/en/project/azurelib/docs/updating/armor
    - No longer have to supply a cache.
    - No longer have to use a GeoItem interface.
    - "Item" rendering/animating is now considered "ItemStack" rendering/animating.
    - No longer register the render in the Item.
        - This is done in your clients onInitializeClient for Fabric and NeoForges FMLClientSetupEvent using AzArmorRendererRegistry#register.
- No longer register the render in the Item.
      - This is done in your clients onInitializeClient for Fabric and NeoForges FMLClientSetupEvent using AzArmorRendererRegistry#register.
- Animations are now done fully using a trigger animation call from the Az<Type>Animator.
- New system fixes Animations not firing properly on Items on first use.
    - You have to now register your item in your mods onInitialize for Fabric and NeoForges FMLCommonSetupEvent using AzIdentityRegistry#register
        - AzIdentityRegistry#register can take 1 item or multiple if you have a lot of item.
- New system fixes Aniamtions not pausing correctly when in singleplayer. (Old system/Geckolib "pauses" it but it still ticks so doesn't hold the animations spot properly)
- New system fixes Animation triggers not working with armors.
- New system shows about a 40% drop in memory usage compared to old systems/Azurelib.
- Move to new Az Naming scheme from Geo
- Fixes crash with Minecolonies when using new render.