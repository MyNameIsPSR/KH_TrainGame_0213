package com.kh.game.controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.game.model.view.ChangePanel;
import com.kh.game.model.view.CommonPanel;
import com.kh.game.model.view.Ending;
import com.kh.game.model.view.MainFrame;
import com.kh.game.model.view.Munjae1;
import com.kh.game.model.view.Munjae2;
import com.kh.game.model.view.Munjae3;
import com.kh.game.model.view.Player;
import com.kh.game.model.view.TimeLimiter;

public class DifferenceSpot extends CommonPanel{
	private JPanel ds = this;
	public static boolean spot1 = false;
	public static boolean spot2 = false;
	public static boolean spot3 = false;
	private JLabel munjae;
	private JLabel result;
	private int [] x;
	private int [] y;
	private int xRange = 40;
	private int yRange = 20;
	private int life = 3;
	private ImageIcon icon = null;
	private JPanel panel2;
	private JPanel timer;
	private JButton button;
	private JButton button2;
	private JButton npc;
	private DifferenceSpot dif = this;

	public DifferenceSpot(MainFrame mf, Player p) {
		super(mf, p);

		CustomMouseAdapter cma = new CustomMouseAdapter();
		timer = new TimeLimiter(5, this);

		//this.p.setStage(3);
		int random = (int)(Math.random()*3)+1;
		if(random == 1) {
			icon = new ImageIcon("codeImg/q1.PNG");
			x = new int [] {231, 163, 120};
			y = new int [] {166, 214, 291};
			panel2 = new Munjae1();

		}else if (random == 2) {
			icon = new ImageIcon("codeImg/q2.PNG");
			x = new int [] {402, 306, 88};
			y = new int [] {107, 160, 247};
			panel2 = new Munjae2();

		}else if (random == 3) {
			icon = new ImageIcon("codeImg/q3.PNG");
			x = new int [] {248, 98, 207};
			y = new int [] {140, 202, 292};
			panel2 = new Munjae3();
		}

		JLabel title = new JLabel("틀린 그림 찾기");
		title.setLocation(390, 10);
		title.setSize(120, 70);

		result = new JLabel("게임 진행중...");
		result.setLocation(400, 500);
		result.setSize(120, 70);

		munjae = new JLabel(icon);
		munjae.setLocation(150, 70);
		munjae.setSize(600, 350);
		munjae.addMouseListener(cma);

		npc = new JButton("NPC자리");
		npc.setSize(100, 100);
		npc.setLocation(19, 445);
		npc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == npc) {
					JTextArea text = new JTextArea();
					text.setText("안녕");
					text.setLocation(19, 300);
					ds.add(text);

				}

			}
		});

		button = new JButton("게임 클리어 !!! 다음으로 ");
		button.setSize(200, 40);
		button.setLocation(350, 450);
		button.setVisible(false);
		button.addActionListener(this);

		button2 = new JButton("실패했습니다... 이전으로");
		button2.setSize(200, 40);
		button2.setLocation(350, 450);
		button2.setVisible(false);
		button2.addActionListener(this);


		this.add(timer);
		this.add(panel2);
		this.add(npc);
		this.setSize(900, 600);
		this.setLayout(null);
		this.setBackground(Color.gray);
		this.add(title);
		this.add(result);
		this.add(munjae);
		this.add(button);
		this.add(button2);

		mf.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.getMf().getContentPane().removeAll();
		if(e.getSource() == button) { //성공했을 때 대화화면으로 넘어가기
			/*GameSave save = new GameSave();
			save.save(dif.p, dif);*/
			ChangePanel.changePanel(super.getMf(), ds, 
					new Ending(super.getMf(), super.getP()));
		}
		if(e.getSource() == button2) { //실패했을 때 대화화면으로 넘어가기
			/*GameSave save = new GameSave();
			save.save(dif.p, dif);*/
			/*ChangePanel.changePanel(mf, ds, 
					new Talk3(mf, dif.p));*/
		}
	} //end method



	public boolean range(int index, Point p) {

		int pointX = p.x;
		int pointY = p.y;

		return (pointX >=x[index]-xRange) && (pointX <=x[index]+xRange)
				&& (pointY >=y[index]-yRange) && (pointY <=y[index]+yRange);
	}




	class CustomMouseAdapter extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();

			if(range(0,p)) {
				DifferenceSpot.spot1 = true;
				munjae.repaint();
				result.setText("정답입니다!!");
			} else if(range(1,p)) {
				DifferenceSpot.spot2 = true;
				munjae.repaint();
				result.setText("정답입니다!!");
			}else if(range(2,p)) {
				DifferenceSpot.spot3 = true;
				munjae.repaint();
				result.setText("정답입니다!!");
			}else {
				life--;
				result.setText("틀렸습니다...");
			}

			if(spot1 == true && spot2 == true && spot3 == true) {
				button.setVisible(true);
			}
			if(life == 0) {
				button2.setVisible(true);
			}


		}
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("X : " + e.getX() + " Y : " + e.getY());
		}

	}

	public JButton getButton2() {
		return button2;
	}

}























