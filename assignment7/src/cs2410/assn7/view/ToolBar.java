package cs2410.assn7.view;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;



/**
 * Created by austin on 11/15/16.
 */
public class ToolBar extends HBox {
    public ToggleButton hourlyBtn = new ToggleButton("Hourly");
    public ToggleButton contractBtn = new ToggleButton("Contract");
    public ToggleButton hobbitBtn = new ToggleButton("Hobbit");
    public ComboBox<String> stringComboBox = new ComboBox<>(FXCollections.observableArrayList("Math","Income", "Hours", "IQ", "Say", "Carrots", "Contracts"));

    public ToolBar() {
        /**
         * This is the default method for the Toolbar class. It takes what is created and sets everything up to display inside of the pane.
         */

        this.getChildren().addAll(stringComboBox, hourlyBtn, contractBtn, hobbitBtn);

        stringComboBox.setValue(stringComboBox.getItems().get(0));

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(hourlyBtn, contractBtn, hobbitBtn);

        this.setSpacing(5);
        this.setPadding(new Insets(10, 10, 10, 10));
    }


    //public void setPersonType(EventHandler<ActionEvent> event) {
       // stringComboBox.setOnAction(event);
  //  }

    public boolean hourlyBtnSelected() {return hourlyBtn.isSelected();}

    public boolean contractBtnSelected() { return contractBtn.isSelected();}

    public boolean hobbitBtnSelected() { return hobbitBtn.isSelected();}

}
