package technology.tag.codejam.contests.y2013.tictactoetomek;

import static technology.tag.codejam.contests.y2013.tictactoetomek.TicTacToeTomekTestCase.ROWS;

import java.io.BufferedReader;
import java.io.IOException;

import technology.tag.codejam.base.TestCaseReader;

public class TicTacToeTomekTestCaseReader implements
		TestCaseReader<TicTacToeTomekTestCase, TicTacToeTomekSolution> {

	public TicTacToeTomekTestCaseReader() {
		super();
	}

	@Override
	public TicTacToeTomekTestCase readTestCase(int caseNumber,
			BufferedReader reader) throws IOException {
		// TODO: clean this up
		if (reader.markSupported()) {
			int readAheadLimit = 1024;
			reader.mark(readAheadLimit);
			String line = reader.readLine();
			if (line == null) {
				return null;
			}
			reader.reset();
		}

		String[] rows = new String[ROWS];
		for (int i = 0; i < rows.length; i++) {
			String line = reader.readLine();
			rows[i] = line;
		}

		return new TicTacToeTomekTestCase(caseNumber, rows);
	}

}