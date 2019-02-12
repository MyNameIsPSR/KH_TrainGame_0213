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

//OX게임화면(수정 필요!)
public class OXPlay extends CommonPanel{
	
	private JPanel oxPlay;
	private JButton obutton, xbutton;
	private OXPlayManager oxm;
	private ArrayList<String> que; //문제를 저장할 문항
	private int index = 0; //리스트 배열의 인덱스
	private JTextArea jta;
	private JTextField jtf;
	 
	public OXPlay(MainFrame mf, Player p) {
		super(mf, p);
		
		this.oxPlay = this;
		oxm = new OXPlayManager(); //객체 생성
		

		this.setLayout(null);
		this.setBounds(0, 0, 900, 600);
		
		//문제
		que = new ArrayList<String>();
		que.add("1. 연산자 중 우선순위가 가장 낮은 것은 대입연산자이다.");
		que.add("2. 클래스가 가진 인스턴스 변수가 메모리에 할당 될 때의 초기화 순서는 JVM이 정한 기본값 -> 명시적 초기값 -> 초기화블럭 -> 매개변수 있는 생성자 이다.");
		que.add("3. 인스턴스 변수는 메소드 종료시 소멸된다.");
		que.add("4. 클래스의 상속은 다중 상속이 가능하지만, 인터페이스는 단일 상속만 가능하다.");
		que.add("5. OOP의 4대 특징은 추상화, 상속, 다형성, 캡슐화이다.");
		que.add("6. JVM에 의해 관리되는 메모리 중 가장 큰 영역은 Static영역이다.");
		que.add("7. 하나 이상의 catch문을 사용할 경우, 반드시 처리할 예외클래스들의 상속관계를 고려하여 최하위 후손클래스들부터 기술 할 필요는 없다.");
		que.add("8. StringBuffer클래스와 StringBuilder클래스는 기본 동작은 다르나 동기화를 지원한다는 점이 같다.");
		que.add("9. Math.random()은 정적메소드로 객체를 생성하지 않고 사용하며 double형태의 난수만 발생 시킬 수 있다.");
		que.add("10. ArrayList는 일반배열과 같이 인덱스로 객체를 관리한다.");

		//배경이미지설정
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
		
		//호출 될 때 마다 q를 jta에 셋팅함 
		System.out.println(index + "문제가 출제되었습니다.");
		jta.setText(que.get(index++));
		
		obutton = new JButton("O");
		obutton.setFont(new Font("고딕",Font.BOLD,30));
		obutton.setContentAreaFilled(false);
		obutton.setForeground(Color.WHITE);
		obutton.setSize(390,100);
		obutton.setLocation(40,420);
		obutton.addActionListener(this);
		
		xbutton = new JButton("X");
		xbutton.setFont(new Font("고딕",Font.BOLD,30));
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
			System.out.println("O버튼 클릭");
			oxm.addUserAnswer("O");
		} else if(e.getSource() == xbutton) {
			System.out.println("X버튼 클릭");
			oxm.addUserAnswer("X");
		}
		//버튼이 눌렸을 때 다음 문제로 넘어가기
		if(index != que.size()) {
			jtf.setText((index + 1) + "/10");
			jta.setText(que.get(index++));
		} else {
			oxm.chAnswer(); //정답 맞추어 보기
			ChangePanel.changePanel(super.getMf(), oxPlay, 
					new OXResult(super.getMf(), super.getP(), oxm.getCnt()));
		} //end if
	} //end method
	
} //end class
