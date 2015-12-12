package mkc.dialog;
import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mkc.model.NonogramBoard;
import mkc.util.FileUtils;

public class StartDialog {

    private static final String NEW_GAME = "New game";
    private static final String LOAD_GAME = "Load game";
    private static Button mLoadGameButton;
    private static Button mNewGameButton;
    private static Button mQuit;
    private static Stage mDialog;
    private static NonogramBoard mGameBoard;

    public static NonogramBoard display() {
        initialize();

        final Label label = new Label(message);

        final HBox buttonLayout = new HBox(10);
        buttonLayout.getChildren().add(mOkButton);
        buttonLayout.setAlignment(Pos.BOTTOM_RIGHT);

        final VBox layout = new VBox(10);
        layout.getChildren().addAll(label, buttonLayout);
        layout.setAlignment(Pos.CENTER);

        final Scene scene = new Scene(layout);
        mDialog.setScene(scene);
        mDialog.setResizable(true);
        mDialog.showAndWait();

        return mGameBoard;
    }

    private static void initialize() {
        mDialog = new Stage();
        mDialog.initModality(Modality.APPLICATION_MODAL);
        mDialog.setTitle("Choose action");
        mDialog.setMinWidth(200);
        mDialog.setMinHeight(125);

        mLoadGameButton = new Button(LOAD_GAME);
        mLoadGameButton.setAlignment(Pos.CENTER);
        mLoadGameButton.setOnAction(event -> {
            final File gameFile = loadGameFile();
            if (gameFile != null) {
                mGameBoard = FileUtils.loadGame(gameFile);
            }
            event.consume();
            mDialog.close();

        });

        mNewGameButton = new Button(NEW_GAME);
        mNewGameButton.setAlignment(Pos.CENTER);
        mNewGameButton.setOnAction(event -> {
            NewGameDialog.displa();
            event.consume();
            mDialog.close();

        });

        mDialog.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                mGameBoard = null;
                event.consume();
                mDialog.close();
            }
        });
    }

    private static File loadGameFile() {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open saved game");
        fileChooser.setSelectedExtensionFilter(new ExtensionFilter("xml"));
        final File gameFile = fileChooser.showOpenDialog(mDialog);
        return gameFile;
    }

}
