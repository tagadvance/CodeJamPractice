package technology.tag.codejam.contests.y2013.fairandsquare;

import technology.tag.codejam.base.AbstractTestCase;

import com.google.common.base.Preconditions;

public class FairAndSquareTestCase extends AbstractTestCase<FairAndSquareSolution> {

	private final Palindrome palindrome;
	private final long a, b;

	public FairAndSquareTestCase(int id, long a, long b, Palindrome palindrome) {
		super(id);
		this.a = a;
		this.b = b;
		this.palindrome = Preconditions.checkNotNull(palindrome);
	}

	@Override
	public FairAndSquareSolution solve() {
		int count = 0;
		for (long i = a; i <= b; i++) {
			if (isFairAndSquare(i)) {
				count++;
			}
		}
		return new FairAndSquareSolution(getCaseNumber(), count);
	}

	public boolean isFairAndSquare(long i) {
		if (palindrome.isPalindrome(i)) {
			double squareRoot = Math.sqrt(i);
			if (isInt(squareRoot)) {
				long root = (long) squareRoot;
				return palindrome.isPalindrome(root);
			}
		}
		return false;
	}

	public static boolean isInt(double d) {
		return (d % 1) == 0;
	}

}
