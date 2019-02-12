package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.game.controller.GameLoad;


public class StartPanel extends CommonPanel {
	
	private JPanel startPanel;
	private JButton btnNew, btnLoad;

	public StartPanel(MainFrame mf) {
		super(mf, new Player());
		this.startPanel = this;

		//패널 설정
		this.setSize(900, 600);
		this.setBackground(Color.gray);
		this.setLayout(null);
		
		//배경이미지
		Image backImg = new ImageIcon("images/GameMain.png")
				.getImage()
				.getScaledInstance(900, 600, 0);
		JLabel backLabel = new JLabel(new ImageIcon(backImg));
		backLabel.setBounds(0, 0, 900, 600);

		//버튼
		btnNew = new JButton("");
		btnNew.setSize(230, 90);
		btnNew.setLocation(165, 440);
		btnNew.setBorderPainted(false);
		btnNew.setContentAreaFilled(false);
		btnNew.addActionListener(this);
		
		btnLoad = new JButton("");
		btnLoad.setSize(230, 90);
		btnLoad.setLocation(520, 440);
		btnLoad.setBorderPainted(false);
		btnLoad.setContentAreaFilled(false);
		btnLoad.addActionListener(this);

		this.add(btnNew);
		this.add(btnLoad);
		this.add(backLabel);
		mf.add(this);
	} //end constr

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNew) {
			System.out.println("새로하기 버튼을 눌렀습니다.");
			ChangePanel.changePanel(super.getMf(), startPanel, 
					new MakePlayer(super.getMf(), super.getP()));
		} else if(e.getSource() == btnLoad) {
			/*GameLoad load = new GameLoad();
			load.load(sp.p, sp, sp.mf);*/

		}
	} //end method
	
} //end class
