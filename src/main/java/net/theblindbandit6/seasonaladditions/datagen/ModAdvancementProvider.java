package net.theblindbandit6.seasonaladditions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.ItemCriterion;
import net.minecraft.advancement.criterion.TravelCriterion;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.item.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {

        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        ModBlocks.RED_CANDY_CANE_BLOCK, // The display icon
                        Text.translatable("advancements.seasonaladditions.festive.root.title"), // The title
                        Text.translatable("advancements.seasonaladditions.festive.root.description"), // The description
                        Identifier.of(SeasonalAdditions.MOD_ID, "textures/gui/advancements/backgrounds/festive.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        false, // Show toast top right
                        false, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_snow", InventoryChangedCriterion.Conditions.items(Items.SNOWBALL))
                .build(consumer, SeasonalAdditions.MOD_ID + "/root");

        AdvancementEntry getCandyCane = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModItems.CANDY_CANE, // The display icon
                        Text.translatable("advancements.seasonaladditions.festive.getcandycane.title"), // The title
                        Text.translatable("advancements.seasonaladditions.festive.getcandycane.description"), // The description
                        null, //Only the root needs a background
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // Parent advancement
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("get_candycane", InventoryChangedCriterion.Conditions.items(ModItems.CANDY_CANE))
                .build(consumer, SeasonalAdditions.MOD_ID + "/get_candycane");

        AdvancementEntry getFairyLight = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModBlocks.YELLOW_FAIRY_LIGHTS, // The display icon
                        Text.translatable("advancements.seasonaladditions.festive.getFairyLight.title"), // The title
                        Text.translatable("advancements.seasonaladditions.festive.getFairyLight.description"), // The description
                        null, //Only the root needs a background
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // Parent advancement
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR)
                .criterion("get_festivefairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.FESTIVE_FAIRY_LIGHTS))
                .criterion("get_greenfairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.GREEN_FAIRY_LIGHTS))
                .criterion("get_redfairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.RED_FAIRY_LIGHTS))
                .criterion("get_bluefairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.BLUE_FAIRY_LIGHTS))
                .criterion("get_whitefairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.WHITE_FAIRY_LIGHTS))
                .criterion("get_yellowfairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.YELLOW_FAIRY_LIGHTS))
                .build(consumer, SeasonalAdditions.MOD_ID + "/get_fairylight");

        AdvancementEntry getAllFairyLights = Advancement.Builder.create().parent(getFairyLight)
                .display(
                        ModBlocks.FESTIVE_FAIRY_LIGHTS, // The display icon
                        Text.translatable("advancements.seasonaladditions.festive.getAllFairyLight.title"), // The title
                        Text.translatable("advancements.seasonaladditions.festive.getAllFairyLight.description"), // The description
                        null, //Only the root needs a background
                        AdvancementFrame.CHALLENGE, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // Parent advancement
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("get_festivefairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.FESTIVE_FAIRY_LIGHTS))
                .criterion("get_greenfairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.GREEN_FAIRY_LIGHTS))
                .criterion("get_redfairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.RED_FAIRY_LIGHTS))
                .criterion("get_bluefairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.BLUE_FAIRY_LIGHTS))
                .criterion("get_whitefairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.WHITE_FAIRY_LIGHTS))
                .criterion("get_yellowfairylight", InventoryChangedCriterion.Conditions.items(ModBlocks.YELLOW_FAIRY_LIGHTS))
                .build(consumer, SeasonalAdditions.MOD_ID + "/get_allfairylights");

        AdvancementEntry getIcecutter = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModBlocks.ICECUTTER, // The display icon
                        Text.translatable("advancements.seasonaladditions.festive.getIcecutter.title"), // The title
                        Text.translatable("advancements.seasonaladditions.festive.getIcecutter.description"), // The description
                        null, //Only the root needs a background
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // Parent advancement
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("get_icecutter", InventoryChangedCriterion.Conditions.items(ModBlocks.ICECUTTER))
                .build(consumer, SeasonalAdditions.MOD_ID + "/get_icecutter");
    }
}