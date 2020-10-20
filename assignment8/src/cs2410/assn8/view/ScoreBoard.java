package cs2410.assn8.view;


import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;


/**
 * Created by Austin Derbique <aderbique@yahoo.com></aderbique@yahoo.com>
 * @since 12/9/16
 */
public class ScoreBoard extends HBox {
    /**
     * Start button for game
     */
    public Button start = new Button("Start");
    /**
     * Cheat button for game
     */
    public Button cheat = new Button("Cheat");
    /**
     * Holds information for seconds counted
     */
    private Integer counter = 0;
    /**
     * Holds information for possible bombs left on field
     */
    private Integer bombCounter = 0;
    /**
     * Property Binding for seconds counted
     */
    private IntegerProperty counterProperty = new SimpleIntegerProperty(counter);
    /**
     * Property Binding for Bombs left
     */
    private IntegerProperty bombProperty = new SimpleIntegerProperty(bombCounter);
    /**
     * Label of seconds counted
     */
    public Label secondString;
    /**
     * Label of possible bombs left
     */
    public Label bombString;
    /**
     * Number of Seconds counted
     */
    public Label numSeconds;
    /**
     * Number of possible bombs remaining
     */
    public Label numBombs;

    public ScoreBoard() {

        /**
         * This is the default method for the Toolbar class. It takes what is created and sets everything up to display inside of the pane.
         */
        secondString = new Label();
        bombString = new Label();
        numSeconds = new Label(" Seconds Elapsed");
        numBombs = new Label(" Bombs Remaining");

        secondString.textProperty().bindBidirectional(counterProperty, new NumberStringConverter());
        bombString.textProperty().bindBidirectional(bombProperty, new NumberStringConverter());

        this.getChildren().addAll(numBombs, start, cheat, numSeconds);
        this.setStyle("-fx-background-color: lightgrey;");
        this.setSpacing(50);
        this.setPadding(new Insets(10, 10, 10, 10));
    }

    /**
     *
     * @param pCounter Holds second counter information
     */
    public void setCounter(Integer pCounter) {
        /**
         * Sets the counter to the parameter
         */
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                counterProperty.set(pCounter);
                numSeconds.setText(Integer.toString(pCounter) + " Seconds Elapsed");
            }
        });

    }

    /**
     *
     * @param pbombCounter Holds bomb counter information
     */
    public void setBombCounter(Integer pbombCounter) {
        /**
         * Sets the bomb counter Property Binding
         */
        bombCounter = pbombCounter;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                bombProperty.set(bombCounter);
                numBombs.setText(Integer.toString(bombCounter) + " Bombs Remaining");
            }
        });
    }

    public void clearScoreBoard() {
        /**
         * Clears the scoreboard
         */
        counter = 0;
        bombCounter = 0;
        numBombs.setText(null);
        numSeconds.setText(null);
    }


}
