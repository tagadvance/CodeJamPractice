package technology.tag.codejam.contests.practice.alwaysturnleft;

import java.util.Iterator;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Chars;

public class Path implements Iterable<Character> {

	private final String path;

	public Path(String path) {
		super();
		Preconditions.checkNotNull(path, "path must not be null");
		Preconditions.checkArgument(path.matches("[WLR]{2,}"), "invalid path");
		this.path = path;
	}

	@Override
	public Iterator<Character> iterator() {
		return Chars.asList(path.toCharArray()).iterator();
	}

	public String getPath() {
		return this.path;
	}

}
