package mypackage;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NameBroad extends JFrame implements ActionListener{
	
	private JTextField tfName;
	private String name="";
	
	public NameBroad(JTextField tfName, String name) throws HeadlessException {
		super();
		this.name = name;
	}

	public NameBroad() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setLayout(new GridLayout(2,1,5,5));
		 int size=10;
		 add(new JLabel("Players Name"));
		 tfName=new JTextField(size);
		 add(tfName);
		 add(createJButton("Ok"));
		 add(createJButton("Retype"));
		 pack();
	     setLocationRelativeTo(null);
	     setVisible(true);
	}
	
	private JButton createJButton(String buttonName) {
		JButton btn=new JButton(buttonName);
		btn.addActionListener(this);
		return btn;
	}
	
	private void process() {
		this.name=tfName.getText();
	}
	
	private void clear() {
		tfName.setText("");
		tfName.requestFocus(); 
	}

	public String getName() {
		return name;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String commad=e.getActionCommand();
		if(commad=="Ok") {
			process();
		}
		else {
			clear();
		}
		if(name!="") {
		LuckyBox lk=new LuckyBox();
		lk.setName(name);
		lk.setVisible(true);
		hide();
		}
	}
}
