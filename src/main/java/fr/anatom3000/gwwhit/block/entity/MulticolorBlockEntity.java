package fr.anatom3000.gwwhit.block.entity;

import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import fr.anatom3000.gwwhit.util.Color;
import fr.anatom3000.gwwhit.util.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class MulticolorBlockEntity extends BlockEntity {
    private static final Random RND = new Random();
    private final Color color = new Color(0, 0, 0);
    private short light = 0;
    private Color.Channel editingChannel = Color.Channel.RED;

    public MulticolorBlockEntity( BlockPos pos, BlockState state ) {
        super( BlockEntityRegistry.MULTICOLOR_BLOCK_ENTITY, pos, state );
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        light = nbt.getShort("light");
        color.copyFromNbt( nbt );
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putShort( "light", light );
        color.writeNbt( nbt );
        super.writeNbt(nbt);
    }

    public short getLight() {
        return light;
    }

    public void nextChannel() {
        this.editingChannel = this.editingChannel.getNext();
    }

    public void increase() {
        this.color.setChannel( this.editingChannel, this.color.getChannel( this.editingChannel ) + 1 );
    }

    public void decrease() {
        this.color.setChannel( this.editingChannel, this.color.getChannel( this.editingChannel ) - 1 );
    }

    public void increaseLight() {
        this.light = (short) Utilities.inverseClamp( 0, 15, this.light + 1 );
    }

    public int getUnifiedColor() {
        return this.color.getUnifiedColor();
    }

    public Random getRandom() {
        return RND;
    }

    public Color getColor() {
        return this.color;
    }
}
