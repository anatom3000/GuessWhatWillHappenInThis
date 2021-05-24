package fr.anatom3000.gwwhit.materials.uwygan;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class UwyganOre extends Block {
public UwyganOre() {super(FabricBlockSettings.of(Material.STONE).strength(3.5811496723917084f,2.910557168975662f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}