package mkc.dialog;

import org.controlsfx.dialog.Wizard;

import mkc.model.NonogramBoard;
import mkc.model.GameBoardSizeSettings;

public class NewGameDialog {

    public static NonogramBoard display() {
        initialize();

        return null;
    }

    private static void initialize() {
        final GameBoardSizeSettings sizeSettings = RowsAndColumnsDialog.display();

        final Wizard wizard = new Wizard();
    }
}
