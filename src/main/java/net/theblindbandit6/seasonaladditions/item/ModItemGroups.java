package net.theblindbandit6.seasonaladditions.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup WINTER_ADDITIONS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SeasonalAdditions.MOD_ID, "winteradditions"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FROSTED_GLOWSTONE_DUST))
                    .displayName(Text.translatable("itemgroup.winteradditions"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.FROSTED_GLOWSTONE_DUST);
                        entries.add(ModBlocks.FROSTED_GLOWSTONE);

                        entries.add(ModBlocks.ICECUTTER);

                    }).build());

    public static void registerItemGroups() {
        SeasonalAdditions.LOGGER.info("Registering Item Groups for " + SeasonalAdditions.MOD_ID);
    }
}
