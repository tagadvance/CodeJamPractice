package technology.tag.codejam.contests.practice.alwaysturnleft;

import org.junit.Assert;
import org.junit.Test;

public class PathTest {

	@Test(expected = NullPointerException.class)
	public void testConstructorThrowsNullPointerException() {
		new Path(null);
	}

	@Test
	public void testIterator() {
		String p = "WRWWLWWLWWLWLWRRWRWWWRWWRWLW";
		Path path = new Path(p);
		int i = 0;
		for (char c : path) {
			Assert.assertEquals(p.charAt(i++), c);
		}
	}

}