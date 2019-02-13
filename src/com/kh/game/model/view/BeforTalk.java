package com.kh.game.model.view;

import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.controller.GameSave;

public class BeforTalk extends CommonPanel{
	
	private JPanel beforTalk;
	private JButton btnChar;
	private int level;
	private String imgAdd;
	

	public BeforTalk(MainFrame mf, Player p, int level) {
		super(mf, p);
		
		//각 열차 칸 집입시 저장
		super.getP().setLevel(level);
		new GameSave().save(super.getP(), beforTalk);
		
		
		this.beforTalk = this;
		this.level = level;
		
		//패널 설정
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);
		
		btnChar = new JButton("");
		btnChar.setBorderPainted(false);
		btnChar.setContentAreaFilled(false);
		btnChar.addActionListener(this);

		switch(level) { //칸마다 배경이미지 다르게 설정
			case 0:
				imgAdd = "images/beforLevelBonus.png";
				break;
			case 1:
				imgAdd = "images/beforLevelOne.png";
				btnChar.setBounds(220, 220, 200, 350);
				break;
			case 2: 
				imgAdd = "images/beforLevelTwo.png";
				btnChar.setBounds(400, 200, 100, 190);
				break;
			case 3: 
				imgAdd = "images/beforLevelThree.png";
				btnChar.setBounds(350, 180, 100, 260); 
				break;
		} //end switch
		
		//배경 이미지
		Image backImg = new ImageIcon(imgAdd)
				.getImage()
				.getScaledInstance(900, 600, 0);
		JLabel backLabel = new JLabel(new ImageIcon(backImg));
		backLabel.setBounds(0, 0, 900, 600);
		
		
		//프레임에 추가
		this.add(btnChar);
		this.add(backLabel);
		
		//패널에 추가
		mf.add(this);
	} //end constr
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("BeforTalk - 문지기를 클릭하셨습니다.");
		ChangePanel.changePanel(super.getMf(), beforTalk,
				new Talk(super.getMf(), level, super.getP()));
	} //end method
	
} //end class
