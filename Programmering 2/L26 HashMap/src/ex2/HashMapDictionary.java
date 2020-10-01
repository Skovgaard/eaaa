package ex2;

import java.util.HashMap;
import java.util.Map;

public class HashMapDictionary<K, V> implements Dictionary<K, V> {

    Map<K, V> map = new HashMap<>();

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public V remove(K key) {
        return map.remove(key);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
