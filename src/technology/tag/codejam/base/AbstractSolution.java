package technology.tag.codejam.base;

import com.google.common.base.Preconditions;

public abstract class AbstractSolution<D> implements DataFormatter<D>, Solution {

	private final int caseNumber;
	private final D data;

	public AbstractSolution(int caseNumber, D data) {
		super();
		Preconditions.checkArgument(caseNumber >= 1);
		this.caseNumber = caseNumber;
		this.data = data;
	}

	public int getCaseNumber() {
		return caseNumber;
	}

	public D getData() {
		return this.data;
	}

	public String toString() {
		return String.format("Case #%d: %s", caseNumber, format(this.data));
	}

}
