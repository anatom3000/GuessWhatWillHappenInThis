package fr.anatom3000.gwwhit.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(OptionsScreen.class)
public class OptionsMenuMixin extends Screen {
	private OptionsMenuMixin(Text title) {
		super(title);
	}



}
