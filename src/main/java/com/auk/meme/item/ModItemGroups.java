package com.auk.meme.item;


import com.auk.meme.MemeMod;
import com.auk.meme.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOD_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,//创建一个物品组
            new Identifier(MemeMod.MOD_ID,"meme"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.meme"))
                    .icon(() -> new ItemStack(ModItems.OP_ITEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MOUSE_HEAD);
                        entries.add(ModItems.DUCK_NECK);
                        entries.add(ModItems.OP_ITEM);
                        entries.add(ModItems.P);


                    }).build());

    public static final ItemGroup MOD_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,//创建一个物品组
            new Identifier(MemeMod.MOD_ID,"meme_block"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.meme_block"))
                    .icon(() -> new ItemStack(ModBlocks.TEST_BLOCK)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.TEST_BLOCK);
                        entries.add(ModBlocks.P_ORE);
                        entries.add(ModBlocks.P_BLOCK);

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
