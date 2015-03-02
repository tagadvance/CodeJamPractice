package technology.tag.codejam.contests.y2013.lawnmower;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import technology.tag.codejam.base.AbstractTestCase;

import com.google.common.base.Throwables;

public class LawnMowerTestCase extends AbstractTestCase<LawnMowerSolution> {

	private final Lawn targetLawn;

	public LawnMowerTestCase(int caseNumber, Lawn lawn) {
		super(caseNumber);
		this.targetLawn = lawn;
	}

	@Override
	public LawnMowerSolution solve() {
		final LawnMower mower = new LawnMower();
		Lawn lawn = new Lawn(targetLawn);
		lawn.reset();

		List<Lawn.Point> targetPoints = targetLawn.getPoints();
		Collections.sort(targetPoints);
		Collections.reverse(targetPoints);

		for (Lawn.Point targetPoint : targetPoints) {
			int targetHeight = targetPoint.getHeight();

			try {
				// if target row contains no points higher than targetHeight
				// then mow it
				boolean isSafeToMow = true;
				for (Lawn.Point rowPoint : targetLawn.rows.get(targetPoint.y)) {
					if (rowPoint.getHeight() > targetHeight) {
						isSafeToMow = false;
						break;
					}
				}
				if (isSafeToMow) {
					mower.mowRow(lawn, targetPoint.y, targetHeight);
				}
			} catch (ExecutionException e) {
				Throwables.propagate(e);
			}
			try {
				// if target column contains no points higher than targetHeight
				// then mow it
				boolean isSafeToMow = true;
				for (Lawn.Point rowPoint : targetLawn.columns
						.get(targetPoint.x)) {
					if (rowPoint.getHeight() > targetHeight) {
						isSafeToMow = false;
						break;
					}
				}
				if (isSafeToMow) {
					mower.mowColumn(lawn, targetPoint.x, targetHeight);
				}
			} catch (ExecutionException e) {
				Throwables.propagate(e);
			}
		}
		return new LawnMowerSolution(getCaseNumber(), targetLawn.equals(lawn));
	}

}