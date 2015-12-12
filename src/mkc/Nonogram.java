package mkc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mkc.fightsimplifier.models.FighterModel;

public class Nonogram  extends Application {

    private static Stage mMainWindow;

    public static void main(String[] args) {
        System.setProperty("glass.accessible.force", "false");
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
        mMainWindow = primaryStage;
        mMainWindow.setTitle("Fightsimplifier");

        
        
        mMainWindow.setScene(new Scene(mWindowPain, 1200, 800));
        mMainWindow.show();
	}

}
