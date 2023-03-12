// package add package name if any;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.fxml.FXMLLoader;


/**
 * Provide a FXMLLoader for FXML files that exists in the same directory as this class (not in a subdirectory) independent
 * of the environment (running from class files, from jar files or from an customized JRE, being modular or not).<br>
 * If there is more than one directory with FXML files, copy this file with different names (e.g. FXMLLocator02.java)
 * into each other directory and make the necessary changes, see {@link #getFXMLLoader(String)}.
 *
 * @author Riebelsteiner
 * @version 1.0
 * @since   2023-03-12
 */
public class FXMLLocator {
	/** can be deleted if hard-coded version is used */
	static Class<?> myClass = null;	
	/** can be deleted if hard-coded version is used */
	static String myName;
	/** 
	 * An explicit standard constructor suppresses Javadoc warnings.
	 */
	public FXMLLocator() {
	} // end of public FXMLLocator() {

	/**
	 * Provide a FXMLLoader.<br>
	 * The caller's class needs
	 * 		<pre>Import &lt;package name&gt;.FXMLLocator;</pre>e.g.
	 * 		<pre>Import myMainPackage.resources.fxml.FXMLLocator;</pre><br>
	 
	 * If you need a copy of this class (e.g. FXMLLocator02) in another directory with FXML files do not forget to
	 * <ol>
	 * <li>rename the copied file,</li>
	 * <li>adjust the package name in the copied file if necessary,</li>
	 * <li>replace all occurrences of FXMLLocator by the new class name (file name) in the copied file,</li>
	 * <li>add the the appropriate Import in the caller's class.</li>
	 * </ol>
	 * If the compile step is ok, the only pitfall at run time can be  an incorrect change from 
	 * <pre>String theLocation = FXMLLocator.class.getResource("FXMLLocator.class").toString().replace(..);</pre> to e.g.
	 * <pre>String theLocation = FXMLLocator02.class.getResource("FXMLLocator02.class").toString().replace(..);;</pre>
	 * 
	 * For a FXML file e.g. named myAppl.fxml the call is simply 
	 * <pre>FXMLLoader fxmlLoader = FXMLLocator.getFXMLLoader("myAppl.fxml");</pre>
	 * 
	 * @param fxmlFileAsString the file name of the FXML file (e.g. "myAppl.fxml") that needs a FMXLLoader
	 * @return the FXMLLoader for the FXML file named <code>fxmlFileAsString</code> with <code>setLocation()</code> done
	 * or <code>null</code> if a <code>MalformedURLException</code> occurs (what should never happen).
	 * <br>If the <code>fxmlFileAsString</code> is wrong, a java.io.FileNotFoundException will occur in the caller's class.

	 */
	 public static FXMLLoader getFXMLLoader(String fxmlFileAsString)  {
		
		 URL fxmlFileURL = null;
		 // delete the next four lines if you like the hard-coded version
		 if (myClass == null) {
			 myClass = new FXMLLocator().getClass();	
			 myName = myClass.getSimpleName() + ".class";
		 }

		 // hard-coded version:
		 // String theLocation = FXMLLocator.class.getResource("FXMLLocator.class").toString();
		 String theLocation = myClass.getResource(myName).toString().replace(myName, fxmlFileAsString);
		 try {
			 fxmlFileURL = new URL(theLocation);
		 } catch (MalformedURLException e) {
			 System.out.println("Failed to find \""+ fxmlFileAsString + "\" within  \""+ theLocation + "\".\n" + 
				 e.getMessage());
			 return null;
		 }

		 FXMLLoader fxmlLoader = new FXMLLoader();
		 fxmlLoader.setLocation(fxmlFileURL);

		 return fxmlLoader;
	} // end of  public static FXMLLoader getFXMLLoader(String fxmlFileAsString)
} // end of public class FXMLLocator 
