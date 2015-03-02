package technology.tag.codejam.base;

import java.io.BufferedReader;
import java.io.IOException;

public interface TestCaseReader<T extends TestCase<S>, S extends Solution> {

	public abstract T readTestCase(int caseNumber, BufferedReader reader)
			throws IOException;

}
