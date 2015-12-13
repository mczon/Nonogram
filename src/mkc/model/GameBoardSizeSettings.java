package mkc.model;

public class NonogramBoardSizeSettings {
    private int mNumberOfRows;
    private int mNumberOfColumns;

    public NonogramBoardSizeSettings() {
    }

    public NonogramBoardSizeSettings(int nrOfColumns, int nrOfRows) {
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

}
