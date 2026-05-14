package com.llightcutie.reefworks.util;

import com.llightcutie.reefworks.Reefworks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final TagKey<Block> BRUSHABLE_CORALS = TagKey.create
            (Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "coral/brushable_corals"));

}
