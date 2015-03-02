package technology.tag.codejam.base;

import java.io.IOException;
import java.io.InputStream;

import com.google.common.base.Preconditions;

public class DefaultInputSource implements InputSource {
	
	private final InputStream inputStream;

	public DefaultInputSource(InputStream inputStream) {
		super();
		this.inputStream = Preconditions.checkNotNull(inputStream, "inputStream must not be null");
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return this.inputStream;
	}
	
}