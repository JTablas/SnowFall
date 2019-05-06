import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	Timer time;
	
	Font titleFont;
	
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;
	
	int currentState = MENU_STATE;
	
	Snowboard board = new Snowboard(250,100,50,50);
	ObjectManager sb = new ObjectManager(board);
	
	GamePanel(){
	time = new Timer(1000/60,this);
	
	titleFont= new Font("Arial",Font.PLAIN,48);
		
	
	
	}

	void startGame(){
		time.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(currentState==MENU_STATE) {
			updateMenuState();
		}else if(currentState==GAME_STATE) {
			updateGameState();
		}else if(currentState==END_STATE) {
			updateEndState();
		}
		repaint();
	}
	
	 @Override

	 public void paintComponent(Graphics g){
	
		 if(currentState==MENU_STATE) {
			 drawMenuState(g);
		 }else if(currentState==GAME_STATE) {
			 drawGameState(g);
		 }else if(currentState==END_STATE) {
			 drawEndState(g);
		 }
	 }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			currentState++;
		}
		if(currentState>END_STATE) {
			currentState=MENU_STATE;
		}
		System.out.println("Yee");
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			board.right=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			board.left=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			board.down=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			board.up=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Yaw");
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			board.right=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			board.left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			board.down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			board.up=false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("haw");
	}
	
	void updateMenuState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, SnowFall.width, SnowFall.height);	
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("SnowFall", 150, 150);
		
		}
	
	void updateGameState() {
		sb.update();
		sb.manageEnemies();
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, SnowFall.width, SnowFall.height);
		
		sb.draw(g);
		
	}
	
	void updateEndState() {
		
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, SnowFall.width, SnowFall.height);
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER", 120, 150);
		
		
	}	
	
}
