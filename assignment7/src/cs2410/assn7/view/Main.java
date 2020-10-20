package cs2410.assn7.view;

import cs2410.assn7.control.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
/**
 * CS2410 Assn 7 - Polyabstraheritance"
 *
 * @author Austin Derbique
 * @version 1.0
 */
public class Main extends Application {

    /**
     * @nameField Contains the input field for name
     * @mathField Contains the input field for math
     * @incomeField Contains the input field for income
     * @hoursField Contains the input field for hours worked
     * @iqField Contains the input field for person's IQ
     * @carrotsField Contains the input field for how many carrots a hobbit has
     * @sayField Contains the input field for what a person says
     * @contractsField Contains the input field for how many contracts a contract worker has completed
     */

    private TextField nameField = new TextField();
    private TextField mathField = new TextField();
    private TextField incomeField = new TextField();
    private TextField hoursField = new TextField();
    private TextField iqField = new TextField();
    private TextField sayField = new TextField();
    private TextField carrotsField = new TextField();
    private TextField contractsField = new TextField();

    private Label nameLabel = new Label("Name:");
    private Label mathLabel = new Label("Math:");
    private Label sayLabel = new Label("Say:");
    private Label iqLabel = new Label("IQ:");
    private Label incomeLabel = new Label("Income:");
    private Label hoursLabel = new Label("Hours:");
    private Label contractsLabel = new Label("Contracts:");
    private Label carrotsLabel = new Label("Carrots");

    private Button saveBtn = new Button("Save"); //Button used for saving a person
    private Button cancelBtn = new Button("Clear"); //Button used for clearing input fields
    private int btnPressed = 0; //Keeps track of which

    private GridPane grid = new GridPane(); //Grid pane used for laying out the fields and labels for creating a person
    BorderPane mainPane = new BorderPane(); //The mainpane everything goes inside of
    private Text text = new Text("Welcome! Please choose something."); //This handles the output for all information being shown
    private ToolBar toolBar; //Creates an instance of toolbar  to be used in GUI
    private StackPane displayPane = new StackPane(); //The display pane is where information is shown for the GUI

    /** This is the start method that initilizes the gui
     *
     * @param primaryStage The main stage for the program
     * @throws Exception Default exception handler
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        nameField.setPromptText("Namez goes here");
        nameField.setPrefColumnCount(10);
        nameField.getText();

        mathField.setPromptText("Enter Maths Here");
        mathField.setPrefColumnCount(10);
        mathField.getText();

        incomeField.setPromptText("Enter the $$$ here");
        incomeField.setPrefColumnCount(10);
        incomeField.getText();

        hoursField.setPromptText("Many hours? much or small");
        hoursField.setPrefColumnCount(10);
        hoursField.getText();

        iqField.setPromptText("ur dum");
        iqField.setPrefColumnCount(10);
        iqField.getText();

        sayField.setPromptText("What are you capable of speaking?");
        sayField.setPrefColumnCount(10);
        sayField.getText();

        contractsField.setPromptText("All the contracts!");
        contractsField.setPrefColumnCount(10);
        contractsField.getText();

        carrotsField.setPromptText("I like carrots");
        carrotsField.setPrefColumnCount(10);
        carrotsField.getText();

        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER);
        toolBar = new ToolBar();
        toolBar.setAlignment(Pos.CENTER);

        displayPane.setPrefSize(500, 300);
        displayPane.getChildren().add(text); //Adds the output text to the displaypane
        mainPane.setTop(toolBar);
        mainPane.setCenter(displayPane);
        Scene scene = new Scene(mainPane);
        primaryStage.setTitle("Polyabstraheritance - Austin Derbique");
        primaryStage.setScene(scene);

        initProgram(); //Calls the init method to handle all button clicks
        Controller.addSamplePeople(); //calls the addSamplePeople() method to create persons and add them to list
        primaryStage.show(); //Shows the primary stage to the screen
    }

    /**
     * initProgram()  Initializes the program and defines what happens when something is pressed
     */
    private void initProgram(){


        toolBar.stringComboBox.setOnAction(new EventHandler<ActionEvent>(){
            /**
             *
             * @param event This event determines what happens when a combo box is selected
             */
            @Override
            public void handle(ActionEvent event){
                displayPane.getChildren().clear();
                grid.getChildren().clear();
                String choice = toolBar.stringComboBox.getValue();

                if(choice.equals("Math")){ text.setText(Controller.getMathList());}
                else if(choice.equals("Income")){text.setText(Controller.getIncomeList());}
                else if(choice.equals("Hours")){text.setText(Controller.getHoursList());}
                else if(choice.equals("IQ")){text.setText(Controller.getIQList());}
                else if(choice.equals("Say")){text.setText(Controller.getSayList());}
                else if(choice.equals("Carrots")){text.setText(Controller.getCarrotsList());}
                else if(choice.equals("Contracts")){text.setText(Controller.getContractsList());}

                displayPane.getChildren().add(text);
            }
        });

        toolBar.contractBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
            /**
             *
             * @param event Shows a GUI for creating a new Contract Worker
             */
            @Override
            public void handle(MouseEvent event) {
                if(!toolBar.contractBtnSelected()) {
                    displayPane.getChildren().clear();
                    grid.getChildren().clear();
                    btnPressed = 1; //Sets the save button equal to contract
                    clearFields();

                    GridPane.setConstraints(nameLabel, 0, 1);
                    GridPane.setConstraints(mathLabel, 0, 2);
                    GridPane.setConstraints(sayLabel, 0, 3);
                    GridPane.setConstraints(iqLabel, 0, 4);
                    GridPane.setConstraints(incomeLabel, 0, 5);
                    GridPane.setConstraints(contractsLabel, 0, 6);
                    GridPane.setConstraints(nameField, 1, 1);
                    GridPane.setConstraints(mathField, 1, 2);
                    GridPane.setConstraints(sayField, 1, 3);
                    GridPane.setConstraints(iqField, 1, 4);
                    GridPane.setConstraints(incomeField, 1, 5);
                    GridPane.setConstraints(contractsField, 1, 6);
                    GridPane.setConstraints(saveBtn, 0, 8);
                    GridPane.setConstraints(cancelBtn, 1, 8);
                    grid.getChildren().addAll(nameLabel, mathLabel, sayLabel, iqLabel, incomeLabel, contractsLabel, nameField, mathField, sayField, iqField, incomeField, contractsField, saveBtn, cancelBtn);
                    displayPane.getChildren().add(grid);
                }
            }
        });

        toolBar.hobbitBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
            /**
             *
             * @param event Shows a GUI for creating a new Hobbit
             */
            @Override
            public void handle(MouseEvent event) {
                if(!toolBar.hobbitBtnSelected()) {
                    //System.out.println("Hobbit is pressed");
                    displayPane.getChildren().clear();
                    grid.getChildren().clear();
                    clearFields();
                    btnPressed = 2; //Sets the save button = to hobbit

                    GridPane.setConstraints(nameLabel, 0, 0);
                    GridPane.setConstraints(mathLabel, 0, 1);
                    GridPane.setConstraints(sayLabel, 0, 2);
                    GridPane.setConstraints(carrotsLabel, 0, 3);
                    GridPane.setConstraints(nameField, 1, 0);
                    GridPane.setConstraints(mathField, 1, 1);
                    GridPane.setConstraints(sayField, 1, 2);
                    GridPane.setConstraints(carrotsField, 1, 3);
                    GridPane.setConstraints(saveBtn, 0, 5);
                    GridPane.setConstraints(cancelBtn, 1, 5);
                    grid.getChildren().addAll(nameLabel, mathLabel, sayLabel, carrotsLabel, nameField, mathField, sayField, carrotsField, saveBtn, cancelBtn);
                    displayPane.getChildren().add(grid);
                }
            }
        });

        toolBar.hourlyBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
            /**
             *
             * @param event Shows a GUI for creating a new hourly worker
             */
            @Override
            public void handle(MouseEvent event) {
                if(!toolBar.hourlyBtnSelected()) {

                    displayPane.getChildren().clear();
                    grid.getChildren().clear();
                    clearFields();
                    btnPressed = 3; //Sets the save button = to hourly worker

                    GridPane.setConstraints(nameLabel, 0, 1);
                    GridPane.setConstraints(mathLabel, 0, 2);
                    GridPane.setConstraints(sayLabel, 0, 3);
                    GridPane.setConstraints(iqLabel, 0, 4);
                    GridPane.setConstraints(incomeLabel, 0, 5);
                    GridPane.setConstraints(hoursLabel, 0, 6);
                    GridPane.setConstraints(nameField, 1, 1);
                    GridPane.setConstraints(mathField, 1, 2);
                    GridPane.setConstraints(sayField, 1, 3);
                    GridPane.setConstraints(iqField, 1, 4);
                    GridPane.setConstraints(incomeField, 1, 5);
                    GridPane.setConstraints(hoursField, 1, 6);
                    GridPane.setConstraints(saveBtn, 0, 8);
                    GridPane.setConstraints(cancelBtn, 1, 8);

                    grid.getChildren().addAll(nameLabel, mathLabel, sayLabel, iqLabel, incomeLabel, hoursLabel, nameField, mathField, sayField, iqField, incomeField, hoursField, saveBtn, cancelBtn);
                    displayPane.getChildren().add(grid);
                    mainPane.setCenter(displayPane);
                }
            }
        });

        saveBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
            /**
             *
             * @param event Save button determines what person you're creating and send information to controller
             */
            @Override
            public void handle(MouseEvent event) {
                if(btnPressed == 1){
                    Controller.addContractWorker(nameField.getText(), mathField.getText(), sayField.getText(), Double.parseDouble(incomeField.getText()), Integer.parseInt(iqField.getText()), Integer.parseInt(contractsField.getText()));
                }
                else if(btnPressed == 2){
                    Controller.addHobbit(nameField.getText(), mathField.getText(), sayField.getText(), Integer.parseInt(carrotsField.getText()));
                }
                else if(btnPressed == 3){
                    Controller.addHourlyWorker(nameField.getText(), mathField.getText(), sayField.getText(), Double.parseDouble(incomeField.getText()), Integer.parseInt(iqField.getText()), Double.parseDouble(hoursField.getText()));
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION); //Creates an alert box to notify user the person has been created
                alert.setTitle("Entry Added");
                alert.setHeaderText(null);
                alert.setContentText(nameField.getText() + " was successfully added!");
                clearFields();
                alert.showAndWait();

            }
        });

        cancelBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
            /**
             *
             * @param event Clears the text fields when pressed
             */
            @Override
            public void handle(MouseEvent event) {
               clearFields();
            }
        });
    }

    private void clearFields(){
        /**
         * This is a method to make clearing text fields easier
         */
        nameField.clear();
        mathField.clear();
        iqField.clear();
        carrotsField.clear();
        incomeField.clear();
        hoursField.clear();
        contractsField.clear();
        sayField.clear();
    }
}
