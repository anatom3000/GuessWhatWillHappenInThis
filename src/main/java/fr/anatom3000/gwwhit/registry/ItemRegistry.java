package fr.anatom3000.gwwhit.registry;

import fr.anatom3000.gwwhit.CustomItemGroups;
import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.item.*;
import fr.anatom3000.gwwhit.materials.CustomArmorMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class ItemRegistry {

    private static final HashMap<String, Item> ITEMS = new HashMap<>() {{
        put("portable_black_hole", new PortableBlackHoleItem(new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP).maxCount(1)));
        put("booster", new BoosterItem(new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP).maxCount(1)));
        put("transdimensional_lens", new TransdimensionalLensItem(new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP).maxCount(1)));
        put("shock_resistant_boots", new ArmorItem(CustomArmorMaterials.SHOCK_RESISTANT_MATERIAL, EquipmentSlot.FEET, new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP)));
        put("reapers_scythe", new Item(new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP).maxCount(1)));
        put("infected_mass", new BlockItem(BlockRegistry.get("infected_mass"), new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP)));
        put("inert_infected_mass", new BlockItem(BlockRegistry.get("inert_infected_mass"), new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP)));
        put("eraser", new Item(new FabricItemSettings().group(CustomItemGroups.GWWHIT_GROUP).maxCount(1)));
        put("cosmic_eraser", new CosmicEraserItem(new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP).maxCount(1)));
        put("dashing_boots", new ArmorItem(CustomArmorMaterials.HASTY_MATERIAL, EquipmentSlot.FEET, new FabricItemSettings().group(CustomItemGroups.GWWHIT_GROUP)));
        put("randomising_block", new BlockItem(BlockRegistry.get("randomising_block"), new FabricItemSettings().group(CustomItemGroups.GWWHIT_GROUP)));
        put("mud", new BlockItem(BlockRegistry.get("mud"), new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP)));
        put("mushroom_grass", new BlockItem(BlockRegistry.get("mushroom_grass"), new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP)));
		    put("condom", new Item( new FabricItemSettings().group( CustomItemGroups.GWWHIT_GROUP ).rarity(Rarity.EPIC) ) ); // ENDER
        put("noscope", new NoscopeItem(new FabricItemSettings().fireproof().group(CustomItemGroups.GWWHIT_GROUP).maxCount(1)));
    }};

    public static void register() {
        for (Map.Entry<String, Item> item : ITEMS.entrySet()) {
            Registry.register(Registry.ITEM, GWWHIT.getId(item.getKey()), item.getValue());
        }
    }

    public static Item get(String itemId) {
        return ITEMS.getOrDefault(itemId, Items.AIR);
    }

    /**
     * @implNote this is here to be called from python
     * @author ENDERZOMBI102
     */
    public static void put(String name, Item item) {
        ITEMS.put(name, item);
    }

}
