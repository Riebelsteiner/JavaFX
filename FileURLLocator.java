// package add package name if any;

import java.net.URL;

/**
 * Returns an URL as String of a File to the caller. That implies that this class is
 * accessible from the caller and that results in providing the URL String even 
 * if the File is stored in another module.<br>
 * The caller's class needs
 * 		<pre>Import &lt;package name&gt;.FileURLLocator;</pre>e.g.
 * 		<pre>Import myMainPackage.resources.text.FileURLLocator;</pre><br>
 * If you need a copy of this class (e.g. FileURLLocator02) in another directory with files do not forget to
 * <ol>
 * <li>rename the copied file,</li>
 * <li>adjust the package name in the copied file if necessary,</li>
 * <li>replace all occurrences of FileURLLocator by the new class name (file name) in the copied file,</li>
 * <li>add the the appropriate Import in the caller's class.</li>
 * </ol>
 * 
 * An example code snippet:
 * <pre>
 * 		URL aURL = FileURLLocator.getFileURL("sample.txt");
 * 
 * 		BufferedReader buffReader = new BufferedReader(new InputStreamReader(aURL.openStream()));
 * 		String lineText;
 * 		while ((lineText = buffReader.readLine()) != null)
 * 			System.out.println(lineText);
 * 		buffReader.close();</pre>
 * 
 * @author 	Riebelsteiner
 * @version 1.0
 * @since   2023-03-12
 * 
 */
public class FileURLLocator {
	/** 
	 * An explicit standard constructor suppresses Javadoc warnings.
	 */
	public FileURLLocator() {
	} // end of public FileURLLocator() {

	/**
	 * Returns an URL for the File with the name <code>fileName</code>
	 * that is stored in the same directory (not subdirectory) as this class.
	 * 
	 * @param fileName the name of the file
	 * @return the URL for the File named fileName
	 */
	public static URL getFileURL(String fileName) {
		return FileURLLocator.class.getResource(fileName);
	} // end of public static URL getFileURL(String fileName)

} // end of public class FileURLLocator 
