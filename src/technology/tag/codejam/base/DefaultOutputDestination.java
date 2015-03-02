package technology.tag.codejam.base;

import java.io.IOException;
import java.io.OutputStream;

import com.google.common.base.Preconditions;

public class DefaultOutputDestination implements OutputDestination {

	private final OutputStream outputStream;

	public DefaultOutputDestination(OutputStream outputStream) {
		super();
		this.outputStream = Preconditions.checkNotNull(outputStream,
				"outputStream must not be null");
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return this.outputStream;
	}

}