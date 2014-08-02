/**
 * 
 */
package firstgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import firstgame.entity.mod.Player;
import firstgame.graphics.Screen;
import firstgame.input.Keyboard;
import firstgame.level.Level;
import firstgame.level.RandomLevel;

/**
 * @author Markus
 *
 */
//This game base on a youtube game development tutorial
//by TheChernoProject.
//The tutorial is available under:
//http://www.youtube.com/watch?v=GFYT7Lqt1h8&list=PLlrATfBNZ98eOOCk2fOFg7Qg5yoQfFAdf
public class Game extends Canvas implements Runnable
{

	// ===========================================
	// ==============Getter/Setter================
	// ===========================================
	/**
	 * 
	 */
	private static final long serialVersionUID = 6520130736213897195L;

	// ===========================================
	// ==============Instance-Variables===========
	// ===========================================
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String GAME_TITLE = "MyFirstGame";

	private Screen screen = null;
	private Keyboard key = null;
	private Thread thread = null;
	private JFrame frame = null;
	private Level level = null;
	private Player player = null;
	private boolean running = false;

	private final BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	private final int[] pixels = ((DataBufferInt) image.getRaster()
			.getDataBuffer()).getData();

	// ===========================================
	// ==============Constructor(s)===============
	// ===========================================

	public Game()
	{
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		key = new Keyboard();
		screen = new Screen(width, height);
		level = new RandomLevel(128, 128);
		player = new Player(key);
		frame = new JFrame(GAME_TITLE);

		addKeyListener(key);
	}

	// ===========================================
	// ==============Methods======================
	// ===========================================
	@Override
	public void run()
	{
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000D / 60;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1)
			{
				update();
				updates++;
				delta--;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - timer >= 1000)
			{
				timer += 1000;
				frame.setTitle(GAME_TITLE + "    |   fps: " + frames + " ups: "
						+ updates);
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}

	public synchronized void start()
	{
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop()
	{
		running = false;
		try
		{
			thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void update()
	{
		key.update();
		player.update();
	}

	public void render()
	{
		BufferStrategy bs = getBufferStrategy();

		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		for (int i = 0; i < pixels.length; i++)
		{
			pixels[i] = screen.pixels[i];
		}
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		g.setColor(Color.white);
		g.drawString("X: " + player.x + ", Y: " + player.y, 50, 50);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args)
	{
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("MyFirstGame");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}
