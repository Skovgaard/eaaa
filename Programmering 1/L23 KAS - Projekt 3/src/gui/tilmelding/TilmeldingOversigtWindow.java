package gui.tilmelding;

import java.time.LocalDate;

import application.model.Konference;
import application.model.Tilmelding;
import gui.windows.KonferenceWindow;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class TilmeldingOversigtWindow extends KonferenceWindow {

	public TilmeldingOversigtWindow(String title, Konference k) {
		super(title, k);
	}

	private TableView<Tilmelding> tvTilmeldinger;

	public void content(GridPane pane) {

		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblKonference = new Label("Oversigt over deltagere til: " + konference.getName());
		lblKonference.setFont(new Font(20));
		pane.add(lblKonference, 0, 0, 1, 1);

		tvTilmeldinger = new TableView<>();
		pane.add(tvTilmeldinger, 0, 3, 1, 9);

		createTilmeldingerTable();

	}

	private void createTilmeldingerTable() {

		tvTilmeldinger.setEditable(false);

		TableColumn<Tilmelding, String> column1 = new TableColumn<>("Navn");
		column1.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Tilmelding, String> column2 = new TableColumn<>("Adresse");
		column2.setCellValueFactory(new PropertyValueFactory<>("adress"));

		TableColumn<Tilmelding, String> column3 = new TableColumn<>("By");
		column3.setCellValueFactory(new PropertyValueFactory<>("city"));

		TableColumn<Tilmelding, String> column4 = new TableColumn<>("Land");
		column4.setCellValueFactory(new PropertyValueFactory<>("land"));

		TableColumn<Tilmelding, String> column5 = new TableColumn<>("Tlf. nr.");
		column5.setCellValueFactory(new PropertyValueFactory<>("tlfNr"));

		TableColumn<Tilmelding, String> column6 = new TableColumn<>("Firma navn");
		column6.setCellValueFactory(new PropertyValueFactory<>("companyName"));

		TableColumn<Tilmelding, String> column7 = new TableColumn<>("Firma tlf. nr.");
		column7.setCellValueFactory(new PropertyValueFactory<>("companyTlfNr"));

		TableColumn<Tilmelding, Boolean> column8 = new TableColumn<>("Foredragsholder");
		column8.setCellValueFactory(new PropertyValueFactory<>("foredragsholderJaNej"));

		TableColumn<Tilmelding, LocalDate> column9 = new TableColumn<>("Ankomst");
		column9.setCellValueFactory(new PropertyValueFactory<>("ankomstDato"));

		TableColumn<Tilmelding, LocalDate> column10 = new TableColumn<>("Afrejse");
		column10.setCellValueFactory(new PropertyValueFactory<>("afrejseDato"));

		TableColumn<Tilmelding, String> column11 = new TableColumn<>("Ledsager");
		column11.setCellValueFactory(new PropertyValueFactory<>("partner"));

		TableColumn<Tilmelding, String> column12 = new TableColumn<>("Hotel");
		column12.setCellValueFactory(new PropertyValueFactory<>("hotel"));

		TableColumn<Tilmelding, String> column13 = new TableColumn<>("Tillæg");
		column13.setCellValueFactory(new PropertyValueFactory<>("tillægString"));
		column13.setMinWidth(75);

		TableColumn<Tilmelding, Double> column14 = new TableColumn<>("Samlet pris");
		column14.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

		tvTilmeldinger.getColumns().add(column1);
		tvTilmeldinger.getColumns().add(column2);
		tvTilmeldinger.getColumns().add(column3);
		tvTilmeldinger.getColumns().add(column4);
		tvTilmeldinger.getColumns().add(column5);
		tvTilmeldinger.getColumns().add(column6);
		tvTilmeldinger.getColumns().add(column7);
		tvTilmeldinger.getColumns().add(column8);
		tvTilmeldinger.getColumns().add(column9);
		tvTilmeldinger.getColumns().add(column10);
		tvTilmeldinger.getColumns().add(column11);
		tvTilmeldinger.getColumns().add(column12);
		tvTilmeldinger.getColumns().add(column13);
		tvTilmeldinger.getColumns().add(column14);

		tvTilmeldinger.getItems().addAll(konference.getTilmeldinger());

	}

}
