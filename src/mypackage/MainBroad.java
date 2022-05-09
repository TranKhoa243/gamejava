package mypackage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainBroad extends JPanel implements ActionListener,Common {

	private ArrayList < Item > items;
	private ArrayList < Enemy > enemies;
	private Box box;
	private Timer timer;
	public static boolean inGame;
	private static int point;
	public int getPoint() {
		return point;
	}
	private int score;
	public MainBroad() {
		initBoard();
	}	
	
	private void initBoard() {
		hideMouse();
		inGame = true;
		point = 0;
		addMouseMotionListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.lightGray);
		setDoubleBuffered(true);
		box = new Box(INIT_BOX_X, INIT_BOX_Y);
		enemies = new ArrayList < Enemy >();
		items = new ArrayList <Item >();
		initEnemy();
		initItem();
		inGame = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}

	private void initEnemy() {
		int initX = (int) (Math.random() * (Common.WIDTH - 50));
		int initY = (int) (Math.random() * (Common.HEIGHT - 50));
		Enemy enemy = new Enemy(initX, initY);
		enemies.add(enemy);
	}
	
	private void initItem() {
		int initX = (int) (Math.random() * (Common.WIDTH - 50));
		int initY = (int) (Math.random() * (Common.HEIGHT - 50));
		Item item = new Item(initX, initY);
		items.add(item);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(inGame) {
			drawObject(g);
		}
		else {
			drawGameOver(g);
		}
	}
	
	private void drawObject(Graphics g) {
		// Draw Box
		g.drawImage(box.getImage(), box.getX(), box.getY(), this);
		// Draw Enemies
		for (Enemy enemy : enemies) {
		g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
		}
		// Draw Item
		for (Item item : items) {
		g.drawImage(item.getImage(), item.getX(), item.getY(), this);
		}
		// Draw Point
		Font font = new Font("Arial", Font.BOLD, 12);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("Your point: " + point, 5, 15);
	}
	
	private void drawGameOver(Graphics g) {
		Font font = new Font("Helvetica", Font.BOLD, 20);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("Game over!", 350, Common.HEIGHT / 2);
		g.drawString("Score: " + point, 370, Common.HEIGHT / 2 + 30);
		score=point;
		LuckyBox.score();
	}

	public int getScore() {
		return score;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		inGame();
		// Update Object
		updateBox();
		updateEnemy();
		updateItem();
		// Check collision
		checkCollision();
		// Repaint
		repaint();
		if(point==enemies.size()) {initItem();initEnemy();}
	}

	private void checkCollision() {
		Rectangle myCharBound = box.getBound();
		for(Enemy e:enemies) {
			Rectangle enemyBound = e.getBound();
			if(myCharBound.intersects(enemyBound)) {
				this.inGame=false;
				}
			else {
				e.visible=true;
			}
		}
		
		for(Item i:items) {
			Rectangle itemBound = i.getBound();
			if(myCharBound.intersects(itemBound)) {
				   point+=1; 
				   i.visible=false;
				} 
		}
	}

	private void inGame() {
		if (!inGame) {
			timer.stop();
		}
	}
	
	private void updateBox() {
		box.move();
	}
	
	private void updateEnemy() {
		for (int i = 0; i < enemies.size(); i++) {
		Enemy enemy = enemies.get(i);
		if (enemy.isVisible()) {
			enemy.move();
		} 
		else {
		    enemies.remove(i);
		}
		}
	}
	
	private void updateItem() {
		for (int i = 0; i < items.size(); i++) {
		Item item = items.get(i);
		if (!item.isVisible()) {
			items.remove(i);
		}
		}
	}
	
	private void hideMouse() {
		ImageIcon emptyIcon = new ImageIcon(new byte[0]);
        Cursor invisibleCursor = getToolkit().createCustomCursor(
                emptyIcon.getImage(), new Point(0,0), "Invisible");
        this.setCursor(invisibleCursor);
	}
	
	private class TAdapter extends MouseMotionAdapter {
		@Override
		public void mouseMoved(MouseEvent e) {
			box.mouseMoved(e);
		}
	}
	
}
