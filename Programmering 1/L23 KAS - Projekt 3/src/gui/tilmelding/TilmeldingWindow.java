package gui.tilmelding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tillæg;
import application.model.Tilmelding;
import application.model.Udflugt;
import gui.windows.AlertWindow;
import gui.windows.KonferenceWindow;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.util.Callback;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class TilmeldingWindow extends KonferenceWindow {

	public TilmeldingWindow(String title, Konference k) {
		super(title, k);
	}

	private TextField txfNavn, txfAdresse, txfBy, txfLand, txfTlfNr, txfFirmaNavn, txfFirmaTlfNr, txfLedsagerNavn;
	private CheckBox cbxForedragsholder;
	private DatePicker dpAnkomst, dpAfrejse;
	private TableView<UdflugtValg> tvUdflugter;
	private TableView<HotelValg> tvHoteller;
	private TableView<HotelValg> tvTillæg;
	private Button btnCancel, btnTilmeld, btnTilmeldNæste;
	private HBox hbxHotelOgTilvalg;

	private HotelValg hotelValg;

	private ContextMenu contextMenu;
	private ArrayList<Deltager> tidligereDeltagerList;
	private Deltager deltager;

	public void content(GridPane pane) {

		Label lblDeltagerInformation = new Label("Deltagerinformation");
		lblDeltagerInformation.setFont(new Font(20));
		pane.add(lblDeltagerInformation, 0, 0, 4, 1);

		Label lblNavn = new Label("Navn:*");
		lblNavn.setPrefWidth(100);
		pane.add(lblNavn, 0, 1);

		txfNavn = new TextField();
		pane.add(txfNavn, 1, 1);

		contextMenu = new ContextMenu();
		txfNavn.setContextMenu(contextMenu);

		txfNavn.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!txfNavn.getText().isEmpty()) {
				updateContextMenu(txfNavn.getText());
				if (contextMenu.getItems().size() > 1)
					contextMenu.show(txfNavn, Side.BOTTOM, 0, 0);
				else
					contextMenu.hide();
			} else
				contextMenu.hide();

			if (deltager != null && !deltager.getName().equals(txfNavn.getText())) {
				txfAdresse.clear();
				txfAdresse.setDisable(false);
				txfBy.clear();
				txfBy.setDisable(false);
				txfLand.clear();
				txfLand.setDisable(false);
				txfTlfNr.clear();
				txfTlfNr.setDisable(false);
				txfFirmaNavn.clear();
				txfFirmaNavn.setDisable(false);
				txfFirmaTlfNr.clear();
				txfFirmaTlfNr.setDisable(false);
				deltager = null;
			}
		});

		tidligereDeltagerList = new ArrayList<>();
		tidligereDeltagerList.addAll(Controller.getDeltagere());

		// -----

		Label lblForedragsholder = new Label("Foredragsholder (Ja/Nej):");
		lblForedragsholder.setPrefWidth(150);
		pane.add(lblForedragsholder, 2, 1);

		cbxForedragsholder = new CheckBox();
		pane.add(cbxForedragsholder, 3, 1);

		Label lblAdresse = new Label("Adresse:*");
		pane.add(lblAdresse, 0, 2);

		txfAdresse = new TextField();
		pane.add(txfAdresse, 1, 2);

		Label lblBy = new Label("By:*");
		pane.add(lblBy, 2, 2);

		txfBy = new TextField();
		pane.add(txfBy, 3, 2);

		Label lblLand = new Label("Land:*");
		pane.add(lblLand, 0, 3);

		txfLand = new TextField();
		pane.add(txfLand, 1, 3);

		Label lblTlfNr = new Label("Tlf.nr.:*");
		pane.add(lblTlfNr, 2, 3);

		txfTlfNr = new TextField();
		pane.add(txfTlfNr, 3, 3);

		Label lblAnkomstDato = new Label("Ankomst Dato:*");
		pane.add(lblAnkomstDato, 0, 4);

		dpAnkomst = new DatePicker();
		pane.add(dpAnkomst, 1, 4);
		dpAnkomst.setEditable(false);
		dpAnkomst.setValue(konference.getStartDate());

		Label lblAfrejseDato = new Label("Afrejse Dato:*");
		pane.add(lblAfrejseDato, 2, 4);

		dpAfrejse = new DatePicker();
		pane.add(dpAfrejse, 3, 4);
		dpAfrejse.setEditable(false);
		dpAfrejse.setValue(konference.getEndDate());

		Label lblFirmaNavn = new Label("Firma Navn:");
		pane.add(lblFirmaNavn, 0, 5);

		txfFirmaNavn = new TextField();
		pane.add(txfFirmaNavn, 1, 5);

		Label lblFirmaTlfNr = new Label("Firma tlf.nr.:");
		pane.add(lblFirmaTlfNr, 2, 5);

		txfFirmaTlfNr = new TextField();
		pane.add(txfFirmaTlfNr, 3, 5);

		// ---------------------------------------------------------------------------------------

		Label lblProgramForLedsagere = new Label("Program for ledsagere");
		lblProgramForLedsagere.setFont(new Font(20));
		pane.add(lblProgramForLedsagere, 0, 6, 4, 1);

		Label lblLedsagerNavn = new Label("Ledsagernavn");
		pane.add(lblLedsagerNavn, 0, 7);

		txfLedsagerNavn = new TextField();
		pane.add(txfLedsagerNavn, 1, 7);

		txfLedsagerNavn.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!txfLedsagerNavn.getText().isEmpty())
				tvUdflugter.setDisable(false);
			else
				tvUdflugter.setDisable(true);
		});

		tvUdflugter = new TableView<>();
		pane.add(tvUdflugter, 0, 8, 4, 3);
		tvUdflugter.setDisable(true);
		tvUdflugter.setMinHeight(103);
		tvUdflugter.setMaxHeight(103);

		createUdflugtTable();

		// ---------------------------------------------------------------------------------------

		Label lblOvernatningsønsker = new Label("Overnatningsønsker");
		lblOvernatningsønsker.setFont(new Font(20));
		pane.add(lblOvernatningsønsker, 0, 12, 4, 1);

		hbxHotelOgTilvalg = new HBox(20);
		pane.add(hbxHotelOgTilvalg, 0, 13, 4, 1);
		hbxHotelOgTilvalg.setPadding(new Insets(0, 0, 0, 0));
		hbxHotelOgTilvalg.setAlignment(Pos.BASELINE_LEFT);

		tvHoteller = new TableView<>();
		hbxHotelOgTilvalg.getChildren().add(tvHoteller);
		tvHoteller.setMinWidth(350);
		tvHoteller.setMaxWidth(350);

		createHotelTable();

		tvTillæg = new TableView<>();
		hbxHotelOgTilvalg.getChildren().add(tvTillæg);
		tvTillæg.setMinWidth(250);
		tvTillæg.setMaxWidth(250);
		tvTillæg.setDisable(true);

		createTillægTable();

		// ---------------------------------------------------------------------------------------

		HBox hbxButtonsUdflugt = new HBox(20);
		pane.add(hbxButtonsUdflugt, 0, 14, 4, 1);
		hbxButtonsUdflugt.setPadding(new Insets(0, 0, 0, 0));
		hbxButtonsUdflugt.setAlignment(Pos.BASELINE_CENTER);

		btnCancel = new Button("Tilbage");
		hbxButtonsUdflugt.getChildren().add(btnCancel);
		btnCancel.setOnAction(event -> cancelAction());

		btnTilmeldNæste = new Button("Tilmeld næste");
		hbxButtonsUdflugt.getChildren().add(btnTilmeldNæste);
		btnTilmeldNæste.setOnAction(event -> tilmeldNæsteAction());

		btnTilmeld = new Button("Opret tilmelding");
		hbxButtonsUdflugt.getChildren().add(btnTilmeld);
		btnTilmeld.setOnAction(event -> tilmeldAction());

	}

	private void updateContextMenu(String txfNavnText) {

		int maxSize = 3;

		contextMenu.getItems().clear();
		MenuItem beskrivelseMenuItem = new MenuItem("Vælg tidligere deltager");
		beskrivelseMenuItem.setDisable(true);
		contextMenu.getItems().add(beskrivelseMenuItem);

		ArrayList<MenuItem> sortedList = new ArrayList<>();
		for (Deltager d : tidligereDeltagerList) {
			if (txfNavnText.length() > d.getName().length())
				continue;
			String subName = d.getName().toLowerCase().substring(0, txfNavnText.length());
			if (txfNavnText.toLowerCase().equals(subName)) {
				MenuItem item = new MenuItem(d.getName() + " (" + d.getTlfNr() + ")");
				item.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						deltager = d;
						txfNavn.setText(d.getName());
						txfAdresse.setText(d.getAdress());
						txfAdresse.setDisable(true);
						txfBy.setText(d.getCity());
						txfBy.setDisable(true);
						txfLand.setText(d.getLand());
						txfLand.setDisable(true);
						txfTlfNr.setText(d.getTlfNr());
						txfTlfNr.setDisable(true);
						txfFirmaNavn.setText(d.getCompanyName());
						txfFirmaNavn.setDisable(true);
						txfFirmaTlfNr.setText(d.getCompanyTlfNr());
						txfFirmaTlfNr.setDisable(true);
					}
				});
				sortedList.add(item);
			}
		}
		Collections.sort(sortedList, (d1, d2) -> d1.getText().compareTo(d2.getText()));

		if (sortedList.size() > maxSize)
			contextMenu.getItems().addAll(sortedList.subList(0, maxSize));
		else
			contextMenu.getItems().addAll(sortedList);
	}

	private void cancelAction() {
		this.hide();
	}

	public void tilmeldNæsteAction() {

		if (!opretTilmelding())
			return;

		txfNavn.clear();
		txfAdresse.clear();
		txfBy.clear();
		txfLand.clear();
		txfTlfNr.clear();
		txfFirmaNavn.clear();
		txfFirmaTlfNr.clear();
		txfLedsagerNavn.clear();

		cbxForedragsholder.setSelected(false);
		dpAnkomst.setValue(konference.getStartDate());
		dpAfrejse.setValue(konference.getEndDate());
		for (UdflugtValg uv : tvUdflugter.getItems()) {
			uv.setSelected(false);
		}
		for (HotelValg hv : tvHoteller.getItems()) {
			hv.setSelected(false);
			for (BooleanProperty bp : hv.getTillægValg()) {
				bp.set(false);
			}
		}
		tvTillæg.setVisible(false);

		hotelValg = null;

		tidligereDeltagerList.clear();
		tidligereDeltagerList.addAll(Controller.getDeltagere());

		deltager = null;

		// TODO Update for each added, not when done? Possible?

	}

	private void tilmeldAction() {
		if (opretTilmelding())
			this.hide();
	}

	private boolean opretTilmelding() {

		String navn = txfNavn.getText();
		String adresse = txfAdresse.getText();
		String by = txfBy.getText();
		String land = txfLand.getText();
		String tlfNr = txfTlfNr.getText();
		String firmaNavn = txfFirmaNavn.getText();
		String firmaTlfNr = txfFirmaTlfNr.getText();

		boolean foredragsholder = cbxForedragsholder.isSelected();
		LocalDate ankomstDato = dpAnkomst.getValue();
		LocalDate afrejseDato = dpAfrejse.getValue();
		String ledsager = txfLedsagerNavn.getText().isEmpty() ? null : txfLedsagerNavn.getText();
		Hotel hotel = hotelValg != null ? hotelValg.getHotel() : null;

		if (txfNavn.getText().isEmpty()) {
			new AlertWindow("Mangler navn", "");
			return false;
		}
		if (txfAdresse.getText().isEmpty()) {
			new AlertWindow("Mangler adresse", "");
			return false;
		}
		if (txfBy.getText().isEmpty()) {
			new AlertWindow("Mangler by", "");
			return false;
		}
		if (txfLand.getText().isEmpty()) {
			new AlertWindow("Mangler land", "");
			return false;
		}
		if (txfTlfNr.getText().isEmpty() || !txfTlfNr.getText().matches("[0-9]+")) {
			new AlertWindow("Mangler gyldig tlf. nr.", "");
			return false;
		}
		if (ankomstDato.compareTo(konference.getStartDate()) < 0) {
			new AlertWindow("Ankomst dato før konference start dato", "");
			return false;
		}
		if (afrejseDato.compareTo(konference.getEndDate()) > 0) {
			new AlertWindow("Afrejse dato efter konference slut dato", "");
			return false;
		}

		ArrayList<Udflugt> udflugter = new ArrayList<>();
		if (ledsager != null) {
			if (tvUdflugter.getItems() != null) {
				for (UdflugtValg uv : tvUdflugter.getItems()) {
					if (uv.getSelected().get()) {
						udflugter.add(uv.getUdflugt());
					}
				}
			}

		}
		ArrayList<Tillæg> tillæg = new ArrayList<>();
		if (hotelValg != null) {
			for (BooleanProperty bp : hotelValg.tillægValg) {
				if (bp.get()) {
					int index = hotelValg.tillægValg.indexOf(bp);
					Tillæg t = hotelValg.getTillæg().get(index);
					tillæg.add(t);
				}
			}
		}

		if (deltager != null) {
			for (Tilmelding t : konference.getTilmeldinger()) {
				if (t.getDeltager() == deltager) {
					new AlertWindow("Deltager allerede tilmeldt", "");
					return false;
				}
			}
		}

		Deltager d = deltager != null ? deltager
				: Controller.createDeltager(navn, adresse, by, land, tlfNr, firmaNavn, firmaTlfNr);
		Controller.createTilmelding(foredragsholder, ankomstDato, afrejseDato, ledsager, d, hotel, konference,
				udflugter, tillæg);

		return true;
	}

	private void createUdflugtTable() {

		tvUdflugter.setSelectionModel(null);
		tvUdflugter.setEditable(true);

		TableColumn<UdflugtValg, String> column1 = new TableColumn<>("Navn og sted");
		column1.setCellValueFactory(new PropertyValueFactory<>("nameAndPlace"));
		column1.setSortable(false);

		TableColumn<UdflugtValg, LocalDate> column2 = new TableColumn<>("Dato");
		column2.setCellValueFactory(new PropertyValueFactory<>("date"));
		column2.setSortable(false);

		TableColumn<UdflugtValg, String> column3 = new TableColumn<>("Pris");
		column3.setCellValueFactory(new PropertyValueFactory<>("priceAndBreakfast"));
		column3.setSortable(false);

		TableColumn<UdflugtValg, Boolean> column4 = new TableColumn<>("Sæt kryds");
		column4.setCellValueFactory(new Callback<CellDataFeatures<UdflugtValg, Boolean>, ObservableValue<Boolean>>() {
			public ObservableValue<Boolean> call(CellDataFeatures<UdflugtValg, Boolean> param) {
				return param.getValue().getSelected();
			}
		});

		column4.setCellFactory(column -> new CheckBoxTableCell<UdflugtValg, Boolean>());
		column4.setSortable(false);

		tvUdflugter.getColumns().add(column1);
		tvUdflugter.getColumns().add(column2);
		tvUdflugter.getColumns().add(column3);
		tvUdflugter.getColumns().add(column4);

		if (konference.getUdflugter() != null) {
			for (Udflugt u : konference.getUdflugter()) {
				UdflugtValg uv = new UdflugtValg(u);
				tvUdflugter.getItems().add(uv);
			}
		}

		int size = 0;
		if (tvUdflugter.getItems().size() > 5)
			size = 5;
		else
			size = tvUdflugter.getItems().size() > 0 ? tvUdflugter.getItems().size() : 1;

		int start = 28;
		int dis = 25;
		tvUdflugter.setMinHeight(start + (size * dis));
		tvUdflugter.setMaxHeight(start + (size * dis));

	}

	private void createHotelTable() {

		tvHoteller.setSelectionModel(null);
		tvHoteller.setEditable(true);

		TableColumn<HotelValg, String> column1 = new TableColumn<>("Hotel");
		column1.setCellValueFactory(new PropertyValueFactory<>("name"));
		column1.setMinWidth(123);
		column1.setMaxWidth(123);
		column1.setSortable(false);

		TableColumn<HotelValg, LocalDate> column2 = new TableColumn<>("Priser: dobbelt/enkelt");
		column2.setCellValueFactory(new PropertyValueFactory<>("doubleAndSinglePrice"));
		column2.setSortable(false);

		TableColumn<HotelValg, Boolean> column3 = new TableColumn<HotelValg, Boolean>("Sæt et kryds");
		column3.setCellValueFactory(new Callback<CellDataFeatures<HotelValg, Boolean>, ObservableValue<Boolean>>() {
			public ObservableValue<Boolean> call(CellDataFeatures<HotelValg, Boolean> p) {
				// Not pretty but if it works, it works!
				boolean hvb = ((HotelValg) p.getValue()).getSelected().get();
				HotelValg hv = (HotelValg) p.getValue();
				if (hvb && hotelValg == null) {
					tvTillæg.setDisable(false);
					hotelValg = (HotelValg) p.getValue();
					if (hotelValg.getTillæg().size() > 0)
						tvTillæg.setVisible(true);
					updateTillægValg(hotelValg);
				} else if (!hvb && hotelValg != null && hotelValg == hv) {
					tvTillæg.setDisable(true);
					hotelValg = null;
					tvTillæg.setVisible(false);
				} else if (hotelValg != hv) {
					((HotelValg) p.getValue()).setSelected(false);
				}
				return ((HotelValg) p.getValue()).getSelected();
			}
		});
		column3.setCellFactory(new Callback<TableColumn<HotelValg, Boolean>, TableCell<HotelValg, Boolean>>() {
			public TableCell<HotelValg, Boolean> call(TableColumn<HotelValg, Boolean> p) {
				return new CheckBoxTableCell<>();
			}
		});
		column3.setSortable(false);

		tvHoteller.getColumns().add(column1);
		tvHoteller.getColumns().add(column2);
		tvHoteller.getColumns().add(column3);

		if (konference.getHoteller() != null) {
			for (Hotel h : konference.getHoteller()) {
				HotelValg hv = new HotelValg(h);
				tvHoteller.getItems().add(hv);
			}
		}
		int size = 0;
		if (tvHoteller.getItems().size() > 5)
			size = 5;
		else
			size = tvHoteller.getItems().size() > 0 ? tvHoteller.getItems().size() : 1;

		int start = 28;
		int dis = 25;
		hbxHotelOgTilvalg.setMinHeight(start + (size * dis));
		hbxHotelOgTilvalg.setMaxHeight(start + (size * dis));
		tvHoteller.setMinHeight(start + (size * dis));
		tvHoteller.setMaxHeight(start + (size * dis));

	}

	public void createTillægTable() {

		tvTillæg.setSelectionModel(null);
		tvTillæg.setEditable(true);
		tvTillæg.setVisible(false);

	}

	public void updateTillægValg(HotelValg h) {

		tvTillæg.getColumns().clear();
		tvTillæg.getItems().clear();

		TableColumn<HotelValg, LocalDate> columnTillæg = new TableColumn<>("Tillæg");
		tvTillæg.getColumns().add(columnTillæg);

		for (Tillæg t : h.getTillæg()) {

			TableColumn<HotelValg, Boolean> column = new TableColumn<HotelValg, Boolean>(t.getName());
			column.setCellValueFactory(new Callback<CellDataFeatures<HotelValg, Boolean>, ObservableValue<Boolean>>() {
				public ObservableValue<Boolean> call(CellDataFeatures<HotelValg, Boolean> p) {
					int index = h.getTillæg().indexOf(t);
					return ((HotelValg) p.getValue()).getSelectedTillægValg(index);
				}
			});
			column.setCellFactory(new Callback<TableColumn<HotelValg, Boolean>, TableCell<HotelValg, Boolean>>() {
				public TableCell<HotelValg, Boolean> call(TableColumn<HotelValg, Boolean> p) {
					return new CheckBoxTableCell<>();
				}
			});
			column.setSortable(false);
			columnTillæg.getColumns().add(column);
		}
		tvTillæg.getItems().add(h);

		tvTillæg.setMinHeight(78);
		tvTillæg.setMaxHeight(78);

	}

	private class UdflugtValg extends Udflugt {

		private Udflugt u;
		private BooleanProperty selected = new SimpleBooleanProperty();

		public UdflugtValg(Udflugt u) {
			super(u.getName(), u.getPlace(), u.getDate(), u.getPrice(), u.getLunch());
			this.u = u;
		}

		public BooleanProperty getSelected() {
			return selected;
		}

		public void setSelected(boolean b) {
			selected.set(b);
		}

		public Udflugt getUdflugt() {
			return u;
		}

	}

	private class HotelValg extends Hotel {

		private BooleanProperty selected = new SimpleBooleanProperty();

		private Hotel h;
		private ArrayList<BooleanProperty> tillægValg = new ArrayList<>();

		public HotelValg(Hotel h) {
			super(h.getName(), h.getSinglePrice(), h.getDoublePrice());
			if (h.getTillæg() != null) {
				for (Tillæg t : h.getTillæg()) {
					super.createTillæg(t);
					tillægValg.add(new SimpleBooleanProperty());
				}
			}
			this.h = h;
		}

		public BooleanProperty getSelected() {
			return selected;
		}

		public void setSelected(boolean b) {
			selected.set(b);
		}

		public BooleanProperty getSelectedTillægValg(int index) {
			return tillægValg.get(index);
		}

		public ArrayList<BooleanProperty> getTillægValg() {
			return tillægValg;
		}

		public Hotel getHotel() {
			return h;
		}

	}
}
