package technology.tag.codejam.base;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.common.base.Preconditions;

public abstract class AbstractFileChooserFactory implements FileBrowser {

	private static final String DEFAULT_DIRECTORY = ".";
	private static final String INITIAL_DIRECTORY_KEY = "initial_directory";

	private final Preferences preferences;

	public AbstractFileChooserFactory(Preferences preferences) {
		super();
		this.preferences = Preconditions.checkNotNull(preferences,
				"preferences must not be null");
	}

	@Override
	public File browse() {
		FutureTask<File> task = new FutureTask<>(new Callable<File>() {
			@Override
			public File call() throws Exception {
				JFileChooser chooser = createtFileChooser();
				int result = chooser.showOpenDialog(null);
				switch (result) {
				case JFileChooser.APPROVE_OPTION:
					File selectedFile = chooser.getSelectedFile();
					setInitialDirecory(selectedFile);
					return selectedFile;
				}
				return null;
			}
		});
		try {
			SwingUtilities.invokeAndWait(task);
			return task.get();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public abstract JFileChooser createtFileChooser();

	public File getInitialDirectory() {
		String path = preferences.get(INITIAL_DIRECTORY_KEY, DEFAULT_DIRECTORY);
		return new File(path);
	}

	public void setInitialDirecory(File file) {
		String path = file.getAbsolutePath();
		preferences.put(INITIAL_DIRECTORY_KEY, path);
	}

	public static class InputFileChooserFactory extends AbstractFileChooserFactory {

		private static final String DESCRIPTION = "input files";
		private static final String EXTENSION = "in";

		public InputFileChooserFactory(Preferences preferences) {
			super(preferences);
		}

		@Override
		public JFileChooser createtFileChooser() {
			File initialDirectory = getInitialDirectory();
			JFileChooser chooser = new JFileChooser(initialDirectory);
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.addChoosableFileFilter(new FileNameExtensionFilter(
					DESCRIPTION, EXTENSION));
			return chooser;
		}

	}

	public static class OutputFileChooserFactory extends AbstractFileChooserFactory {

		private static final String DESCRIPTION = "output files";
		private static final String EXTENSION = "out";

		public OutputFileChooserFactory(Preferences preferences) {
			super(preferences);
		}

		@Override
		public JFileChooser createtFileChooser() {
			File initialDirectory = getInitialDirectory();
			JFileChooser chooser = new JFileChooser(initialDirectory);
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.addChoosableFileFilter(new FileNameExtensionFilter(
					DESCRIPTION, EXTENSION));
			return chooser;
		}

	}

}
