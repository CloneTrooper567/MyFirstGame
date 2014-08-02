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
public class RockTile extends Tile
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
	public RockTile(Sprite sprite)
	{
		super(sprite);
	}

	//===========================================
	//==============Methods======================
	//===========================================
	@Override
	public void render(int x, int y, Screen screen)
	{
		//Converting back into tileprecision
		screen.renderTile(x << 4, y << 4, this);
	}

	@Override
	public boolean solid()
	{
		return true;
	}
	//===========================================
	//==============Getter/Setter================
	//===========================================

}
