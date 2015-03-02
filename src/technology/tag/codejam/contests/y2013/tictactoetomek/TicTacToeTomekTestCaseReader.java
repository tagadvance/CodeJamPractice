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

		String[] rows = new String[ROWS];
		for (int i = 0; i < rows.length; i++) {
			String line = reader.readLine();
			if (line == null) {
				return null;
			}
			rows[i] = line;
		}
		reader.readLine();

		return new TicTacToeTomekTestCase(caseNumber, rows);
	}

}