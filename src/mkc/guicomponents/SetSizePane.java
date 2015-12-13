package mkc.guicomponents;

import org.controlsfx.dialog.WizardPane;

import javafx.beans.value.ChangeListener;
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
    }

    public GameBoardSizeSettings getSizeSettings() {
    	return mSizeSettings;
    }
}
