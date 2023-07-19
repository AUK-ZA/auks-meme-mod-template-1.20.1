package com.auk.meme;

import com.auk.meme.block.ModBlocks;
import com.auk.meme.item.ModItemGroups;
import com.auk.meme.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemeMod implements ModInitializer {
	public static final String MOD_ID = "auks-meme-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {		//初始化
		LOGGER.info("Hello AUK world");
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}