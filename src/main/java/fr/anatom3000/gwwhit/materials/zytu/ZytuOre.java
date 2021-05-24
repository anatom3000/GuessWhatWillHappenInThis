package fr.anatom3000.gwwhit.materials.zytu;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
public class ZytuOre extends Block {
public ZytuOre() {super(FabricBlockSettings.of(Material.STONE).strength(2.7756672377378107f,4.245648694295583f).sounds(BlockSoundGroup.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 1));}

}