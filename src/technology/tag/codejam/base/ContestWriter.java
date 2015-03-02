package technology.tag.codejam.base;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public interface ContestWriter<S extends Solution> {

	public void write(List<S> solutions, PrintStream out) throws IOException;

}
