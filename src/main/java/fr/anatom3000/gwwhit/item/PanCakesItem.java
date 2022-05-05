package fr.anatom3000.gwwhit.item;

import fr.anatom3000.gwwhit.CustomItemGroups;
import fr.anatom3000.gwwhit.util.PancakeDamageSource;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Rarity;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PanCakesItem extends Item {
    public PanCakesItem() {
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

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if ( user instanceof PlayerEntity player )
            user.damage( new PancakeDamageSource( player ), 6 );
        return super.finishUsing(stack, world, user);
    }
}
