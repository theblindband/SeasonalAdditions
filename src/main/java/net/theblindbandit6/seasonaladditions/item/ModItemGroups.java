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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CANDY_CANE))
                    .displayName(Text.translatable("itemgroup.winteradditions"))
                    .entries((displayContext, entries) -> {
                        //Icecutter
                        entries.add(ModBlocks.ICECUTTER);
                        //Ice
                        entries.add(ModBlocks.ICE_SLAB);
                        entries.add(ModBlocks.ICE_STAIRS);
                        entries.add(ModBlocks.ICE_WALL);
                        //Packed Ice
                        entries.add(ModBlocks.PACKED_ICE_SLAB);
                        entries.add(ModBlocks.PACKED_ICE_STAIRS);
                        entries.add(ModBlocks.PACKED_ICE_WALL);
                        //Blue Ice
                        entries.add(ModBlocks.BLUE_ICE_SLAB);
                        entries.add(ModBlocks.BLUE_ICE_STAIRS);
                        entries.add(ModBlocks.BLUE_ICE_WALL);
                        //Snow
                        entries.add(ModBlocks.SNOW_SLAB);
                        entries.add(ModBlocks.SNOW_STAIRS);
                        entries.add(ModBlocks.SNOW_WALL);
                        //Small Ice Bricks
                        entries.add(ModBlocks.SMALL_ICE_BRICKS);
                        entries.add(ModBlocks.SMALL_ICE_BRICKS_SLAB);
                        entries.add(ModBlocks.SMALL_ICE_BRICKS_STAIRS);
                        entries.add(ModBlocks.SMALL_ICE_BRICKS_WALL);
                        //Large Ice Bricks
                        entries.add(ModBlocks.LARGE_ICE_BRICKS);
                        entries.add(ModBlocks.LARGE_ICE_BRICKS_SLAB);
                        entries.add(ModBlocks.LARGE_ICE_BRICKS_STAIRS);
                        entries.add(ModBlocks.LARGE_ICE_BRICKS_WALL);
                        //Polished Ice
                        entries.add(ModBlocks.POLISHED_ICE);
                        entries.add(ModBlocks.POLISHED_ICE_SLAB);
                        entries.add(ModBlocks.POLISHED_ICE_STAIRS);
                        entries.add(ModBlocks.POLISHED_ICE_WALL);
                        //Chiseled Ice Bricks
                        entries.add(ModBlocks.CHISELED_ICE_BRICKS);
                        //Frosted Glowstone
                        entries.add(ModItems.FROSTED_GLOWSTONE_DUST);
                        entries.add(ModBlocks.FROSTED_GLOWSTONE);
                        //Candy Cane
                        entries.add(ModItems.CANDY_CANE);
                        entries.add(ModBlocks.RED_CANDY_CANE_BLOCK);
                        entries.add(ModBlocks.RED_CANDY_CANE_SLAB);
                        entries.add(ModBlocks.RED_CANDY_CANE_STAIRS);
                        entries.add(ModBlocks.GREEN_CANDY_CANE_BLOCK);
                        entries.add(ModBlocks.GREEN_CANDY_CANE_SLAB);
                        entries.add(ModBlocks.GREEN_CANDY_CANE_STAIRS);
                        //Peppermint
                        entries.add(ModItems.PEPPERMINT);
                        //Fairy Lights
                        entries.add(ModBlocks.RED_FAIRY_LIGHTS);
                        entries.add(ModBlocks.GREEN_FAIRY_LIGHTS);
                        entries.add(ModBlocks.WHITE_FAIRY_LIGHTS);
                        entries.add(ModBlocks.FESTIVE_FAIRY_LIGHTS);

                    }).build());

    public static void registerItemGroups() {
        SeasonalAdditions.LOGGER.info("Registering Item Groups for " + SeasonalAdditions.MOD_ID);
    }
}
