package fr.anatom3000.gwwhit.materials.renu;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class RenuOre extends Block {
public RenuOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.4194845704914698f,1.9795404760820334f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}