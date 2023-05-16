package me.jsinco.cadiachallenges.config.registry;

import java.util.HashMap;
import java.util.Map;

public abstract class Registry<K, V> implements IRegistry<K, V> {

    private final Map<K, V> map;

    protected Registry() {
        this(new HashMap<>());
    }

    protected Registry(final Map<K, V> map) {
        this.map = map;
    }

    @Override
    public Map<K, V> getRegistry() {
        return this.map;
    }
}
