import java.awt.Color;
import java.awt.Graphics;

public class Trees extends GameObject {

	Trees(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.treeImg, x-25, y-50, width+70, height+100, null);
	}
	
	void update() {
		super.update();

		y-=10;
		if(y<=0){
		isAlive=false;
		}
	}
	
}
