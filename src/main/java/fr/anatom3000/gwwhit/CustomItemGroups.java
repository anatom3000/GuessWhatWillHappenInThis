package fr.anatom3000.gwwhit;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.registry.ItemRegistry;
import fr.anatom3000.gwwhit.registry.NewMaterials;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class CustomItemGroups {
    public static final ItemGroup GWWHIT_GROUP;
    public static final ItemGroup CURSED_GROUP;
    public static final ItemGroup MORE_ORES_GROUP;
    
    static {
        GWWHIT_GROUP = FabricItemGroupBuilder.create(GWWHIT.getId("gwwhit")).icon(() -> new ItemStack(ItemRegistry.get("portable_black_hole"))).build();
        
        if (ConfigManager.getLoadedConfig().gameplay.items.hiddenItemsTab) {
            CURSED_GROUP = FabricItemGroupBuilder.create(GWWHIT.getId("cursed")).icon(() -> new ItemStack(Items.COMMAND_BLOCK)).build();
        } else {
            CURSED_GROUP = null;
        }
    
        MORE_ORES_GROUP = switch (ConfigManager.getLoadedConfig().content.moreOres.tab) {
            case NONE -> null;
            case MAIN -> GWWHIT_GROUP;
            case SEPARATE -> FabricItemGroupBuilder.create(GWWHIT.getId("more_ores")).icon(() -> new ItemStack(NewMaterials.INSTANCE.ores.get(0).block)).build();
        };
    }
}
