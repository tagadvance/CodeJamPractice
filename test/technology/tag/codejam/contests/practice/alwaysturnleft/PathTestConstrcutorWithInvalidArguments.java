package technology.tag.codejam.contests.practice.alwaysturnleft;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PathTestConstrcutorWithInvalidArguments {

	@Parameters
	public static Iterable<Object[]> parameters() {
		return Arrays.asList(new Object[][] { { "" }, { " " }, { "W W" } });
	}

	private String path;

	public PathTestConstrcutorWithInvalidArguments(String path) {
		this.path = path;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPathConstrcutorWithInvalidArgumentsThrowsIllegalArgumentException() {
		new Path(this.path);
	}

}
