package iterator.dinermergercafe;

import java.util.HashMap;
import java.util.Iterator;

public class CafeMenu implements Iterable<MenuItem> {
	HashMap<String, MenuItem> menuItems = new HashMap<>();

	public CafeMenu() {
		this.addItem("Veggie Burger and Air Fries",
				"Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
				true, 3.99);
		this.addItem("Soup of the day",
				"A cup of the soup of the day, with a side salad",
				false, 3.69);
		this.addItem("Burrito",
				"A large burrito, with whole pinto beans, salsa, guacamole",
				true, 4.29);
	}

	public void addItem(String name, String description,
			boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(menuItem.getName(), menuItem);
	}

//	public HashMap<String, MenuItem> getItems() {
//		return menuItems;
//	}

	@Override
	public Iterator<MenuItem> createIterator() {
		return menuItems.values().iterator();
	}
}
