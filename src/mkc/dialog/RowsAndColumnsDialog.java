package mkc.dialog;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mkc.guicomponents.NumberTextField;
import mkc.model.GameBoardSizeSettings;

public class RowsAndColumnsDialog {

    static NumberTextField sNumberOfRows;
    static NumberTextField sNumberOfColumns;

    public static GameBoardSizeSettings display() {
        final Label rowsLabel = new Label("Rows:");
        final Label columnsLabel = new Label("Columns:");

        sNumberOfRows = new NumberTextField(0, false);
        sNumberOfColumns = new NumberTextField(0, false);

        final GridPane layout = new GridPane();
        layout.add(rowsLabel, 0, 0);
        layout.add(sNumberOfRows, 1, 0);
        layout.add(columnsLabel, 0, 1);
        layout.add(sNumberOfColumns, 1, 1);

        final Scene scene = new Scene(layout);
        final Stage dialog = new Stage();
        dialog.setScene(scene);
        dialog.setResizable(true);
        dialog.showAndWait();

        final GameBoardSizeSettings settings =
                new GameBoardSizeSettings(sNumberOfColumns.getValue(),
                        sNumberOfRows.getValue());

        return settings;
    }
}
