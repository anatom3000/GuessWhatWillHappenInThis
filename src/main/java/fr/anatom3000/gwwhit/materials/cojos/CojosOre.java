package fr.anatom3000.gwwhit.materials.cojos;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class CojosOre extends Block {
public CojosOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.258951485803472f,3.9675914010278306f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}