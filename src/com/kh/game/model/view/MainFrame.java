package com.kh.game.model.view;

import javax.swing.JFrame;
 
public class MainFrame extends JFrame{
	
	public MainFrame() { //팀별로 하나만 작성
		this.setLocation(62, 80);
		this.setSize(900, 600);
		this.setLayout(null);
		
		new StartPanel(this);
		
		this.setResizable(false);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
