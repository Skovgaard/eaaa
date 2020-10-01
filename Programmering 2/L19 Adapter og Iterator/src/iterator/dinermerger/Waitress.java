package iterator.dinermerger;

public class Waitress {
	private PancakeHouseMenu pancakeHouseMenu;
	private DinerMenu dinerMenu;

	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}

	public void printMenu() {
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();

		System.out.println("MENU\n----\nBREAKFAST");
		this.printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		this.printMenu(dinerIterator);
	}

	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

//	public void printVegetarianMenu() {
//		this.printVegetarianMenu(pancakeHouseMenu.createIterator());
//		this.printVegetarianMenu(dinerMenu.createIterator());
//	}
//
//	public boolean isItemVegetarian(String name) {
//		Iterator<MenuItem> breakfastIterator = pancakeHouseMenu.createIterator();
//		if (this.isVegetarian(name, breakfastIterator))
//			return true;
//		Iterator<MenuItem> dinnerIterator = dinerMenu.createIterator();
//		if (this.isVegetarian(name, dinnerIterator))
//			return true;
//		return false;
//	}
//
//	private void printVegetarianMenu(Iterator<MenuItem> iterator) {
//		while (iterator.hasNext()) {
//			MenuItem menuItem = iterator.next();
//			if (menuItem.isVegetarian()) {
//				System.out.print(menuItem.getName());
//				System.out.println("\t\t" + menuItem.getPrice());
//				System.out.println("\t" + menuItem.getDescription());
//			}
//		}
//	}
//
//	private boolean isVegetarian(String name, Iterator<MenuItem> iterator) {
//		while (iterator.hasNext()) {
//			MenuItem menuItem = iterator.next();
//			if (menuItem.getName().equals(name)) {
//				if (menuItem.isVegetarian())
//					return true;
//			}
//		}
//		return false;
//	}
}
