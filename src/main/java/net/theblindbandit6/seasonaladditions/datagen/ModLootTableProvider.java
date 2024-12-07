package net.theblindbandit6.seasonaladditions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.block.custom.PeppermintBushBlock;
import net.theblindbandit6.seasonaladditions.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);

        //Icecutter
        addDrop(ModBlocks.ICECUTTER);
        //Ice
        addDrop(ModBlocks.ICE_SLAB, block -> this.slabDrops(block));
        addDrop(ModBlocks.ICE_STAIRS);
        addDrop(ModBlocks.ICE_WALL);
        //Packed Ice
        addDrop(ModBlocks.PACKED_ICE_SLAB, block -> this.slabDrops(block));
        addDrop(ModBlocks.PACKED_ICE_STAIRS);
        addDrop(ModBlocks.PACKED_ICE_WALL);
        //Blue Ice
        addDrop(ModBlocks.BLUE_ICE_SLAB, block -> this.slabDrops(block));
        addDrop(ModBlocks.BLUE_ICE_STAIRS);
        addDrop(ModBlocks.BLUE_ICE_WALL);
        //Snow
        addDrop(ModBlocks.SNOW_SLAB, block -> this.slabDrops(block));
        addDrop(ModBlocks.SNOW_STAIRS);
        addDrop(ModBlocks.SNOW_WALL);
        //Small Ice Bricks
        addDrop(ModBlocks.SMALL_ICE_BRICKS);
        addDrop(ModBlocks.SMALL_ICE_BRICKS_SLAB, block -> this.slabDrops(block));
        addDrop(ModBlocks.SMALL_ICE_BRICKS_STAIRS);
        addDrop(ModBlocks.SMALL_ICE_BRICKS_WALL);
        //Large Ice Bricks
        addDrop(ModBlocks.LARGE_ICE_BRICKS);
        addDrop(ModBlocks.LARGE_ICE_BRICKS_SLAB, block -> this.slabDrops(block));
        addDrop(ModBlocks.LARGE_ICE_BRICKS_STAIRS);
        addDrop(ModBlocks.LARGE_ICE_BRICKS_WALL);
        //Polished Ice
        addDrop(ModBlocks.POLISHED_ICE);
        addDrop(ModBlocks.POLISHED_ICE_SLAB, block -> this.slabDrops(block));
        addDrop(ModBlocks.POLISHED_ICE_STAIRS);
        addDrop(ModBlocks.POLISHED_ICE_WALL);
        //Chiseled Ice Bricks
        addDrop(ModBlocks.CHISELED_ICE_BRICKS);
        //Frosted Glowstone
        addDrop(ModBlocks.FROSTED_GLOWSTONE, multipleOreDrops(ModBlocks.FROSTED_GLOWSTONE, ModItems.FROSTED_GLOWSTONE_DUST, 1, 4));
        //Candy Cane Blocks
        addDrop(ModBlocks.RED_CANDY_CANE_BLOCK);
        addDrop(ModBlocks.RED_CANDY_CANE_SLAB, block -> this.slabDrops(block));
        addDrop(ModBlocks.RED_CANDY_CANE_STAIRS);
        addDrop(ModBlocks.GREEN_CANDY_CANE_BLOCK);
        addDrop(ModBlocks.GREEN_CANDY_CANE_SLAB, block -> this.slabDrops(block));
        addDrop(ModBlocks.GREEN_CANDY_CANE_STAIRS);

        this.addDrop(ModBlocks.PEPPERMINT_BUSH,
                block -> this.applyExplosionDecay(
                        block, LootTable.builder().pool(LootPool.builder().conditionally(
                                                BlockStatePropertyLootCondition.builder(ModBlocks.PEPPERMINT_BUSH).properties(StatePredicate.Builder.create().exactMatch(PeppermintBushBlock.AGE, 3))
                                        )
                                        .with(ItemEntry.builder(ModItems.PEPPERMINT))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        ).pool(LootPool.builder().conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.PEPPERMINT_BUSH).properties(StatePredicate.Builder.create().exactMatch(PeppermintBushBlock.AGE, 2))
                                ).with(ItemEntry.builder(ModItems.PEPPERMINT))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
