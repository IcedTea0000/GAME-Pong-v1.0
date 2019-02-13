package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	int x, y;
	int xMove, yMove;

	public Ball(){
		genRandomDirection(); // tao huong di chuyen ngau nhien cho ball
	}
	
	// ve ball
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, 30, 30);
	}

	// tao huong di chuyen ball ngau nhien trong khoang 3-5
	public void genRandomDirection() {
		Random r = new Random();
		xMove = 3 - r.nextInt(2);
		yMove = 3 - r.nextInt(2);
	}

	// di chuyen ball
	public void move() {
		x += xMove;
		y += yMove;
	}

	// kiem tra va cham voi cac paddle va cac canh frame
	public void checkCollision(HumanPaddle p1, AiPaddle p2) {
		if ((x >= 680 || x <=0) || (x <= 90 && y >= p1.y && y <= p1.y + 130)
				|| (x >= p2.x && y >= p2.y && y <= p2.y + 130))
			xMove *= -1;
		if (y > 471 || y < -1)
			yMove *= -1;
		System.out.println("Ball collision dc thuc hien");
	}

}
