package technology.tag.codejam.base;

import java.io.File;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OutputFileBrowser extends AbstractFileBrowser {

	private static final String DESCRIPTION = "output files";
	private static final String EXTENSION = "out";

	public OutputFileBrowser(Preferences preferences) {
		super(preferences);
	}

	@Override
	public File selectFile() {
		File initialDirectory = getInitialDirectory();
		JFileChooser chooser = new JFileChooser(initialDirectory);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileFilter filter = new FileNameExtensionFilter(DESCRIPTION, EXTENSION);
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int result = chooser.showSaveDialog(null);
		switch (result) {
		case JFileChooser.APPROVE_OPTION:
			File selectedFile = chooser.getSelectedFile();
			setInitialDirecory(selectedFile);
			return selectedFile;
		}
		return null;
	}

}