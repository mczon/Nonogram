package mkc.guicomponents;

import org.controlsfx.dialog.WizardPane;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import mkc.model.GameBoardSizeSettings;

public class SetSizePane extends WizardPane {

    private final GameBoardSizeSettings mSizeSettings = new GameBoardSizeSettings();
    private final NumberTextField mNumberOfColumns;
    private final NumberTextField mNumberOfRows;

    public SetSizePane() {
        mNumberOfColumns = new NumberTextField(1, false);
        mNumberOfRows = new NumberTextField(1, false);

        mNumberOfColumns.focusedProperty().addListener(
                (ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
                    if (newValue) {
                        mSizeSettings.setNumberOfColumns(mNumberOfColumns.getValue());
                    }
                });

        mNumberOfRows.focusedProperty().addListener(
                (ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
                    if (newValue) {
                        mSizeSettings.setNumberOfRows(mNumberOfRows.getValue());
                    }
                });

        final Label columnsLabel = new Label("Number of columns:");
        final Label rowsLabel = new Label("Number of rows:");

        final GridPane grid = new GridPane();
        grid.add(columnsLabel, 0, 0);
        grid.add(mNumberOfColumns, 1, 0);
        grid.add(rowsLabel, 0, 1);
        grid.add(mNumberOfRows, 1, 1);

        setContent(grid);
    }

    public GameBoardSizeSettings getSizeSettings() {
        return mSizeSettings;
    }
}
