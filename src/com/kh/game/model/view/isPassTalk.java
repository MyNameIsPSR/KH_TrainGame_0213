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
	private JLabel talkLabel; //���� ǥ������ ��
	private int index = 0; //����Ʈ �迭
	private JButton btnNext;
	private GameManager gm;

	public isPassTalk(MainFrame mf, Player p, 
			ArrayList<String> talkArr, String imgAdd, GameManager gm) {
		//�ʱ�ȭ
		super(mf, p);
		this.isPt = this;
		this.talkArr = talkArr;
		this.imgAdd = imgAdd;
		this.gm = gm;

		//�г� ����
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null);

		//��ȭȭ��
		Image backImg = new ImageIcon(imgAdd)
				.getImage()
				.getScaledInstance(900, 600, 0);
		JLabel backLabel = new JLabel(new ImageIcon(backImg));
		backLabel.setBounds(0, 0, 900, 600);

		//��ȭ ǥ��
		talkLabel = new JLabel(talkArr.get(index++));
		talkLabel.setForeground(Color.WHITE);
		talkLabel.setFont(new Font("����ü",Font.BOLD,20));
		talkLabel.setBounds(30, 320, 800, 150); 

		btnNext = new JButton("Next >");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("����ü",Font.BOLD,15));
		btnNext.setContentAreaFilled(false);
		btnNext.setBounds(720, 480, 120, 40);
		btnNext.addActionListener(this);

		this.add(btnNext);
		this.add(talkLabel);
		this.add(backLabel);

		mf.add(this);
		System.out.println("isPassTalk - ������ ȣ��");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNext) {
			if(index != talkArr.size()) {
				System.out.println("������ư�� �������ϴ�.");
				talkLabel.setText(talkArr.get(index));
			} else { //��ȭ�� ������
				gm.changPanel(this);
			} //end if
			index++;
		}
	}
} //end class
