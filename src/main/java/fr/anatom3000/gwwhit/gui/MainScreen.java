package fr.anatom3000.gwwhit.gui;

import fr.anatom3000.gwwhit.config.ConfigManager;
import fr.anatom3000.gwwhit.config.data.MainConfig;
import fr.anatom3000.gwwhit.util.SafeUtils;
import fr.anatom3000.gwwhit.util.Utilities;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;

import java.awt.*;
import java.net.URI;

public class MainScreen extends Screen {
    private static final URI FORK = SafeUtils.doSafely(() -> new URI("https://github.com/anatom3000/GuessWhatWillHappenInThis/fork"));
    private static final URI MORE_INFO = SafeUtils.doSafely(() -> new URI("https://www.youtube.com/watch?v=o-YBDTqX_ZU"));

    private final Screen parent;

    public MainScreen(Text title, Screen parent) {
        super(title);
        this.parent = parent;
    }

    @Override
    protected void init() {
        addDrawableChild(
                new ButtonWidget(
                        this.width / 2 - 155,
                        this.height / 6 + 48 - 6,
                        150,
                        20,
                        new TranslatableText("gui.gwwhit.config"),
                        (button) -> MinecraftClient.getInstance().openScreen(
                                    AutoConfig.getConfigScreen(
                                            MainConfig.class,
                                            this
                                    ).get()
                        )
                )
        );
        addDrawableChild(
                new ButtonWidget(
                        this.width / 2 + 5,
                        this.height / 6 + 48 - 6,
                        150,
                        20,
                        new TranslatableText("gui.gwwhit.more_info"),
                        (button) -> Util.getOperatingSystem().open(MORE_INFO)

                )
        );
        addDrawableChild(
                new ButtonWidget(
                        this.width / 2 - 155,
                        this.height / 6 + 70,
                        150,
                        20,
                        new TranslatableText("gui.gwwhit.fork"),
                        (button) -> Util.getOperatingSystem().open(FORK)
                )
        );
        if (ConfigManager.getActiveConfig().misc.debugMode) {
            addDrawableChild(
                    new ButtonWidget(
                            this.width / 2 + 5,
                            this.height / 6 + 70,
                            150,
                            20,
                            new TranslatableText("gui.gwwhit.reload"),
                            (button) -> MinecraftClient.getInstance().reloadResources()
                    )
            );
        }
        addDrawableChild(
                new ButtonWidget(
                        this.width / 2 - 100,
                        this.height / 6 + 168,
                        200,
                        20,
                        ScreenTexts.DONE,
                        (button) -> MinecraftClient.getInstance().openScreen(this.parent)
                )
        );
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }


}
