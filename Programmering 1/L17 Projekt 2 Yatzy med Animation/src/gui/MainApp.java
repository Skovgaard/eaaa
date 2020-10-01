package gui;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.YatzyDice;

public class MainApp extends Application {
	private final Controller controller = new Controller();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// Buttons used to put images of dice into.
	private final ToggleButton[] btnImages = new ToggleButton[5];
	// Images for the 5 dice.
	private DieImage[] dieImages = new DieImage[5];
	// Shows the hold status of the 5 dice.
	private final static CheckBox[] cbxHolds = new CheckBox[5];
	// Shows the obtained results.
	// For results not set yet, the possible result of
	// the actual face values of the 5 dice are shown.
	private final TextField[] txfResults = new TextField[15];
	// Shows points in sums, bonus and total.
	private final TextField txfSumSame = new TextField("0"), txfBonus = new TextField("0"),
			txfSumOther = new TextField("0"), txfTotal = new TextField("0");

	private final Label lblRolled = new Label("Rolls: " + 0);
	private final Button btnRoll = new Button(" Roll ");

	private void initContent(GridPane pane) {
		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
//		dicePane.setGridLinesVisible(true);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");

		// borders to make dices pretty
		BorderStroke borderStrokeTransparent = new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID,
				new CornerRadii(0), new BorderWidths(1));
		Border borderTransparent = new Border(borderStrokeTransparent);

		// add the 5 dice fields for animation + image
		for (int i = 0; i < btnImages.length; i++) {
			btnImages[i] = new ToggleButton();
			dieImages[i] = new DieImage();
			btnImages[i].setGraphic(dieImages[i].getdieFace());
			btnImages[i].setPadding(new Insets(0));
			btnImages[i].setBorder(borderTransparent);
			btnImages[i].setDisable(true);
			btnImages[i].setOpacity(1);
			dicePane.add(btnImages[i], i, 0);
		}

		// add chbHolds
		for (int i = 0; i < cbxHolds.length; i++) {
			cbxHolds[i] = new CheckBox("Hold");
			dicePane.add(cbxHolds[i], i, 1);
			cbxHolds[i].setDisable(true);
		}

		// add lblRolled and btnRoll
		dicePane.add(lblRolled, 1, 2);
		dicePane.add(btnRoll, 3, 2);
		btnRoll.setDefaultButton(true);
		btnRoll.setOnAction(event -> controller.rollDice());

		// ---------------------------------------------------------------------

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		// scorePane.setGridLinesVisible(true);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");
		int w = 50; // width of the text fields

		// add labels for results, add txfResults,
		String[] lblNames = new String[] { "1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One Pair", "Two Pairs",
				"Three-same", "Four-same", "Full House", "Small Str.", "Large Str.", "Chance", "Yatzy" };
		Label[] lblResult = new Label[15];

		for (int i = 0; i < txfResults.length; i++) {
			int row = i < 6 ? i : i + 1;
			lblResult[i] = new Label(lblNames[i]);
			scorePane.add(lblResult[i], 0, row);
			txfResults[i] = new TextField();
			txfResults[i].setPrefWidth(w);
			txfResults[i].setEditable(false);
			scorePane.add(txfResults[i], 1, row);
			txfResults[i].setOnMouseClicked(event -> controller.mouseClicked(event));
		}

		// add labels and text fields for sums, bonus and total.
		scorePane.add(new Label("Sum"), 3, 5);
		scorePane.add(txfSumSame, 4, 5);
		txfSumSame.setPrefWidth(w);
		scorePane.add(new Label("Bonus"), 3, 6);
		scorePane.add(txfBonus, 4, 6);
		txfBonus.setPrefWidth(w);
		scorePane.add(new Label("Sum"), 3, 15);
		scorePane.add(txfSumOther, 4, 15);
		txfSumOther.setPrefWidth(w);
		scorePane.add(new Label("TOTAL"), 3, 16);
		scorePane.add(txfTotal, 4, 16);
		txfTotal.setPrefWidth(w);
	}

	// returns list of dices to hold
	public static boolean[] getHolds() {
		boolean[] hold = new boolean[cbxHolds.length];
		for (int i = 0; i < hold.length; i++) {
			hold[i] = cbxHolds[i].isSelected();
		}
		return hold;
	}

	// update dices 0 roll count on gui
	public void updateDiceFields(int[] values, int rolls) {
		for (int i = 0; i < btnImages.length; i++) {
			String dieFace = Integer.toString(values[i]);
			dieImages[i].setDieFace(Integer.valueOf(dieFace));
			btnImages[i].setGraphic(dieImages[i].getdieFace());
		}
		lblRolled.setText("Rolls: " + rolls);
	}

	// updates results on gui
	public void updateResults(int[] results) {
		for (int i = 0; i < results.length; i++) {
			if (!controller.isLocked(i))
				txfResults[i].setText(Integer.toString(results[i]));
		}
	}

	// returns index for textfield
	public int getTextFieldIndex(TextField txf) {
		for (int i = 0; i < txfResults.length; i++) {
			if (txfResults[i].equals(txf))
				return i;
		}
		return -1;
	}

	// -------------------------------------------------------------------------

	private class Controller {
		private YatzyDice dice = new YatzyDice();
		private boolean[] lockedResults = new boolean[15];
		private int sumSame = 0;
		private int bonus = 0;
		private int sumOther = 0;
		private int total = 0;
		private boolean canLock = false;
		private int resultCounter = 0;

		private Random random = new Random();

		// Create a method for btnRoll's action.
		// Hint: Create small helper methods to be used in the action method.
		public void rollDice() {
			// check of all results chosen to allow reset
			// else rolls dices not held and enable/disable hold checkboxes
			if (resultCounter == 15) {
				reset();
			} else {
				for (int i = 0; i < cbxHolds.length; i++) {
					if (dice.getThrowCount() == 0) {
						cbxHolds[i].setDisable(false);

					} else if (cbxHolds[i].isSelected())
						cbxHolds[i].setDisable(true);
				}

				// if not all throws used, do animation method
				// throws dices which are not held and update fields
				if (dice.getThrowCount() < 3) {
					rollDicesAnimation();
					dice.throwDice(getHolds());
					updateDiceFields(dice.getValues(), dice.getThrowCount());
					// if 3 throws, disable button and checkboxes
					if (dice.getThrowCount() == 3) {
						btnRoll.setDisable(true);
						for (int i = 0; i < cbxHolds.length; i++) {
							cbxHolds[i].setDisable(true);
						}
					}
				}

			}

		}

		// -------------------------------------------------------------------------

		// Create a method for mouse click on one of the text fields in txfResults.
		// Hint: Create small helper methods to be used in the mouse click method.
		private void mouseClicked(MouseEvent event) {
			TextField txf = (TextField) event.getSource();
			int index = getTextFieldIndex(txf);
			// if allowed to lock result and not already locked in clicked field
			// then calculate and update fields and reset dice stuff
			if (canLock && !lockedResults[index]) {
				txf.setStyle("-fx-background-color: yellow");
				if (index < 6) {
					sumSame += dice.getResults()[index];
					txfSumSame.setText(Integer.toString(sumSame));
					if (sumSame >= 63) {
						bonus = 50;
						txfBonus.setText(Integer.toString(bonus));
					}
				} else {
					sumOther += dice.getResults()[index];
					txfSumOther.setText(Integer.toString(sumOther));
				}
				total = sumSame + sumOther + bonus;
				txfTotal.setText(Integer.toString(total));
				lockedResults[index] = true;
				dice.resetThrowCount();
				lblRolled.setText("Rolls: " + dice.getThrowCount());
				canLock = false;
				btnRoll.setDisable(false);
				for (int i = 0; i < cbxHolds.length; i++) {
					cbxHolds[i].setSelected(false);
					cbxHolds[i].setDisable(true);
				}
				resultCounter++;
			}
			if (resultCounter == 15) {
				btnRoll.setText("Reset");
			}

		}

		public boolean isLocked(int index) {
			return lockedResults[index];
		}

		public void reset() {
			// resets variables and fields
			sumSame = 0;
			txfSumSame.setText(Integer.toString(sumSame));
			bonus = 0;
			txfBonus.setText(Integer.toString(bonus));
			sumOther = 0;
			txfSumOther.setText(Integer.toString(sumOther));
			total = 0;
			txfTotal.setText(Integer.toString(total));
			resultCounter = 0;
			dice.resetThrowCount();
			btnRoll.setText(" Roll ");

			// sets dices to show 1
			for (int i = 0; i < dieImages.length; i++) {
				dieImages[i].setDieFace(1);
			}

			// resets results and style of result fields
			for (int i = 0; i < lockedResults.length; i++) {
				lockedResults[i] = false;
				txfResults[i].setStyle(null);
			}
			updateResults(new int[15]);
		}

		public void rollDicesAnimation() {

			canLock = false;

			// disables checkboxes while rolling
			for (int i = 0; i < cbxHolds.length; i++) {
				if (!cbxHolds[i].isSelected())
					cbxHolds[i].setDisable(true);
			}

			// sets unlocked results to 0 while rolling
			for (int i = 0; i < lockedResults.length; i++) {
				if (!lockedResults[i]) {
					txfResults[i].setText("0");
				}
			}

			// creates timeline for dice animation and rolls all not held dices
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(.2), (actionEvent) -> {
				for (int i = 0; i < btnImages.length; i++) {
					if (!getHolds()[i]) {
						int r = random.nextInt(6) + 1;
						dieImages[i].setDieFace(r);
					}
				}
			}));
			// when timeline finishes, update fields and enable checkboxes
			// timeline run indepedent from other code, so have to update after animation is
			// done
			timeline.setOnFinished(event -> {
				for (int i = 0; i < btnImages.length; i++) {
					String dieFace = Integer.toString(dice.getValues()[i]);
					dieImages[i].setDieFace(Integer.valueOf(dieFace));
					btnImages[i].setGraphic(dieImages[i].getdieFace());
					updateResults(dice.getResults());
					if (!cbxHolds[i].isSelected())
						cbxHolds[i].setDisable(false);
					canLock = true;
				}
			});

			// random amount of animations images from 3 to 3 + (0-4)
			timeline.setCycleCount(random.nextInt(5) + 3);
			timeline.play();

		}

	}

}
