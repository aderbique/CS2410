package cs2410.assn8.controller;

import cs2410.assn8.view.Cell;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by austin on 12/7/16.
 */
public class GameController extends GridPane {

    /**
     * The percentage of bombs on field
     */
    private static final int PERCENT_BOMBS = 25;
    /**
     * The number of columns in playing field
     */
    private static final int TILES_HEIGHT = 20;
    /**
     * The number of rows in playing field
     */
    private static final int TILES_WIDTH = 20;
    /**
     * The event handler passed to the buttons
     */
    private EventHandler<MouseEvent> buttonHandler;
    /**
     * The number of bombs on playing field
     */
    private int numBombs = (int) (PERCENT_BOMBS * .01 * TILES_HEIGHT * TILES_WIDTH);
    /**
     * The number of tiles revealed
     */
    private int numTilesRevealed = 0;
    /**
     * An ArrayList of Cells
     */
    private ArrayList<Cell> cellList;
    /**
     * An ArrayList of Cell bombs
     */
    private ArrayList<Cell> bombList = new ArrayList<Cell>();
    /**
     * An array of images to hold during cheat method
     */
    private Image[] bombListImage = new Image[numBombs];
    /**
     * Counts the bombs
     */
    private Integer bombCounter;
    /**
     * An Array of Cells
     */
    private Cell[][] boardList;
    /**
     * Determines if game is running
     */
    private Boolean isGameRunning = false;
    /**
     * Value for seconds counter
     */
    public Integer secondCount = 0;
    /**
     * Bomb image
     */
    Image bomb = new Image(getClass().getResourceAsStream("bomb.png"));
    /**
     * Question image
     */
    Image question = new Image(getClass().getResourceAsStream("question.png"));
    /**
     * Flag image
     */
    Image flag = new Image(getClass().getResourceAsStream("flag.png"));

    /**
     * Default constructor to create a game
     */
    public GameController() {
        try {
            initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**Initalizer for method
     *
     * @throws Exception
     */
    public void initialize() throws Exception {
        bombCounter = (int) (PERCENT_BOMBS * .01 * TILES_WIDTH * TILES_HEIGHT);
        cellList = new ArrayList<Cell>();
        initializeBtnHandler();

        for (int i = 0; i < numBombs; i++) {
            cellList.add(new Cell(Boolean.TRUE));
        }

        for (int i = 0; i < (TILES_HEIGHT * TILES_WIDTH - numBombs); i++) {
            cellList.add(new Cell(Boolean.FALSE));
        }

        Collections.shuffle(cellList);

        boardList = new Cell[TILES_HEIGHT][TILES_WIDTH];
        int count = 0;
        for (int i = 0; i < TILES_HEIGHT; i++) {
            for (int j = 0; j < TILES_WIDTH; j++) {
                boardList[i][j] = cellList.get(count);
                cellList.get(count).setCoords(i, j);
                this.add(cellList.get(count), j, i);
                cellList.get(count).setOnMousePressed(buttonHandler);
                count++;
                boardList[i][j].setDisable(true);

                if(boardList[i][j].getIsBomb()){
                    bombList.add(boardList[i][j]);
                }
            }
        }

    }

    /**
     * Initalizes the button handler
     */
    public void initializeBtnHandler() {
        buttonHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Cell temp = (Cell) event.getSource();
                if(!boardList[temp.getCellRow()][temp.getCellCol()].isDisable()){

                if (event.isPrimaryButtonDown()) {
                    //System.out.println("Primary button pressed");

                    if(!boardList[temp.getCellRow()][temp.getCellCol()].getIsClear()) {
                        boardList[temp.getCellRow()][temp.getCellCol()].setFlag("isClear");
                        boardList[temp.getCellRow()][temp.getCellCol()].setGraphic(null);
                    }

                    if (boardList[temp.getCellRow()][temp.getCellCol()].getIsBomb()) {
                        endGame(false);
                    } else {
                        revealTile(temp.getCellRow(), temp.getCellCol());
                    }

                    if(numTilesRevealed == TILES_WIDTH*TILES_HEIGHT-numBombs){
                        endGame(Boolean.TRUE);
                    }


                } else if (event.isSecondaryButtonDown()) {

                    if (temp.getIsPossible()) {
                        boardList[temp.getCellRow()][temp.getCellCol()].setFlag("isCheck");
                        boardList[temp.getCellRow()][temp.getCellCol()].setGraphic(new ImageView(question));
                    } else if (temp.getIsCheck()) {
                        boardList[temp.getCellRow()][temp.getCellCol()].setFlag("isClear");
                        boardList[temp.getCellRow()][temp.getCellCol()].setGraphic(null);
                        bombCounter++;
                        //System.out.println("The bomb count is now " + bombCounter);
                    } else if (temp.getIsClear()) {
                        boardList[temp.getCellRow()][temp.getCellCol()].setFlag("isPossible");
                        boardList[temp.getCellRow()][temp.getCellCol()].setGraphic(new ImageView(flag));
                        bombCounter--;
                    }
                }
            }
            }
        };
    }

    /**
     *
     * @param win Determines if the game is won or not
     */
    public void endGame(Boolean win){
        isGameRunning = false;
        showBombs();
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //Creates an alert box to notify user the person has been created
        if(win){
            alert.setTitle("You won!");
            alert.setContentText("You were victorious in " + secondCount + " seconds.");
        }
        else{
            alert.setTitle("Game Over");
            alert.setContentText("It took you " + secondCount + " seconds to lose. You suck!");
        }
        alert.setHeaderText(null);
        alert.showAndWait();
        hideBombs();
        bombList.clear();
        numTilesRevealed = 0;
        secondCount = 0;
        try {
            initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @param pCellRow Cell row
     * @param pCellCol Cell Column
     */
    public void revealTile(int pCellRow, int pCellCol) {
        if( (pCellRow < 0 || pCellRow >= TILES_HEIGHT) || ( pCellCol >= TILES_WIDTH || pCellCol< 0) ||(boardList[pCellRow][pCellCol].isDisable())){
            return;
        }
        int bombsInRange = 0;
        for(int i = pCellRow-1; i < pCellRow + 2; i++){
            for (int j = pCellCol-1; j < pCellCol + 2; j++){
                if((i>-1 && i< TILES_HEIGHT) && (j>-1 && j<TILES_WIDTH)){
                    if(boardList[i][j].getIsBomb()){
                        bombsInRange++;
                    }
                }
            }
        }
        if(boardList[pCellRow][pCellCol].getIsClear()) {
            boardList[pCellRow][pCellCol].setDisable(true);
            numTilesRevealed++;
        }
        if(bombsInRange == 0) {
            revealTile(pCellRow, pCellCol - 1);
            revealTile(pCellRow, pCellCol +1);
            revealTile(pCellRow - 1, pCellCol);
            revealTile(pCellRow + 1, pCellCol);
        }else{
            boardList[pCellRow][pCellCol].setText(Integer.toString(bombsInRange));
            }

    }

    /**
     * Enables board to be played
     */
    public void startGame(){

        for (int i = 0; i < TILES_HEIGHT; i++) {
            for (int j = 0; j < TILES_WIDTH; j++) {
                boardList[i][j].setDisable(false);
                boardList[i][j].setText("");
            }
        }
        clearCounter();
        isGameRunning = true;
        //startTimer();
    }

    public void clearCounter(){
        secondCount = 0;
    }

    /**
     * Method to show bombs on board
     */
    public void showBombs(){
        for(int i = 0; i < bombList.size(); i++){
            if(bombList.get(i).getIsCheck()){
                bombListImage[i] = question;
            }
            else if(bombList.get(i).getIsPossible()){
                bombListImage[i] = flag;
            }
            else if(bombList.get(i).getIsClear()){
                bombListImage[i] = null;
            }
            bombList.get(i).setGraphic(new ImageView(bomb));
        }
    }

    /**
     * Method to hide bombs on board
     */
    public void hideBombs(){
        for(int i = 0; i < bombList.size(); i++){
            bombList.get(i).setGraphic(new ImageView(bombListImage[i]));
        }
    }

    /**
     *
     * @param pCounter Parameter for passing the counter value
     */
    public void setCounter(Integer pCounter){
        secondCount = pCounter;
    }

    /**
     *
     * @return True if running, false if game is not running
     */
    public Boolean isGameRunning(){
        return isGameRunning;
    }

    /**
     *
     * @return Returns the bomb count
     */
    public Integer getBombCounter(){
        return bombCounter;
    }

}