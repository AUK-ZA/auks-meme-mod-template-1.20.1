package com.auk.meme.item;

import com.auk.meme.MemeMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TEST = registerItems("test",
            new Item(new FabricItemSettings()));//创建Test物品
    public static final Item MOUSE_HEAD = registerItems("mouse-head",
            new Item(new FabricItemSettings()));//创建物品
    public static final Item DUCK_NECK = registerItems("duck-neck",
            new Item(new FabricItemSettings().food(ModFoodComponents.DUCK_NECK)));//创建物品




    public static Item registerItems(String name, Item item){      //辅助方法注册物品
        return Registry.register(Registries.ITEM,new Identifier(MemeMod.MOD_ID,name),item);
    }

    public static void registerModItems(){
        MemeMod.LOGGER.info("为"+ MemeMod.MOD_ID+"注册物品");


    }
}
