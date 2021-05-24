package fr.anatom3000.gwwhit.materials.silo;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class SiloOre extends Block {
public SiloOre() {super(FabricBlockSettings.of(Material.STONE).strength(1.9326458369384065f,1.6891983454746753f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}