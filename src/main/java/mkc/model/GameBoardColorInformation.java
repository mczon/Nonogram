package main.java.mkc.model;

import main.java.mkc.guicomponents.GameBoardSquare;

public class GameBoardColorInformation {

    private GameBoardSquare[][] mColorInformation;
    private int mColumns = -1;
    private int mRows = -1;

    public GameBoardColorInformation(int columns, int rows) {
        setBoardSize(columns, rows);
    }

    public void setBoardSize(int columns, int rows) {
        if (mColumns != columns || mRows != rows) {
            mColumns = columns;
            mRows = rows;
            mColorInformation = new GameBoardSquare[mColumns][mRows];

            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < mRows; j++) {
                    mColorInformation[i][j] = new GameBoardSquare();
                }
            }
        }
    }
}
