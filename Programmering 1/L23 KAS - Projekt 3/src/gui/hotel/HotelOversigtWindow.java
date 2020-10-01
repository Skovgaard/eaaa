package gui.hotel;

import application.model.Hotel;
import application.model.Konference;
import application.model.Tilmelding;
import gui.windows.KonferenceWindow;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class HotelOversigtWindow extends KonferenceWindow {

	public HotelOversigtWindow(String title, Konference k) {
		super(title, k);
	}

	private TreeTableView<Object> ttvHoteller;

	public void content(GridPane pane) {

		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblKonference = new Label("Oversigt over deltagere til hoteller");
		lblKonference.setFont(new Font(20));
		pane.add(lblKonference, 0, 0, 1, 1);

		ttvHoteller = new TreeTableView<>();
		pane.add(ttvHoteller, 0, 3, 1, 9);

		createHotelTable();

	}

	private void createHotelTable() {

		ttvHoteller.setEditable(false);

		TreeTableColumn<Object, String> column1 = new TreeTableColumn<>("Navn");
		column1.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
		column1.setMinWidth(150);

		TreeTableColumn<Object, String> column2 = new TreeTableColumn<>("Ledsager");
		column2.setCellValueFactory(new TreeItemPropertyValueFactory<>("ledsager"));
		column2.setMinWidth(100);

		TreeTableColumn<Object, String> column3 = new TreeTableColumn<>("Tillæg");
		column3.setCellValueFactory(new TreeItemPropertyValueFactory<>("tillægString"));

		TreeTableColumn<Object, String> column4 = new TreeTableColumn<>("Tlf. nr.");
		column4.setCellValueFactory(new TreeItemPropertyValueFactory<>("tlfNr"));
		column4.setMinWidth(75);

		TreeTableColumn<Object, String> column5 = new TreeTableColumn<>("Ankomst dato");
		column5.setCellValueFactory(new TreeItemPropertyValueFactory<>("ankomstDato"));

		TreeTableColumn<Object, String> column6 = new TreeTableColumn<>("Afrejse dato");
		column6.setCellValueFactory(new TreeItemPropertyValueFactory<>("afrejseDato"));

		ttvHoteller.getColumns().add(column1);
		ttvHoteller.getColumns().add(column2);
		ttvHoteller.getColumns().add(column3);
		ttvHoteller.getColumns().add(column4);
		ttvHoteller.getColumns().add(column5);
		ttvHoteller.getColumns().add(column6);

		TreeItem<Object> root = new TreeItem<Object>(new Object());
		ttvHoteller.setRoot(root);
		ttvHoteller.setShowRoot(false);

		for (Hotel h : konference.getHoteller()) {

			TreeItem<Object> hotel = new TreeItem<Object>(h);
			root.getChildren().add(hotel);

			for (Tilmelding t : konference.getTilmeldinger()) {

				if (t.getHotel() == h) {
					TreeItem<Object> tilmelding = new TreeItem<Object>(t);
					hotel.getChildren().add(tilmelding);
				}
			}
		}

	}

}
