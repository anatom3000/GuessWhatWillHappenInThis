package fr.anatom3000.gwwhit.materials.mudatb;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class MudatbBlock extends Block {
public MudatbBlock() {super(FabricBlockSettings.of(Material.METAL).strength(1.288711501040225f,2.304988035400448f).sounds(BlockSoundGroup.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}