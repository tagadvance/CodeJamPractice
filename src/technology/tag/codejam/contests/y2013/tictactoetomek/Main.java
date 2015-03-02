package technology.tag.codejam.contests.y2013.tictactoetomek;

import java.io.IOException;
import java.util.prefs.Preferences;

import technology.tag.codejam.base.CodeJam;

public class Main {

	private Main() {

	}

	private void example() throws IOException {
		String s = "6\nXXXT\n....\nOO..\n....\n\nXOXT\nXXOO\nOXOX\nXXOO\n\nXOX.\nOX..\n....\n....\n\nOOXX\nOXXX\nOX.T\nO..O\n\nXXXO\n..O.\n.O..\nT...\n\nOXXX\nXO..\n..O.\n...O";
		new CodeJam.Builder<TicTacToeTomekTestCase, TicTacToeTomekSolution>()
				.setTestCaseReader(new TicTacToeTomekTestCaseReader())
				.useStringInputSource(s).useSystemOutputDestination().build()
				.jam();
	}

	public void live() throws IOException {
		Preferences preferences = Preferences
				.userNodeForPackage(TicTacToeTomekTestCase.class);
		new CodeJam.Builder<TicTacToeTomekTestCase, TicTacToeTomekSolution>()
				.setTestCaseReader(new TicTacToeTomekTestCaseReader())
				.useSwingInputSource(preferences)
				.useSwingOutputDestination(preferences).build().jam();
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.example();
		// main.live();
	}

}
