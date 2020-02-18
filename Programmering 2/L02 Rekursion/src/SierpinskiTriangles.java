import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class SierpinskiTriangles extends Application {

    private static final int DRAW_PANE_HEIGHT = 320;
    private static final int DRAW_PANE_WIDTH = DRAW_PANE_HEIGHT * 2;

    private static final int MAX_ORDER = 8;

    private static Pane drawPane;
    private static Scene scene;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane();
        pane.setPrefSize(DRAW_PANE_WIDTH, DRAW_PANE_HEIGHT + 100);
        scene = new Scene(pane);

        stage.setTitle("Sierpenski Triangles");
        stage.setScene(scene);
        stage.show();

        initContent(pane);
    }

    private static int order = 0;
    private static Label lblOrder = new Label("Order: " + order);

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        drawPane = new Pane();
        drawPane.setPrefSize(DRAW_PANE_WIDTH, DRAW_PANE_HEIGHT);

        HBox hbxDrawPane = new HBox(25);
        pane.add(hbxDrawPane, 0, 0, 1, 1);
        hbxDrawPane.setPadding(new Insets(0, 0, 0, 0));
        hbxDrawPane.setAlignment(Pos.BASELINE_CENTER);
        hbxDrawPane.getChildren().add(drawPane);

        draw(order, 20, DRAW_PANE_HEIGHT - 20, DRAW_PANE_HEIGHT - 40);

        HBox hbxButtonsAndOrder = new HBox(25);
        pane.add(hbxButtonsAndOrder, 0, 1, 1, 1);
        hbxButtonsAndOrder.setPadding(new Insets(0, 0, 0, 0));
        hbxButtonsAndOrder.setAlignment(Pos.BASELINE_CENTER);

        Button btnDecrease = new Button("<");
        hbxButtonsAndOrder.getChildren().add(btnDecrease);
        btnDecrease.setOnAction(event -> this.decreaseAction());

        hbxButtonsAndOrder.getChildren().add(lblOrder);

        Button btnIncrease = new Button(">");
        hbxButtonsAndOrder.getChildren().add(btnIncrease);
        btnIncrease.setOnAction(event -> this.increaseAction());

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.LEFT)
                decreaseAction();
            if (key.getCode() == KeyCode.RIGHT)
                increaseAction();
        });
    }

    // ------------------------------------------------------------------------

    private void draw(double n, double x, double y, double h) {
        if (n == 0)
            drawTriangle(x, y, h);
        else {
            double t = h / 2;
            draw(n - 1, x, y, t);
            draw(n - 1, x + t, y - t, t);
            draw(n - 1, x + t * 2, y, t);
        }
    }

    private void drawTriangle(double x, double y, double h) {
        Polygon triangle = new Polygon(x, y, x + 2 * h, y, x + h, y - h);
        drawPane.getChildren().add(triangle);
        triangle.setFill(Color.TRANSPARENT);
        triangle.setStroke(Color.BLACK);
    }

    // ------------------------------------------------------------------------

    private void decreaseAction() {
        if (order > 0) {
            order--;
            lblOrder.setText("Order: " + order);
            drawPane.getChildren().clear();
            draw(order, 20, DRAW_PANE_HEIGHT - 20, DRAW_PANE_HEIGHT - 40);
        }
    }

    private void increaseAction() {
        if (order < MAX_ORDER) {
            order++;
            lblOrder.setText("Order: " + order);
            draw(order, 20, DRAW_PANE_HEIGHT - 20, DRAW_PANE_HEIGHT - 40);
        }
    }
}
