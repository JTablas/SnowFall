import java.awt.Color;
import java.awt.Graphics;

public class Snowboard extends GameObject{

	boolean right = false;
	boolean left = false;
	boolean up = false;
	boolean down = false;
	
	Snowboard(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	int speed =5;
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	void update() {
		super.update();
		if(right==true) {
			x+=speed;
		}
		if(left==true) {
			x-=speed;
		}
		if(down==true) {
			y+=speed;
		}
		if(up==true) {
			y-=speed;
		}
		
	}

	
}
