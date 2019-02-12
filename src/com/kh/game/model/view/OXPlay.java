package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kh.game.controller.OXPlayManager;

//OX����ȭ��(���� �ʿ�!)
public class OXPlay extends CommonPanel{
	
	private JPanel oxPlay;
	private JButton obutton, xbutton;
	private OXPlayManager oxm;
	private ArrayList<String> que; //������ ������ ����
	private int index = 0; //����Ʈ �迭�� �ε���
	private JTextArea jta;
	private JTextField jtf;
	 
	public OXPlay(MainFrame mf, Player p) {
		super(mf, p);
		
		this.oxPlay = this;
		oxm = new OXPlayManager(); //��ü ����
		

		this.setLayout(null);
		this.setBounds(0, 0, 900, 600);
		
		//����
		que = new ArrayList<String>();
		que.add("1. ������ �� �켱������ ���� ���� ���� ���Կ������̴�.");
		que.add("2. Ŭ������ ���� �ν��Ͻ� ������ �޸𸮿� �Ҵ� �� ���� �ʱ�ȭ ������ JVM�� ���� �⺻�� -> ����� �ʱⰪ -> �ʱ�ȭ�� -> �Ű����� �ִ� ������ �̴�.");
		que.add("3. �ν��Ͻ� ������ �޼ҵ� ����� �Ҹ�ȴ�.");
		que.add("4. Ŭ������ ����� ���� ����� ����������, �������̽��� ���� ��Ӹ� �����ϴ�.");
		que.add("5. OOP�� 4�� Ư¡�� �߻�ȭ, ���, ������, ĸ��ȭ�̴�.");
		que.add("6. JVM�� ���� �����Ǵ� �޸� �� ���� ū ������ Static�����̴�.");
		que.add("7. �ϳ� �̻��� catch���� ����� ���, �ݵ�� ó���� ����Ŭ�������� ��Ӱ��踦 ����Ͽ� ������ �ļ�Ŭ��������� ��� �� �ʿ�� ����.");
		que.add("8. StringBufferŬ������ StringBuilderŬ������ �⺻ ������ �ٸ��� ����ȭ�� �����Ѵٴ� ���� ����.");
		que.add("9. Math.random()�� �����޼ҵ�� ��ü�� �������� �ʰ� ����ϸ� double������ ������ �߻� ��ų �� �ִ�.");
		que.add("10. ArrayList�� �Ϲݹ迭�� ���� �ε����� ��ü�� �����Ѵ�.");

		//����̹�������
		JLabel backImg = new JLabel(new ImageIcon
				(new ImageIcon("images/OrienBack.png")
				.getImage()
				.getScaledInstance(900, 600, 0)));
		backImg.setBounds(0, 0, 900, 600);
		
		jtf = new JTextField(50);
		jtf.setText((index + 1) + "/10");
		jtf.setBackground(Color.BLACK);
		jtf.setForeground(Color.WHITE);
		jtf.setSize(800,50);
		jtf.setLocation(40, 40);
		
		jta = new JTextArea();
		jta.setSize(800, 300);
		jta.setLocation(40, 100);
		jta.setEditable(false);
		
		//ȣ�� �� �� ���� q�� jta�� ������ 
		System.out.println(index + "������ �����Ǿ����ϴ�.");
		jta.setText(que.get(index++));
		
		obutton = new JButton("O");
		obutton.setFont(new Font("���",Font.BOLD,30));
		obutton.setContentAreaFilled(false);
		obutton.setForeground(Color.WHITE);
		obutton.setSize(390,100);
		obutton.setLocation(40,420);
		obutton.addActionListener(this);
		
		xbutton = new JButton("X");
		xbutton.setFont(new Font("���",Font.BOLD,30));
		xbutton.setContentAreaFilled(false);
		xbutton.setForeground(Color.WHITE);
		xbutton.setSize(390,100);
		xbutton.setLocation(450,420);
		xbutton.addActionListener(this);
		
		this.setLayout(null);
		this.add(jtf);
		this.add(jta);
		this.add(obutton);
		this.add(xbutton);
		this.add(backImg);
		System.out.println(que.size());
		mf.add(this);
	} //end constr
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == obutton) {
			System.out.println("O��ư Ŭ��");
			oxm.addUserAnswer("O");
		} else if(e.getSource() == xbutton) {
			System.out.println("X��ư Ŭ��");
			oxm.addUserAnswer("X");
		}
		//��ư�� ������ �� ���� ������ �Ѿ��
		if(index != que.size()) {
			jtf.setText((index + 1) + "/10");
			jta.setText(que.get(index++));
		} else {
			oxm.chAnswer(); //���� ���߾� ����
			ChangePanel.changePanel(super.getMf(), oxPlay, 
					new OXResult(super.getMf(), super.getP(), oxm.getCnt()));
		} //end if
	} //end method
	
} //end class
