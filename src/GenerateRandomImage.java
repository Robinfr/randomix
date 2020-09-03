// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package randomix.actions;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

/**
 * Will generate a random image and set it to the passed image entity.
 */
public class GenerateRandomImage extends CustomJavaAction<java.lang.Void>
{
	private IMendixObject ImageEntity;
	private java.lang.Long Width;
	private java.lang.Long Height;

	public GenerateRandomImage(IContext context, IMendixObject ImageEntity, java.lang.Long Width, java.lang.Long Height)
	{
		super(context);
		this.ImageEntity = ImageEntity;
		this.Width = Width;
		this.Height = Height;
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		// BEGIN USER CODE
		Core.storeImageDocumentContent(getContext(), ImageEntity, generateImage(Width.intValue(), Height.intValue()), 10, 10);
		return null;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GenerateRandomImage";
	}

	// BEGIN EXTRA CODE
	private InputStream generateImage(int width, int height) throws IOException {
		Random random = new Random();
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < width; i++) {         
            for (int j = 0; j < height; j++) {

                int x = random.nextInt(256);
                int y = random.nextInt(256);
                int z = random.nextInt(256);
                
                Color color = new Color(x, y, z);
                int rgb = color.getRGB();
                
                img.setRGB(i, j, rgb);
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(img, "jpeg", stream);
        
        return new ByteArrayInputStream(stream.toByteArray());
	}
	// END EXTRA CODE
}
