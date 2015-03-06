package technology.tag.codejam.contests.practice.alwaysturnleft;

import com.google.common.base.MoreObjects;

public class ImmutablePoint implements Point {

	private final int x, y;

	public ImmutablePoint() {
		this(0, 0);
	}

	public ImmutablePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(ImmutablePoint.class).add("x", x)
				.add("y", y).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImmutablePoint other = (ImmutablePoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}