package fr.anatom3000.gwwhit.materials.botud;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
public class BotudOre extends Block {
public BotudOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.424393544424001f,4.2406564361777965f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}