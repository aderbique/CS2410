package cs2410.assn8.view;

import javafx.scene.control.Button;

/**
 * Created by austin on 12/7/16.
 */
public class Cell extends Button {
    private Boolean isBomb;
    private Boolean isPossible = false;
    private Boolean isCheck = false;
    private Boolean isClear = true;
    private int cellRow;
    private int cellCol;

    /**
     *
     * @param setBomb Sets the cell as a bomb
     */
    public Cell(Boolean setBomb) {
        isBomb = setBomb;
        this.setPrefHeight(40);
        this.setPrefWidth(40);
        this.getStylesheets().addAll("style.css");
    }

    /**
     *
     * @return Checks to see if cell is a bomb
     */
    public Boolean getIsBomb() {
        return isBomb;
    }

    /**
     *
     * @return Checks if possible flag is set
     */
    public Boolean getIsPossible() {
        return isPossible;
    }

    /**
     *
     * @return Checks if check flag is set
     */
    public Boolean getIsCheck() {
        return isCheck;
    }

    /**
     *
     * @return Checks if clear flag is set
     */
    public Boolean getIsClear() {
        return isClear;
    }

    /**
     *
     * @return returns cell row
     */
    public int getCellRow() {
        return cellRow;
    }

    /**
     *
     * @return returns cell column
     */
    public int getCellCol() {
        return cellCol;
    }

    /**
     *
     * @param setRow Gives Row coords for cell
     * @param setCol Gives Col coords for cell
     */
    public void setCoords(int setRow, int setCol) {
        cellRow = setRow;
        cellCol = setCol;
    }

    public void setFlag(String pFlag) {
        if (pFlag.equals("isPossible")) {
            isPossible = true;
            isCheck = false;
            isClear = false;
        } else if (pFlag.equals("isCheck")) {
            isPossible = false;
            isCheck = true;
            isClear = false;

        } else if (pFlag.equals("isClear")) {
            isPossible = false;
            isCheck = false;
            isClear = true;
        }
    }
}


