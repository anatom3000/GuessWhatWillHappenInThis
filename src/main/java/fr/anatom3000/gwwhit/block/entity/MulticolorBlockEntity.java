package fr.anatom3000.gwwhit.block.entity;

import fr.anatom3000.gwwhit.model.MulticolorBakedModel;
import fr.anatom3000.gwwhit.model.MulticolorUnbakedModel;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import fr.anatom3000.gwwhit.util.Color;
import fr.anatom3000.gwwhit.util.Utilities;
import net.fabricmc.fabric.api.rendering.data.v1.RenderAttachmentBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class MulticolorBlockEntity extends BlockEntity {

    private Color color = new Color(0, 0, 0);
    private short light = 0;

    public MulticolorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.MULTICOLOR_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        light = nbt.getShort("light");
        color = new Color(
                nbt.getShort("clr-r"),
                nbt.getShort("clr-g"),
                nbt.getShort("clr-b")
        );
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putShort( "light", light );
        nbt.putShort( "clr-r", (short) color.getRed() );
        nbt.putShort( "clr-g", (short) color.getGreen() );
        nbt.putShort( "clr-b", (short) color.getBlue() );
        super.writeNbt(nbt);
    }

    public short getLight() {
        return light;
    }

    public int getMcColor() {
        return me.shedaniel.math.Color.ofRGB(
                color.getRed(),
                color.getGreen(),
                color.getBlue()
        ).getColor();
    }
}
