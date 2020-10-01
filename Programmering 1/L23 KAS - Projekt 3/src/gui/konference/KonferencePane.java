package gui.konference;

import java.time.LocalDate;
import java.util.ArrayList;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tillæg;
import application.model.Tilmelding;
import application.model.Udflugt;
import gui.MainApp;
import gui.hotel.HotelOpretWindow;
import gui.hotel.HotelOversigtWindow;
import gui.hotel.HotelTilføjWindow;
import gui.tillæg.TillægOpretWindow;
import gui.tilmelding.TilmeldingOversigtWindow;
import gui.tilmelding.TilmeldingWindow;
import gui.udflugt.UdflugtOpretWindow;
import gui.udflugt.UdflugtOversigtWindow;
import gui.windows.AlertWindow;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
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

public class KonferencePane extends GridPane {

	private Konference konference;

	private TableView<Tilmelding> tvTilmeldinger;
	private TableView<Hotel> tvHoteller;
	private TableView<Tillæg> tvTillæg;
	private TableView<Udflugt> tvUdflugter;

	private Button btnOpretTilmelding, btnFjernTilmelding, btnOversigtTilmelding, btnOpretHotel, btnTilføjHotel,
			btnFjernHotel, btnOversigtHotel, btnOpretTillæg, btnFjernTillæg, btnOpretUdflugt, btnFjernUdflugt,
			btnTilbage, btnOversigtUdflugt;

	public KonferencePane(Konference k) {
		this.konference = k;

		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblKonference = new Label(k.getName());
		lblKonference.setFont(new Font(20));
		this.add(lblKonference, 0, 0, 1, 1);

		this.add(new Separator(), 0, 1, 4, 1);

		Label lblTilmeldinger = new Label("Tilmeldinger:");
		lblTilmeldinger.setFont(new Font(15));
		this.add(lblTilmeldinger, 0, 2);

		tvTilmeldinger = new TableView<>();
		this.add(tvTilmeldinger, 0, 3, 1, 9);
		tvTilmeldinger.setMinWidth(537);
		tvTilmeldinger.setMaxWidth(537);
		tvTilmeldinger.setMinHeight(500);
		tvTilmeldinger.setMaxHeight(500);

		createTilmeldingerTable();

		ChangeListener<Tilmelding> tilmeldingListener = (ov, oldTilmelding,
				newTilmelding) -> selectedTilmeldingChanged();
		tvTilmeldinger.getSelectionModel().selectedItemProperty().addListener(tilmeldingListener);

		HBox hbxButtonsTilmeld = new HBox(50);
		this.add(hbxButtonsTilmeld, 0, 12, 1, 1);
		hbxButtonsTilmeld.setPadding(new Insets(00, 0, 0, 0));
		hbxButtonsTilmeld.setAlignment(Pos.BASELINE_CENTER);

		btnOpretTilmelding = new Button("Ny tilmelding");
		hbxButtonsTilmeld.getChildren().add(btnOpretTilmelding);
		btnOpretTilmelding.setOnAction(event -> opretTilmeldingAction());

		btnFjernTilmelding = new Button("Fjern");
		hbxButtonsTilmeld.getChildren().add(btnFjernTilmelding);
		btnFjernTilmelding.setOnAction(event -> fjernTilmeldingAction());
		btnFjernTilmelding.setDisable(true);

		btnOversigtTilmelding = new Button("Oversigt");
		hbxButtonsTilmeld.getChildren().add(btnOversigtTilmelding);
		btnOversigtTilmelding.setOnAction(event -> oversigtTilmeldingAction());

		this.add(new Separator(Orientation.VERTICAL), 1, 2, 1, 11);

		int secondColumnTableWidth = 385;

		Label lblHoteller = new Label("Hoteller:");
		lblHoteller.setFont(new Font(15));
		this.add(lblHoteller, 2, 2);

		tvHoteller = new TableView<>();
		this.add(tvHoteller, 2, 3, 1, 1);
		tvHoteller.setMinWidth(secondColumnTableWidth);
		tvHoteller.setMaxWidth(secondColumnTableWidth);
		tvHoteller.setMinHeight(103);
		tvHoteller.setMaxHeight(103);

		createHotelTable();

		ChangeListener<Hotel> hotelListener = (ov, oldHotel, newHotel) -> selectedHotelChanged();
		tvHoteller.getSelectionModel().selectedItemProperty().addListener(hotelListener);

		HBox hbxButtonsHotel = new HBox(25);
		this.add(hbxButtonsHotel, 2, 4, 1, 1);
		hbxButtonsHotel.setPadding(new Insets(0, 0, 0, 0));
		hbxButtonsHotel.setAlignment(Pos.BASELINE_CENTER);

		btnOpretHotel = new Button("Opret");
		hbxButtonsHotel.getChildren().add(btnOpretHotel);
		btnOpretHotel.setOnAction(event -> opretHotelAction());

		btnTilføjHotel = new Button("Tilføj");
		hbxButtonsHotel.getChildren().add(btnTilføjHotel);
		btnTilføjHotel.setOnAction(event -> tilføjHotelAction());

		checkTilføjHotel();

		btnFjernHotel = new Button("Fjern");
		hbxButtonsHotel.getChildren().add(btnFjernHotel);
		btnFjernHotel.setOnAction(event -> fjernHotelAction());
		btnFjernHotel.setDisable(true);

		btnOversigtHotel = new Button("Oversigt");
		hbxButtonsHotel.getChildren().add(btnOversigtHotel);
		btnOversigtHotel.setOnAction(event -> oversigtHotelAction());

		this.add(new Separator(), 2, 5, 1, 1);

		Label lblTillæg = new Label("Tillæg: (til valgt hotel)");
		lblTillæg.setFont(new Font(15));
		this.add(lblTillæg, 2, 6);

		tvTillæg = new TableView<>();
		this.add(tvTillæg, 2, 7, 1, 1);
		tvTillæg.setMinWidth(secondColumnTableWidth);
		tvTillæg.setMaxWidth(secondColumnTableWidth);
		tvTillæg.setMinHeight(103);
		tvTillæg.setMaxHeight(103);

		createTillægTable();

		ChangeListener<Tillæg> tillægListener = (ov, oldTillæg, newTillæg) -> selectedTillægChanged();
		tvTillæg.getSelectionModel().selectedItemProperty().addListener(tillægListener);

		HBox hbxButtonsTillæg = new HBox(25);
		this.add(hbxButtonsTillæg, 2, 8, 1, 1);
		hbxButtonsTillæg.setPadding(new Insets(0, 0, 0, 0));
		hbxButtonsTillæg.setAlignment(Pos.BASELINE_CENTER);

		btnOpretTillæg = new Button("Opret");
		btnOpretTillæg.setDisable(true);
		hbxButtonsTillæg.getChildren().add(btnOpretTillæg);
		btnOpretTillæg.setOnAction(event -> opretTillægAction());

		btnFjernTillæg = new Button("Fjern");
		hbxButtonsTillæg.getChildren().add(btnFjernTillæg);
		btnFjernTillæg.setOnAction(event -> fjernTillægAction());
		btnFjernTillæg.setDisable(true);

		this.add(new Separator(), 2, 9, 1, 1);

		Label lblUdflugt = new Label("Udflugter:");
		lblUdflugt.setFont(new Font(15));
		this.add(lblUdflugt, 2, 10);

		tvUdflugter = new TableView<>();
		this.add(tvUdflugter, 2, 11, 1, 1);
		tvUdflugter.setMinWidth(secondColumnTableWidth);
		tvUdflugter.setMaxWidth(secondColumnTableWidth);
		tvUdflugter.setMinHeight(103);
		tvUdflugter.setMaxHeight(103);

		createUdflugtTable();

		ChangeListener<Udflugt> udflugtListener = (ov, oldUdflugt, newUdflugt) -> selectedUdflugtChanged();
		tvUdflugter.getSelectionModel().selectedItemProperty().addListener(udflugtListener);

		HBox hbxButtonsUdflugt = new HBox(25);
		this.add(hbxButtonsUdflugt, 2, 12, 1, 1);
		hbxButtonsUdflugt.setPadding(new Insets(0, 0, 0, 0));
		hbxButtonsUdflugt.setAlignment(Pos.BASELINE_CENTER);

		btnOpretUdflugt = new Button("Opret");
		hbxButtonsUdflugt.getChildren().add(btnOpretUdflugt);
		btnOpretUdflugt.setOnAction(event -> opretUdflugtAction());

		btnFjernUdflugt = new Button("Fjern");
		hbxButtonsUdflugt.getChildren().add(btnFjernUdflugt);
		btnFjernUdflugt.setOnAction(event -> fjernUdflugtAction());
		btnFjernUdflugt.setDisable(true);

		btnOversigtUdflugt = new Button("Oversigt");
		hbxButtonsUdflugt.getChildren().add(btnOversigtUdflugt);
		btnOversigtUdflugt.setOnAction(event -> oversigtUdflugtAction());

		this.add(new Separator(), 0, 13, 3, 1);

		HBox hbxButtons = new HBox(100);
		this.add(hbxButtons, 0, 14, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		btnTilbage = new Button("Tilbage til Konference Oversigt");
		hbxButtons.getChildren().add(btnTilbage);
		btnTilbage.setOnAction(event -> tilbageAction());

	}

	private void createTilmeldingerTable() {

		tvTilmeldinger.setEditable(false);

		TableColumn<Tilmelding, String> column1 = new TableColumn<>("Navn");
		column1.setCellValueFactory(new PropertyValueFactory<>("name"));
		column1.setPrefWidth(100);

		TableColumn<Tilmelding, String> column2 = new TableColumn<>("Tlf. nr.");
		column2.setCellValueFactory(new PropertyValueFactory<>("tlfNr"));
		column2.setPrefWidth(75);

		TableColumn<Tilmelding, Boolean> column3 = new TableColumn<>("Foredragsholder");
		column3.setCellValueFactory(new PropertyValueFactory<>("foredragsholderJaNej"));

		TableColumn<Tilmelding, LocalDate> column4 = new TableColumn<>("Ankomst");
		column4.setCellValueFactory(new PropertyValueFactory<>("ankomstDato"));

		TableColumn<Tilmelding, LocalDate> column5 = new TableColumn<>("Afrejse");
		column5.setCellValueFactory(new PropertyValueFactory<>("afrejseDato"));

		TableColumn<Tilmelding, Double> column6 = new TableColumn<>("Samlet pris");
		column6.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

		tvTilmeldinger.getColumns().add(column1);
		tvTilmeldinger.getColumns().add(column2);
		tvTilmeldinger.getColumns().add(column3);
		tvTilmeldinger.getColumns().add(column4);
		tvTilmeldinger.getColumns().add(column5);
		tvTilmeldinger.getColumns().add(column6);

		tvTilmeldinger.getItems().addAll(konference.getTilmeldinger());
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

		tvHoteller.getItems().addAll(konference.getHoteller());

	}

	private void createTillægTable() {
		tvTillæg.setEditable(false);

		TableColumn<Tillæg, String> column1 = new TableColumn<>("Navn");
		column1.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Tillæg, LocalDate> column2 = new TableColumn<>("Pris (kr)");
		column2.setCellValueFactory(new PropertyValueFactory<>("price"));

		tvTillæg.getColumns().add(column1);
		tvTillæg.getColumns().add(column2);
	}

	private void createUdflugtTable() {
		tvUdflugter.setEditable(false);

		TableColumn<Udflugt, String> column1 = new TableColumn<>("Navn, sted");
		column1.setCellValueFactory(new PropertyValueFactory<>("nameAndPlace"));

		TableColumn<Udflugt, LocalDate> column2 = new TableColumn<>("Dato");
		column2.setCellValueFactory(new PropertyValueFactory<>("date"));

		TableColumn<Udflugt, LocalDate> column3 = new TableColumn<>("Pris (kr)");
		column3.setCellValueFactory(new PropertyValueFactory<>("priceAndBreakfast"));

		tvUdflugter.getColumns().add(column1);
		tvUdflugter.getColumns().add(column2);
		tvUdflugter.getColumns().add(column3);

		tvUdflugter.getItems().addAll(konference.getUdflugter());

	}

	private void checkTilføjHotel() {
		ArrayList<Hotel> hoteller = new ArrayList<>();
		for (Hotel h : Controller.getHoteller()) {
			if (!konference.getHoteller().contains(h)) {
				hoteller.add(h);
			}
		}
		if (hoteller.isEmpty())
			btnTilføjHotel.setDisable(true);
		else
			btnTilføjHotel.setDisable(false);

	}

	// ---------------------------------------------------------------------------------------

	private void opretTilmeldingAction() {
		TilmeldingWindow tw = new TilmeldingWindow("Ny tilmelding", konference);
		tw.showAndWait();

		updateTilmeldinger();
	}

	private void fjernTilmeldingAction() {
		Tilmelding t = tvTilmeldinger.getSelectionModel().getSelectedItem();
		Controller.removeTilmeldingFromKonference(t, konference);

		updateTilmeldinger();

		btnFjernTilmelding.setDisable(true);
	}

	private void oversigtTilmeldingAction() {
		TilmeldingOversigtWindow tow = new TilmeldingOversigtWindow("Tilmeldings Oversigt", konference);
		tow.showAndWait();
	}

	private void selectedTilmeldingChanged() {
		Tilmelding t = tvTilmeldinger.getSelectionModel().getSelectedItem();
		if (t != null) {
			btnFjernTilmelding.setDisable(false);
		} else {
			btnFjernTilmelding.setDisable(true);
		}
	}

	private void updateTilmeldinger() {
		tvTilmeldinger.getItems().clear();
		tvTilmeldinger.getItems().setAll(konference.getTilmeldinger());
	}

	// ---------------------------------------------------------------------------------------

	private void opretHotelAction() {
		HotelOpretWindow how = new HotelOpretWindow("Opret hotel for " + konference.getName(), konference);
		how.showAndWait();

		updateHoteller();
	}

	private void tilføjHotelAction() {
		HotelTilføjWindow htw = new HotelTilføjWindow("Tilføj hotel", konference);
		htw.showAndWait();

		updateHoteller();

		checkTilføjHotel();
	}

	private void fjernHotelAction() {
		Hotel h = tvHoteller.getSelectionModel().getSelectedItem();

		for (Tilmelding t : konference.getTilmeldinger()) {
			if (h == t.getHotel()) {
				new AlertWindow("Kan ikke fjerne hotel", "Hotel tilknyttet en/flere tilmeldinger");
				return;
			}
		}

		Controller.removeHotelFromKonference(h, konference);

		updateHoteller();

		checkTilføjHotel();
	}

	private void oversigtHotelAction() {
		HotelOversigtWindow how = new HotelOversigtWindow("Hotel Oversigt", konference);
		how.showAndWait();
	}

	private void selectedHotelChanged() {
		Hotel h = tvHoteller.getSelectionModel().getSelectedItem();
		if (h != null) {
			btnOpretTillæg.setDisable(false);
			btnFjernHotel.setDisable(false);
			tvTillæg.getItems().clear();
			tvTillæg.getItems().addAll(h.getTillæg());
		} else {
			btnOpretTillæg.setDisable(true);
			btnFjernHotel.setDisable(true);
		}
	}

	public void updateHoteller() {
		tvHoteller.getItems().clear();
		tvHoteller.getItems().setAll(konference.getHoteller());
	}

	// ---------------------------------------------------------------------------------------

	private void opretTillægAction() {
		Hotel h = tvHoteller.getSelectionModel().getSelectedItem();
		TillægOpretWindow how = new TillægOpretWindow("Opret tillæg for " + h.getName(), konference, h);
		how.showAndWait();

		updateTillæg();
	}

	private void fjernTillægAction() {
		Hotel h = tvHoteller.getSelectionModel().getSelectedItem();
		Tillæg t = tvTillæg.getSelectionModel().getSelectedItem();

		for (Tilmelding til : Controller.getTilmeldinger()) {

			if (til.getTillæg() == null)
				continue;
			if (til.getTillæg().contains(t)) {
				new AlertWindow("Kan ikke fjerne tillæg", "Tillæg tilknyttet en/flere tilmeldinger");
				return;
			}
		}

		Controller.removeTillægFromHotel(t, h);

		updateTillæg();
	}

	private void selectedTillægChanged() {
		Tillæg t = tvTillæg.getSelectionModel().getSelectedItem();
		if (t != null) {
			btnFjernTillæg.setDisable(false);
		} else {
			btnFjernTillæg.setDisable(true);
		}
	}

	public void updateTillæg() {
		Hotel h = tvHoteller.getSelectionModel().getSelectedItem();

		tvTillæg.getItems().clear();
		tvTillæg.getItems().addAll(h.getTillæg());
	}

	// ---------------------------------------------------------------------------------------

	private void opretUdflugtAction() {
		UdflugtOpretWindow uow = new UdflugtOpretWindow("Opret udflugt for " + konference.getName(), konference);
		uow.showAndWait();

		updateUdflugter();
	}

	private void fjernUdflugtAction() {
		Udflugt u = tvUdflugter.getSelectionModel().getSelectedItem();

		for (Tilmelding t : konference.getTilmeldinger()) {

			if (t.getUdflugter() == null)
				continue;
			if (t.getUdflugter().contains(u)) {
				new AlertWindow("Kan ikke fjerne udflugt", "Udflugt tilknyttet en/flere tilmeldinger");
				return;
			}
		}

		Controller.removeUdflugtFromKonference(u, konference);

		updateUdflugter();

	}

	private void oversigtUdflugtAction() {
		UdflugtOversigtWindow uow = new UdflugtOversigtWindow("Oversigt over udflugter", konference);
		uow.showAndWait();
	}

	private void selectedUdflugtChanged() {
		Udflugt u = tvUdflugter.getSelectionModel().getSelectedItem();
		if (u != null) {
			btnFjernUdflugt.setDisable(false);
		} else {
			btnFjernUdflugt.setDisable(true);
		}
	}

	private void updateUdflugter() {
		tvUdflugter.getItems().clear();
		tvUdflugter.getItems().addAll(konference.getUdflugter());
	}

	// ---------------------------------------------------------------------------------------

	private void tilbageAction() {
		MainApp.changeWindow(null);
	}
}
