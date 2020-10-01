package gui.konference;

import java.time.LocalDate;

import application.controller.Controller;
import application.model.Konference;
import gui.MainApp;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

public class KonferenceOversigtPane extends GridPane {

	private TableView<Konference> tvKonferencer;
	private Button btnOpret;

	public KonferenceOversigtPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblKonferencer = new Label("Konferencer: (klik for mere info)");
		this.add(lblKonferencer, 0, 0);
		lblKonferencer.setFont(new Font(20));

		tvKonferencer = new TableView<>();
		this.add(tvKonferencer, 0, 2, 4, 8);
		tvKonferencer.setMinWidth(555);
		tvKonferencer.setMinHeight(400);

		createKonferenceTable();

		ChangeListener<Konference> listener = (ov, oldCompny, newCompany) -> vælgKonferenceAction();
		tvKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

		HBox hbxButtons = new HBox(100);
		this.add(hbxButtons, 0, 10, 4, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		btnOpret = new Button("Opret Konference");
		hbxButtons.getChildren().add(btnOpret);
		btnOpret.setOnAction(event -> this.opretKonferencAction());

	}

	private void update() {
		tvKonferencer.getItems().clear();
		tvKonferencer.getItems().addAll(Controller.getKonferencer());
	}

	private void createKonferenceTable() {

		tvKonferencer.setEditable(false);

		TableColumn<Konference, String> column1 = new TableColumn<>("Navn");
		column1.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Konference, LocalDate> column2 = new TableColumn<>("Start Dato");
		column2.setCellValueFactory(new PropertyValueFactory<>("startDate"));

		TableColumn<Konference, LocalDate> column3 = new TableColumn<>("Slut Dato");
		column3.setCellValueFactory(new PropertyValueFactory<>("endDate"));

		TableColumn<Konference, LocalDate> column4 = new TableColumn<>("SU Dato");
		column4.setCellValueFactory(new PropertyValueFactory<>("lastRegistrationDate"));

		TableColumn<Konference, String> column5 = new TableColumn<>("Sted");
		column5.setCellValueFactory(new PropertyValueFactory<>("location"));

		TableColumn<Konference, Double> column6 = new TableColumn<>("Dagspris");
		column6.setCellValueFactory(new PropertyValueFactory<>("dayPrice"));

		tvKonferencer.getColumns().add(column1);
		tvKonferencer.getColumns().add(column2);
		tvKonferencer.getColumns().add(column3);
		tvKonferencer.getColumns().add(column4);
		tvKonferencer.getColumns().add(column5);
		tvKonferencer.getColumns().add(column6);

		tvKonferencer.getItems().addAll(Controller.getKonferencer());
	}

	private void opretKonferencAction() {
		KonferenceOpretWindow kw = new KonferenceOpretWindow();
		kw.showAndWait();

		update();
	}

	private void vælgKonferenceAction() {
		Konference k = tvKonferencer.getSelectionModel().getSelectedItem();
		if (k != null) {
			MainApp.changeWindow(k);
		}
	}
}
