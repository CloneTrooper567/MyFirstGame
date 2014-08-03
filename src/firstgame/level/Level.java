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
public class Level {

	// ===========================================
	// ==============Instance-Variables===========
	// ===========================================
	protected int width, height;
	protected int[] tiles;

	// ===========================================
	// ==============Constructor(s)===============
	// ===========================================
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	// ===========================================
	// ==============Methods======================
	// ===========================================

	protected void loadLevel(String path) {

	}

	protected void generateLevel() {

	}

	public void update() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		// Screen corner pins location
		// ------------------------
		// |x0/y0 y0 y0 y0 y0 y0/x1|
		// |x0 x1|
		// |x0 x1|
		// |x0/y1 y1 y1 y1 y1 y1/x1|
		// -----------------------
		screen.setOffset(xScroll, yScroll);
		// Changing pixelprecision to tileprecision
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}

	// ===========================================
	// ==============Getter/Setter================
	// ===========================================

	public Tile getTile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return Tile.voidTile;
		}
		if (tiles[x + y * width] == 0) {
			return Tile.grass;
		}
		if (tiles[x + y * width] == 1) {
			return Tile.flower1;
		}
		if (tiles[x + y * width] == 2) {
			return Tile.rock;
		}
		if (tiles[x + y * width] == 3) {
			return Tile.tree;
		}
		return Tile.voidTile;

	}
}
