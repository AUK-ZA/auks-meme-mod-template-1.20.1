package com.auk.meme.block;


import com.auk.meme.MemeMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block TEST_BLOCK = registerBlock("test_block" ,
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));//创建方块实例

    public static Block registerBlock(String name , Block block){       //辅助方法注册方块
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(MemeMod.MOD_ID,name),block);
    }
    public static Item registerBlockItem(String name, Block block){         //辅助方法注册方块物品
        return Registry.register(Registries.ITEM,new Identifier(MemeMod.MOD_ID,name),
                new BlockItem(block,new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        MemeMod.LOGGER.info("注册方块for"+MemeMod.MOD_ID);

    }
}
