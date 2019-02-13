package pong;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle {
	final int WIDTH = 30, HEIGHT = 130;
	int x = 60, y = 60;
	int yMoveUp, yMoveDown;
	boolean yUp = false, yDown = false;

	// Ve human paddle
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	// Di chuyen human paddle
	public void move() {
		
		if (yUp) {
			yMoveUp -= 2;
			if (yMoveUp <= -4)
				yMoveUp = -4;
			y += yMoveUp;
		}
		if (yDown) {
			yMoveDown += 2;
			if (yMoveDown >= 4)
				yMoveDown = 4;
			y += yMoveDown;
		}
		
		//chan human paddle thoat khoi frame
		if (y <= 0)
			y = 0;
		if (y >= 370)
			y = 370;
	}
}
