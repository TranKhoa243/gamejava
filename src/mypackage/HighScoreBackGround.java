package mypackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mypackage.io.SerializableFileFactory;
import mypackage.model.HighScore;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HighScoreBackGround extends JFrame {

	private JPanel contentPane;
	private JTextField PlayerHighScore1;
	private JTextField PlayerHighScore2;
	private JTextField PlayerHighScore3;
	private JTextField PlayerHighScore4;
	private JTextField PlayerHighScore5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HighScoreBackGround frame = new HighScoreBackGround();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HighScoreBackGround() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img=Toolkit.getDefaultToolkit().getImage(HighScoreBackGround.class.getResource("/image_background/golden_trophy.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		PlayerHighScore1 = new JTextField();
		PlayerHighScore1.setColumns(10);
		
		PlayerHighScore2 = new JTextField();
		PlayerHighScore2.setColumns(10);
		
		PlayerHighScore3 = new JTextField();
		PlayerHighScore3.setColumns(10);
		
		PlayerHighScore4 = new JTextField();
		PlayerHighScore4.setColumns(10);
		
		PlayerHighScore5 = new JTextField();
		PlayerHighScore5.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(151)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(PlayerHighScore5, Alignment.TRAILING)
						.addComponent(PlayerHighScore4, Alignment.TRAILING)
						.addComponent(PlayerHighScore3, Alignment.TRAILING)
						.addComponent(PlayerHighScore2)
						.addComponent(PlayerHighScore1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(PlayerHighScore1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(PlayerHighScore2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PlayerHighScore3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PlayerHighScore4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(PlayerHighScore5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(91, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		process();
	}
	
	private void process() {
		ArrayList<HighScore> arrHS= SerializableFileFactory.loadFile("C:\\Users\\Admin\\Desktop\\HighScore.txt");
		String line1=arrHS.get(0).getName()+":"+arrHS.get(0).getScore();
		String line2=arrHS.get(1).getName()+":"+arrHS.get(1).getScore();
		String line3=arrHS.get(2).getName()+":"+arrHS.get(2).getScore();
		String line4=arrHS.get(3).getName()+":"+arrHS.get(3).getScore();
		String line5=arrHS.get(4).getName()+":"+arrHS.get(4).getScore();
		PlayerHighScore1.setText(String.valueOf(line1));
		PlayerHighScore2.setText(String.valueOf(line2));
		PlayerHighScore3.setText(String.valueOf(line3));
		PlayerHighScore4.setText(String.valueOf(line4));
		PlayerHighScore5.setText(String.valueOf(line5));
	}
}
