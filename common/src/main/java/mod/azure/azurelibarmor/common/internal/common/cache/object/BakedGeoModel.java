/**
 * This class is a fork of the matching class found in the Geckolib repository.
 * Original source: https://github.com/bernie-g/geckolib
 * Copyright © 2024 Bernie-G.
 * Licensed under the MIT License.
 * https://github.com/bernie-g/geckolib/blob/main/LICENSE
 */
package mod.azure.azurelibarmor.common.internal.common.cache.object;

import mod.azure.azurelibarmor.core.animatable.model.CoreBakedGeoModel;
import mod.azure.azurelibarmor.core.animatable.model.CoreGeoBone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Baked model object for azurelibarmor models.
 */
public class BakedGeoModel implements CoreBakedGeoModel {

    public final Map<String, GeoBone> bonesByName;

    public final List<GeoBone> topLevelBones;

    public BakedGeoModel(List<GeoBone> topLevelBones) {
        this.bonesByName = new HashMap<>();
        this.topLevelBones = topLevelBones;
        mapBonesByName(topLevelBones);
    }

    private void mapBonesByName(List<GeoBone> geoBones) {
        geoBones.forEach(geoBone -> {
            bonesByName.put(geoBone.getName(), geoBone);
            mapBonesByName(geoBone.getChildBones());
        });
    }

    /**
     * Gets the list of top-level bones for this model. Identical to calling {@link BakedGeoModel#getTopLevelBones()}
     */
    @Override
    public List<? extends CoreGeoBone> getBones() {
        return this.topLevelBones;
    }

    /**
     * Gets a bone from this model by name.<br>
     *
     * @param name The name of the bone
     * @return An {@link Optional} containing the {@link GeoBone} if one matches, otherwise an empty Optional
     */
    public Optional<GeoBone> getBone(String name) {
        return Optional.ofNullable(bonesByName.get(name));
    }

    public List<GeoBone> getTopLevelBones() {
        return topLevelBones;
    }
}
