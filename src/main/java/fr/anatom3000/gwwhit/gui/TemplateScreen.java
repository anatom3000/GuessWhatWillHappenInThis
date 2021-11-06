package fr.anatom3000.gwwhit.gui;

import fr.anatom3000.gwwhit.GWWHIT;
import fr.anatom3000.gwwhit.gui.widget.TemplateListWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemplateScreen extends Screen {
    private static final Text WARNING = new TranslatableText("gui.gwwhit.templates.warning");
    private static final String[] TEMPLATES;
    private final Screen parent;
    private TemplateListWidget list;

    public TemplateScreen(Screen parent) {
        super(new TranslatableText("gui.gwwhit.templates"));
        this.parent = parent;
    }

    @Override
    public void onClose() {
        client.setScreen(parent);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        list.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 16, 0xffffff);
        drawCenteredText(matrices, this.textRenderer, WARNING, this.width / 2, this.height - 56, 0xff2222);
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    protected void init() {
        list = addSelectableChild(new TemplateListWidget(client, width, height - 50, 32, this.height - 70));

        for (String s : TEMPLATES) {
            list.addEntry(s, s.equals("none"));
        }

        this.addDrawableChild(
                new ButtonWidget(
                        this.width / 2 - 155,
                        this.height - 29,
                        150,
                        20,
                        ScreenTexts.CANCEL,
                        button -> onClose()
                )
        );
        this.addDrawableChild(
                new ButtonWidget(
                        this.width / 2 - 155 + 160,
                        this.height - 29,
                        150,
                        20,
                        ScreenTexts.DONE,
                        button -> {

                            //noinspection ConstantConditions
                            client.setScreen(new ConfirmTemplateScreen(list.getSelectedOrNull().getId(), parent));
                        }
                )
        );

        super.init();
    }

    static {
        try {
            Path base = GWWHIT.CONTAINER.getPath("config_template");
            TEMPLATES = Files.walk(base, 1)
                    .filter(Files::isDirectory)
                    .filter(path -> !path.equals(base))
                    .map(path -> path.getFileName().toString())
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Exception when reading in templates!", e);
        }
    }
}
