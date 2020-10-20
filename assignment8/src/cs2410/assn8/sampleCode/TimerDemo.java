package cs2410.assn8.sampleCode;

/**
 *
 */


        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;
        import javafx.stage.WindowEvent;

        import java.util.Timer;
        import java.util.TimerTask;

/**
 * @author Chad
 *
 */
public class TimerDemo extends Application implements EventHandler<ActionEvent> {
    private String[] colors = {"blue", "green", "red", "yellow"};
    private Timer timer = new Timer();
    Button btn = new Button("Click Me");
    Pane pane1 = new Pane();

    private int colorIterate = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane mainPane = new BorderPane();
        pane1.setPrefSize(200, 200);

        mainPane.setTop(btn);
        mainPane.setCenter(pane1);

        btn.setOnAction(this);

        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                timer.cancel();
            }
        });
    }

    private void changeColor() {
        pane1.setStyle("-fx-background-color: " + colors[colorIterate%colors.length]);
        colorIterate++;
    }


    private void blinkPanel() {
        timer.scheduleAtFixedRate(new TimerTask(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                if (colorIterate == colors.length) {
                    colorIterate = 0;
                    this.cancel();
                }
                else {
                    changeColor();
                }

            }}, 0, 1000);
    }

    @Override
    public void handle(ActionEvent event) {
        blinkPanel();
    }
}
