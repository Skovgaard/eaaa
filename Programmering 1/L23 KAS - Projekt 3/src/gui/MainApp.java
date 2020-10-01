package gui;

import application.controller.Controller;
import application.model.Konference;
import gui.konference.KonferenceOversigtPane;
import gui.konference.KonferencePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void init() {
		Controller.init();
	}

	private static BorderPane pane = new BorderPane();

	private static Stage stage;

	public void start(Stage stage) {
		MainApp.stage = stage;
		stage.setTitle("KAS");
		this.initContent();
		stage.setResizable(true);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	public void initContent() {
		KonferenceOversigtPane kop = new KonferenceOversigtPane();
		pane.setCenter(kop);
	}

	public static void changeWindow(Konference k) {
		if (k == null) {
			KonferenceOversigtPane kop = new KonferenceOversigtPane();
			pane.setCenter(kop);
		} else {
			KonferencePane kp = new KonferencePane(k);
			pane.setCenter(kp);
		}
		stage.sizeToScene();
		stage.centerOnScreen();
	}
}
