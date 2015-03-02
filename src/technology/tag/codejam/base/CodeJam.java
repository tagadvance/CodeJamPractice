package technology.tag.codejam.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.prefs.Preferences;

import com.google.common.base.Preconditions;

public class CodeJam<T extends TestCase<S>, S extends Solution> {

	private final DefaultContestReader<T, S> contestReader;
	private final InputSource inputSource;
	private final OutputDestination destination;
	private final ExecutorService service;

	private CodeJam(Builder<T, S> builder) {
		this.contestReader = new DefaultContestReader<>(builder.testCaseReader);
		this.inputSource = builder.inputSource;
		this.destination = builder.destination;
		this.service = builder.service;
	}

	public DefaultContestReader<T, S> getContestReader() {
		return contestReader;
	}

	public InputSource getInputSource() {
		return inputSource;
	}

	public OutputDestination getDestination() {
		return destination;
	}

	public ExecutorService getService() {
		return service;
	}

	public void jam() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputSource.getInputStream()));
				PrintStream out = new PrintStream(destination.getOutputStream())) {
			Contest<T, S> contest = contestReader.readContest(reader);
			ContestSolver solver;
			if (this.service == null) {
				solver = new DefaultContestSolver();
			} else {
				solver = new ParallelContestSolver(this.service);
			}
			List<S> solutions = solver.solve(contest);
			DefaultContestWriter<S> writer = new DefaultContestWriter<>();
			writer.write(solutions, out);
		}
	}

	public static class Builder<T extends TestCase<S>, S extends Solution> {

		private TestCaseReader<T, S> testCaseReader;
		private InputSource inputSource;
		private OutputDestination destination;

		private ExecutorService service;

		public Builder() {

		}

		public Builder<T, S> setTestCaseReader(
				TestCaseReader<T, S> testCaseReader) {
			this.testCaseReader = Preconditions.checkNotNull(testCaseReader,
					"testCaseReader must not be null");
			return this;
		}

		public Builder<T, S> useStringInputSource(String s) {
			return this.useInputSource(new StringInputSource(s));
		}

		public Builder<T, S> useSystemInputSource() {
			return this.useInputSource(new DefaultInputSource(System.in));
		}

		public Builder<T, S> useFileBrowserInputSource() {
			Preferences preferences = Preferences
					.userNodeForPackage(CodeJam.class);
			return useFileBrowserInputSource(preferences);
		}

		public Builder<T, S> useFileBrowserInputSource(Preferences preferences) {
			return this.useInputSource(new FileBrowserInputSource(
					new InputFileBrowser(preferences)));
		}

		public Builder<T, S> useInputSource(InputSource inputSource) {
			this.inputSource = Preconditions.checkNotNull(inputSource,
					"inputSource must not be null");
			return this;
		}

		public Builder<T, S> useSystemOutputDestination() {
			return this.useOutputDestination(new DefaultOutputDestination(System.out));
		}

		public Builder<T, S> useFileBrowserOutputDestination() {
			Preferences preferences = Preferences
					.userNodeForPackage(CodeJam.class);
			return useFileBrowserOutputDestination(preferences);
		}

		public Builder<T, S> useFileBrowserOutputDestination(Preferences preferences) {
			return this.useOutputDestination(new FileBrowserOutputDestination(
					new OutputFileBrowser(preferences)));
		}

		public Builder<T, S> useOutputDestination(OutputDestination destination) {
			this.destination = Preconditions.checkNotNull(destination,
					"destination must not be null");
			return this;
		}

		public Builder<T, S> useExecutorService(ExecutorService service) {
			this.service = service;
			return this;
		}

		public CodeJam<T, S> build() {
			return new CodeJam<T, S>(this);
		}

	}

}