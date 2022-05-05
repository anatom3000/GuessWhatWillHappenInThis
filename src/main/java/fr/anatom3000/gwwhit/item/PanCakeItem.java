package fr.anatom3000.gwwhit.item;

import fr.anatom3000.gwwhit.CustomItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PanCakeItem extends Item {
    public PanCakeItem() {
        super(
            new FabricItemSettings()
                .food(
                    new FoodComponent.Builder()
                        .hunger(5)
                        .build()
                )
                .rarity( Rarity.UNCOMMON )
                .group( CustomItemGroups.GWWHIT_GROUP )
        );
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.gwwhit.pancakes.tooltip") );
        super.appendTooltip(stack, world, tooltip, context);
    }
}
