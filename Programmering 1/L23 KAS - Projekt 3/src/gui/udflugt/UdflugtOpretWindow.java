package gui.udflugt;

import java.time.LocalDate;
import java.util.ArrayList;

import application.controller.Controller;
import application.model.Konference;
import application.model.Udflugt;
import gui.windows.AlertWindow;
import gui.windows.KonferenceWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
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

public class UdflugtOpretWindow extends KonferenceWindow {

	public UdflugtOpretWindow(String title, Konference k) {
		super(title, k);
	}

	private TextField txfNavn, txfPris, txfSted;
	private DatePicker dpDato;
	private CheckBox cbxFrokost;
	private Button btnTilbage, btnOpret;

	public void content(GridPane pane) {

		Label lblOpretHotel = new Label("Opret udflugt");
		lblOpretHotel.setFont(new Font(20));
		pane.add(lblOpretHotel, 0, 0, 4, 1);

		pane.add(new Separator(), 0, 1, 4, 1);

		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 0, 2);

		txfNavn = new TextField();
		pane.add(txfNavn, 1, 2);

		Label lblSted = new Label("Sted:");
		pane.add(lblSted, 2, 2);

		txfSted = new TextField();
		pane.add(txfSted, 3, 2);

		Label lblDobbeltPris = new Label("Dato:");
		pane.add(lblDobbeltPris, 0, 3);

		dpDato = new DatePicker();
		pane.add(dpDato, 1, 3);
		dpDato.setMinWidth(180);
		dpDato.setMaxWidth(180);

		Label lblPris = new Label("Pris:");
		pane.add(lblPris, 2, 3);

		HBox hbxPrisOgFrokost = new HBox(15);
		pane.add(hbxPrisOgFrokost, 3, 3, 4, 1);
		hbxPrisOgFrokost.setPadding(new Insets(0, 0, 0, 0));
		hbxPrisOgFrokost.setAlignment(Pos.BASELINE_LEFT);

		txfPris = new TextField();
		hbxPrisOgFrokost.getChildren().add(txfPris);
		txfPris.setMaxWidth(65);

		Label lblFrokost = new Label("Frokost:");
		hbxPrisOgFrokost.getChildren().add(lblFrokost);

		cbxFrokost = new CheckBox();
		hbxPrisOgFrokost.getChildren().add(cbxFrokost);

		HBox hbxButtons = new HBox(25);
		pane.add(hbxButtons, 0, 4, 4, 1);
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
		String sted = txfSted.getText().length() > 0 ? txfSted.getText() : null;
		LocalDate dato = dpDato.getValue();
		double pris;
		boolean frokost = cbxFrokost.isSelected();

		if (txfNavn.getText().isEmpty()) {
			new AlertWindow("Mangler navn", "");
			return;
		}

		if (dato == null) {
			new AlertWindow("Dato ikke gyldig", "");
			return;
		}

		// Unødveng, men virker!
		ArrayList<LocalDate> dates = new ArrayList<>();
		int konferenceDays = konference.getEndDate().compareTo(konference.getStartDate()) + 1;
		for (int i = 0; i < konferenceDays; i++) {
			int year = konference.getStartDate().getYear();
			int month = konference.getStartDate().getMonthValue();
			int day = konference.getStartDate().getDayOfMonth();
			LocalDate ld = LocalDate.of(year, month, day);
			dates.add(ld.plusDays(i));
		}

		boolean dateInside = false;
		for (LocalDate ld : dates) {
			if (ld.compareTo(dato) == 0) {
				dateInside = true;
			}
		}

		if (!dateInside) {
			new AlertWindow("Dato udenfor konference", "");
			return;
		}

		if (!txfPris.getText().matches("[0-9]+")) {
			new AlertWindow("Mangler gyldig pris", "");
			return;
		}
		pris = Double.valueOf(txfPris.getText());
		Udflugt u = Controller.createUdflugt(navn, sted, dato, pris, frokost, konference);
		konference.createUdflugt(u);
		hide();
	}

	private void tilbageAction() {
		hide();
	}

}
