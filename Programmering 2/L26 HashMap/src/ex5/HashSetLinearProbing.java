package ex5;

// TODO: Kan optimeres flere steder, hvor den tjekker både null og DELETED

/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetLinearProbing {
    private Object[] buckets;
    private int currentSize;
    private static final String DELETED = "DELETED";

    /**
     * Constructs a hash table.
     *
     * @param bucketsLength the length of the buckets array
     */
    public HashSetLinearProbing(int bucketsLength) {
        buckets = new Object[bucketsLength];
        currentSize = 0;
    }

    /**
     * Tests for set membership.
     *
     * @param x an object
     * @return true if x is an element of this set
     */
    public boolean contains(Object x) {
        int h = hashValue(x);
        Object bucket = buckets[h];
        while (bucket != null) {
            if (bucket.equals(x))
                return true;
            h = (h + 1) % buckets.length;
            bucket = buckets[h];
        }
        return false;
    }

    /**
     * Adds an element to this set.
     *
     * @param x an object
     * @return true if x is a new object, false if x was already in the set
     */
    public boolean add(Object x) {

        if (loadFactor() > 0.75)
            rehash();

        if (contains(x))
            return false;
        if (currentSize == buckets.length)
            throw new IllegalStateException("HashSet is full");
        int h = hashValue(x);
        Object bucket = buckets[h];
        while (bucket != null && !bucket.equals(DELETED)) {
            h = (h + 1) % buckets.length;
            bucket = buckets[h];
        }
        buckets[h] = x;
        currentSize++;
        return true;
    }

    private double loadFactor() {
        return (double) currentSize / buckets.length;
    }

    /**
     * Removes an object from this set.
     *
     * @param x an object
     * @return true if x was removed from this set, false if x was not an
     * element of this set
     */
    public boolean remove(Object x) {
        int h = hashValue(x);
        Object bucket = buckets[h];
        while (bucket != null && !bucket.equals(DELETED)) {
            if (bucket.equals(x)) {
                buckets[h] = DELETED;
                return true;
            }
            h = (h + 1) % buckets.length;
            bucket = buckets[h];
        }
        return false;
    }

    /**
     * Gets the number of elements in this set.
     *
     * @return the number of elements
     */
    public int size() {
        return currentSize;
    }

    private int hashValue(Object x) {
        int h = x.hashCode();
        if (h < 0) {
            h = -h;
        }
        h = h % buckets.length;
        return h;
    }

    private void rehash() {
        Object[] oldBuckets = buckets;
        int oldSize = currentSize;
        buckets = new Object[buckets.length * 2];
        for (Object o : oldBuckets) {
            if (o != null && o != DELETED) {
                add(o);
            }
        }
        currentSize = oldSize;
    }

    // method only for test purpose
    public void writeOut() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println(i + "\t" + buckets[i]);
        }
    }

}
