/**
 * 
 */
package firstgame.level;

import firstgame.graphics.Screen;
import firstgame.level.tile.Tile;

/**
 * @author Markus
 *
 */
public class Level
{

	// ===========================================
	// ==============Instance-Variables===========
	// ===========================================
	protected Tile[] tiles;
	protected int width, height;
	protected int[] tileInt;

	// ===========================================
	// ==============Constructor(s)===============
	// ===========================================
	public Level(int width, int height)
	{
		this.width = width;
		this.height = height;
		tileInt = new int[width * height];
		generateLevel();
	}

	public Level(String path)
	{
		loadLevel(path);
		generateLevel();
	}

	// ===========================================
	// ==============Methods======================
	// ===========================================

	protected void loadLevel(String path)
	{

	}

	protected void generateLevel()
	{

	}

	public void update()
	{

	}

	public void render(int xScroll, int yScroll, Screen screen)
	{
		// Screen corner pins location
		// ------------------------
		// |x0/y0 y0 y0 y0 y0 y0/x1|
		// |x0 					 x1|
		// |x0 					 x1|
		// |x0/y1 y1 y1 y1 y1 y1/x1|
		// -----------------------
		screen.setOffset(xScroll, yScroll);
		// Changing pixelprecision to tileprecision
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++)
		{
			for (int x = x0; x < x1; x++)
			{
				if (x + y * 16 < 0 || x + y * 16 >= 16 * 16)
				{
					Tile.voidTile.render(x, y, screen);
					continue;
				}
				tiles[x + y * 16].render(x, y, screen);

			}
		}
	}

	// ===========================================
	// ==============Getter/Setter================
	// ===========================================

	public Tile getTile(int x, int y)
	{
		if (x < 0 || x >= width || y < 0 || y >= height)
		{
			return Tile.voidTile;
		}
		if (tileInt[x + y * width] == 0)
		{
			return Tile.grass;
		}
		if (tileInt[x + y * width] == 1)
		{
			return Tile.flower1;
		}
		if (tileInt[x + y * width] == 2)
		{
			return Tile.rock;
		}
		if (tileInt[x + y * width] == 3)
		{
			return Tile.tree;
		}
		return Tile.voidTile;

	}
}
