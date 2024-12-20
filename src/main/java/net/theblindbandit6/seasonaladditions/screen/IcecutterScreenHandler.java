package net.theblindbandit6.seasonaladditions.screen;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.interfaces.IcecutterRecipeGetter;
import net.theblindbandit6.seasonaladditions.interfaces.ModRecipeManagerGetter;
import net.theblindbandit6.seasonaladditions.recipe.IcecuttingRecipe;
import net.theblindbandit6.seasonaladditions.recipe.display.IcecuttingRecipeDisplay;

import java.util.List;
import java.util.Optional;

public class IcecutterScreenHandler extends ScreenHandler {
    public static final int INPUT_ID = 0;
    public static final int OUTPUT_ID = 1;
    private static final int INVENTORY_START = 2;
    private static final int INVENTORY_END = 29;
    private static final int OUTPUT_START = 29;
    private static final int OUTPUT_END = 38;
    private final ScreenHandlerContext context;
    final Property selectedRecipe = Property.create();
    private final World world;
    private IcecuttingRecipeDisplay.Grouping availableRecipes = IcecuttingRecipeDisplay.Grouping.empty();
    private ItemStack inputStack = ItemStack.EMPTY;
    long lastTakeTime;
    final Slot inputSlot;
    final Slot outputSlot;
    Runnable contentsChangedListener = () -> {
    };
    public final Inventory input = new SimpleInventory(1) {
        @Override
        public void markDirty() {
            super.markDirty();
            IcecutterScreenHandler.this.onContentChanged(this);
            IcecutterScreenHandler.this.contentsChangedListener.run();
        }
    };
    final CraftingResultInventory output = new CraftingResultInventory();

    public IcecutterScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public IcecutterScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(SeasonalAdditions.ICECUTTER_SCREEN_HANDLER, syncId);
        this.context = context;
        this.world = playerInventory.player.getWorld();
        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 33));
        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                stack.onCraftByPlayer(player.getWorld(), player, stack.getCount());
                IcecutterScreenHandler.this.output.unlockLastRecipe(player, this.getInputStacks());
                ItemStack itemStack = IcecutterScreenHandler.this.inputSlot.takeStack(1);
                if (!itemStack.isEmpty()) {
                    IcecutterScreenHandler.this.populateResult(IcecutterScreenHandler.this.selectedRecipe.get());
                }

                context.run((world, pos) -> {
                    long l = world.getTime();
                    if (IcecutterScreenHandler.this.lastTakeTime != l) {
                        world.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        IcecutterScreenHandler.this.lastTakeTime = l;
                    }
                });
                super.onTakeItem(player, stack);
            }

            private List<ItemStack> getInputStacks() {
                return List.of(IcecutterScreenHandler.this.inputSlot.getStack());
            }
        });
        this.addPlayerSlots(playerInventory, 8, 84);
        this.addProperty(this.selectedRecipe);
    }

    public int getSelectedRecipe() {
        return this.selectedRecipe.get();
    }

    public IcecuttingRecipeDisplay.Grouping getAvailableRecipes() {
        return this.availableRecipes;
    }

    public int getAvailableRecipeCount() {
        return this.availableRecipes.size();
    }

    public boolean canCraft() {
        return this.inputSlot.hasStack() && !this.availableRecipes.isEmpty();
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, ModBlocks.ICECUTTER);
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.selectedRecipe.get() == id) {
            return false;
        } else {
            if (this.isInBounds(id)) {
                this.selectedRecipe.set(id);
                this.populateResult(id);
            }

            return true;
        }
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.availableRecipes.size();
    }

    @Override
    public void onContentChanged(Inventory inventory) {
        ItemStack itemStack = this.inputSlot.getStack();
        if (!itemStack.isOf(this.inputStack.getItem())) {
            this.inputStack = itemStack.copy();
            this.updateInput(itemStack);
        }
    }

    private void updateInput(ItemStack stack) {
        this.selectedRecipe.set(-1);
        this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            if (this.world instanceof ServerWorld serverWorld) {
                this.availableRecipes = ((IcecutterRecipeGetter) serverWorld.getRecipeManager()).seasonalAdditions$getIcecutterRecipes().filter(stack);
            } else if (this.world instanceof ClientWorld clientWorld) {
                this.availableRecipes = ((ModRecipeManagerGetter) clientWorld).seasonalAdditions$getModRecipeManager().getIcecutterRecipes().filter(stack);
            }
        } else {
            this.availableRecipes = IcecuttingRecipeDisplay.Grouping.empty();
        }
    }

    private void populateResult(int selectedId) {
        Optional<RecipeEntry<IcecuttingRecipe>> optionalRecipe;

        if (!this.availableRecipes.isEmpty() && this.isInBounds(selectedId)) {
            IcecuttingRecipeDisplay.GroupEntry groupEntry = this.availableRecipes.entries().get(selectedId);
            optionalRecipe = groupEntry.recipe().recipe();

        } else {
            optionalRecipe = Optional.empty();
        }

        optionalRecipe.ifPresentOrElse(
                recipeEntry -> {
                    IcecuttingRecipe icecuttingRecipe = recipeEntry.value();
                    var inputCount = inputSlot.getStack().getCount();

                    if (inputCount < icecuttingRecipe.inputCount()) {
                        this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
                        this.output.setLastRecipe(null);
                    } else {
                        this.output.setLastRecipe(recipeEntry);
                        this.outputSlot.setStackNoCallbacks(icecuttingRecipe.craft(createRecipeInput(), this.world.getRegistryManager()));
                    }
                },
                () -> {
                    this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
                    this.output.setLastRecipe(null);
                }
        );

        this.sendContentUpdates();
    }

    private SingleStackRecipeInput createRecipeInput() {
        return new SingleStackRecipeInput(this.input.getStack(0));
    }

    @Override
    public ScreenHandlerType<?> getType() {
        return SeasonalAdditions.ICECUTTER_SCREEN_HANDLER;
    }

    public void setContentsChangedListener(Runnable contentsChangedListener) {
        this.contentsChangedListener = contentsChangedListener;
    }

    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.output && super.canInsertIntoSlot(stack, slot);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();
            if (slot == 1) {
                item.onCraftByPlayer(itemStack2, player.getWorld(), player);
                if (!this.insertItem(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickTransfer(itemStack2, itemStack);
            } else if (slot == 0) {
                if (!this.insertItem(itemStack2, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (isWoodcuttingRecipe(itemStack2)) {
                if (!this.insertItem(itemStack2, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 2 && slot < 29) {
                if (!this.insertItem(itemStack2, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 29 && slot < 38 && !this.insertItem(itemStack2, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            }

            slot2.markDirty();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTakeItem(player, itemStack2);
            if (slot == 1) {
                player.dropItem(itemStack2, false);
            }

            this.sendContentUpdates();
        }

        return itemStack;
    }

    private boolean isWoodcuttingRecipe(ItemStack itemStack2) {
        return (this.world instanceof ServerWorld serverWorld &&
                ((IcecutterRecipeGetter) serverWorld.getRecipeManager()).seasonalAdditions$getIcecutterRecipes().contains(itemStack2)) ||
                (this.world instanceof ClientWorld clientWorld &&
                        ((ModRecipeManagerGetter) clientWorld).seasonalAdditions$getModRecipeManager().getIcecutterRecipes().contains(itemStack2));
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.output.removeStack(1);
        this.context.run((world, pos) -> this.dropInventory(player, this.input));
    }
}
