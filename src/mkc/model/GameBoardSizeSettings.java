package mkc.model;

public class GameBoardSizeSettings {
    private int mNumberOfRows;
    private int mNumberOfColumns;

    public GameBoardSizeSettings() {
    }

    public GameBoardSizeSettings(int nrOfColumns, int nrOfRows) {
        mNumberOfRows = nrOfColumns;
        mNumberOfRows = nrOfRows;
    }

    public int getNumberOfColumns() {
        return mNumberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        mNumberOfColumns = numberOfColumns;
    }

    public int getNumberOfRows() {
        return mNumberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        mNumberOfRows = numberOfRows;
    }

    public boolean equals(GameBoardSizeSettings other) {
        return mNumberOfColumns == other.getNumberOfColumns() &&
                mNumberOfRows == other.getNumberOfRows();
    }
}
