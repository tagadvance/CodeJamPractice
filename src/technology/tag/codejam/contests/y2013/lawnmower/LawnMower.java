package technology.tag.codejam.contests.y2013.lawnmower;

public class LawnMower {

	public LawnMower() {

	}

	public void mowRow(Lawn lawn, int row, int height) {
		for (int i = 0; i < lawn.getWidth(); i++) {
			mow(lawn, i, row, height);
		}
	}

	public void mowColumn(Lawn lawn, int column, int height) {
		for (int i = 0; i < lawn.getHeight(); i++) {
			mow(lawn, column, i, height);
		}
	}

	public void mow(Lawn lawn, int x, int y, int height) {
		int currentHeight = lawn.getHeight(x, y);
		if (height < currentHeight) {
			lawn.setHeight(x, y, height);
		}
	}

}