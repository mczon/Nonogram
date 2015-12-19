package main.java.mkc.guicomponents;

import org.controlsfx.dialog.Wizard;
import org.controlsfx.dialog.WizardPane;

public class SetFixedPane extends WizardPane {

    private int mColumns = 0;
    private int mRows = 0;

    @Override
    public void onEnteringPage(Wizard wizard) {
        super.onEnteringPage(wizard);
    }

    @Override
    public void onExitingPage(Wizard wizard) {
        super.onExitingPage(wizard);
    }

    public void setSizeSettings(int columns, int rows) {
        if (mColumns != columns) {
            mColumns = columns;
        }

        if (mRows != rows) {
            mRows = rows;
        }
    }
}
