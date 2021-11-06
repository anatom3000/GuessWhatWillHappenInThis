package fr.anatom3000.gwwhit.mixin.access;

import net.minecraft.item.ItemGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemGroup.class)
public interface ItemGroupAccess {
    @Accessor("GROUPS")
    static void setGroups(ItemGroup[] value) {
        assert false;
    }
}
