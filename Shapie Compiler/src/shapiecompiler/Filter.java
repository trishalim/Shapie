package shapiecompiler;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class Filter extends FileFilter{

	@Override
	public boolean accept(File f) {
		 if (f.isDirectory()) {
		      return true;
		    } else {
		      String path = f.getAbsolutePath().toLowerCase();
		        String extension = ".txt";
		        if ((path.endsWith(extension) && (path.charAt(path.length() 
		                  - extension.length() - 1)) == '.')) {
		          return true;
		        }
		     }
		    
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

		
}
