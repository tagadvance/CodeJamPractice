package technology.tag.codejam.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.google.common.base.Preconditions;

public class FileOutputDestination implements OutputDestination {

	private final File file;

	public FileOutputDestination(File file) {
		this.file = Preconditions.checkNotNull(file, "file must not be null");
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return new FileOutputStream(file);
	}

}