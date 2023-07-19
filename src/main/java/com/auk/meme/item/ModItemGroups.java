package com.auk.meme.item;


import com.auk.meme.MemeMod;
import com.auk.meme.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOD_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,//创建一个物品组
            new Identifier(MemeMod.MOD_ID,"test"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.test"))
                    .icon(() -> new ItemStack(ModItems.TEST)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TEST);
                        entries.add(ModBlocks.TEST_BLOCK);

                    }).build());
    /*private static void addItemToIngredientItemGroup(FabricItemGroupEntries entries){//将物品加入Ingredient物品组
        entries.add(ModItems.TEST);
    }*/

    public static void registerItemGroups(){
        MemeMod.LOGGER.info("为"+MemeMod.MOD_ID+"注册物品组");
        /*ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(ModItemGroups::addItemToIngredientItemGroup);//这句看不太懂*/
    }
}
