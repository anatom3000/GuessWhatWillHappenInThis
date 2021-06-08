package fr.anatom3000.gwwhit.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class CachingTransformer<TVal, TParam> implements BiFunction<TVal, TParam, TVal> {
    private final Map<TVal, TVal> cache = new HashMap<>();
    private final BiFunction<TVal, TParam, TVal> transformer;

    public CachingTransformer(BiFunction<TVal, TParam, TVal> transformer) {
        this.transformer = transformer;
    }

    @Override
    public TVal apply(TVal val, TParam param) {
        if (!cache.containsKey(val))
            cache.put(val, transformer.apply(val, param));
        return cache.get(val);
    }
}
