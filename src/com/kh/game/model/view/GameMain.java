package com.kh.game.model.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.controller.DifferenceSpot;

public class GameMain extends CommonPanel{
	private JPanel gameMain;
	private String imgAdd;
	private String title;
	private String description;
	private JButton[] btnGame = new JButton[3];
	private int level;

	public GameMain(MainFrame mf, Player p, int level) {
		super(mf, p);
		this.gameMain = this;
		this.level = level;

		//패널 설정
		gameMain.setLayout(null);
		this.setBounds(0, 0, 900, 600);
		
		//각 단계마다 다른 설정
		switch(level) {
			case 1:
				title = "O X 게임";
				imgAdd = "images/ox.png";
				description = "\n" +
						" 1. 문제를 읽고 맞으면 O, 틀리면 X를 눌러주세요.\n"
						+ " 2. 만약 5문제 이상 틀렸다면 문을 통과할 수 없습니다.\n"
						+ " 3. 게임에 실패할 시 단백질 양갱이 하나 감소 됩니다. \n"
						+ " 4. 양갱을 모두 소비하면 Game Over!\n"
						+ "\n 부디 좋은 결과가 있기를 기도합니다.";
				break;
			case 2:
				title = "가로 세로 낱말 퍼즐";
				imgAdd = "images/가로세로.png";
				description = "설명";
				break;
			case 3:
				title = "틀린 코드 찾기";
				imgAdd = "images/틀린코드찾기.png";
				description = "\n" + 
						" 1. 중앙의 코드를 보고 틀린부분 3곳 을 클릭하세요.\n"
						+ " 2. 오답을 세번클릭시 통과할 수 없습니다.\n"
						+ " 3. 주어진 시간안에 틀린부분을 모두 찾지 않으면 통과할 수 없습니다.\n"
						+ " 4. 게임에 실패할 시 단백질 양갱이 하나 감소 됩니다. \n"
						+ " 5. 양갱을 모두 소비하면 Game Over!\n"
						+ "\n 부디 좋은 결과가 있기를 기도합니다.";
				break;
		}
		
		int y = 0;
		for(int i = 0; i < btnGame.length; i++) { //버튼 3개 생성
			btnGame[i] = new JButton("");
			btnGame[i].setBounds(665, 345 + y, 130, 45);
			btnGame[i].setBorderPainted(false);
			btnGame[i].setContentAreaFilled(false);
			this.add(btnGame[i]);
			btnGame[i].addActionListener(this);
			y += 60;
		} //end for(i)

		JLabel gameImg = new JLabel(new ImageIcon(new ImageIcon(imgAdd)
				.getImage()
				.getScaledInstance(900, 600, 0)));
		gameImg.setBounds(0, 0, 900, 600);
		this.add(gameImg);
		
		mf.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGame[2]) { //돌아가기 버튼 눌렀을 때
			ChangePanel.changePanel(super.getMf(), gameMain, 
					new BeforTalk(super.getMf(), super.getP(), level));
		} else if(e.getSource() == btnGame[1]) { //게임 설명 버튼 눌렀을 때
			new DescripDlg(super.getMf(), title, description);
		} else if(e.getSource() == btnGame[0]) { //게임하기 버튼 눌렀을 때
			switch(level) {
			case 1:
				ChangePanel.changePanel(super.getMf(), gameMain, 
						new OXPlay(super.getMf(), super.getP()));
				break;
			case 2:
				ChangePanel.changePanel(super.getMf(), gameMain, 
						new CrossPanel(super.getMf(), super.getP()));
				break;
			case 3: 
				ChangePanel.changePanel(super.getMf(), gameMain, 
						new DifferenceSpot(super.getMf(), super.getP()));
				break;
			} //end switch			
		} //end if
	}

} //end class