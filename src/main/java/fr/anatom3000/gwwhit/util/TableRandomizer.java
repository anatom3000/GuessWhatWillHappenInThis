package fr.anatom3000.gwwhit.util;

import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TableRandomizer extends CachingTransformer<Identifier, Map<Identifier, LootTable>> {
    private static boolean tablesCached = false;
    private static final List<Identifier> TABLES_CURRENT = new ArrayList<>();
    public TableRandomizer(Random rng) {
        super((val, param) -> {
            if (!tablesCached) {
                tablesCached = true;
                TABLES_CURRENT.clear();
                TABLES_CURRENT.addAll(param.keySet());
                TABLES_CURRENT.sort(Identifier::compareTo);
            }
            return TABLES_CURRENT.get(rng.nextInt(TABLES_CURRENT.size()));
        });
    }

    @Override
    public Identifier apply(Identifier identifier, Map<Identifier, LootTable> identifierLootTableMap) {
        tablesCached = false;
        return super.apply(identifier, identifierLootTableMap);
    }
}
