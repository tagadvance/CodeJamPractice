package technology.tag.codejam.base;

import java.io.IOException;
import java.io.OutputStream;

public interface OutputDestination {
	
	public OutputStream getOutputStream() throws IOException;
	
}
