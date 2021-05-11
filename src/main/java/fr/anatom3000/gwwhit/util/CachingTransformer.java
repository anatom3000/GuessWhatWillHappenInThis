package fr.anatom3000.gwwhit.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

public class CachingTransformer<T> implements UnaryOperator<T> {
    private Map<T, T> cache = new HashMap<>();
    private UnaryOperator<T> transformer;

    @Override
    public T apply(T str) {
        if (!cache.containsKey(str))
            cache.put(str, transformer.apply(str));
        return cache.get(str);
    }

    public CachingTransformer(UnaryOperator<T> transformer) {
        this.transformer = transformer;
    }
}
