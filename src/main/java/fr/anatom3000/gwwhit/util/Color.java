package fr.anatom3000.gwwhit.util;

import net.minecraft.nbt.NbtCompound;

/**
 * TODO: MOVE THIS TO ENDLIB AS I NEED IT
 */
public final class Color {
    private short red, green, blue;

    public Color( int r, int g, int b ) {
        this( (short) r, (short) g, (short) b );
    }

    public Color( short r, short g, short b ) {
        this.red = (short) Utilities.inverseClamp( 0, 255, r );
        this.green = (short) Utilities.inverseClamp( 0, 255, g );
        this.blue = (short) Utilities.inverseClamp( 0, 255, b );
    }

    public Color( NbtCompound nbt ) {
        this.setRed( nbt.getShort( "clr-r" ) );
        this.setGreen( nbt.getShort( "clr-g" ) );
        this.setBlue( nbt.getShort( "clr-b" ) );
    }

    public short getRed() {
        return red;
    }

    public void setRed(short r) {
        this.red = (short) Utilities.inverseClamp( 0, 255, r );
    }

    public short getGreen() {
        return green;
    }

    public void setGreen(short g) {
        this.green = (short) Utilities.inverseClamp( 0, 255, g );
    }

    public short getBlue() {
        return blue;
    }

    public void setBlue(short b) {
        this.blue = (short) Utilities.inverseClamp( 0, 255, b );
    }

    public int getUnifiedColor() {
        return (
                ( 0xFF << 24 ) |
                ( ( this.red & 0xFF ) << 16 ) |
                ( ( this.green & 0xFF ) << 8 ) |
                ( this.blue & 0xFF )
        );
    }

    public void writeNbt( NbtCompound nbt ) {
        nbt.putShort( "clr-r", this.getRed() );
        nbt.putShort( "clr-g", this.getGreen() );
        nbt.putShort( "clr-b", this.getBlue() );
    }

    public void copyFromNbt( NbtCompound nbt ) {
        this.setRed( nbt.getShort( "clr-r" ) );
        this.setGreen( nbt.getShort( "clr-g" ) );
        this.setBlue( nbt.getShort( "clr-b" ) );
    }

    public void setChannel( Color.Channel colorChannel, int value ) {
        setChannel( colorChannel, (short) value );
    }

    public void setChannel( Color.Channel colorChannel, short value ) {
        switch ( colorChannel ) {
            case RED -> setRed( value );
            case GREEN -> setGreen( value );
            case BLUE -> setBlue( value );
            default -> throw new IllegalStateException( "Unexpected value: " + colorChannel );
        }
    }

    public short getChannel( Channel colorChannel ) {
        return switch ( colorChannel ) {
            case RED -> getRed();
            case GREEN -> getGreen();
            case BLUE -> getBlue();
        };
    }

    public float getFloatRed() {
        return this.getRed() / 255f;
    }

    public float getFloatGreen() {
        return this.getGreen() / 255f;
    }

    public float getFloatBlue() {
        return this.getBlue() / 255f;
    }

	public Color copy() {
        return new Color( red, green, blue );
	}

	public enum Channel {
        RED(1),
        GREEN(2),
        BLUE(0);

        private final int next;

        Channel( int next ) {
            this.next = next;
        }

        public Channel getNext() {
            return forOrdinal( this.next );
        }

        public static Channel forOrdinal( int ordinal ) {
            return switch ( ordinal ) {
                case 0 -> RED;
                case 1 -> GREEN;
                case 2 -> BLUE;
                default -> throw new IllegalStateException( "Unexpected value: " + ordinal );
            };
        }
    }
}
