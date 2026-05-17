package com.llightcutie.reefworks.block;

import com.llightcutie.reefworks.Reefworks;
import com.llightcutie.reefworks.world.feature.ModTreeGrowers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModBlocks {
    public static final Block CORAL_HEART_BLOCK = registerBlock("coral_heart_block",
            new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.CORAL_BLOCK)
                    .noOcclusion()
                    .randomTicks()
                    .lightLevel(state -> 10)
            ));

    public static final Block DEAD_TUBE_POLYP_SAMPLE = registerBlock("dead_tube_polyp_sample",
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)
            ));

    public static final Block DEAD_BRAIN_POLYP_SAMPLE = registerBlock("dead_brain_polyp_sample",
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)
            ));

    public static final Block DEAD_BUBBLE_POLYP_SAMPLE = registerBlock("dead_bubble_polyp_sample",
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)
            ));

    public static final Block DEAD_FIRE_POLYP_SAMPLE = registerBlock("dead_fire_polyp_sample",
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)
            ));

    public static final Block DEAD_HORN_POLYP_SAMPLE = registerBlock("dead_horn_polyp_sample",
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)
            ));

    public static final Block TUBE_POLYP_SAMPLE = registerBlock("tube_polyp_sample",
            new PolypGrowthBlock(ModTreeGrowers.TUBE_CORAL, ModBlocks.DEAD_TUBE_POLYP_SAMPLE, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(state -> 8)
            ));

    public static final Block BRAIN_POLYP_SAMPLE = registerBlock("brain_polyp_sample",
            new PolypGrowthBlock(ModTreeGrowers.BRAIN_CORAL, ModBlocks.DEAD_BRAIN_POLYP_SAMPLE, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(state -> 8)
            ));

    public static final Block BUBBLE_POLYP_SAMPLE = registerBlock("bubble_polyp_sample",
            new PolypGrowthBlock(ModTreeGrowers.BUBBLE_CORAL, ModBlocks.DEAD_BUBBLE_POLYP_SAMPLE, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(state -> 8)
            ));

    public static final Block FIRE_POLYP_SAMPLE = registerBlock("fire_polyp_sample",
            new PolypGrowthBlock(ModTreeGrowers.FIRE_CORAL, ModBlocks.DEAD_FIRE_POLYP_SAMPLE, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(state -> 8)
            ));

    public static final Block HORN_POLYP_SAMPLE = registerBlock("horn_polyp_sample",
            new PolypGrowthBlock(ModTreeGrowers.HORN_CORAL, ModBlocks.DEAD_HORN_POLYP_SAMPLE, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.WET_GRASS)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(state -> 8)
            ));

    public static final Block TUBE_POLYP_LANTERN = registerBlock("tube_polyp_lantern",
            new LanternBlock(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.METAL)
                            .forceSolidOn()
                            .requiresCorrectToolForDrops()
                            .strength(3.5F)
                            .sound(SoundType.LANTERN)
                            .lightLevel(blockStatex -> 13)
                            .noOcclusion()
                            .pushReaction(PushReaction.DESTROY)
            )
    );

    public static final Block BRAIN_POLYP_LANTERN = registerBlock("brain_polyp_lantern",
            new LanternBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightLevel(blockStatex -> 13)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
            )
    );

    public static final Block BUBBLE_POLYP_LANTERN = registerBlock("bubble_polyp_lantern",
            new LanternBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightLevel(blockStatex -> 13)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
            )
    );

    public static final Block FIRE_POLYP_LANTERN = registerBlock("fire_polyp_lantern",
            new LanternBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightLevel(blockStatex -> 13)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
            )
    );

    public static final Block HORN_POLYP_LANTERN = registerBlock("horn_polyp_lantern",
            new LanternBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightLevel(blockStatex -> 13)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
            )
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);

        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, name),
                new BlockItem(block, new Item.Properties())
        );
    }

    public static void registerModBlocks() {
        Reefworks.LOGGER.info("Registering Mod Blocks for " + Reefworks.MOD_ID);
    }
}