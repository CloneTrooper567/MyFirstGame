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
public class VoidTile extends Tile
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
	public VoidTile(Sprite sprite)
	{
		super(sprite);
	}

	//===========================================
	//==============Methods======================
	//===========================================
	@Override
	public void render(int x, int y, Screen screen)
	{
		screen.renderTile(x << 4, y << 4, this);
	}
	//===========================================
	//==============Getter/Setter================
	//===========================================

}
