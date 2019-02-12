package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.controller.GameManager;

public class isPassTalk extends CommonPanel{
	private JPanel isPt;
	private int level;
	private String imgAdd;
	private JPanel newPane;
	private ArrayList<String> talkArr;
	private JLabel talkLabel; //말을 표현해줄 것
	private int index = 0; //리스트 배열
	private JButton btnNext;
	private GameManager gm;

	public isPassTalk(MainFrame mf, Player p, 
			ArrayList<String> talkArr, String imgAdd, GameManager gm) {
		//초기화
		super(mf, p);
		this.isPt = this;
		this.talkArr = talkArr;
		this.imgAdd = imgAdd;
		this.gm = gm;

		//패널 설정
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);

		//대화화면
		Image backImg = new ImageIcon(imgAdd)
				.getImage()
				.getScaledInstance(900, 600, 0);
		JLabel backLabel = new JLabel(new ImageIcon(backImg));
		backLabel.setBounds(0, 0, 900, 600);

		//대화 표시
		talkLabel = new JLabel(talkArr.get(index++));
		talkLabel.setForeground(Color.WHITE);
		talkLabel.setFont(new Font("굴림체",Font.BOLD,20));
		talkLabel.setBounds(30, 320, 800, 150); 

		btnNext = new JButton("Next >");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("굴림체",Font.BOLD,15));
		btnNext.setContentAreaFilled(false);
		btnNext.setBounds(720, 480, 120, 40);
		btnNext.addActionListener(this);

		this.add(btnNext);
		this.add(talkLabel);
		this.add(backLabel);

		mf.add(this);
		System.out.println("isPassTalk - 성공적 호출");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNext) {
			if(index != talkArr.size()) {
				System.out.println("다음버튼을 눌렀습니다.");
				talkLabel.setText(talkArr.get(index));
			} else { //대화의 끝에서
				gm.changPanel(this);
			} //end if
			index++;
		}
	}
} //end class
