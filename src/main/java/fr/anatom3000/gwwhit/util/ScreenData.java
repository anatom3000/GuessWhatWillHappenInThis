package fr.anatom3000.gwwhit.util;

import io.gitlab.jfronny.libjf.unsafe.UltraEarlyInit;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.awt.image.BufferedImage;

import static fr.anatom3000.gwwhit.GWWHIT.getId;

public class ScreenData implements UltraEarlyInit {
    public static final Identifier SCREENSHOT_TEXTURE = getId( "textures/dyn/desktop.png" );
    public static BufferedImage image;

    @Override
    public void init() {
        // take screenshot
        var size = MouseInfo.getPointerInfo()
            .getDevice()
            .getDefaultConfiguration()
            .getBounds();
        var screen = Utilities.takeScreenshot( size );
        // convert image
        image = new BufferedImage( screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB );
        var graphics = image.getGraphics();
        graphics.drawImage( screen, 0, 0, null );
        graphics.dispose();
    }

    public static Insets getWindowDecorations() {
        return Toolkit.getDefaultToolkit().getScreenInsets( MouseInfo.getPointerInfo().getDevice().getDefaultConfiguration() );
    }
}
