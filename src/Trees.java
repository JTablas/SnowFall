 import java.awt.Color;
import java.awt.Graphics;

public class Trees extends GameObject {

	Trees(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 50, 50);
	}
	
	void update() {
		super.update();
		y-=5;
		if(y<=0){
		isAlive=false;
		}
	}
	
}
