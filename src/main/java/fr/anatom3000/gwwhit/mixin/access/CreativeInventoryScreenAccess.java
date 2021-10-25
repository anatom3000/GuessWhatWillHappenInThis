package fr.anatom3000.gwwhit.mixin.access;

import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CreativeInventoryScreen.class)
public interface CreativeInventoryScreenAccess {
    @Accessor
    static int getSelectedTab() {
        throw new AssertionError();
    }

    @Accessor
    static void setSelectedTab(int value) {
        throw new AssertionError();
    }
}
