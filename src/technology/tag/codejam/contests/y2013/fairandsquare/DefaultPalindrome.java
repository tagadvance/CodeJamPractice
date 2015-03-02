package technology.tag.codejam.contests.y2013.fairandsquare;

public class DefaultPalindrome implements Palindrome {

	@Override
	public boolean isPalindrome(Object o) {
		String forward = o.toString();
		String reverse = new StringBuilder(forward).reverse().toString();
		return forward.equals(reverse);
	}

}