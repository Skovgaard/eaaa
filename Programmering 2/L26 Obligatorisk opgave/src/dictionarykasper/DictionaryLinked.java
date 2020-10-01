package dictionarykasper;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

    private Node start;
    private int size;

    /**
     * HashingMap constructor comment.
     */

    public DictionaryLinked() {
        // Sentinel (tomt listehoved - der ikke indeholder data)
        start = new Node();
        size = 0;
    }

    @Override
    public V get(K key) {
        Node node = start;
        while (node != null && node.key != null) {
            if (node.key.equals(key))
                return node.value;
            node = node.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        Node prevNode = null;
        Node node = start;
        while (node != null && node.key != null) {
            if (node.key.equals(key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            prevNode = node;
            node = node.next;
        }

        Node newNode = new Node();
        newNode.next = null;
        newNode.key = key;
        newNode.value = value;

        if (prevNode != null)
            prevNode.next = newNode;
        if (isEmpty())
            start = newNode;
        size++;

        return null;
    }

    @Override
    public V remove(K key) {
        Node prevNode = null;
        Node node = start;
        while (node != null && node.key != null) {
            if (node.key.equals(key)) {
                if (prevNode != null)
                    prevNode.next = node.next;
                if (node.equals(start))
                    start = node.next;
                size--;
                return node.value;
            }
            prevNode = node;
            node = node.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        Node next;
        K key;
        V value;
    }

}
