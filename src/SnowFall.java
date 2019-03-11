import java.awt.Dimension;

import javax.swing.JFrame;

public class SnowFall {

	JFrame frame;
	
	final int width= 500;
	final int height= 800;
	
	GamePanel game;
	
	public static void main(String[] args) {
	SnowFall snow = new SnowFall();
	
	snow.setup();
	
	}
	
	SnowFall(){
	frame = new JFrame();
	
	game = new GamePanel();
	
	}
	
	void setup(){
		frame.add(game);
		frame.addKeyListener(game);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));

        frame.pack();
        frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.startGame();
	}
	
}