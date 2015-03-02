package technology.tag.codejam.base;

import java.io.IOException;
import java.io.InputStream;

public interface InputSource {

	public InputStream getInputStream() throws IOException;

}