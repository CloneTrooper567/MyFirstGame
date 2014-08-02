/**
 * 
 */
package firstgame.level.tile;

import firstgame.graphics.Screen;
import firstgame.graphics.Sprite;

/**
 * @author Markus
 *
 */
public class Tile
{

	// ===========================================
	// ==============Instance-Variables===========
	// ===========================================
	public int x = 0, y = 0;
	public Sprite sprite = null;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile flower1 = new FlowerTile(Sprite.flower1);
	public static Tile flower2 = new FlowerTile(Sprite.flower2);
	public static Tile tree = new TreeTile(Sprite.tree);
	public static Tile rock = new RockTile(Sprite.rock);

	// ===========================================
	// ==============Constructor(s)===============
	// ===========================================
	public Tile(Sprite sprite)
	{
		this.sprite = sprite;
	}

	// ===========================================
	// ==============Methods======================
	// ===========================================
	public void render(int x, int y, Screen screen)
	{

	}

	public boolean solid()
	{
		return false;
	}
	// ===========================================
	// ==============Getter/Setter================
	// ===========================================

}
