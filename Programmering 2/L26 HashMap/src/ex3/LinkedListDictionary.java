package ex3;

import ex2.Dictionary;

import java.util.LinkedList;

public class LinkedListDictionary<K, V> implements Dictionary<K, V> {

    LinkedList<Node> linkedList = new LinkedList<>();

    @Override
    public V get(K key) {
        for (Node node : linkedList) {
            if (node.key.equals(key))
                return node.value;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        if (get(key) == null) {
            linkedList.addLast(new Node(key, value));
            return null;
        } else {
            V oldValue = get(key);
            for (Node node : linkedList) {
                if (node.key.equals(key))
                    node.value = value;
            }
            return oldValue;
        }
    }

    @Override
    public V remove(K key) {
        for (Node node : linkedList) {
            if (node.key.equals(key)) {
                linkedList.remove(node);
                return node.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public String toString() {
        return linkedList.toString();
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
