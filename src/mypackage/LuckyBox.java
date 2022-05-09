package mypackage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.xml.ws.handler.MessageContext.Scope;


import mypackage.model.HighScore;

public class LuckyBox extends JFrame implements Common{
	
	private static MainBroad mB=new MainBroad();
	private static int score;
	private static String name;
	private static boolean check =true;
	public LuckyBox() {
		setTitle("Lucky Box");
		add(mB);
		setSize(Common.WIDTH, Common.HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void score() {
		score=mB.getScore();
		HighScore nHS=new HighScore(name, score);
		if(check==true) {
		LoadSaveHighScore nLS=new LoadSaveHighScore();
		nLS.SaveLoadFile(nHS);
		check=false;
		}
	}

	public void setName(String s) {
		name=s;
	}
}
