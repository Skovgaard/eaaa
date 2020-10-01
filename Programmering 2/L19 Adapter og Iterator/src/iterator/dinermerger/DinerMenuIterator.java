package iterator.dinermerger;

import java.util.NoSuchElementException;

public class DinerMenuIterator implements Iterator<MenuItem> {
	private MenuItem[] items;
	private int position = 0;

	public DinerMenuIterator(MenuItem[] items) {
		this.items = items;
	}

	@Override
	public MenuItem next() {
		if (!this.hasNext())
			throw new NoSuchElementException();

		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.length || items[position] == null)
			return false;
		else
			return true;
	}
}
