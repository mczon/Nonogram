package mkc.dialog;

import org.controlsfx.dialog.Wizard;

import javafx.scene.control.ButtonType;
import mkc.guicomponents.GameBoardWizardFlow;
import mkc.model.NonogramBoard;

public class NewGameDialog {

    public static NonogramBoard display() {
        initialize();

        return null;
    }

    private static void initialize() {
        final Wizard wizard = new Wizard();
        wizard.setTitle("Create new game board");
        wizard.setFlow(new GameBoardWizardFlow());
        wizard.showAndWait().ifPresent(result -> {
            if (result == ButtonType.FINISH) {
                System.out.println("Done");
            }
        });
    }
}
