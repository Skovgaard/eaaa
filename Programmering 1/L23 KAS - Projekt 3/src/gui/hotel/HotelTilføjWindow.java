package gui.hotel;

import java.time.LocalDate;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Konference;
import gui.windows.KonferenceWindow;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class HotelTilføjWindow extends KonferenceWindow {

	public HotelTilføjWindow(String title, Konference k) {
		super(title, k);
	}

	private TableView<Hotel> tvHoteller;
	private Button btnTilbage, btnTilføj;

	public void content(GridPane pane) {

		Label lblOpretHotel = new Label("Tilføj hotel");
		lblOpretHotel.setFont(new Font(20));
		pane.add(lblOpretHotel, 0, 0);

		pane.add(new Separator(), 0, 1, 2, 1);

		tvHoteller = new TableView<>();
		pane.add(tvHoteller, 0, 2, 1, 1);
		tvHoteller.setMinWidth(370);
		tvHoteller.setMaxWidth(370);
		tvHoteller.setMinHeight(103);
		tvHoteller.setMaxHeight(103);

		ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> selectedHotelChanged();
		tvHoteller.getSelectionModel().selectedItemProperty().addListener(listener);

		createHotelTable();

		HBox hbxButtons = new HBox(25);
		pane.add(hbxButtons, 0, 5, 1, 1);
		hbxButtons.setPadding(new Insets(0, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		btnTilbage = new Button("Tilbage");
		hbxButtons.getChildren().add(btnTilbage);
		btnTilbage.setOnAction(event -> tilbageAction());

		btnTilføj = new Button("Tilføj");
		hbxButtons.getChildren().add(btnTilføj);
		btnTilføj.setOnAction(event -> tilføjAction());
		btnTilføj.setDisable(true);

	}

	private void selectedHotelChanged() {
		Hotel h = tvHoteller.getSelectionModel().getSelectedItem();
		if (h != null) {
			btnTilføj.setDisable(false);
		} else {
			btnTilføj.setDisable(true);
		}
	}

	private void createHotelTable() {
		tvHoteller.setEditable(false);

		TableColumn<Hotel, String> column1 = new TableColumn<>("Navn");
		column1.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Hotel, LocalDate> column2 = new TableColumn<>("Dobbelt Pris (kr)");
		column2.setCellValueFactory(new PropertyValueFactory<>("doublePrice"));

		TableColumn<Hotel, LocalDate> column3 = new TableColumn<>("Enkelt pris (kr)");
		column3.setCellValueFactory(new PropertyValueFactory<>("singlePrice"));

		tvHoteller.getColumns().add(column1);
		tvHoteller.getColumns().add(column2);
		tvHoteller.getColumns().add(column3);

		for (Hotel h : Controller.getHoteller()) {
			if (!konference.getHoteller().contains(h)) {
				tvHoteller.getItems().add(h);
			}
		}
	}

	private void tilføjAction() {

		Hotel h = tvHoteller.getSelectionModel().getSelectedItem();
		Controller.addHotelToKonference(h, konference);
		hide();
	}

	private void tilbageAction() {
		hide();
	}

}
