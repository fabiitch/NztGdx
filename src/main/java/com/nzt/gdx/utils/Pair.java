package com.nzt.gdx.utils;

//TODO a finir si besoin
public class Pair<K, V> {
    public K key;
    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean isKey(K object, boolean identity) {
        if (identity)
            return key == object;
        return key.equals(object);
    }

    public boolean isValue(K object, boolean identity) {
        if (identity)
            return value == object;
        return value.equals(object);
    }

}
