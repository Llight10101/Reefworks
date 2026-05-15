package com.llightcutie.reefworks;

import com.llightcutie.reefworks.block.ModBlocks;
import com.llightcutie.reefworks.item.ModItemGroups;
import com.llightcutie.reefworks.item.ModItems;
import com.llightcutie.reefworks.world.feature.ModFeatures;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reefworks implements ModInitializer {
	public static final String MOD_ID = "reefworks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModFeatures.registerModFeatures();
	}
}