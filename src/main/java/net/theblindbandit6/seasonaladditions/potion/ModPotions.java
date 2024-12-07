package net.theblindbandit6.seasonaladditions.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;

public class ModPotions {
    public static final RegistryEntry<Potion> FROSTED_POTION = registerPotion("frosted_potion",
            new Potion("frosted_potion",
                    new StatusEffectInstance(StatusEffects.SLOWNESS, 1200, 1),
                    new StatusEffectInstance(StatusEffects.WEAKNESS, 1200, 1)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(SeasonalAdditions.MOD_ID, name), potion);
    }

    public static void registerPotions() {

    }
}
