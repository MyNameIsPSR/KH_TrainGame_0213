package com.kh.game.model.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class GamePanel extends JPanel{
	private CrossPanel cp;
	private JPanel GamePanel;
	private GameBoard gb;
	private GamePanel gp = this;

	public GamePanel(CrossPanel cp, GameBoard gb) {
		this.cp = cp;
		this.GamePanel = this;
		this.gb = gb;

		this.setSize(800, 445);
		this.setBackground(Color.white);
		this.setLocation(45, 80);
		this.setLayout(null);

		ResultPanel rp = new ResultPanel(this);
		
		JButton button1 = new JButton("다시풀기");
		JButton button2 = new JButton("정답확인");
		JButton button3 = new JButton("Next");
		JButton button4 = new JButton("확인");

		button1.setSize(100, 30);
		button2.setSize(100, 30);
		button3.setSize(120, 40);
		button4.setSize(100, 35);

		button1.setLocation(190, 413);
		button2.setLocation(298, 413);
		button3.setLocation(660, 403);
		button4.setLocation(245, 320);

		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < gb.tf.length; i++) {
					for(int j = 0; j < gb.tf[i].length; j++) {
						gb.tf[i][j].setText("");
					}
				}
			}
		});
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < gb.tf.length; i++) {
					for(int j = 0; j < gb.tf[i].length; j++) {
						gb.tf[i][j].setEditable(false);
					}
				}
				GamePanel.add(button3);
				GamePanel.add(button4);
				GamePanel.remove(gp.gb);
				GamePanel.add(rp);
				GamePanel.repaint();
			}
		});
		
		cp.setBtnNext(button3);
		button3.addActionListener(cp);
		
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePanel.remove(button4);
				GamePanel.add(gp.gb);
				GamePanel.remove(rp);
				GamePanel.repaint();
			}
		});

		JTextArea munjae = new JTextArea("<가로문제>\n\n" + 
				"1. Primitive Data Type을 객체화해주는 클래스는?\n\n" + 
				"2. 어떤 변수가 값을 가지지 않음을 나타내는 특별한 값은?\n\n" + 
				"3. 반복문을 빠져나갈 때 사용하는 구문은?\n\n" + 
				"4. 조건식의 결과값이 true일 때 블록 안의 내용을 실행하고 false일 때는 실행하지 않는 제어문은? \n\n" + 
				"5. Date 클래스의 gettime 메소드 사용 시 return 받는 값의 자료형은?\n\n" + 
				"6. 배열의 길이를 확인할 수 있는 구문은?\n\n\n" + 
				"<세로문제>\n\n" + 
				"1. heap 메모리에 객체를 생성하고 stack에 주소값을 넣어주는 연산자는?\n\n" + 
				"2. 자신을 호출한 메소드로 돌아가는 구문은?\n\n" + 
				"3. 접근제한자 중 어디에서든 접근이 가능한 것은?\n\n" + 
				"4. byte * short 연산 시 결과값의 자료형은?\n\n" + 
				"5. 접근제한자 중 범위가 가장 좁은 것?\n\n" + 
				"6. 출력문에서 데이터를 출력하고 자동으로 줄바꿈 처리를 해주는 메소드는?");

		munjae.setBounds(400, 0, 400, 400);
		munjae.setLineWrap(true);
		munjae.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		munjae.setEditable(false);

		JScrollPane scroller = new JScrollPane(munjae, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scroller.setSize(400, 400);
		scroller.setLocation(400, 0);
		
		this.add(scroller);

		this.add(button1);
		this.add(button2);
		this.add(gb);
		cp.add(this);
	}
}
