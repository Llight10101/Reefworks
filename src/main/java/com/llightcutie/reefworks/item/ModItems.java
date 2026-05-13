package com.llightcutie.reefworks.item;

import com.llightcutie.reefworks.Reefworks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item CORAL_BRUSH = registerItem("coral_brush", new Item(new Item.Properties()));
    public static final Item POLYP_SAMPLE = registerItem("polyp_sample", new Item(new Item.Properties()));


    private static Item registerItem(String name, Item item) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, name);

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void registerModItems() {
        Reefworks.LOGGER.info("Registering Mod Items for " + Reefworks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(ModItems.CORAL_BRUSH);
            entries.accept(ModItems.POLYP_SAMPLE);
        });
    }
}