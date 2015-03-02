package technology.tag.codejam.base;

import java.util.List;

public interface Contest<T extends TestCase<S>, S extends Solution> {

	public int getNumberOfTestCases();

	public List<T> getTestCases();

}
