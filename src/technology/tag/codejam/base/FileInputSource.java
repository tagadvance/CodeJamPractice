package technology.tag.codejam.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.base.Preconditions;

public class FileInputSource implements InputSource {

	private final File file;

	public FileInputSource(File file) throws FileNotFoundException {
		this.file = Preconditions.checkNotNull(file, "file must not be null");
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(file);
	}

}