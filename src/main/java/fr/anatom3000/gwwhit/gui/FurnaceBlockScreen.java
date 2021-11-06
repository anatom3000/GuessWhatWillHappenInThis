package fr.anatom3000.gwwhit.gui;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class FurnaceBlockScreen extends CottonInventoryScreen<FurnaceGuiDescription> {
    public FurnaceBlockScreen(FurnaceGuiDescription gui, PlayerEntity player, Text title) {
        super(gui, player, title);
    }
}
