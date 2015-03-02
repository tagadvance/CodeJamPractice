package technology.tag.codejam.contests.y2013.tictactoetomek;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;

import technology.tag.codejam.base.AbstractTestCase;

public class TicTacToeTomekTestCase extends
		AbstractTestCase<TicTacToeTomekSolution> {

	public static enum Status {

		NOT_COMPLETED, X_WON, O_WON, DRAW;

	}

	public static final int ROWS = 4, COLUMNS = 4, WIN = 3;
	public static final String EMPTY_CELL = ".";

	private final String[] rows;

	public TicTacToeTomekTestCase(int id, String... rows) {
		super(id);
		Preconditions.checkArgument(ROWS == rows.length,
				"incorrect number of rows");
		this.rows = rows;
	}

	public char getValue(int row, int column) {
		return rows[row].charAt(column);
	}

	@Override
	public TicTacToeTomekSolution solve() {
		for (Line line : createLines()) {
			String lineString = line.toString();
			if (lineString.contains("T")) {
				if (lineString.contains("XXX")) {
					return new TicTacToeTomekSolution(getCaseNumber(),
							Status.X_WON);
				} else if (lineString.contains("OOO")) {
					return new TicTacToeTomekSolution(getCaseNumber(),
							Status.O_WON);
				}
			} else {
				if (lineString.contains("XXXX")) {
					return new TicTacToeTomekSolution(getCaseNumber(),
							Status.X_WON);
				} else if (lineString.contains("OOOO")) {
					return new TicTacToeTomekSolution(getCaseNumber(),
							Status.O_WON);
				}
			}
		}
		if (hasEmptyCells()) {
			return new TicTacToeTomekSolution(getCaseNumber(),
					Status.NOT_COMPLETED);
		} else {
			return new TicTacToeTomekSolution(getCaseNumber(), Status.DRAW);
		}
	}

	private List<Line> createLines() {
		List<Line> lines = new ArrayList<>();

		// add rows
		for (int y = 0; y < ROWS; y++) {
			int i = 0;
			lines.add(new Line(new Point(i++, y), new Point(i++, y), new Point(
					i++, y), new Point(i++, y)));
		}

		// add columns
		for (int x = 0; x < COLUMNS; x++) {
			int i = 0;
			lines.add(new Line(new Point(x, i++), new Point(x, i++), new Point(
					x, i++), new Point(x, i++)));
		}

		// add diagonal
		{
			int x = 0, y = 0;
			lines.add(new Line(new Point(x++, y++), new Point(x++, y++),
					new Point(x++, y++), new Point(x++, y++)));
		}
		{
			int x = 1, y = 0;
			lines.add(new Line(new Point(x++, y++), new Point(x++, y++),
					new Point(x++, y++)));
		}
		{
			int x = 0, y = 1;
			lines.add(new Line(new Point(x++, y++), new Point(x++, y++),
					new Point(x++, y++)));
		}
		{
			int x = 0, y = ROWS - 1;
			lines.add(new Line(new Point(x++, y--), new Point(x++, y--),
					new Point(x++, y--), new Point(x++, y--)));
		}
		{
			int x = 1, y = ROWS - 1;
			lines.add(new Line(new Point(x++, y--), new Point(x++, y--),
					new Point(x++, y--)));
		}
		{
			int x = 0, y = ROWS - 2;
			lines.add(new Line(new Point(x++, y--), new Point(x++, y--),
					new Point(x++, y--)));
		}
		return lines;
	}

	class Line {

		private Point[] points;

		public Line(Point... points) {
			super();
			this.points = points;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (Point point : points) {
				char c = getValue(point.y, point.x);
				sb.append(c);
			}
			return sb.append('\n').toString();
		}

	}

	public boolean hasEmptyCells() {
		for (String row : rows) {
			if (row.contains(EMPTY_CELL)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < ROWS; row++) {
			String rowString = rows[row];
			sb.append(rowString);
		}
		return sb.append('\n').toString();
	}

}