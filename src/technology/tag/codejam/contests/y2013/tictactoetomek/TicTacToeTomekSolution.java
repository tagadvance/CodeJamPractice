package technology.tag.codejam.contests.y2013.tictactoetomek;

import technology.tag.codejam.base.AbstractSolution;
import technology.tag.codejam.contests.y2013.tictactoetomek.TicTacToeTomekTestCase.Status;

public class TicTacToeTomekSolution extends AbstractSolution<Status> {

	public TicTacToeTomekSolution(int caseNumber, Status data) {
		super(caseNumber, data);
	}

	@Override
	public String format(Status data) {
		switch (data) {
		case X_WON:
			return "X won";
		case O_WON:
			return "O won";
		case DRAW:
			return "Draw";
		case NOT_COMPLETED:
			return "Game has not completed";
		}
		throw new IllegalArgumentException();
	}

}
