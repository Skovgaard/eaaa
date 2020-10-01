package gui.udflugt;

import application.model.Konference;
import application.model.Tilmelding;
import application.model.Udflugt;
import gui.windows.KonferenceWindow;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/* Gruppe B
 * Jacob Lund Andersen
 * Annemie Schulz
 * Kasper Skovgaard Pedersen
 */

public class UdflugtOversigtWindow extends KonferenceWindow {

	public UdflugtOversigtWindow(String title, Konference k) {
		super(title, k);
	}

	private TreeTableView<Object> ttvHoteller;

	public void content(GridPane pane) {

		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblKonference = new Label("Oversigt over ledsagere til udflugter");
		lblKonference.setFont(new Font(20));
		pane.add(lblKonference, 0, 0, 1, 1);

		ttvHoteller = new TreeTableView<>();
		pane.add(ttvHoteller, 0, 3, 1, 9);

		createHotelTable();

	}

	private void createHotelTable() {

		ttvHoteller.setEditable(false);

		TreeTableColumn<Object, String> column1 = new TreeTableColumn<>("Ledsager");
		column1.setCellValueFactory(new TreeItemPropertyValueFactory<>("ledsager"));
		column1.setMinWidth(200);

		TreeTableColumn<Object, String> column2 = new TreeTableColumn<>("Tlf. nr.");
		column2.setCellValueFactory(new TreeItemPropertyValueFactory<>("tlfNr"));
		column2.setMinWidth(75);

		TreeTableColumn<Object, String> column3 = new TreeTableColumn<>("Deltager navn");
		column3.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
		column3.setMinWidth(150);

		ttvHoteller.getColumns().add(column1);
		ttvHoteller.getColumns().add(column2);
		ttvHoteller.getColumns().add(column3);

		TreeItem<Object> root = new TreeItem<Object>(new Object());
		ttvHoteller.setRoot(root);
		ttvHoteller.setShowRoot(false);

		for (Udflugt u : konference.getUdflugter()) {

			TreeItem<Object> udflugt = new TreeItem<Object>(new UdflugtExt(u));
			root.getChildren().add(udflugt);

			for (Tilmelding t : konference.getTilmeldinger()) {

				if (t.getUdflugter() != null) {
					if (t.getUdflugter().contains(u)) {
						TreeItem<Object> tilmelding = new TreeItem<Object>(t);
						udflugt.getChildren().add(tilmelding);
					}
				}
			}
		}
	}

	protected class UdflugtExt extends Udflugt {

		public UdflugtExt(Udflugt u) {
			super(u.getName(), u.getPlace(), u.getDate(), u.getPrice(), u.getLunch());
		}

		public String getLedsager() {
			return toString();
		}

		public String getName() {
			return "";
		}

	}

//	protected class TilmeldingExt extends Tilmelding {
//
//		public TilmeldingExt(Tilmelding t) {
//			super(t.getForedragsholder(), t.getAnkomstDato(), t.getAfrejseDato(), t.getLedsager(), t.getDeltager(),
//					t.getHotel(), t.getKonference(), t.getUdflugter(), t.getTillæg());
//		}
//		
//		public String getLedsager() {
//			
//		}
//
//	}

}
