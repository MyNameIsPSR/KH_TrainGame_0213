package com.kh.game.model.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Talk extends CommonPanel { 
	
	private JPanel talk;
	private int level;
	private int index = 0; //리스트 배열
	//대사를 저장할 리스트
	private ArrayList<String> talkArr = new ArrayList<String>();
	private JPanel gamePanel; //다음 패널, 게임메인화면
	private JButton btnNext, btnPre, btnGameStart; //다음, 이전, 게임시작
	private JLabel talkLabel; //말을 표현해줄 것
	private Image dk; //이미지

	public Talk(MainFrame mf, int level, Player p) {
		super(mf, p);
		this.talk = this; 
		this.level = level;
		
		//패널 설정
		this.setBounds(0, 0, 900, 600);
		this.setLayout(null); 
		

		//각 레벨마다 다른 대사 처리
		switch(level) {
		case 1:
			talkArr.add("어딜 가는 게냐...");
			talkArr.add("뭐 ?! 머리칸으로 가겠다고 ?!");
			talkArr.add("몇년 전 반란을 일으켰던 사람들 중 살아 돌아온 사람은 단 한명도 없었다..");
			talkArr.add("나는 절대로 허락하지 못한다..");
			talkArr.add("혼자서라도 꼭 가야겠다면 나랑 게임을 해서 이겨보거라.");
			talkArr.add("나조차 이기지 못한다면 어차피 무의미한 희생이 늘어날 뿐이야...");
			talkArr.add("게임을 할테냐 ? 아니면 포기하겠느냐...?");
			dk = new ImageIcon("images/TalkLevelOne.png").getImage()
					.getScaledInstance(900, 600, 0);
			break;
		case 2:
			talkArr.add("엔진은 신성하다. 윌포드님은 자비롭다. 그분은 거룩하시다.");
			talkArr.add("엔진이 멈추면 어떻게 되죠 ?");
			talkArr.add("(학생들 : 얼어 죽는다 !!!)");
			talkArr.add("잘했어요 ~");
			talkArr.add("꼬리칸에서 멍청한 손님이 오셨네요.");
			talkArr.add("머리칸에는 거룩하신 윌포드님만 들어가실 수 있어요.");
			talkArr.add("꼬리칸 출신인 당신이 그쪽으로 가는걸 보고있기 거북하군요.");
			talkArr.add("학생들에게 꼬리칸 출신이 얼마나 멍청한지 보여주도록 합니다.");
			talkArr.add("어때요 저랑 게임을 하시겠어요 ???");
			dk = new ImageIcon("images/TalkLevelTwo.png").getImage()
					.getScaledInstance(900, 600, 0);
			break;
		case 3:
			talkArr.add("결국 여기까지 왔군요.");
			talkArr.add("하지만 당신의 허영된 꿈은 여기까지 입니다.");
			talkArr.add("고귀하신 윌포드님에게 당신을 보낼 수는 없어요.");
			talkArr.add("제가 마지막으로 자비를 베풀겠습니다. 얼른 꼬리칸으로 돌아가세요.");
			talkArr.add("저와의 게임은 목숨을 걸어야 할 겁니다.");
			talkArr.add("얼른 선택하시죠.");
			dk = new ImageIcon("images/TalkLevelThree.png").getImage()
					.getScaledInstance(900, 600, 0);
			break;
		} //end switch

		talkLabel = new JLabel(talkArr.get(index++));
		talkLabel.setForeground(Color.WHITE);
		talkLabel.setFont(new Font("굴림체",Font.BOLD,20));
		talkLabel.setBounds(30, 320, 800, 150); 

		JLabel dki = new JLabel(new ImageIcon(dk));
		dki.setBounds(0, 0, 900, 600);

		btnNext = new JButton("Next >");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("굴림체",Font.BOLD,15));
		btnNext.setContentAreaFilled(false);
		btnNext.setBounds(720, 480, 120, 40);
		btnNext.addActionListener(this);

		btnPre = new JButton("포기 할래!");
		btnPre.addActionListener(this);
		btnPre.setFont(new Font("굴림체",Font.BOLD,15));
		btnPre.setForeground(Color.WHITE);
		btnPre.setContentAreaFilled(false);
		btnPre.setBounds(590, 480, 120, 40);
		btnPre.setVisible(false);
		
		btnGameStart = new JButton("도전 할게!");
		btnGameStart.addActionListener(this);
		btnGameStart.setForeground(Color.WHITE);
		btnGameStart.setFont(new Font("굴림체",Font.BOLD,15));
		btnGameStart.setContentAreaFilled(false);
		btnGameStart.setBounds(720, 480, 120, 40);
		btnGameStart.setVisible(false);
		
		this.add(btnNext);
		this.add(btnPre);
		this.add(btnGameStart);
		this.add(talkLabel);
		this.add(dki);

		mf.add(this);
	}

	public void setLevel(int level) {
		this.level = level;
	} //end method

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNext) {
			if(index != talkArr.size()) {
				System.out.println("다음버튼을 눌렀습니다.");
				talkLabel.setText(talkArr.get(index));
			} else { //대화의 끝에서
				System.out.println("대화의 끝입니다.");
				btnNext.setVisible(false);
				talk.remove(btnNext);
				btnPre.setVisible(true);
				btnGameStart.setVisible(true);
			} //end if
			index++;
		} //end if
		if(e.getSource() == btnPre) { //이전버튼 클릭했을 때
			//문지기 클릭 전으로 돌아가기
			ChangePanel.changePanel(super.getMf(), talk,
					new BeforTalk(super.getMf(), super.getP(), level));
		}
		if(e.getSource() == btnGameStart) { //게임하기 버튼 클릭했을 때
			ChangePanel.changePanel(super.getMf(), talk,
					new GameMain(super.getMf(), super.getP(), level));
		} //end if

	} //end method
} 