package technology.tag.codejam.contests.y2013.lawnmower;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import technology.tag.codejam.base.TestCaseReader;

public class LawnMowerTestCaseReader implements
		TestCaseReader<LawnMowerTestCase, LawnMowerSolution> {

	public LawnMowerTestCaseReader() {
		super();
	}
	
	@Override
	public LawnMowerTestCase readTestCase(int caseNumber, BufferedReader reader) throws IOException {
		String dimensions = reader.readLine();
		if (dimensions == null) {
			return null;
		}
		Dimension d = parseDimension(dimensions);
		Lawn lawn = new Lawn(d);
		for (int y = 0; y < d.height; y++) {
			String row = reader.readLine();
			String[] tokens = row.split(" ");
			for (int x = 0; x < tokens.length; x++) {
				int height = Integer.parseInt(tokens[x]);
				lawn.setHeight(x, y, height);
			}
		}
		return new LawnMowerTestCase(caseNumber, lawn);
	}

	private Dimension parseDimension(String input) {
		Pattern pattern = Pattern.compile("(\\d+)\\s(\\d+)");
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			int height = Integer.parseInt(matcher.group(1));
			int width = Integer.parseInt(matcher.group(2));
			return new Dimension(width, height);
		}
		throw new IllegalArgumentException("\"" + input + "\"");
	}

}