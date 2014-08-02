/**
 * 
 */
package firstgame.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Markus
 *
 */
public class SpriteSheet
{

	// ===========================================
	// ==============Instance-Variables===========
	// ===========================================
	private String path = "";
	public final int SIZE;
	public int[] pixels = null;

	public static SpriteSheet tiles = new SpriteSheet("/text/spritesheet.png",
			256);

	// ===========================================
	// ==============Constructor(s)===============
	// ===========================================
	private SpriteSheet(String path, int size)
	{
		this.path = path;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}

	// ===========================================
	// ==============Methods======================
	// ===========================================
	private void load()
	{
		try
		{
			BufferedImage image = ImageIO.read(SpriteSheet.class
					.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();

			// Scanning is done horizontally
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	// ===========================================
	// ==============Getter/Setter================
	// ===========================================

}
