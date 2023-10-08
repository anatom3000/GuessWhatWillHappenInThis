package fr.anatom3000.gwwhit.mixin.access;

import net.minecraft.item.ItemGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemGroup.class)
public interface ItemGroupAccess {
	// disabled because it was causing weird mixin errors i dont know how to fix
	// TODO re-enable and fix
    //@Accessor("GROUPS")
    //static void setGroups(ItemGroup[] value) {
    //    assert false;
    //}
}
