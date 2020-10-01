package iterator.dinermerger.javaiterator;

import java.util.Iterator;

public interface Iterable<T> { // named Menu in the book
	public Iterator<T> createIterator();
}
