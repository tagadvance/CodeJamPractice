package technology.tag.codejam.contests.practice.alwaysturnleft;

import technology.tag.codejam.base.AbstractSolution;

public class AlwaysTurnLeftSolution extends AbstractSolution<CharSequence[]> {

	public static final String NEWLINE = System.getProperty("line.separator");

	public AlwaysTurnLeftSolution(int caseNumber, CharSequence[] data) {
		super(caseNumber, data);
	}

	@Override
	public String format(CharSequence[] data) {
		StringBuilder sb = new StringBuilder();
		for (CharSequence sequence : data) {
			if (sb.length() > 0) {
				sb.append(NEWLINE);
			}
			sb.append(sequence);
		}
		return sb.toString();
	}

	public String toString() {
		return String.format("Case #%d:%n%s", getCaseNumber(),
				format(getData()));
	}

}
