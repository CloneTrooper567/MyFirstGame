/**
 * 
 */
package firstgame.entity.mod;

import firstgame.graphics.Screen;
import firstgame.graphics.Sprite;
import firstgame.input.Keyboard;

/**
 * @author Markus
 *
 */
public class Player extends Mob
{

	//===========================================
	//==============Instance-Variables===========
	//===========================================
	private Keyboard input;
	private Sprite sprite = Sprite.player_up;
	private int anim = 0;
	private boolean walking = false;

	//===========================================
	//==============Constructor(s)===============
	//===========================================
	public Player(Keyboard input)
	{
		this.input = input;
	}

	public Player(int x, int y, Keyboard input)
	{
		this(input);
		this.x = x;
		this.y = y;

	}

	//===========================================
	//==============Methods======================
	//===========================================
	@Override
	public void update()
	{
		int xa = 0, ya = 0;
		if (anim < 7500)
		{
			anim++;
		} else
		{
			anim = 0;
		}
		if (input.up)
		{
			ya--;
		}
		if (input.down)
		{
			ya++;
		}
		if (input.left)
		{
			xa--;
		}
		if (input.right)
		{
			xa++;
		}

		if (xa != 0 || ya != 0)
		{
			move(xa, ya);
			walking = true;
		} else
		{
			walking = false;
		}
	}

	@Override
	public void render(Screen screen)
	{

		boolean xFlip = false;
		switch (dir) {
		case 0:
			sprite = Sprite.player_back;
			if (walking)
			{
				if (anim % 20 >= 10)
				{
					sprite = Sprite.move_back1;
				} else
				{
					sprite = Sprite.move_back2;
				}
			}

			break;
		case 1:
			sprite = Sprite.player_right;
			if (walking)
			{
				if (anim % 20 >= 10)
				{
					sprite = Sprite.move_right1;
				} else
				{
					sprite = Sprite.move_right2;
				}
			}
			break;
		case 2:
			sprite = Sprite.player_up;
			if (walking)
			{
				if (anim % 20 >= 10)
				{
					sprite = Sprite.move_forward1;
				} else
				{
					sprite = Sprite.move_forward2;
				}
			}
			break;
		case 3:
			xFlip = true;
			sprite = Sprite.player_right;
			if (walking)
			{
				if (anim % 20 >= 10)
				{
					sprite = Sprite.move_right1;
				} else
				{
					sprite = Sprite.move_right2;
				}
			}
			break;
		}
		screen.renderPlayer(x - 16, y - 16, sprite, xFlip, false);
	}

	//===========================================
	//==============Getter/Setter================
	//===========================================

}
