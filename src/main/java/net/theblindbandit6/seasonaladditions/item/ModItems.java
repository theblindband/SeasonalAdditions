package net.theblindbandit6.seasonaladditions.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;

public class ModItems {
    //Mod Items
    //Winter Items
    //Frosted Glowstone Dust
    public static final Item FROSTED_GLOWSTONE_DUST=registerItem("frosted_glowstone_dust",new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SeasonalAdditions.MOD_ID,"frosted_glowstone_dust")))));
    //Additional Items:
    //Candy Cane
    //Gingerbread
    //Santa and Elf Hats
    //Marshmallows

    //Item Register Methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SeasonalAdditions.MOD_ID, name), item);
    }

    public static void registerModItems() {

    }
}