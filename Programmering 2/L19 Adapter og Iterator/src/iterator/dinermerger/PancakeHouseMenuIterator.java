package iterator.dinermerger;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PancakeHouseMenuIterator implements Iterator<MenuItem> {
	private ArrayList<MenuItem> items;
	private int position = 0;

	public PancakeHouseMenuIterator(ArrayList<MenuItem> items) {
		this.items = items;
	}

	@Override
	public MenuItem next() {
		if (!this.hasNext())
			throw new NoSuchElementException();

		MenuItem item = items.get(position);
		position = position + 1;
		return item;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.size())
			return false;
		else
			return true;
	}
}
