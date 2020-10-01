package ex4;

import ex2.Dictionary;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDictionary<K, V> implements Dictionary<K, V> {

    private final int INITIAL_SIZE = 10;
    private ArrayList<Node>[] buckets = new ArrayList[INITIAL_SIZE];
    private int currentSize;

    public ArrayDictionary() {
        for (int i = 0; i < INITIAL_SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
        currentSize = 0;
    }

    @Override
    public V get(K key) {
        int hashValue = hashValue(key);
        for (Node node : buckets[hashValue]) {
            if (node.key.equals(key))
                return node.value;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public V put(K key, V value) {
        int hashValue = hashValue(key);
        if (get(key) == null) {
            Node newNode = new Node(key, value);
            buckets[hashValue].add(newNode);
            currentSize++;
        } else {
            for (Node node : buckets[hashValue]) {
                if (node.key.equals(key)) {
                    V oldValue = node.value;
                    node.value = value;
                    return oldValue;
                }
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int hashValue = hashValue(key);
        for (Node node : buckets[hashValue]) {
            if (node.key.equals(key)) {
                buckets[hashValue].remove(node);
                currentSize--;
                return node.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private int hashValue(K x) {
        int h = x.hashCode();
        if (h < 0) {
            h = -h;
        }
        h = h % buckets.length;
        return h;
    }

    @Override
    public String toString() {
        return Arrays.toString(buckets);
    }

    private class Node {

        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
