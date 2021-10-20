package fr.anatom3000.gwwhit.gui.widget;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.AlwaysSelectedEntryListWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class TemplateListWidget extends AlwaysSelectedEntryListWidget<TemplateListWidget.Entry> {

    public TemplateListWidget(MinecraftClient client, int width, int height, int top, int bottom) {
        super(client, width, height, top, bottom, 20);
    }

    @Override
    protected boolean isFocused() {
        return true;
    }

    public int addEntry(String id, boolean select) {
        Entry entry = new Entry(id);
        if (select) setSelected(entry);
        return super.addEntry(entry);
    }

    public class Entry extends AlwaysSelectedEntryListWidget.Entry<TemplateListWidget.Entry> {
        private final String id;

        public Entry(String id) {
            this.id = id;
        }

        @Override
        public void render(MatrixStack matrices, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta) {
            drawCenteredText(matrices, MinecraftClient.getInstance().textRenderer, id, x + entryWidth / 2, y - 5 + entryHeight / 2, 0xFFFFFFFF);
        }

        public String getId() {
            return id;
        }

        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            if (button == 0) {
                TemplateListWidget.this.setSelected(this);
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Text getNarration() {
            return new LiteralText(id);
        }
    }
}
