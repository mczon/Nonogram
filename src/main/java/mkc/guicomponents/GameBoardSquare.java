package main.java.mkc.guicomponents;

import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;

public class GameBoardSquare extends Label {

	public static final int BLACK_COLOR_ID = 1;
	public static final int FIXED_COLOR_ID = 1;
	public static final int WHITE_COLOR_ID = 0;
	public static final int RED_COLOR_ID = 2;

	private final Label mLabel;
	private int mColorId;



	public GameBoardSquare() {
		mColorId = 0;
		mLabel = new Label();
		mLabel.setOnMouseClicked(mouseEvent -> {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				updateColor();
			}
		});
	}

	private void updateColor() {
		if (mColorId >= 0) {
			mColorId = (mColorId + 1) % 3;
		}

		switch(mColorId) {
		case WHITE_COLOR_ID:
			mLabel.setStyle("-fx-border-color:black; -fx-background-color: white;");
			break;
		case RED_COLOR_ID:
			mLabel.setStyle("-fx-border-color:black; -fx-background-color: red;");
			break;
		default:
			mLabel.setStyle("-fx-border-color:white; -fx-background-color: black;");
			break;
		}
	}
}
