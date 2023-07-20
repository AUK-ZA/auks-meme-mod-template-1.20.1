package com.auk.meme.sound;

import com.auk.meme.MemeMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {//该类是根据官方源码瞎猜的

        public static final SoundEvent OP_SOUND_EVENT = registerSoundEvent("op_sound");
        private static SoundEvent registerSoundEvent(String name){
                Identifier identifier = new Identifier(MemeMod.MOD_ID,name);
                return Registry.register(Registries.SOUND_EVENT,identifier,SoundEvent.of(identifier));
        }



        public static final Identifier MY_SOUND_ID = new Identifier("auks-meme-mod:op_sound");


        public static void registerSounds(){
                MemeMod.LOGGER.info("加载声音");}


}


