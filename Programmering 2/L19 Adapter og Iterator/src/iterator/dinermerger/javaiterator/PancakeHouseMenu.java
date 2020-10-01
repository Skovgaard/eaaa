package iterator.dinermerger.javaiterator;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Iterable<MenuItem> {
	private ArrayList<MenuItem> menuItems;

	public PancakeHouseMenu() {
		menuItems = new ArrayList<>();

		this.addItem("K&B's Pancake Breakfast",
				"Pancakes with scrambled eggs, and toast",
				true,
				2.99);

		this.addItem("Regular Pancake Breakfast",
				"Pancakes with fried eggs, sausage",
				false,
				2.99);

		this.addItem("Blueberry Pancakes",
				"Pancakes made with fresh blueberries",
				true,
				3.49);

		this.addItem("Waffles",
				"Waffles, with your choice of blueberries or strawberries",
				true,
				3.59);
	}

	public void addItem(String name, String description,
			boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}

//	public ArrayList<MenuItem> getMenuItems() {
//		return menuItems;
//	}

	@Override
	public Iterator<MenuItem> createIterator() {
//		return new PancakeHouseMenuIterator(menuItems);
		return menuItems.iterator();
	}

	@Override
	public String toString() {
		return "Objectville Pancake House Menu";
	}

	// other menu methods here
}
