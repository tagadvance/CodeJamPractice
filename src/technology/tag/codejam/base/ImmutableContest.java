package technology.tag.codejam.base;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class ImmutableContest<T extends TestCase<S>, S extends Solution>
		implements Contest<T, S> {

	private final int numberOfTestCases;
	private final List<T> testCases;

	public ImmutableContest(int numberOfTestCases, List<T> testCases) {
		super();
		Preconditions.checkArgument(numberOfTestCases == testCases.size(),
				"incorrect number of test cases");
		this.numberOfTestCases = numberOfTestCases;
		this.testCases = ImmutableList.copyOf(testCases);
	}

	@Override
	public int getNumberOfTestCases() {
		return this.numberOfTestCases;
	}

	@Override
	public List<T> getTestCases() {
		return this.testCases;
	}

}
