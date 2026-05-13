package com.llightcutie.reefworks.block;

import com.llightcutie.reefworks.Reefworks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

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

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.accept(ModBlocks.CORAL_HEART_BLOCK);
        });
    }
}