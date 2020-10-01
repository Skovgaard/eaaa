package gui.windows;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class AlertWindow {

	public AlertWindow(String headerText, String contentText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Fejl");
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.show();
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.setAlwaysOnTop(true);
	}

}
