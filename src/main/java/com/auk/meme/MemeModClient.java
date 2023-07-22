package com.auk.meme;

import com.auk.meme.block.ModBlocks;
import com.auk.meme.item.ModItemGroups;
import com.auk.meme.item.ModItems;
import com.auk.meme.sound.ModSounds;
import net.fabricmc.api.ClientModInitializer;

public class MemeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MemeMod.LOGGER.info("初始化客户端");

    }
}

