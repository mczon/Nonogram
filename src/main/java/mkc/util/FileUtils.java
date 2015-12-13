package mkc.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import mkc.dialog.ErrorDialog;
import mkc.model.NonogramBoard;

public class FileUtils {

    public static NonogramBoard loadGame(File file) {
        NonogramBoard board = null;
        if (file != null) {
            try {
                final JAXBContext context = JAXBContext.newInstance(NonogramBoard.class);
                final Unmarshaller um = context.createUnmarshaller();

                // Reading XML from the file and unmarshalling.
                board = (NonogramBoard) um.unmarshal(file);

                // Save the file path to the registry.
                board.setFilePath(file.getAbsolutePath());

            } catch (final Exception e) {
                ErrorDialog.display("Error",
                        "Could not load data from file:\n" + file.getAbsolutePath());
            }
        }

        return board;
    }

    public static void saveGame(NonogramBoard board) {
        if (board.getFilePath() == null) {
            // Choose where to save
        }

        if (board.getFilePath() != null) {
            try {
                final File gameFile = new File(board.getFilePath());
                final JAXBContext context = JAXBContext.newInstance(NonogramBoard.class);
                final Marshaller m = context.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                // Marshalling and saving XML to the file.
                m.marshal(board, gameFile);
            } catch (final Exception e) {
                ErrorDialog.display("Error", "Could not save data to file:\n" + board.getFilePath());
            }
        }
    }
}
