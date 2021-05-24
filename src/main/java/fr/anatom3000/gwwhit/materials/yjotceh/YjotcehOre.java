package fr.anatom3000.gwwhit.materials.yjotceh;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class YjotcehOre extends Block {
public YjotcehOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.684605805215211f,2.2255814440263992f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 2).slipperiness(0.8298249223988254f));}

}