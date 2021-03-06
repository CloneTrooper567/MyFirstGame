/**
 * Markus Kaschke
 * 03.08.2014
 */
package firstgame.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import firstgame.level.tile.Tile;

/**
 * @author Markus
 *
 */
public class SpwanLevel extends Level
{

	// ===========================================
	// =========Global-Variables==================
	// ===========================================
	private Tile[] tiles;
	private int[] levelpixels;

	// ===========================================
	// =========Constructor=======================
	// ===========================================

	public SpwanLevel(String path)
	{
		super(path);

	}

	// ===========================================
	// =========Methods===========================
	// ===========================================
	@Override
	protected void loadLevel(String path)
	{
		try {
			BufferedImage image = ImageIO.read(SpwanLevel.class
					.getResource(path));

			int w = image.getWidth();
			int h = image.getHeight();
			tiles = new Tile[w * h];
			image.getRGB(0, 0, w, h, levelpixels, 0, w);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load Level file!");
		}
	}

	@Override
	protected void generateLevel()
	{
		// Grass = 0xFF00;
		// Flower = 0xFFFF00;
		// Rock = 0x7F7F00;
		for (int i = 0; i < levelpixels.length; i++) {

			if (levelpixels[i] == 0xff00) {
				tiles[i] = Tile.grass;
			}
			if (levelpixels[i] == 0xffff00) {
				tiles[i] = Tile.flower1;
			}
			if (levelpixels[i] == 0x7f7f00) {
				tiles[i] = Tile.rock;
			}
		}
	}
	// ===========================================
	// =========Getter-Setter=====================
	// ===========================================

}
