package cs2410.assn8.view;

import cs2410.assn8.controller.GameController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by austin on 12/7/16.
 */
public class Main extends Application {
    /**
     * The main pane all other panes go into
     */
    private BorderPane mainPane = new BorderPane(); //mainPane everything goes into
    /**
     * The gameboard of type gridPane
     */
    private GameController board;
    /**
     *  The scoreboard of type Hbox
     */
    public ScoreBoard scoreBoard;
    /**
     * The Display pane which content is displayed inside
     */
    private StackPane displayPane = new StackPane();
    /**
     * The timer to run the second counter
     */
    private Timer timer = new Timer();
    /**
     * The value stored for seconds counted
     */
    public Integer secondCount = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });

        scoreBoard = new ScoreBoard();
        board = new GameController();
        displayPane.getChildren().add(board);
        scoreBoard.setAlignment(Pos.TOP_CENTER);
        board.setAlignment(Pos.BOTTOM_CENTER);
        displayPane.setPrefSize(800, 700);

        mainPane.setTop(scoreBoard);
        mainPane.setCenter(displayPane);
        Scene scene = new Scene(mainPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Minesweeperish - Austin Derbique");
        primaryStage.setResizable(false);

        initProgram();
        primaryStage.show();

    }

    private void initProgram() {

        board.clearCounter();
        scoreBoard.clearScoreBoard();
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (board.isGameRunning()) {
                    secondCount++;
                    board.setCounter(secondCount);
                    scoreBoard.setCounter(secondCount);
                    scoreBoard.setBombCounter(board.getBombCounter());
                }

            }
        }, 0, 1000);


        scoreBoard.start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                secondCount = 0;
                board.clearCounter();
                scoreBoard.setCounter(0);
                board.startGame();
            }
        });

        scoreBoard.cheat.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                board.showBombs();
            }
        });

        scoreBoard.cheat.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                board.hideBombs();
            }
        });

    }
}