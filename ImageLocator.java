// package add package name if any;

import javafx.scene.image.Image;

/**
 * Provides an Image to the caller. That implies that this class is accessible from the caller 
 * and that results in providing the image even if it is stored in another module.
 * The caller's class needs
 * 		<pre>Import &lt;package name&gt;.ImageLocator;</pre>e.g.
 * 		<pre>Import myMainPackage.resources.images.ImageLocator;</pre><br>
 
 * If you need a copy of this class (e.g. ImageLocator02) in another directory with image files do not forget to
 * <ol>
 * <li>rename the copied file,</li>
 * <li>adjust the package name in the copied file if necessary,</li>
 * <li>replace all occurrences of ImageLocator by the new class name (file name) in the copied file,</li>
 * <li>add the the appropriate Import in the caller's class.</li>
 * </ol>
 * 
 * For a image file e.g. named myLogo.gif the call is simply 
 * <pre>logoIcon = ImageLocator.getImage("myLogo.gif");</pre>
 *
 * @author 	Riebelsteiner
 * @version 1.0
 * @since   2023-03-12
 */ 
public class ImageLocator {
	/** 
	 * An explicit standard constructor suppresses Javadoc warnings.
	 */
	public ImageLocator() {
	} // end of public ImageLocator() {
	
	/**
	 * Provides an image that is located in the same directory (no subdirectory) as this class. 
	 * @param imageFileName the name of the image file without any path
	 * @return the image named imageFileName found in the same directory.
	 */
	public static Image getImage(String imageFileName)  {

		 return new Image(ImageLocator.class.getResource(imageFileName).toExternalForm());

	} // end of public static Image getImage(String imageFileName)

} // end of public class ImageLocator
