package pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ThreadGraphic extends Applet implements Runnable {
	Thread thread = new Thread(this);
	Ball ball = new Ball();
	
	public void init() {
		this.setSize(400, 400);
		ball.genRandomDirection();
		thread.start();
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 400, 400);
		//g.drawString(String.valueOf(count),10, 10);

	}

	@Override
	public void run() {
		ball.x = 200;
		ball.y = 200;
		for (;;) {
			repaint();
			try {
				thread.sleep(10);
			} catch (Exception e) {
			}
		}
	}

}
