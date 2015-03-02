package technology.tag.codejam.base;

import java.util.ArrayList;
import java.util.List;

public class DefaultContestSolver implements ContestSolver {

	public DefaultContestSolver() {

	}

	@Override
	public <T extends TestCase<S>, S extends Solution> List<S> solve(
			Contest<T, S> contest) {
		List<S> solutions = new ArrayList<>();
		for (T testCase : contest.getTestCases()) {
			S solution = testCase.solve();
			solutions.add(solution);
		}
		return solutions;
	}

}