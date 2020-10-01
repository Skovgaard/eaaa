package gui.tillæg;

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

public class TillægOpretWindow extends KonferenceWindow {

	private Hotel hotel;

	public TillægOpretWindow(String title, Konference k, Hotel h) {
		super(title, k);
		this.hotel = h;
	}

	private TextField txfNavn, txfPris;
	private Button btnTilbage, btnOpret;

	public void content(GridPane pane) {

		Label lblOpretHotel = new Label("Opret tillæg til hotel");
		lblOpretHotel.setFont(new Font(20));
		pane.add(lblOpretHotel, 0, 0);

		pane.add(new Separator(), 0, 1, 2, 1);

		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 0, 2);

		txfNavn = new TextField();
		pane.add(txfNavn, 1, 2);

		Label lblPris = new Label("Pris:");
		pane.add(lblPris, 0, 3);

		txfPris = new TextField();
		pane.add(txfPris, 1, 3);

		HBox hbxButtons = new HBox(25);
		pane.add(hbxButtons, 0, 4, 2, 1);
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

		String navn = txfNavn.getText();
		double pris;

		if (txfNavn.getText().isEmpty()) {
			new AlertWindow("Mangler navn", "");
			return;
		}

		if (!txfPris.getText().matches("[0-9]+")) {
			new AlertWindow("Mangler gyldig pris", "");
			return;
		}
		pris = Double.valueOf(txfPris.getText());
		Controller.createTillægForHotel(navn, pris, hotel);
		hide();
	}

	private void tilbageAction() {
		hide();
	}

}
