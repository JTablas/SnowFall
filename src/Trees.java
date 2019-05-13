import java.awt.Color;
import java.awt.Graphics;

public class Trees extends GameObject {

	Trees(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	int yy = 800;
	void draw(Graphics g) {
<<<<<<< HEAD
		g.drawImage(GamePanel.treeImg, x-25, y-50, width+70, height+100, null);
=======
		g.setColor(Color.YELLOW);
		g.fillRect(x, yy, 50, 50);
>>>>>>> a222e401510725de9a47a1c6f15d7893133f3847
	}
	
	void update() {
		super.update();
<<<<<<< HEAD
		y-=10;
		if(y<=0){
		isAlive=false;
		}
=======
		yy--;
>>>>>>> a222e401510725de9a47a1c6f15d7893133f3847
	}
	
}
