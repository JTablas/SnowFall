import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	Timer time;
	
	Font titleFont;
	Font instruction;
	
	int score = 0;
	
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;
	
	long startTime= 0;
	long endTime = 0;
	float frameTime = 0;
	double totalTime= 0;
	
	int currentState = MENU_STATE;
	
	double treetracker = 0;
	
	Snowboard board = new Snowboard(250,100,50,50);
	ObjectManager sb = new ObjectManager(board);
	
	public static BufferedImage treeImg;

    public static BufferedImage snowBoarderImg;

    public static BufferedImage snowmountainImg;
	
	GamePanel(){
	time = new Timer(1000/60,this);
	
	titleFont= new Font("Arial",Font.PLAIN,48);
	instruction= new Font("Arial",Font.PLAIN,24);
		
	startTime=System.currentTimeMillis();
	 
	

     try {

         treeImg = ImageIO.read(this.getClass().getResourceAsStream("New Tree.png"));

         snowBoarderImg = ImageIO.read(this.getClass().getResourceAsStream("Skier.png"));

         snowmountainImg = ImageIO.read(this.getClass().getResourceAsStream("newmountainsnow.png"));

 } catch (IOException e) {

         // TODO Auto-generated catch block

         e.printStackTrace();

 }
	
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
		
		if(currentState==GAME_STATE){
			totalTime = 0;
			startTime=System.currentTimeMillis();
			score=0;
		}
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE&&currentState==MENU_STATE){
			JOptionPane.showMessageDialog(null,"Move with the arrow keys and try to avoid the trees for as long as possible");
		}
		if(currentState>END_STATE) {
			currentState=MENU_STATE;
			board=new Snowboard(250,100,50,50);
			sb= new ObjectManager(board);
		}
		
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
		
	}
	
	void updateMenuState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, SnowFall.width, SnowFall.height);	
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("SnowFall", 150, 150);
		g.setFont(instruction);
		g.drawString("Press Enter to start", 150, 400);
		g.drawString("Press SPACE for instructions", 100, 450);
		
		}
	
	void updateGameState() {
		sb.update();
		sb.manageEnemies();
		sb.checkCollision();
		sb.purgeObjects();
		
		
		if(board.isAlive==false){
			currentState=END_STATE;
			
			startTime= 0;
			endTime = 0;
			
			frameTime = 0;
			
			totalTime = 0;
			
		}
		if(currentState==GAME_STATE){
		endTime= System.currentTimeMillis();
		frameTime = (float)(((double)endTime-(double)startTime)/1000.0);
		totalTime += frameTime;
		startTime = endTime;
		score=(int)totalTime;
		System.out.println(score);
		System.out.println(totalTime);
		treetracker +=frameTime;
		
		if(treetracker>5){
		sb.increaseDifficulty();
		treetracker=0;
		}
		
		
		}

	}
	
	void drawGameState(Graphics g) {

		g.drawImage(GamePanel.snowmountainImg,0,0, SnowFall.width, SnowFall.height, null);
		
		sb.draw(g);
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Time " + getScore(), 0, 40);
	}
	
	void updateEndState() {
		
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, SnowFall.width, SnowFall.height);
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER", 120, 150);

		g.setFont(instruction);
		g.drawString("You have survived " + getScore() + " seconds", 150,300);
		g.drawString("Press Enter to restart", 150, 400);
		
		
	}	
	
	int getScore(){
		return score;
	}
	
}
