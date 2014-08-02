/**
 * 
 */
package firstgame.graphics;

import java.util.Random;

import firstgame.level.tile.Tile;

/**
 * @author Markus
 *
 */
public class Screen
{

	// ===========================================
	// ==============Instance-Variables===========
	// ===========================================
	public int width = 0;
	public int height = 0;
	public int MAP_SIZE = 64;
	public int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffset = 0;
	public int yOffset = 0;

	public int[] pixels = null;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	private final Random random = new Random();

	// ===========================================
	// ==============Constructor(s)===============
	// ===========================================
	public Screen(int width, int height)
	{
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < tiles.length; i++)
		{
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	// ===========================================
	// ==============Methods======================
	// ===========================================

	public void renderTile(int xp, int yp, Tile tile)
	{
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++)
		{
			// ya = y absolute
			// xa = x absolute
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++)
			{
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0
						|| ya >= height)
				{
					break;
				}
				if (xa < 0)
				{
					xa = 0;
				}
				int col = tile.sprite.pixels[x + y * tile.sprite.SIZE];
				if (col != 0xffff00ff)
				{
					pixels[xa + ya * width] = col;
				} else
				{
					pixels[xa + ya * width] = 0x8CD776; //Hintergrundfarbe
				}

			}
		}
	}

	//TODO Überarbeiten, zu unübersichtlich
	public void renderPlayer(int xp, int yp, Sprite sprite, boolean xFlip,
			boolean yFlip)
	{
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++)
		{
			// ya = y absolute
			// xa = x absolute
			int ya = y + yp;
			int ys = y;
			if (yFlip)
			{
				ys = 31 - y;
			}
			for (int x = 0; x < 32; x++)
			{
				int xa = x + xp;
				int xs = x;
				if (xFlip)
				{
					xs = 31 - x;
				}

				if (xa < -32 || xa >= width || ya < 0 || ya >= height)
				{
					break;
				}
				if (xa < 0)
				{
					xa = 0;
				}

				int col = sprite.pixels[xs + ys * 32];
				if (col != 0)
				{
					pixels[xa + ya * width] = col;
				}
			}
		}
	}

	public void clear()
	{
		for (int i = 0; i < pixels.length; i++)
		{
			pixels[i] = 0;
		}
	}

	// ===========================================
	// ==============Getter/Setter================
	// ===========================================

	public void setOffset(int xOffset, int yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
