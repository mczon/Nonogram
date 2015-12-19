package main.java.mkc.model;

import org.controlsfx.dialog.Wizard;

public class GameBoardWizard extends Wizard {

    private int mColumns;
    private int mRows;

    public int getColumns() {
        return mColumns;
    }

    public void setColumns(int columns) {
        mColumns = columns;
    }

    public int getRows() {
        return mRows;
    }

    public void setRows(int rows) {
        mRows = rows;
    }
}
