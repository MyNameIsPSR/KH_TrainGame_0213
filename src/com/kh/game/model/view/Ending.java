package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
 

public class Ending extends CommonPanel{
	
	private JPanel ending;
	
	public Ending(MainFrame mf, Player p) {
		super(mf, p);
		this.ending = this;
		
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);
		
		JLabel backImg = new JLabel
				(new ImageIcon(new ImageIcon("images/Ending.png")
				.getImage()
				.getScaledInstance(900, 600, 0)));
		backImg.setBounds(0, 0, 900, 600);
		
		JButton btnStart = new JButton("종료");
		btnStart.setBounds(650, 490, 150, 40);
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("굴림체",Font.BOLD,15));
		btnStart.setContentAreaFilled(false);
		btnStart.addActionListener(this);

		this.add(btnStart);
		this.add(backImg);
		
		btnStart.addActionListener(this);
		
		//占쏙옙占쏙옙占쌈울옙 占쌩곤옙
		mf.add(this);
	} //end method
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ChangePanel.changePanel(super.getMf(), ending, 
				new StartPanel(super.getMf()));
	} //end method
	
} //end class
