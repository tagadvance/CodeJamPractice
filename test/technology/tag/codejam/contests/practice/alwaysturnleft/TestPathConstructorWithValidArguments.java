package technology.tag.codejam.contests.practice.alwaysturnleft;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPathConstructorWithValidArguments {

	@Parameters
	public static Iterable<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{ "WRWWLWWLWWLWLWRRWRWWWRWWRWLW" },
				{ "WWRRWLWLWWLWWLWWRWWRWWLW" }, { "WW" }, });
	}

	private String path;

	public TestPathConstructorWithValidArguments(String path) {
		this.path = path;
	}

	@Test
	public void testConstructorAcceptsValidArgument() {
		new Path(this.path);
	}

	public void testGetPathIsNotNull() {
		Path path = new Path(this.path);
		assertEquals(this.path, path.getPath());
	}

}
