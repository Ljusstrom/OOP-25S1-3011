import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasDemo extends Application {
    private double alpha = 1.0;

    @Override
    public void start(Stage stage) throws Exception {
        Canvas canvas = new Canvas(200, 200);
        Button clearButton = new Button("Clear");
        Image img = new Image("/image.jpg");

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fillOval(10, 10, 30, 30);
        gc.setFill(Color.BLUE);
        gc.setGlobalAlpha(alpha);
        gc.fillOval(15, 15, 30, 30);
        gc.drawImage(img, 0, 0, 100, 50);

        gc.moveTo(0, 0);
        gc.lineTo(20, 20);
        gc.stroke();

        FlowPane pane = new FlowPane();
        pane.getChildren().add(canvas);
        pane.getChildren().add(clearButton);
        Scene scene = new Scene(pane);
        stage.setTitle("Canvas Demo");
        stage.setScene(scene);
        stage.show();

        canvas.setFocusTraversable(true); // enable setting of focus
        canvas.setOnKeyPressed(keyEvent -> {
            KeyCode key = keyEvent.getCode();
            System.out.println("Key: " + key);
            if (key == KeyCode.UP) {
                alpha += 0.1;
                gc.setGlobalAlpha(alpha);
            }
            if (key == KeyCode.DOWN) {
                alpha -= 0.1;
                gc.setGlobalAlpha(alpha);
            }
        });

        canvas.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();
            //System.out.println("Mouse moved: ("+x+","+y+")");
        });

        canvas.setOnMouseClicked(event -> {
            gc.fillOval(event.getX(), event.getY(), 30, 30);
        });

        clearButton.setOnAction(event-> gc.clearRect(0, 0, 200, 200));
    }
}
