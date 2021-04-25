package fr.anatom3000.gwwhit.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.UnaryOperator;

public class TransformingMap<TKey, TVal> implements Map<TKey, TVal> {
    private final Map<TKey, TVal> backer;
    private final UnaryOperator<TVal> transformer;
    public boolean initializing;
    public int initI;
    public int initMax;

    public TransformingMap(Map<TKey, TVal> m, UnaryOperator<TVal> t) {
        backer = m;
        transformer = t;
    }

    public void init() {
        Collection<TVal> values = backer.values();
        initI = 0;
        initMax = values.size();
        initializing = true;
        for (TVal value : values) {
            transformer.apply(value);
        }
        initializing = false;
    }

    @Override
    public int size() {
        return backer.size();
    }

    @Override
    public boolean isEmpty() {
        return backer.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return backer.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return backer.containsValue(o);
    }

    @Override
    public TVal get(Object o) {
        return transformer.apply(backer.get(o));
    }

    @Override
    public TVal put(TKey s, TVal s2) {
        transformer.apply(s2);
        return backer.put(s, s2);
    }

    @Override
    public TVal remove(Object o) {
        return backer.remove(o);
    }

    @Override
    public void putAll(Map<? extends TKey, ? extends TVal> map) {
        for (TVal value : map.values()) {
            transformer.apply(value);
        }
        backer.putAll(map);
    }

    @Override
    public void clear() {
        backer.clear();
    }

    @Override
    public Set<TKey> keySet() {
        return backer.keySet();
    }

    @Override
    public Collection<TVal> values() {
        return backer.values();
    }

    @Override
    public Set<Entry<TKey, TVal>> entrySet() {
        return backer.entrySet();
    }
}
