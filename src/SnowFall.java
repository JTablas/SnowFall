import javax.swing.JFrame;

public class SnowFall {

	JFrame frame;
	
	final int width= 500;
	final int height= 800;
	
	public static void main(String[] args) {
	SnowFall snow = new SnowFall();
	
	snow.setup();
	
	SnowFall(){
	frame = new JFrame();
	}

	
	
}
	
	void setup(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}