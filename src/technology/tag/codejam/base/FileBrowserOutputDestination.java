package technology.tag.codejam.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.google.common.base.Preconditions;

public class FileBrowserOutputDestination implements OutputDestination {

	private final FileBrowser browser;

	public FileBrowserOutputDestination(FileBrowser browser) {
		this.browser = Preconditions.checkNotNull(browser,
				"browser must not be null");
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		File file = browser.browse();
		return new FileOutputStream(file);
	}

}