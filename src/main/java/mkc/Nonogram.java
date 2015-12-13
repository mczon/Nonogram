package mkc;

import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mkc.dialog.StartDialog;
import mkc.model.NonogramBoard;

public class Nonogram  extends Application {

    private Stage mMainWindow;
    private BorderPane mWindowPain;

    public static void main(String[] args) {
        System.setProperty("glass.accessible.force", "false");
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        mMainWindow = primaryStage;
        mMainWindow.setTitle("Nonogram");

        mWindowPain = new BorderPane();

        final Scene scene = new Scene(mWindowPain, 1200, 800);
        final URL resource = this.getClass().getResource("../resources/css/tableStyleSheet.css");
        scene.getStylesheets().add(resource.getPath());
        mMainWindow.setScene(scene);
        mMainWindow.show();

        final NonogramBoard gameBoard = StartDialog.display();
        if (gameBoard == null) {
            mMainWindow.close();
        }
    }

}
