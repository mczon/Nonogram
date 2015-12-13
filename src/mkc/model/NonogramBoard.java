package mkc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

import com.google.common.collect.Lists;

@XmlRootElement(name="Nonogram")
public class NonogramBoard {

	@XmlElement(name="Rows")
	private List<ColorInformation> mRows;

	@XmlElement(name="Columns")
	private List<ColorInformation> mColumns;

	@XmlElement(name="Colors")
	private int[][] mColors;

	@XmlTransient
	private String mFilePath;

	public List<ColorInformation> getRows() {
		return mRows;
	}

	public void setRows(List<ColorInformation> rows) {
		mRows = rows;
	}

	public List<ColorInformation> getColumns() {
		return mColumns;
	}

	public void setColumns(List<ColorInformation> columns) {
		mColumns = columns;
	}

	public int[][] getColors() {
		return mColors;
	}

	public void setColors(int[][] colors) {
		mColors = colors;
	}

	public String getFilePath() {
		return mFilePath;
	}

	public void setFilePath(String filePath) {
		mFilePath = filePath;
	}

	private class ColorInformation {
		@XmlValue
		List<Integer> mColorInformation;

		public ColorInformation() {
			mColorInformation = Lists.newArrayList();
		}

		public ColorInformation(List<Integer> colorInformation) {
			mColorInformation = colorInformation;
		}
	}
}