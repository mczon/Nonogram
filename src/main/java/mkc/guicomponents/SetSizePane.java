package main.java.mkc.guicomponents;

import org.controlsfx.dialog.Wizard;
import org.controlsfx.dialog.WizardPane;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.java.mkc.model.GameBoardWizard;

public class SetSizePane extends WizardPane {

    private final NumberTextField mColumnsField;
    private final NumberTextField mRowsField;

    public SetSizePane() {
        mColumnsField = new NumberTextField(1, false);
        mRowsField = new NumberTextField(1, false);

        final Label columnsLabel = new Label("Number of columns:");
        final Label rowsLabel = new Label("Number of rows:");

        final GridPane grid = new GridPane();
        grid.add(columnsLabel, 0, 0);
        grid.add(mColumnsField, 1, 0);
        grid.add(rowsLabel, 0, 1);
        grid.add(mRowsField, 1, 1);

        setContent(grid);
    }

    @Override
    public void onExitingPage(Wizard wizard) {
        super.onExitingPage(wizard);

        final GameBoardWizard gbw = ((GameBoardWizard)wizard);
        gbw.setColumns(mColumnsField.getValue());
        gbw.setRows(mRowsField.getValue());
    }
}
