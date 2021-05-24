package fr.anatom3000.gwwhit.materials.luqysk;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class LuqyskOre extends Block {
public LuqyskOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.4606853439713725f,3.1933893636656094f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2));}

}