package com.auk.meme.item.custom;

import com.auk.meme.sound.ModSounds;
import com.mojang.brigadier.StringReader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class OpItem extends Item {
    public OpItem(Settings settings) {
        super(settings);
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(ModSounds.OP_SOUND_EVENT, 1.0F, 1.0F);

        if (!world.isClient) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) playerEntity;
            ServerCommandSource source = serverPlayerEntity.getCommandSource();

            try {
                executeCommand(serverPlayerEntity, source, "gamerule sendCommandFeedback false");
                executeCommand(serverPlayerEntity, source, "title @a title {\"text\":\"原神\",\"color\":\"gold\"}");
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
    private void executeCommand(ServerPlayerEntity serverPlayerEntity, //执行指令
                  ServerCommandSource source, String command) throws Exception {
        serverPlayerEntity.getServer().getCommandManager().execute(serverPlayerEntity.getServer()
                .getCommandManager().getDispatcher().parse(new StringReader(command), source),command);
    }
}
