package ex7;

public interface Bag {
    /**
     * Add the string to the bag
     */
    public void add(String s);

    /**
     * Remove the string from the bag (if it is the bag).
     */
    public void remove(String s);

    /**
     * Get the count the string in the bag.
     */
    public int getCount(String s);
}