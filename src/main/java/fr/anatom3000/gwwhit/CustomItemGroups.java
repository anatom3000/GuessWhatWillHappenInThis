package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.registry.ItemRegistry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CustomItemGroups {
    public static final ItemGroup GWWHIT_GROUP = FabricItemGroupBuilder.create(GuessWhatWillHappenInThisMod.ID("gwwhit")).icon(() -> new ItemStack(ItemRegistry.get("portable_black_hole"))).build();
}
