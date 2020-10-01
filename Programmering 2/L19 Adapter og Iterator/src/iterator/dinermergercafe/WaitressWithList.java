package iterator.dinermergercafe;

import java.util.ArrayList;
import java.util.Iterator;

public class WaitressWithList {
	private ArrayList<Iterable<MenuItem>> menus;

	public WaitressWithList(ArrayList<Iterable<MenuItem>> menus) {
		this.menus = menus;
	}

	public void printMenu() {
		Iterator<Iterable<MenuItem>> menuIterator = menus.iterator();
		while (menuIterator.hasNext()) {
			Iterable<MenuItem> menuItemIterator = menuIterator.next();
			this.printMenu(menuItemIterator.createIterator());
			System.out.println();
		}
//		System.out.println("MENU\n----\nBREAKFAST");
//		this.printMenu(pancakeIterator);
//		System.out.println("\nLUNCH");
//		this.printMenu(dinerIterator);
//		System.out.println("\nDINNER");
//		this.printMenu(cafeIterator);
	}

	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

//	public void printVegetarianMenu() {
//		System.out.println("\nVEGETARIAN MENU\n---------------");
//		this.printVegetarianMenu(pancakeHouseMenu.createIterator());
//		this.printVegetarianMenu(dinerMenu.createIterator());
//		this.printVegetarianMenu(cafeMenu.createIterator());
//	}
//
//	public boolean isItemVegetarian(String name) {
//		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
//		if (this.isVegetarian(name, pancakeIterator))
//			return true;
//		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
//		if (this.isVegetarian(name, dinerIterator))
//			return true;
//		Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();
//		if (this.isVegetarian(name, cafeIterator))
//			return true;
//		return false;
//	}
//
//	private void printVegetarianMenu(Iterator<MenuItem> iterator) {
//		while (iterator.hasNext()) {
//			MenuItem menuItem = (MenuItem) iterator.next();
//			if (menuItem.isVegetarian()) {
//				System.out.print(menuItem.getName() + ", ");
//				System.out.print(menuItem.getPrice() + " -- ");
//				System.out.println(menuItem.getDescription());
//			}
//		}
//	}
//
//	private boolean isVegetarian(String name, Iterator<MenuItem> iterator) {
//		while (iterator.hasNext()) {
//			MenuItem menuItem = (MenuItem) iterator.next();
//			if (menuItem.getName().equals(name)) {
//				if (menuItem.isVegetarian())
//					return true;
//			}
//		}
//		return false;
//	}
}
