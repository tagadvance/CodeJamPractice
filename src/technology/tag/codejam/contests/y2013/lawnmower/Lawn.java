package technology.tag.codejam.contests.y2013.lawnmower;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class Lawn {

	public static final int INITIAL_HEIGHT = 100;

	private final int width, height;
	private int[][] lawn;

	LoadingCache<Integer, List<Point>> rows = CacheBuilder.newBuilder().build(
			new CacheLoader<Integer, List<Point>>() {

				@Override
				public List<Point> load(Integer row) throws Exception {
					List<Point> points = new ArrayList<>();
					for (int column = 0; column < Lawn.this.width; column++) {
						points.add(new Point(Lawn.this, column, row));
					}
					return points;
				}

			});
	LoadingCache<Integer, List<Point>> columns = CacheBuilder.newBuilder()
			.build(new CacheLoader<Integer, List<Point>>() {

				@Override
				public List<Point> load(Integer column) throws Exception {
					List<Point> points = new ArrayList<>();
					for (int row = 0; row < Lawn.this.height; row++) {
						points.add(new Point(Lawn.this, column, row));
					}
					return points;
				}

			});

	public Lawn(int width, int height) {
		this.width = width;
		this.height = height;
		this.lawn = new int[height][width];
		reset();
	}

	public Lawn(Dimension d) {
		this(d.width, d.height);
	}

	/**
	 * Copy constructor.
	 * 
	 * @param lawn
	 */
	public Lawn(Lawn lawn) {
		this(lawn.width, lawn.height);
		final int position = 0;
		for (int i = 0; i < lawn.lawn.length; i++) {
			System.arraycopy(lawn.lawn[i], position, this.lawn[i], position,
					lawn.lawn[i].length);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Cache<Integer, List<Point>> getRows() {
		return rows;
	}

	public Cache<Integer, List<Point>> getColumns() {
		return columns;
	}

	public void reset() {
		for (int[] row : lawn) {
			for (int i = 0; i < row.length; i++) {
				row[i] = INITIAL_HEIGHT;
			}
		}
	}

	public int getHeight(int x, int y) {
		return lawn[y][x];
	}

	public void setHeight(int x, int y, int height) {
		lawn[y][x] = height;
	}

	public List<Point> getPoints() {
		List<Point> points = new ArrayList<>();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				points.add(new Point(this, x, y));
			}
		}
		return points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(lawn);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Lawn))
			return false;
		Lawn other = (Lawn) obj;
		if (!Arrays.deepEquals(lawn, other.lawn))
			return false;
		return true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int[] row : lawn) {
			for (int col : row) {
				sb.append(col + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public class Point implements Comparable<Point> {

		private final Lawn lawn;
		public final int x, y;

		public Point(Lawn lawn, int x, int y) {
			super();
			this.lawn = Preconditions.checkNotNull(lawn);
			this.x = x;
			this.y = y;
		}

		public int getHeight() {
			return lawn.getHeight(x, y);
		}

		@Override
		public int compareTo(Point o) {
			Integer height = getHeight();
			Integer otherheight = o.getHeight();
			return height.compareTo(otherheight);
		}

	}

}