package fr.anatom3000.gwwhit.compat;

import fr.anatom3000.gwwhit.CustomItemGroups;
import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.registry.ItemRegistry;
import io.github.linkle.valleycraft.init.FoodAndCooking;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import static fr.anatom3000.gwwhit.GWWHIT.getId;

public class Compats {

    public static void init() {
        initValleycraftCompat( FabricLoader.getInstance().isModLoaded("valleycraft") );
    }

    public static void initValleycraftCompat( boolean present ) {
        if ( present ) {
            GWWHIT.RESOURCE_PACK.addRecipe(
                getId("pancakes_from_valleycraft_pancake"),
                JRecipe.shaped(
                    JPattern.pattern(" # ", " # ", " # "),
                    JKeys.keys().key( "#", JIngredient.ingredient().item( FoodAndCooking.PANCAKE ) ),
                    JResult.result( "gwwhit:pancakes" )
                )
            );
        } else {
            // if vallycraft is not present, use backup recipes and items
            // NOTE: The fact that adding ValleyCraft removes items is wanted, adds more cursed!
            ItemRegistry.put( "flour", new Item( new Item.Settings().group( CustomItemGroups.GWWHIT_GROUP ) ) );
            ItemRegistry.put( "pancake_mix", new Item( new Item.Settings().group( CustomItemGroups.GWWHIT_GROUP ) ) );
            GWWHIT.RESOURCE_PACK.addRecipe(
                getId("flour_from_wheat"),
                JRecipe.shapeless(
                    JIngredients.ingredients().add( JIngredient.ingredient().item( Items.WHEAT ) ),
                    JResult.result( "gwwhit:flour" )
                )
            );
            GWWHIT.RESOURCE_PACK.addRecipe(
                getId("pancake_mix_from_flour_and_sugar"),
                JRecipe.shapeless(
                    JIngredients.ingredients()
                        .add( JIngredient.ingredient().item( ItemRegistry.get("flour") ) )
                        .add( JIngredient.ingredient().item( Items.MILK_BUCKET ) )
                        .add( JIngredient.ingredient().item( Items.SUGAR ) )
                        .add( JIngredient.ingredient().item( Items.EGG ) ),
                    JResult.result( "gwwhit:pancake_mix" )
                )
            );
            GWWHIT.RESOURCE_PACK.addRecipe(
                getId("pancakes_from_pancake_mix"),
                JRecipe.smoking(
                    JIngredient.ingredient().item( ItemRegistry.get("pancake_mix") ),
                    JResult.result( "gwwhit:pancakes" )
                )
            );
        }
    }
}
