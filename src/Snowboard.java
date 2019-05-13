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
		g.drawImage(GamePanel.snowBoarderImg, x-10, y-8, width+20, height+16, null);
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
		if(x<0){
			x=0;
		}
		if(x>SnowFall.width-20){
			x=SnowFall.width-20;
		}
		if(y<0){
			y=0;
		}
		if(y>SnowFall.height-20){
			y=SnowFall.height-20;
		}
		
	}
	
	int getX(){
		return x;
	}
	
	int getY(){
		return y;
	}

	
}
