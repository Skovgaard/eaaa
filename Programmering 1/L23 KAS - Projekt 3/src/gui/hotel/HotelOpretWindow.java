package gui.hotel;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Konference;
import gui.windows.AlertWindow;
import gui.windows.KonferenceWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class HotelOpretWindow extends KonferenceWindow {

	public HotelOpretWindow(String title, Konference k) {
		super(title, k);
	}

	private TextField txfNavn, txfEnkeltPris, txfDobbeltPris;
	private Button btnTilbage, btnOpret;

	public void content(GridPane pane) {

		Label lblOpretHotel = new Label("Opret hotel");
		lblOpretHotel.setFont(new Font(20));
		pane.add(lblOpretHotel, 0, 0);

		pane.add(new Separator(), 0, 1, 2, 1);

		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 0, 2);

		txfNavn = new TextField();
		pane.add(txfNavn, 1, 2);

		Label lblEnkeltPris = new Label("Enkelt pris:");
		pane.add(lblEnkeltPris, 0, 3);

		txfEnkeltPris = new TextField();
		pane.add(txfEnkeltPris, 1, 3);

		Label lblDobbeltPris = new Label("Dobbelt pris:");
		pane.add(lblDobbeltPris, 0, 4);

		txfDobbeltPris = new TextField();
		pane.add(txfDobbeltPris, 1, 4);

		HBox hbxButtons = new HBox(25);
		pane.add(hbxButtons, 0, 5, 2, 1);
		hbxButtons.setPadding(new Insets(0, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		btnTilbage = new Button("Tilbage");
		hbxButtons.getChildren().add(btnTilbage);
		btnTilbage.setOnAction(event -> tilbageAction());

		btnOpret = new Button("Opret");
		hbxButtons.getChildren().add(btnOpret);
		btnOpret.setOnAction(event -> opretAction());

	}

	private void opretAction() {

		String navn = txfNavn.getText() + "";
		double enkeltPris;
		double dobbeltPris;

		if (txfNavn.getText().isEmpty()) {
			new AlertWindow("Mangler navn", "");
			return;
		}

		if (!txfEnkeltPris.getText().matches("[0-9]+")) {
			new AlertWindow("Mangler gyldig enkelt pris", "");
			return;
		}
		if (!txfDobbeltPris.getText().matches("[0-9]+")) {
			new AlertWindow("Mangler gyldig dobbelt pris", "");
			return;
		}
		enkeltPris = Double.valueOf(txfEnkeltPris.getText());
		dobbeltPris = Double.valueOf(txfDobbeltPris.getText());
		Hotel h = Controller.createHotel(navn, enkeltPris, dobbeltPris);
		konference.addHotel(h);
		hide();
	}

	private void tilbageAction() {
		hide();
	}

}
