package com.auk.meme.util;

import com.auk.meme.block.ModBlocks;
import com.auk.meme.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();

    }
    private static void registerFuels(){ //注册燃料
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.P,200);
        registry.add(ModBlocks.P_BLOCK,2000);
    }
}
