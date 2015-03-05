package technology.tag.codejam.contests.practice.alwaysturnleft;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import technology.tag.codejam.base.Solution;

public class AlwaysTurnLeftSolutionTest {
	
	@Test
	public void testCase1Solution() {
		String expected = "Case #1:\nac5\n386\n9c7\ne43\n9c5";
		
		int caseNumber = 1;
		CharSequence[] data = {"ac5", "386", "9c7", "e43", "9c5"};
		Solution solution = new AlwaysTurnLeftSolution(caseNumber, data);
		String output = solution.toString();
		
		assertEquals(expected, output);
	}
	
	@Test
	public void testCase2Solution() {
		String expected = "Case #2:\n3";
		
		int caseNumber = 2;
		CharSequence[] data = {"3"};
		Solution solution = new AlwaysTurnLeftSolution(caseNumber, data);
		String output = solution.toString();
		
		assertEquals(expected, output);
	}

}
