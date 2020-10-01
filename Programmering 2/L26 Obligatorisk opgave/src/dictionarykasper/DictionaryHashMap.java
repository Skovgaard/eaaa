package dictionarykasper;

import java.util.HashMap;
import java.util.Map;

public class DictionaryHashMap<K, V> implements Dictionary<K, V> {

    private Map<K, V>[] tabel;
    private static int N = 10;

    /**
     * HashingMap constructor comment.
     */

    public DictionaryHashMap() {
        tabel = new HashMap[N];
        for (int i = 0; i < N; i++) {
            tabel[i] = new HashMap<>();
        }
    }

    @Override
    public V get(K key) {
        int i = key.hashCode() % N;
        Map<K, V> m = tabel[i];
        return m.get(key);
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        int i = 0;
        while (empty && i < N) {
            empty = (tabel[i]).isEmpty();
            i++;
        }
        return empty;
    }

    @Override
    public V put(K key, V value) {
        int i = key.hashCode() % N;
        Map<K, V> m = tabel[i];
        V oldValue = m.get(key);
        m.put(key, value);
        return oldValue;
    }

    @Override
    public V remove(K key) {
        int i = key.hashCode() % N;
        Map<K, V> m = tabel[i];
        return m.remove(key);
    }

    @Override
    public int size() {
        int count = 0;
        for (Map<K, V> kvMap : tabel) {
            count += kvMap.keySet().size();
        }
        return count;
    }
}
