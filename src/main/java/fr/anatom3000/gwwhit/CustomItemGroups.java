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
    public static final ItemGroup COLORS_GROUP;

    static {
        GWWHIT_GROUP = FabricItemGroupBuilder.create(GWWHIT.getId("gwwhit"))
                .icon(() -> new ItemStack(ItemRegistry.get("portable_black_hole")))
                .build();

        //Dynamically hidden
        CURSED_GROUP = FabricItemGroupBuilder.create(GWWHIT.getId("cursed"))
                .icon(() -> new ItemStack(Items.COMMAND_BLOCK))
                .build();

        MORE_ORES_GROUP = switch (ConfigManager.getActiveConfig().moreOres.tab) {
            case NONE -> null;
            case MAIN -> GWWHIT_GROUP;
            case SEPARATE -> FabricItemGroupBuilder.create(GWWHIT.getId("more_ores"))
                    .icon(() -> new ItemStack(NewMaterials.ores.get(0).block))
                    .build();
        };

        COLORS_GROUP = switch (ConfigManager.getActiveConfig().blocks.colors.tab) {
            case NONE -> null;
            case MAIN -> GWWHIT_GROUP;
            case SEPARATE -> FabricItemGroupBuilder.create(
                    GWWHIT.getId("colors")
            ).icon(
                    () -> new ItemStack( Items.CYAN_DYE )
            ).build();
        };
    }
}
