package technology.tag.codejam.base;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class DefaultContestWriter<S extends Solution> implements
		ContestWriter<S> {

	public DefaultContestWriter() {

	}

	@Override
	public void write(List<S> solutions, PrintStream out) throws IOException {
		for (S solution : solutions) {
			out.println(solution.getOutput());
		}
	}

}