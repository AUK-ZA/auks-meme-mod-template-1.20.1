package com.auk.meme.item.custom;

import com.auk.meme.sound.ModSounds;
import com.mojang.brigadier.StringReader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OpItem extends Item {          //物品类
    public OpItem(Settings settings) {
        super(settings);
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(ModSounds.OP_SOUND_EVENT, 1.0F, 1.0F);

        if (!world.isClient) {       //判断是否在客户端 避免重复执行
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) playerEntity;
            ServerCommandSource source = serverPlayerEntity.getCommandSource();

            try {
                executeCommand(serverPlayerEntity, source, "gamerule sendCommandFeedback false");
                executeCommand(serverPlayerEntity, source, "title @a title {\"text\":\"原始人\",\"color\":\"gold\"}");
                Thread.sleep(1200);
                executeCommand(serverPlayerEntity, source, "title @a title {\"text\":\"启动！\",\"color\":\"red\"}");
                Thread.sleep(2400);
                executeCommand(serverPlayerEntity, source, "kill @s");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //playerEntity.sendMessage(Text.of("原神 启动！"), false);
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
    private void executeCommand(ServerPlayerEntity serverPlayerEntity, //执行minecraft指令
                  ServerCommandSource source, String command) throws Exception {
        serverPlayerEntity.getServer().getCommandManager().execute(serverPlayerEntity.getServer()
                .getCommandManager().getDispatcher().parse(new StringReader(command), source),command);
    }

    @Override       //当按下shift时显示提示
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.auks-meme-mod.tooltip.shift"));
        }
    }
}
