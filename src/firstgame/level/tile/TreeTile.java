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
public class TreeTile extends Tile
{

	//===========================================
	//==============Instance-Variables===========
	//===========================================

	//===========================================
	//==============Constructor(s)===============
	//===========================================
	/**
	 * @param sprite
	 */
	public TreeTile(Sprite sprite)
	{
		super(sprite);
	}

	//===========================================
	//==============Methods======================
	//===========================================
	@Override
	public void render(int x, int y, Screen screen)
	{
		//This tree needs 32x32 pixels
		screen.renderTile(x << 4, y << 4, this);
	}
	//===========================================
	//==============Getter/Setter================
	//===========================================

}
