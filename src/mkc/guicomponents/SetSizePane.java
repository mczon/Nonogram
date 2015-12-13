package mkc.guicomponents;

import org.controlsfx.dialog.WizardPane;

import javafx.beans.value.ChangeListener;
import mkc.model.NonogramBoardSizeSettings;

public class SetSizePane extends WizardPane {

    private final NonogramBoardSizeSettings sizeSettings = new NonogramBoardSizeSettings();
    private final NumberTextField mNumberOfColumns;
    private final NumberTextField mNumberOfRows;

    public SetSizePane() {
        mNumberOfColumns = new NumberTextField(1, false);
        mNumberOfRows = new NumberTextField(1, false);

        mNumberOfColumns.focusedProperty().addListener(
                (ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
                    if (newValue) {
                        sizeSettings.setNumberOfColumns(mNumberOfColumns.getValue());
                    }
                });

        mNumberOfRows.focusedProperty().addListener(
                (ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
                    if (newValue) {
                        sizeSettings.setNumberOfRows(mNumberOfRows.getValue());
                    }
                });
    }
}
