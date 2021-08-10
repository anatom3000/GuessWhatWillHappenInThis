package fr.anatom3000.gwwhit.gui;

import fr.anatom3000.gwwhit.config.ModConfig;
import fr.anatom3000.gwwhit.util.SafeUtils;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;

import java.net.URI;

public class MainScreen extends Screen {
    private static final URI GITHUB = SafeUtils.doSafely(() -> new URI("https://www.youtube.com/watch?v=o-YBDTqX_ZU"));

    private final Screen parent;

    public MainScreen(Text title, Screen parent) {
        super(title);
        this.parent = parent;
    }

    @Override
    protected void init() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 155, this.height / 6 + 48 - 6, 150, 20, new TranslatableText("gui.gwwhit.config"), (button) -> {
            this.client.openScreen(AutoConfig.getConfigScreen(ModConfig.class, this).get());
        }));
        this.addDrawableChild(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 48 - 6, 150, 20, new TranslatableText("gui.gwwhit.something"), (button) -> {
            Util.getOperatingSystem().open(GITHUB);
        }));


        addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 168, 200, 20, ScreenTexts.DONE, (button) -> {
            client.openScreen(this.parent);
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }


}
