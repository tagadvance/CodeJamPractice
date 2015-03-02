package technology.tag.codejam.base;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.google.common.base.Preconditions;

public class StringInputSource implements InputSource {

	private final String s;

	public StringInputSource(String s) {
		super();
		this.s = Preconditions.checkNotNull(s, "s must not be null");
	}

	@Override
	public InputStream getInputStream() throws IOException {
		byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
		return new ByteArrayInputStream(bytes);
	}

}