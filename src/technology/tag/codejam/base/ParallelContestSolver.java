package technology.tag.codejam.base;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class ParallelContestSolver implements ContestSolver {

	private ExecutorService service;

	public ParallelContestSolver(ExecutorService service) {
		this.service = Preconditions.checkNotNull(service,
				"service must not be null");
	}

	@Override
	public <T extends TestCase<S>, S extends Solution> List<S> solve(
			Contest<T, S> contest) {
		final Map<T, S> solutions = Collections.synchronizedMap(new TreeMap<>(
				new Comparator<T>() {
					@Override
					public int compare(T o1, T o2) {
						return o1.getCaseNumber() - o2.getCaseNumber();
					}
				}));
		for (final T testCase : contest.getTestCases()) {
			service.submit(new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					S solution = testCase.solve();
					solutions.put(testCase, solution);
					return null;
				}

			});
		}
		return Lists.newArrayList(solutions.values());
	}

}