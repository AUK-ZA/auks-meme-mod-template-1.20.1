package com.auk.meme.sound;

import com.auk.meme.MemeMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {//该类是根据官方源码瞎猜的



        public static final Identifier MY_SOUND_ID = new Identifier("auks-meme-mod:my_sound");
        public static SoundEvent MY_SOUND_EVENT = SoundEvent.of(MY_SOUND_ID);

        public static void registerSounds(){
                MemeMod.LOGGER.info("加载声音");}


}


