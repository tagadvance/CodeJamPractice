package technology.tag.codejam.base;

import java.io.IOException;
import java.io.OutputStream;

public class SystemOutputDestination implements OutputDestination {

	public SystemOutputDestination() {

	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return System.out;
	}

}
