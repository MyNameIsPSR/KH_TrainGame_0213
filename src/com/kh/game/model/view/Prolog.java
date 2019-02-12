package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Prolog extends CommonPanel{

	private JPanel prolog; 

	public Prolog(MainFrame mf, Player p) {
		super(mf, p);
		this.prolog = this;

		//패널 설정
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);

		//백그라운드 이미지
		JLabel backImg = new JLabel
				(new ImageIcon(new ImageIcon("images/Prolog.png")
				.getImage()
				.getScaledInstance(900, 600, 0)));
		backImg.setBounds(0, 0, 900, 600);

		//버튼
		JButton btnStart = new JButton("게임 시작");
		btnStart.setBounds(650, 490, 150, 40);
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("굴림체",Font.BOLD,15));
		btnStart.setContentAreaFilled(false);
		btnStart.addActionListener(this);

		//패널에 추가
		this.add(btnStart);
		this.add(backImg);

		mf.add(this);
	} //end method

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Prolog - 게임시작 버튼 클릭");
		ChangePanel.changePanel(super.getMf(), prolog,
				new BeforTalk(super.getMf(), super.getP(), 1));
	} //end method

} //end class
