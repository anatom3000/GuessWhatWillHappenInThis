package fr.anatom3000.gwwhit.materials.uwalusq;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class UwalusqOre extends Block {
public UwalusqOre() {super(FabricBlockSettings.of(Material.STONE).strength(4.377612215255365f,4.642682211595366f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 0));}

}