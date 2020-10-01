package iterator.dinermergercafe;

import java.util.ArrayList;

public class MenuTestDriveWithList {
	public static void main(String args[]) {
		ArrayList<Iterable<MenuItem>> menus = new ArrayList<>();
		menus.add(new PancakeHouseMenu());
		menus.add(new DinerMenu());
		menus.add(new CafeMenu());

		WaitressWithList waitress = new WaitressWithList(menus);

		waitress.printMenu();

//		waitress.printVegetarianMenu();
//
//		System.out.println("\nCustomer asks, is the Hotdog vegetarian?");
//		System.out.print("Waitress says: ");
//		if (waitress.isItemVegetarian("Hotdog")) {
//			System.out.println("Yes");
//		} else {
//			System.out.println("No");
//		}
//		System.out.println("\nCustomer asks, are the Waffles vegetarian?");
//		System.out.print("Waitress says: ");
//		if (waitress.isItemVegetarian("Waffles")) {
//			System.out.println("Yes");
//		} else {
//			System.out.println("No");
//		}
	}
}
