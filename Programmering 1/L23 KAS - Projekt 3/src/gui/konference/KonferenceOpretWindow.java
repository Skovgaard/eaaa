package gui.konference;

import java.time.LocalDate;

import application.controller.Controller;
import gui.windows.AlertWindow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class KonferenceOpretWindow extends Stage {

	public KonferenceOpretWindow() {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle("Ny konference");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	// -------------------------------------------------------------------------

	private TextField txfNavn, txfSted, txfPris;
	private DatePicker dpStart, dpSlut, dpSidste;
	private Button btnCancel, btnOpret;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblNavn = new Label("Navn:");
		pane.add(lblNavn, 0, 0);

		txfNavn = new TextField();
		pane.add(txfNavn, 0, 1);

		Label lblSted = new Label("Sted:");
		pane.add(lblSted, 1, 0);

		txfSted = new TextField();
		pane.add(txfSted, 1, 1);

		Label lblPris = new Label("Dags pris:");
		pane.add(lblPris, 2, 0);

		txfPris = new TextField();
		pane.add(txfPris, 2, 1);

		Label lblstartDato = new Label("Start Dato:");
		pane.add(lblstartDato, 0, 2);

		dpStart = new DatePicker();
		pane.add(dpStart, 0, 3);
		dpStart.setEditable(false);

		Label lblSlutDato = new Label("Slut Dato:");
		pane.add(lblSlutDato, 1, 2);

		dpSlut = new DatePicker();
		pane.add(dpSlut, 1, 3);
		dpSlut.setEditable(false);

		Label lblSidsteDato = new Label("Sidste Tilmeldings Dato:");
		pane.add(lblSidsteDato, 2, 2);

		dpSidste = new DatePicker();
		pane.add(dpSidste, 2, 3);
		dpSidste.setEditable(false);

		HBox hbxButtons = new HBox(100);
		pane.add(hbxButtons, 0, 4, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 10, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		btnCancel = new Button("Cancel");
		hbxButtons.getChildren().add(btnCancel);
		btnCancel.setOnAction(event -> cancelAction());

		btnOpret = new Button("Opret");
		hbxButtons.getChildren().add(btnOpret);
		btnOpret.setOnAction(event -> opretAction());

	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void opretAction() {

		String navn = txfNavn.getText();
		String sted = navn = txfSted.getText();
		double pris;
		LocalDate start = dpStart.getValue();
		LocalDate slut = dpSlut.getValue();
		LocalDate sidste = dpSidste.getValue();

		if (txfNavn.getText().isEmpty()) {
			new AlertWindow("Mangler navn", "");
			return;
		}

		if (txfSted.getText().isEmpty()) {
			new AlertWindow("Mangler sted", "");
			return;
		}

		if (!txfPris.getText().matches("[0-9]+")) {
			new AlertWindow("Mangler gyldig pris", "");
			return;
		}

		if (start == null) {
			new AlertWindow("Mangler start dato", "");
			return;
		}
		if (slut == null) {
			new AlertWindow("Mangler slut dato", "");
			return;
		}
		if (sidste == null) {
			new AlertWindow("Mangler sidste tilmeldings dato", "");
			return;
		}

		if (slut.compareTo(start) < 0) {
			new AlertWindow("Slut dato før start dato", "");
			return;
		}

		if (start.compareTo(sidste) < 0) {
			new AlertWindow("Sidste tilmeldelses dato ikke før start dato", "");
			return;
		}
		pris = Double.valueOf(txfPris.getText());
		Controller.createKonference(navn, start, slut, sidste, sted, pris);

		this.hide();

	}

}
