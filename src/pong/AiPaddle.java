package pong;

import java.awt.Color;
import java.awt.Graphics;

public class AiPaddle {
	final int WIDTH = 30, HEIGHT = 130;
	int x = 710, y = 60;
	int yMove;

	//ve ai paddle
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	//di chuyen ai paddle
	public void move(Ball ball) {
		yMove = 3;
		//di chuyen paddle theo trung tam ball
		if (y + 30 >= ball.y+15)
			y -= yMove;
		else
			y += yMove;
		
		//chan ai paddle thoat khoi frame
		if (y <= 0)
			y = 0;
		if (y >= 370)
			y = 370;
	}
}
