package cs2410.assn8.sampleCode;


        import javafx.application.Application;
        import javafx.beans.binding.Bindings;
        import javafx.beans.binding.NumberBinding;
        import javafx.beans.property.DoubleProperty;
        import javafx.beans.property.SimpleDoubleProperty;
        import javafx.beans.value.ChangeListener;
        import javafx.beans.value.ObservableValue;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.Pane;
        import javafx.stage.Stage;
        import javafx.util.converter.NumberStringConverter;

/**
 * Add a description of the class here
 *
 * @author Chad
 * @version XXX
 */
public class NumberBindingDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField textWidth = new TextField();
        Label multLabel = new Label("X");
        TextField textHeight = new TextField();
        Label eqLabel = new Label("=");
        DoubleProperty intWidth = new SimpleDoubleProperty(5.0);
        //Bindings.bindBidirectional(textWidth.textProperty(), intWidth, new NumberStringConverter());
        textWidth.textProperty().bindBidirectional(intWidth, new NumberStringConverter());

        DoubleProperty intHeight = new SimpleDoubleProperty(20.2);
        Bindings.bindBidirectional(textHeight.textProperty(), intHeight, new NumberStringConverter());

        TextField textArea = new TextField();
        textArea.setEditable(false);

        NumberBinding area = intHeight.multiply(intWidth);

        area.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                textArea.setText(area.getValue().toString());
            }
        });

        HBox hPane = new HBox();

        hPane.getChildren().addAll(textWidth, multLabel, textHeight, eqLabel, textArea);

        Pane mainPane = new Pane();

        mainPane.getChildren().add(hPane);
        Scene scene  = new Scene(mainPane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
