package technology.tag.codejam.base;

import java.io.IOException;
import java.io.InputStream;

public class SystemInputSource implements InputSource {

	public SystemInputSource() {

	}

	@Override
	public InputStream getInputStream() throws IOException {
		return System.in;
	}

}
