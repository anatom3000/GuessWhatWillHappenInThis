package fr.anatom3000.gwwhit.block.entity;

import fr.anatom3000.gwwhit.gui.SlowFurnaceScreenHandler;
import fr.anatom3000.gwwhit.inventory.ImplementedInventory;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SlowFurnaceBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory, SidedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize( 3, ItemStack.EMPTY );


    public SlowFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super( BlockEntityRegistry.SLOW_FURNACE_BLOCK_ENTITY, pos, state );
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("container.gwwhit.slow_furnace");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new SlowFurnaceScreenHandler( syncId, inv, this );
    }

    // --- inventory ---

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, this.inventory);
        super.writeNbt(nbt);
    }

    /**
     * Avaliable slots:
     *  - 0: Input slot
     *  - 1: Fuel slot
     *  - 2: Output slot
     * @param slot  The inventory slot of which to replace the itemstack.
     * @param stack The replacing itemstack. If the stack is too big for
     *              this inventory ({@link Inventory#getMaxCountPerStack()}),
     */
    @Override
    public void setStack(int slot, ItemStack stack) {
        ImplementedInventory.super.setStack(slot, stack);
    }

    /**
     * Avaliable slots:
     *  - 0: Input slot
     *  - 1: Fuel slot
     *  - 2: Output slot
     * @param slot  The inventory slot of which to get the itemstack.
     */
    @Override
    public ItemStack getStack(int slot) {
        return ImplementedInventory.super.getStack(slot);
    }

    // --- sided inventory ---

    @Override
    public int[] getAvailableSlots(Direction side) {
        // Just return an array of all slots
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    public boolean canInsert( int slot, ItemStack stack, @Nullable Direction direction ) {
        return direction != Direction.UP && getStack(slot).isItemEqual( stack );
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }

    public static <E extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState blockState, E e) {
    }
}
