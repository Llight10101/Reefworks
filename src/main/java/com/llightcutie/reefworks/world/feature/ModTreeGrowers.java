package com.llightcutie.reefworks.world.feature;

import com.llightcutie.reefworks.Reefworks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {

    public static final TreeGrower TUBE_CORAL = new TreeGrower(
            "tube_coral",
            Optional.empty(),
            Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "tube_coral_growth"))),
            Optional.empty()
    );

    public static final TreeGrower BRAIN_CORAL = new TreeGrower(
            "brain_coral",
            Optional.empty(),
            Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "brain_coral_growth"))),
            Optional.empty()
    );

    public static final TreeGrower BUBBLE_CORAL = new TreeGrower(
            "bubble_coral",
            Optional.empty(),
            Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "bubble_coral_growth"))),
            Optional.empty()
    );

    public static final TreeGrower FIRE_CORAL = new TreeGrower(
            "fire_coral",
            Optional.empty(),
            Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "fire_coral_growth"))),
            Optional.empty()
    );

    public static final TreeGrower HORN_CORAL = new TreeGrower(
            "horn_coral",
            Optional.empty(),
            Optional.of(ResourceKey.create(Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "horn_coral_growth"))),
            Optional.empty()
    );
}