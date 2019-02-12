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

		//�г� ����
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);

		//��׶��� �̹���
		JLabel backImg = new JLabel
				(new ImageIcon(new ImageIcon("images/Prolog.png")
				.getImage()
				.getScaledInstance(900, 600, 0)));
		backImg.setBounds(0, 0, 900, 600);

		//��ư
		JButton btnStart = new JButton("���� ����");
		btnStart.setBounds(650, 490, 150, 40);
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("����ü",Font.BOLD,15));
		btnStart.setContentAreaFilled(false);
		btnStart.addActionListener(this);

		//�гο� �߰�
		this.add(btnStart);
		this.add(backImg);

		mf.add(this);
	} //end method

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Prolog - ���ӽ��� ��ư Ŭ��");
		ChangePanel.changePanel(super.getMf(), prolog,
				new BeforTalk(super.getMf(), super.getP(), 1));
	} //end method

} //end class
