package com.llightcutie.reefworks.item;

import com.llightcutie.reefworks.Reefworks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item CORAL_BRUSH = registerItem("coral_brush", new CoralBrushItem(new Item.Properties().durability(24)));

    public static final Item TUBE_POLYP_SAMPLE = registerItem("tube_polyp_sample", new Item(new Item.Properties()));
    public static final Item BRAIN_POLYP_SAMPLE = registerItem("brain_polyp_sample", new Item(new Item.Properties()));
    public static final Item BUBBLE_POLYP_SAMPLE = registerItem("bubble_polyp_sample", new Item(new Item.Properties()));
    public static final Item FIRE_POLYP_SAMPLE = registerItem("fire_polyp_sample", new Item(new Item.Properties()));
    public static final Item HORN_POLYP_SAMPLE = registerItem("horn_polyp_sample", new Item(new Item.Properties()));

    public static final Item DEAD_TUBE_POLYP_SAMPLE = registerItem("dead_tube_polyp_sample", new Item(new Item.Properties()));
    public static final Item DEAD_BRAIN_POLYP_SAMPLE = registerItem("dead_brain_polyp_sample", new Item(new Item.Properties()));
    public static final Item DEAD_BUBBLE_POLYP_SAMPLE = registerItem("dead_bubble_polyp_sample", new Item(new Item.Properties()));
    public static final Item DEAD_FIRE_POLYP_SAMPLE = registerItem("dead_fire_polyp_sample", new Item(new Item.Properties()));
    public static final Item DEAD_HORN_POLYP_SAMPLE = registerItem("dead_horn_polyp_sample", new Item(new Item.Properties()));

    public static final Item BLEACHED_CORAL_FRAGMENT = registerItem("bleached_coral_fragment", new Item(new Item.Properties()));

    public static final Item CORAL_HEART_CORE = registerItem("coral_heart_core", new Item(new Item.Properties()));


    private static Item registerItem(String name, Item item) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Reefworks.MOD_ID, name);

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void registerModItems() {
        Reefworks.LOGGER.info("Registering Mod Items for " + Reefworks.MOD_ID);
    }
}
