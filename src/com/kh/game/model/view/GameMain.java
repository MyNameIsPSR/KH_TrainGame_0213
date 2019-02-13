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

		//�г� ����
		gameMain.setLayout(null);
		this.setBounds(0, 0, 900, 600);
		
		//�� �ܰ踶�� �ٸ� ����
		switch(level) {
			case 1:
				title = "O X ����";
				imgAdd = "images/ox.png";
				description = "\n" +
						" 1. ������ �а� ������ O, Ʋ���� X�� �����ּ���.\n"
						+ " 2. ���� 5���� �̻� Ʋ�ȴٸ� ���� ����� �� �����ϴ�.\n"
						+ " 3. ���ӿ� ������ �� �ܹ��� �簻�� �ϳ� ���� �˴ϴ�. \n"
						+ " 4. �簻�� ��� �Һ��ϸ� Game Over!\n"
						+ "\n �ε� ���� ����� �ֱ⸦ �⵵�մϴ�.";
				break;
			case 2:
				title = "���� ���� ���� ����";
				imgAdd = "images/���μ���.png";
				description = "����";
				break;
			case 3:
				title = "Ʋ�� �ڵ� ã��";
				imgAdd = "images/Ʋ���ڵ�ã��.png";
				description = "\n" + 
						" 1. �߾��� �ڵ带 ���� Ʋ���κ� 3�� �� Ŭ���ϼ���.\n"
						+ " 2. ������ ����Ŭ���� ����� �� �����ϴ�.\n"
						+ " 3. �־��� �ð��ȿ� Ʋ���κ��� ��� ã�� ������ ����� �� �����ϴ�.\n"
						+ " 4. ���ӿ� ������ �� �ܹ��� �簻�� �ϳ� ���� �˴ϴ�. \n"
						+ " 5. �簻�� ��� �Һ��ϸ� Game Over!\n"
						+ "\n �ε� ���� ����� �ֱ⸦ �⵵�մϴ�.";
				break;
		}
		
		int y = 0;
		for(int i = 0; i < btnGame.length; i++) { //��ư 3�� ����
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
		if(e.getSource() == btnGame[2]) { //���ư��� ��ư ������ ��
			ChangePanel.changePanel(super.getMf(), gameMain, 
					new BeforTalk(super.getMf(), super.getP(), level));
		} else if(e.getSource() == btnGame[1]) { //���� ���� ��ư ������ ��
			new DescripDlg(super.getMf(), title, description);
		} else if(e.getSource() == btnGame[0]) { //�����ϱ� ��ư ������ ��
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