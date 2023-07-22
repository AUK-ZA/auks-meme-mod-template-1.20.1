package com.auk.meme.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {        //创建食物物品
    public static final FoodComponent DUCK_NECK = new FoodComponent.Builder().hunger(1).saturationModifier(0.1f)    //创建食物实例
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200, 1), 1.0f)//添加效果
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0), 1.0f).build();

}
