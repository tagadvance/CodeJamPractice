package technology.tag.codejam.base;

import java.util.List;

public interface ContestSolver {

	public <T extends TestCase<S>, S extends Solution> List<S> solve(
			Contest<T, S> contest);

}