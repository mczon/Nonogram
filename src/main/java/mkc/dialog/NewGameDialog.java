package main.java.mkc.dialog;

import javafx.scene.control.ButtonType;
import main.java.mkc.guicomponents.GameBoardWizardFlow;
import main.java.mkc.model.GameBoardWizard;
import main.java.mkc.model.NonogramBoard;

public class NewGameDialog {

    public static NonogramBoard display() {
        initialize();

        return null;
    }

    private static void initialize() {
        final GameBoardWizard wizard = new GameBoardWizard();
        wizard.setTitle("Create new game board");
        wizard.setFlow(new GameBoardWizardFlow());
        wizard.showAndWait().ifPresent(result -> {
            if (result == ButtonType.FINISH) {
                System.out.println("Done");
            }
        });
    }
}
