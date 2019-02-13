package pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong extends Applet implements Runnable, KeyListener {
	HumanPaddle p1;
	AiPaddle p2;
	Ball ball;
	Thread thread;
	int xMove, yMove;
	int x, y;

	public void init() {
		this.resize(800, 500); // set size frame
		
		p1 = new HumanPaddle();
		p2 = new AiPaddle();
		ball = new Ball();
		thread = new Thread(this);
		this.addKeyListener(this);
		
		thread.start();
	}

	public void paint(Graphics g) {
		// to frame mau den
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 500);

		// kiem tra neu ball di qua canh trai & phai frame
		if ((ball.x < 0) || (ball.x > 770)) {
			g.setColor(Color.white);
			g.drawString("GAME OVER", 365, 250);

		} else {
			p1.move();
			p1.draw(g);

			ball.move();
			ball.draw(g);

			p2.move(ball);
			p2.draw(g);
			ball.checkCollision(p1, p2);
		}
	}

	@Override
	public void run() {
		// khoi tao vi tri cua ball
		ball.x = 200;
		ball.y = 200;
		int count = 0;
		// thread.interrupt(); su dung InterruptedException
		for (;;) {
			count++;
			repaint();
			System.out.println("FRAME: " + count);
			System.out.println("Human x " + p1.x + " y " + p1.y);
			System.out.println("Ai x " + p2.x + " y " + p2.y);
			System.out.println("Ball x " + ball.x + " y " + ball.y);
			System.out.println();

			try {
				thread.sleep(10);
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode() == KeyEvent.VK_UP)
			p1.yUp = true;
		else if (k.getKeyCode() == KeyEvent.VK_DOWN)
			p1.yDown = true;
	}

	@Override
	public void keyReleased(KeyEvent k) {
		p1.yUp = false;
		p1.yDown = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}