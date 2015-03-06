package technology.tag.codejam.contests.practice.alwaysturnleft;

import static technology.tag.codejam.contests.practice.alwaysturnleft.MutableRoom.Opening.EAST;
import static technology.tag.codejam.contests.practice.alwaysturnleft.MutableRoom.Opening.NORTH;
import static technology.tag.codejam.contests.practice.alwaysturnleft.MutableRoom.Opening.SOUTH;
import static technology.tag.codejam.contests.practice.alwaysturnleft.MutableRoom.Opening.WEST;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import technology.tag.codejam.base.DataFormatter;
import technology.tag.codejam.contests.practice.alwaysturnleft.MutableRoom.Opening;

@RunWith(Parameterized.class)
public class RoomFormatterTest {

	@Parameters
	public static Iterable<Object[]> parameters() {
		return Arrays.asList(new Object[][] { { new Opening[] { NORTH }, "1" },
				{ new Opening[] { SOUTH }, "2" },
				{ new Opening[] { NORTH, SOUTH }, "3" },
				{ new Opening[] { WEST }, "4" },
				{ new Opening[] { NORTH, WEST }, "5" },
				{ new Opening[] { SOUTH, WEST }, "6" },
				{ new Opening[] { NORTH, SOUTH, WEST }, "7" },
				{ new Opening[] { EAST }, "8" },
				{ new Opening[] { NORTH, EAST }, "9" },
				{ new Opening[] { SOUTH, EAST }, "a" },
				{ new Opening[] { NORTH, SOUTH, EAST }, "b" },
				{ new Opening[] { WEST, EAST }, "c" },
				{ new Opening[] { NORTH, WEST, EAST }, "d" },
				{ new Opening[] { SOUTH, WEST, EAST }, "e" },
				{ new Opening[] { NORTH, SOUTH, WEST, EAST }, "f" }, });
	}

	private Opening[] openings;
	private String expectedOutput;

	public RoomFormatterTest(Opening[] openings, String expectedOutput) {
		super();
		this.openings = openings;
		this.expectedOutput = expectedOutput;
	}

	@Test
	public void testFormat() {
		DataFormatter<Room> formatter = new RoomFormatter();
		Point point = new ImmutablePoint();
		Room room = new MutableRoom(point, openings); // FIXME: replace with mock
		String output = formatter.format(room);
		Assert.assertEquals(expectedOutput, output);
	}

}