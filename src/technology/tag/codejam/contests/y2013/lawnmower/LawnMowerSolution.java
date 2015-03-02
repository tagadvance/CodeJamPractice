package technology.tag.codejam.contests.y2013.lawnmower;

import technology.tag.codejam.base.AbstractSolution;

public class LawnMowerSolution extends AbstractSolution<Boolean> {

	public LawnMowerSolution(int testCaseNumber, Boolean isPossible) {
		super(testCaseNumber, isPossible);
	}

	@Override
	public String format(Boolean data) {
		return data ? "YES" : "NO";
	}

}