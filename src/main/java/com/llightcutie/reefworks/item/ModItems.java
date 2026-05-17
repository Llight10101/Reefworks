package com.llightcutie.reefworks.item;

import com.llightcutie.reefworks.Reefworks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item CORAL_BRUSH = registerItem("coral_brush", new CoralBrushItem(new Item.Properties().durability(24)));

    public static final Item BLEACHED_CORAL_FRAGMENT = registerItem("bleached_coral_fragment", new Item(new Item.Properties()));
    public static final Item POLYP_PASTE = registerItem("polyp_paste", new Item(new Item.Properties()));

    public static final Item CORAL_HEART_CORE = registerItem("coral_heart_core", new Item(new Item.Properties()));


    private static Item registerItem(String name, Item item) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, name);

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void registerModItems() {
        Reefworks.LOGGER.info("Registering Mod Items for " + Reefworks.MOD_ID);
    }
}
