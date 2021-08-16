package fr.anatom3000.gwwhit.util;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

public final class McUtilities {

	public static void insertMany(PlayerInventory inv, ItemStack... stacks) {
		for ( ItemStack stack : stacks )
			inv.insertStack( stack );
	}


}
