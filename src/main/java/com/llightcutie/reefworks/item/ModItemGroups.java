package com.llightcutie.reefworks.item;

import com.llightcutie.reefworks.Reefworks;
import com.llightcutie.reefworks.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final CreativeModeTab REEFWORKS_BLOCKS = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "reefworks_blocks"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.reefworks.reefworks_blocks")).icon(() -> new ItemStack(ModBlocks.CORAL_HEART_BLOCK))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.CORAL_HEART_BLOCK);
                    })
                    .build());

    public static final CreativeModeTab REEFWORKS_TOOLS = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "reefworks_tools"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.reefworks.reefworks_tools")).icon(() -> new ItemStack(ModItems.CORAL_BRUSH))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.CORAL_BRUSH);
                    })
                    .build());

    public static final CreativeModeTab REEFWORKS_ORGANICS = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "reefwork_organics"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.reefworks.reefworks_organics")).icon(() -> new ItemStack(ModItems.POLYP_SAMPLE))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.POLYP_SAMPLE);
                        output.accept(ModItems.ALTERED_POLYP_SAMPLE);
                    })
                    .build());


    public static void registerItemGroups() {
        Reefworks.LOGGER.info("Registering Item Groups for " + Reefworks.MOD_ID);
    }
}
