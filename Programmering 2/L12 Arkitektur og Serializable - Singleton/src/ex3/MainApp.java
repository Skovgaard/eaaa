package ex3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 3");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
//        stage.setHeight(600);
//        stage.setWidth(400);
        stage.show();
    }

    private TextField txfName = new TextField();
    private ListView<Person> lvwPersons = new ListView<>();

    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 1, 0);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 0);
        btnAdd.setOnAction(event -> addPerson());

        pane.add(lvwPersons, 0, 1, 3, 1);
        lvwPersons.setMinHeight(300);
    }

    private void addPerson() {
        String name = txfName.getText();
        Person person = new Person(name);
        Controller.addPerson(person);
        lvwPersons.getItems().add(person);
        txfName.clear();
    }
}
