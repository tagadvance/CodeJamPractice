package technology.tag.codejam.contests.y2013.lawnmower;

import java.io.IOException;
import java.util.prefs.Preferences;

import technology.tag.codejam.base.CodeJam;

public class Main {

	private Main() {

	}

	private void example() throws IOException {
		String s = "3\n3 3\n2 1 2\n1 1 1\n2 1 2\n5 5\n2 2 2 2 2\n2 1 1 1 2\n2 1 2 1 2\n2 1 1 1 2\n2 2 2 2 2\n1 3\n1 2 1";
		new CodeJam.Builder<LawnMowerTestCase, LawnMowerSolution>()
				.setTestCaseReader(new LawnMowerTestCaseReader())
				.useStringInputSource(s).useSystemOutputDestination().build()
				.jam();
	}

	public void live() throws IOException {
		Preferences preferences = Preferences
				.userNodeForPackage(LawnMowerTestCase.class);
		new CodeJam.Builder<LawnMowerTestCase, LawnMowerSolution>()
				.setTestCaseReader(new LawnMowerTestCaseReader())
				.useFileBrowserInputSource(preferences)
				.useFileBrowserOutputDestination(preferences).build().jam();
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.example();
		// main.live();
	}

}
