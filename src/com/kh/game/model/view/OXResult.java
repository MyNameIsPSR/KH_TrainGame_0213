package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.game.controller.GameManager;

public class OXResult extends CommonPanel {
	
	private JPanel oxResult;
	private JButton btnNext;
	private int cnt;
	private String imgAdd;
	private boolean isPass;
	
	public OXResult(MainFrame mf, Player p, int cnt) {
		super(mf, p);
		this.oxResult = this;
		this.cnt = cnt;
		
		//ox.p.setStage(1);
		
		this.setLayout(null);
		this.setBounds(0, 0, 900, 600);
		
		//배경이미지설정
		JLabel backImg = new JLabel(new ImageIcon
				(new ImageIcon("images/OrienBack.png")
				.getImage()
				.getScaledInstance(900, 600, 0)));
		backImg.setBounds(0, 0, 900, 600);		
		
		JTextField jtf = new JTextField(50);
		jtf.setText("틀린 갯수 : " + cnt + " / 10");
		jtf.setSize(800,50);
		jtf.setLocation(40, 50);
		
		//통과 불통과 여부 부분
		if(cnt >= 5) { //5개 이상이면 불통과
			imgAdd = "images/OX_Fail.png";
			isPass = false;
		} else { //통과
			imgAdd = "images/OX_Pass.png";
			isPass = true;
		} //end if
		
		Image icon = new ImageIcon(imgAdd)
				.getImage().getScaledInstance(800, 350, 0);
		JLabel imgLabel= new JLabel(new ImageIcon(icon));
		
		imgLabel.setBounds(40, 120, 800, 350);
		
		
		btnNext = new JButton("NEXT");
		btnNext.setFont(new Font("굴림체",Font.BOLD,25));
		btnNext.setContentAreaFilled(false);
		btnNext.setForeground(Color.WHITE);
		btnNext.setSize(140,50);
		btnNext.setLocation(700,490);
		btnNext.addActionListener(this);
		
		this.add(jtf);
		this.add(imgLabel);
		this.add(btnNext);
		this.add(backImg);
		mf.add(this);
	} //end constr
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OXResult - 다음 버튼 눌림");
			/*GameSave save = new GameSave();
			save.save(ox.p, ox);*/
			
			new GameManager(super.getMf(), 1, isPass, super.getP(), this);
		
	} //end method
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
} //end class
