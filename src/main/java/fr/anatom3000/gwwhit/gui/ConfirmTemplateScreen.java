package fr.anatom3000.gwwhit.gui;

import fr.anatom3000.gwwhit.config.OverrideManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

import java.io.IOException;

public class ConfirmTemplateScreen extends Screen {
    private final TranslatableText WARNING = new TranslatableText("gui.gwwhit.templates.warning");
    private final TranslatableText INFO = new TranslatableText("gui.gwwhit.templates.confirm.info");
    private final String id;
    private final Screen parent;

    protected ConfirmTemplateScreen(String id, Screen parent) {
        super(new TranslatableText("gui.gwwhit.templates.confirm"));
        this.id = id;
        this.parent = parent;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 40, 0xffffff);
        drawCenteredText(matrices, this.textRenderer, INFO, this.width / 2, 70, 0xffffff);
        drawCenteredText(matrices, this.textRenderer, WARNING, this.width / 2, 90, 0xff2222);
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    protected void init() {
        this.addDrawableChild(
                new ButtonWidget(
                        this.width / 2 - 155,
                        120,
                        150,
                        20,
                        ScreenTexts.CANCEL,
                        (button) -> client.setScreen(parent)
                )
        );
        this.addDrawableChild(
                new ButtonWidget(
                        this.width / 2 - 155 + 160,
                        120,
                        150,
                        20,
                        new TranslatableText("gui.gwwhit.templates.confirm.confirm"),
                        (button) -> {
                            try {
                                OverrideManager.applyTemplate(id);
                                MinecraftClient.getInstance().stop();
                            } catch (IOException e) {
                                throw new RuntimeException("Failed to load config template!", e);
                            }
                        }
                )
        );

        super.init();
    }
}
