package fr.anatom3000.gwwhit.util;

import fr.anatom3000.gwwhit.config.ConfigManager;
import net.minecraft.util.math.MathHelper;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConsoleHacker {
    public static void hack() {
        if (!ConfigManager.getActiveConfig().misc.rainbowConsole) return;

        PrintStream out = new PrintStream(new FileOutputStream(FileDescriptor.out), true);
        Random random = new Random();

        String[] effects = StringFormat.EFFECTS;

        var colorState = new Object() {
            public float color = 0;
            public final boolean[] enabledEffects = new boolean[effects.length];
        };

        for (int i = 0; i < colorState.enabledEffects.length; i++) {
            colorState.enabledEffects[i] = random.nextBoolean();
        }

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            try {
                int packedColor = MathHelper.hsvToRgb(colorState.color, 1, 1);
                int r = (packedColor & 0x00ff0000) >> 16;
                int g = (packedColor & 0x0000ff00) >> 8;
                int b = (packedColor & 0x000000ff);

                out.print(StringFormat.RESET);
                for (int i = 0; i < colorState.enabledEffects.length; i++)
                    if (colorState.enabledEffects[i]) out.print(effects[i]);
                out.print(StringFormat.color(r, g, b));

                int changedEffect = random.nextInt(colorState.enabledEffects.length);
                colorState.enabledEffects[changedEffect] = !colorState.enabledEffects[changedEffect];
                colorState.color += 0.0001;
                colorState.color %= 1;
            } catch (Exception ignored) {
            }
        }, 0, 10, TimeUnit.MILLISECONDS);
    }
}
