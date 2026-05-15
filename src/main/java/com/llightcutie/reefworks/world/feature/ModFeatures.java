package com.llightcutie.reefworks.world.feature;

import com.llightcutie.reefworks.Reefworks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ModFeatures {

    public static final Feature<CoralGrowthConfig> CORAL_GROWTH = Registry.register(
            BuiltInRegistries.FEATURE,
            ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "coral_growth"),
            new CoralGrowthFeature(CoralGrowthConfig.CODEC)
    );

    public static void registerModFeatures() {
        Reefworks.LOGGER.info("Registering Mod Features for " + Reefworks.MOD_ID);
    }
}