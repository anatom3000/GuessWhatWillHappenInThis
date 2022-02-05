package fr.anatom3000.gwwhit.gui;

import fr.anatom3000.gwwhit.block.entity.SlowFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class SlowFurnaceScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public SlowFurnaceScreenHandler( int syncId, PlayerInventory inv ) {
        this( syncId, inv, new SimpleInventory(3) );

    }

    public SlowFurnaceScreenHandler(int syncId, PlayerInventory inv, Inventory inventory) {
        super( ScreenHandlerType.FURNACE, syncId );
        checkSize( inventory, 3 );
        this.inventory = inventory;

        inventory.onOpen( inv.player );
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if ( slot != null && slot.hasStack() ) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if ( invSlot < this.inventory.size() ) {
                if (! this.insertItem( originalStack, this.inventory.size(), this.slots.size(), true ) ) {
                    return ItemStack.EMPTY;
                }
            } else if (! this.insertItem( originalStack, 0, this.inventory.size(), false ) ) {
                return ItemStack.EMPTY;
            }

            if ( originalStack.isEmpty() ) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }
}
