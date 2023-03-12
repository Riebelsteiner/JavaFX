// package add package name if any;

/**
 * Returns an URL as String of a StyleSheet to the caller. That implies that this class is
 * accessible from the caller and that results in providing the URL String even 
 * if the StyleSheet is stored in another module.<br>
 * The caller's class needs
 * 		<pre>Import &lt;package name&gt;.StyleLocator;</pre>e.g.
 * 		<pre>Import myMainPackage.resources.styles.StyleLocator;</pre><br>
 * If you need a copy of this class (e.g. FileURLLocator) in another directory with style files do not forget to
 * <ol>
 * <li>rename the copied file,</li>
 * <li>adjust the package name in the copied file if necessary,</li>
 * <li>replace all occurrences of StyleLocator by the new class name (file name) in the copied file,</li>
 * <li>add the the appropriate Import in the caller's class.</li>
 * </ol>
 * 
 * For a StyleSheet e.g. named myMainStyle.css the call is simply 
 * <pre>myNode.getStylesheets().add(StyleLocator.getStyleSheetURLAsString("myMainStyle.css"));</pre>
 * 
 * @author Riebelsteiner
 * @version 1.0
 * @since   2023-03-12
 */ 
public class StyleLocator {
	/** 
	 * An explicit standard constructor suppresses Javadoc warnings.
	 */
	public StyleLocator() {
	} // end of public StyleLocator() {
	
	/**
	 * Returns a String with the URL of the StyleSheet with the name <code>styleSheetName</code> that is stored
	 * in the same directory (not subdirectory) as this class.
	 * @param styleSheetName the name of the StyleSheet
	 * @return a String the represents an URL for the accessing the StyleSheet
	 */
	public static String getStyleSheetURLAsString(String styleSheetName)  {
		return StyleLocator.class.getResource(styleSheetName).toExternalForm();
	} // end of public static String getStyleSheetURLAsString(String styleSheetName)

} // end of public class StyleLocator