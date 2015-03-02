package technology.tag.codejam.contests.y2013.fairandsquare;

import java.io.IOException;
import java.util.prefs.Preferences;

import technology.tag.codejam.base.CodeJam;

public class Main {

	private Main() {

	}

	private void example() throws IOException {
		String s = "3\n1 4\n10 120\n100 1000";
		new CodeJam.Builder<FairAndSquareTestCase, FairAndSquareSolution>()
				.setTestCaseReader(new FairAndSquareTestCaseReader())
				.useStringInputSource(s).useSystemOutputDestination().build()
				.jam();
	}

	public void live() throws IOException {
		Preferences preferences = Preferences
				.userNodeForPackage(FairAndSquareTestCase.class);
		new CodeJam.Builder<FairAndSquareTestCase, FairAndSquareSolution>()
				.setTestCaseReader(new FairAndSquareTestCaseReader())
				.useFileBrowserInputSource(preferences)
				.useFileBrowserOutputDestination(preferences).build().jam();
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.example();
		// main.live();
	}

}
