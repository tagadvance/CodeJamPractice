package technology.tag.codejam.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.common.base.Preconditions;

public class FileBrowserInputSource implements InputSource {

	private final FileBrowser browser;
	private File file;

	public FileBrowserInputSource(FileBrowser browser) {
		this.browser = Preconditions.checkNotNull(browser,
				"browser must not be null");
	}

	/**
	 * 
	 * @return
	 */
	public File getRecentFile() {
		return file;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		File file = this.file = browser.browse();
		return new FileInputStream(file);
	}

	public OutputDestination createMagicOutputDestination() {
		return new MagicFileOutputDestination();
	}

	public class MagicFileOutputDestination implements OutputDestination {

		@Override
		public OutputStream getOutputStream() throws IOException {
			File inputFile = getRecentFile();
			File outputFile = createOutputFileInSameDirectoryAs(inputFile);
			return new FileOutputStream(outputFile);
		}

		public File createOutputFileInSameDirectoryAs(File inputFile) {
			File parent = inputFile.getParentFile();

			String name = inputFile.getName();
			String extension = ".in";
			String baseName;
			if (name.endsWith(extension)) {
				int beginIndex = 0, endIndex = name.length()
						- extension.length();
				baseName = name.substring(beginIndex, endIndex);
			} else {
				// http://stackoverflow.com/a/4546093/625688
				String expression = "\\.(?=[^\\.]+$)";
				String[] tokens = name.split(expression);
				baseName = tokens[0];
			}

			String outName = baseName.concat(".out");
			return new File(parent, outName);
		}

	}

}