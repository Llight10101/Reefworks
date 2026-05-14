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
    public static final CreativeModeTab REEFWORKS_CORE = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, "reefworks_core"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.reefworks.reefworks_core")).icon(() -> new ItemStack(ModBlocks.CORAL_HEART_BLOCK))
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
            FabricItemGroup.builder().title(Component.translatable("itemGroup.reefworks.reefworks_organics")).icon(() -> new ItemStack(ModBlocks.TUBE_POLYP_SAMPLE))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.TUBE_POLYP_SAMPLE);
                        output.accept(ModBlocks.BRAIN_POLYP_SAMPLE);
                        output.accept(ModBlocks.BUBBLE_POLYP_SAMPLE);
                        output.accept(ModBlocks.FIRE_POLYP_SAMPLE);
                        output.accept(ModBlocks.HORN_POLYP_SAMPLE);

                        output.accept(ModBlocks.DEAD_TUBE_POLYP_SAMPLE);
                        output.accept(ModBlocks.DEAD_BRAIN_POLYP_SAMPLE);
                        output.accept(ModBlocks.DEAD_BUBBLE_POLYP_SAMPLE);
                        output.accept(ModBlocks.DEAD_FIRE_POLYP_SAMPLE);
                        output.accept(ModBlocks.DEAD_HORN_POLYP_SAMPLE);

                        output.accept(ModItems.BLEACHED_CORAL_FRAGMENT);

                        output.accept(ModItems.CORAL_HEART_CORE);
                    })
                    .build());


    public static void registerItemGroups() {
        Reefworks.LOGGER.info("Registering Item Groups for " + Reefworks.MOD_ID);
    }
}
