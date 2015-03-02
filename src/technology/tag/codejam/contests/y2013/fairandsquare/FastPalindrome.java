package technology.tag.codejam.contests.y2013.fairandsquare;

public class FastPalindrome implements Palindrome {

	@Override
	public boolean isPalindrome(Object o) {
		String s = o.toString();
		char[] ch = s.toCharArray();
		for (int i = 0, j = ch.length - 1; i < j && i != j; i++, j--) {
			if (ch[i] != ch[j])
				return false;
		}
		return true;
	}

}