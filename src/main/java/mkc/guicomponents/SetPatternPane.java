package main.java.mkc.guicomponents;

import java.util.List;

import org.controlsfx.dialog.Wizard;
import org.controlsfx.dialog.WizardPane;

import com.google.common.collect.Lists;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.java.mkc.model.GameBoardWizard;

public class SetPatternPane extends WizardPane {
    private int mColumns = -1;
    private int mRows = -1;
    private final TableView<DescriptionRow> mColumnTable;
    private final TableView<DescriptionRow> mRowTable;

    private TextField mColumnTextField;
    private TextField mRowTextField;;

    private int mColumnIndex = 1;
    private int mRowIndex = 1;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public SetPatternPane() {
        super();
        mColumnTable = new TableView<DescriptionRow>();
        mRowTable = new TableView<DescriptionRow>();

        mColumnTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        mRowTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        final TableColumn columnIndexCol = new TableColumn("index");
        final TableColumn columnValueCol = new TableColumn("Values");
        final TableColumn rowIndexCol = new TableColumn("Index");
        final TableColumn rowValuesCol = new TableColumn("Values");
        rowIndexCol.setCellValueFactory(new PropertyValueFactory<DescriptionRow, String>("index"));
        rowValuesCol.setCellValueFactory(new PropertyValueFactory<DescriptionRow, String>("description"));

        columnValueCol.setSortable(false);
        rowValuesCol.setSortable(false);
        mColumnTable.getColumns().addAll(columnIndexCol, columnValueCol);
        mRowTable.getColumns().addAll(rowIndexCol, rowValuesCol);

        final Label columnLabel = new Label("Column information");
        final Label rowLabel = new Label("Row information");
        columnLabel.setFont(new Font("Arial", 20));
        rowLabel.setFont(new Font("Arial", 20));

        final Label informationLabel = new Label("Write the values space seperated, ie '1 2 12 5'");

        mColumnTextField = new TextField("");
        final Button columnButton = new Button("Add column description");
        columnButton.setOnAction(e -> {
            updateTable(mColumnIndex, mColumns, mColumnTextField, mColumnTable);

        });

        mRowTextField = new TextField("");
        final Button rowButton = new Button("Add row description");
        rowButton.setOnAction(e -> {
            updateTable(mRowIndex, mRows, mRowTextField, mRowTable);
        });

        final HBox addColumnDescription = new HBox();
        addColumnDescription.getChildren().addAll(mColumnTextField, columnButton);

        final HBox addRowDescription = new HBox();
        addRowDescription.getChildren().addAll(mRowTextField, rowButton);

        final GridPane tableGrid = new GridPane();
        tableGrid.add(columnLabel, 0, 0);
        tableGrid.add(rowLabel, 1, 0);
        tableGrid.add(mColumnTable, 0, 1);
        tableGrid.add(mRowTable, 1, 1);
        tableGrid.add(addColumnDescription, 0, 2);
        tableGrid.add(addRowDescription, 1, 2);
        final VBox layout = new VBox();
        layout.getChildren().addAll(tableGrid, informationLabel);
        final String css = SetPatternPane.class.getResource("../../../resources/css/tableStyleSheet.css").toExternalForm();

        layout.getStylesheets().clear();
        layout.getStylesheets().add(css);
        setContent(layout);
    }

    @Override
    public void onEnteringPage(Wizard wizard) {
        super.onEnteringPage(wizard);
        final GameBoardWizard gbw = ((GameBoardWizard) wizard);

        if (mRows != gbw.getRows()) {
            mRows = gbw.getRows();
            resetTableInformation(mRows, mRowTable);
        }

        if (mColumns != gbw.getColumns()) {
            mColumns = gbw.getColumns();
            resetTableInformation(mColumns, mColumnTable);
        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void updateTable(int currentIndex, int maxIndex, TextField description, TableView table) {
        final String descriptionText = description.getText();
        if (currentIndex < maxIndex && isDescriptionValid(descriptionText)) {
            table.getItems().add(new DescriptionRow(currentIndex, descriptionText));
            description.setText("");
            currentIndex++;
        }
    }

    private boolean isDescriptionValid(String descriptionText) {
        boolean retValue = true;
        final String[] split = descriptionText.split(" ");
        for (final String number : split) {
            try {
                Integer.parseInt(number);
            } catch (final NumberFormatException e) {
                retValue = false;
                break;
            }
        }

        return retValue;
    }

    private void resetTableInformation(int numberOfRows, TableView<DescriptionRow> table) {
        final List<DescriptionRow> tableRows = Lists.newArrayList();
        for (int i = 0; i < numberOfRows; i++) {
            tableRows.add(new DescriptionRow(i + 1, ""));
        }
        final ObservableList<DescriptionRow> data = FXCollections.observableArrayList(tableRows);
        table.setItems(data);
    }

    public static class DescriptionRow {
        private final int mIndex;
        private final SimpleStringProperty mDescription;

        private DescriptionRow(int index, String description) {
            mIndex = index;
            mDescription = new SimpleStringProperty(description);
        }

        public int getIndex() {
            return mIndex;
        }

        public String getDescription() {
            return mDescription.get();
        }
    }
}
