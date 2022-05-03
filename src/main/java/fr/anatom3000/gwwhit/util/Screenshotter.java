package fr.anatom3000.gwwhit.util;

import io.gitlab.jfronny.libjf.unsafe.UltraEarlyInit;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Screenshotter implements UltraEarlyInit {
    private static final Path SCREENSHOT_FILE = Path.of( System.getProperty("user.dir"), "data/screen.png" );
    public static BufferedImage image;

    @Override
    public void init() {
        // take screenshot
        var device = MouseInfo.getPointerInfo().getDevice();
        var display = device.getDisplayMode();
        // FIXME: The windows version of the device (D3DGraphicsDevice) has those two fields to determine the actual screen size, find a way to use it so the screen doesn't have black bars on the bottom & right sides
        var scaleX = 1f;
        var scaleY = 1f;
        var screen = Utilities.takeScreenshot( new Rectangle(
            (int) ( display.getWidth() / scaleX),
            (int) ( display.getHeight() / scaleY )
        ));
        // convert image
        image = new BufferedImage( screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB );
        var graphics = image.getGraphics();
        graphics.drawImage( screen, 0, 0, null );
        graphics.dispose();
        // save image to tmp file
        //noinspection ResultOfMethodCallIgnored
        SCREENSHOT_FILE.getParent().toFile().mkdirs();
        try {
            ImageIO.write( image, "png", SCREENSHOT_FILE.toFile() );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getNativeImageBackedTexture() {
        try {
            return new NativeImageBackedTexture(
                NativeImage.read( Files.newInputStream( SCREENSHOT_FILE ) )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
