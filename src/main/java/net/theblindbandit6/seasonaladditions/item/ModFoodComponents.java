package net.theblindbandit6.seasonaladditions.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {
    //Food Components
    public static final FoodComponent CANDY_CANE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();

    //Effects - Not currently being used, just here for future reference
    public static final ConsumableComponent CANDY_CANE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.15f)).build();
}
