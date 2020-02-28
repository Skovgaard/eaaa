package ex5student;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SubFrame extends Stage implements ColorObserver {
    private GridPane pane;


    public SubFrame(String title, MainApp main, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        this.pane = new GridPane();
        this.initContent(this.pane);

        Scene scene = new Scene(this.pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private Label lblInfo;

    private void initContent(GridPane pane) {
        this.pane.setPadding(new Insets(20));
        this.pane.setHgap(10);
        this.pane.setVgap(10);

        Label lblHeader = new Label("Computer Science is colorfull");
        this.pane.add(lblHeader, 0, 0);

        Button btnSubscribe = new Button("Subscribe");
        this.pane.add(btnSubscribe, 0, 1);
        btnSubscribe.setOnAction(event -> this.subscribeAction());

        Button btnUnsubscribe = new Button("Unsubscribe");
        this.pane.add(btnUnsubscribe, 0, 2);
        btnUnsubscribe.setOnAction(event -> this.unsubscribeAction());

        this.lblInfo = new Label("State: Unsubscribed");
        this.pane.add(this.lblInfo, 0, 3);
    }

    // -------------------------------------------------------------------------

    private void subscribeAction() {
        MainApp.observers.add(this);
    }

    private void unsubscribeAction() {
        MainApp.observers.remove(this);
    }

    @Override
    public void update(String color) {
        pane.setStyle("-fx-background-color: " + color);
    }
}
