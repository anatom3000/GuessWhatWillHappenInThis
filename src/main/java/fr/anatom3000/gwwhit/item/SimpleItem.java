package fr.anatom3000.gwwhit.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.block.Block;

public class SimpleItem extends Item {

	public SimpleItem(FabricItemSettings settings) {
		super(settings);
	}

	public static BlockItem fromBlock(Block block, FabricItemSettings settings) {
		return new BlockItem(block, settings);
	}

}
