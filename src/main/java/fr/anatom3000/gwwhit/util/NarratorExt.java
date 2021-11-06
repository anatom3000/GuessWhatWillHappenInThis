package fr.anatom3000.gwwhit.util;

import net.minecraft.client.util.NarratorManager;

public interface NarratorExt {
    static NarratorExt getInstance() {
        return ((NarratorExt)NarratorManager.INSTANCE);
    }

    void gwwhit$load();
}
