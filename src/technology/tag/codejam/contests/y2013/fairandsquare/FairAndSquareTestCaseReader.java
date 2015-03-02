package technology.tag.codejam.contests.y2013.fairandsquare;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import technology.tag.codejam.base.TestCaseReader;

public class FairAndSquareTestCaseReader implements
		TestCaseReader<FairAndSquareTestCase, FairAndSquareSolution> {

	public FairAndSquareTestCaseReader() {
	}

	@Override
	public FairAndSquareTestCase readTestCase(int caseNumber,
			BufferedReader reader) throws IOException {
		String input = reader.readLine();
		if (input == null) {
			return null;
		}
		MinMax minMax = parseAB(input);
		return new FairAndSquareTestCase(caseNumber, minMax.min, minMax.max,
				new FastPalindrome());
	}

	private MinMax parseAB(String input) {
		Pattern pattern = Pattern.compile("(\\d+)\\s(\\d+)");
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			long a = Long.parseLong(matcher.group(1));
			long b = Long.parseLong(matcher.group(2));
			return new MinMax(a, b);
		}
		throw new IllegalArgumentException("\"" + input + "\"");
	}

}