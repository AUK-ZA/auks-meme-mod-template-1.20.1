package com.auk.meme.item.custom;

import com.auk.meme.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class OpItem extends Item {

    public OpItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(ModSounds.OP_SOUND_EVENT, 1.0F, 1.0F);
        for (int i = 0; i < 5; i++) {
            playerEntity.sendMessage(Text.translatable("原神 启动！"));//这里每循环一次会执行两次 不知道为什么
        }

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}