package com.kh.game.controller;

import java.util.ArrayList;

import com.kh.game.model.view.BeforTalk;
import com.kh.game.model.view.ChangePanel;
import com.kh.game.model.view.CommonPanel;
import com.kh.game.model.view.CrossPanel;
import com.kh.game.model.view.MainFrame;
import com.kh.game.model.view.OXResult;
import com.kh.game.model.view.Player;
import com.kh.game.model.view.Talk;
import com.kh.game.model.view.isPassTalk;

public class GameManager {
	private MainFrame mf;
	private Player p;
	private String imgAdd;
	private CommonPanel oldPane;
	private CommonPanel newPane;
	private ArrayList<String> talkArr;
	private int level;
	private boolean isPass;

	public GameManager(MainFrame mf, int level, 
			boolean isPass, Player p, CommonPanel oldPane) {

		this.mf = mf;
		this.level = level;
		this.isPass = isPass;
		this.p = p;

		talkArr = new ArrayList<String>();

		switch(level) {
		case 1:
			imgAdd = "images/TalkLevelOne.png";
			this.oldPane = (OXResult)(oldPane);
			if(isPass) {
				talkArr.add("그래... 나로서는 너를 막지 못하겠구나...");
				talkArr.add("다음 칸으로 가는 문을 열어주마..");
				talkArr.add("이번에는 제발 무의미한 희생이 아니기를...");
				//newPane = (Talk)(new Talk(mf, 2, p));
			} else { 
				talkArr.add("나조차 이기지 못하면서 머리칸이라니...");
				talkArr.add("이런 삶이 억울하다면 좀 더 공부하여 도전하거라...");
				//newPane = (BeforTalk)(new BeforTalk(mf, p, level));
			} //end if
			break;
		case 2:
			imgAdd = "images/TalkLevelTwo.png";
			this.oldPane = (CrossPanel)(oldPane);
			if(isPass) { 
				talkArr.add("내가 지다니...");
				talkArr.add("더러운 꼬리칸 출신답게 속임수를 썼을 거야...");
				talkArr.add("내가 꼬리칸 사람에게 졌을리가 없어...");
				talkArr.add("(중-얼 중-얼 중-얼 중-얼)");
				//newPane = (Talk)(new Talk(mf, 3, p));
			} else { 
				talkArr.add("학생들에게 좋은 교육이 되었을 것 같군요.");
				talkArr.add("여러분, 꼬리칸 사람들은 다 이렇게 멍청하답니다.");
				talkArr.add("월포드여 영원하라 !!!");
				//newPane = (BeforTalk)(new BeforTalk(mf, p, level));
			} //end if
			break;
		case 3:
			imgAdd = "images/TalkLevelThree.png";
			if(isPass) { 

			} else { 
				talkArr.add("정말로 어리석군요...");
				talkArr.add("자비를 베풀었음에도 저에게 도전하다니...");
				talkArr.add("당신의 여정은 결국 여기까지 입니다.");
				//newPane = (BeforTalk)(new BeforTalk(mf, p, level));
			} //end if
			break;
		} //end switch
		ChangePanel.changePanel(mf, oldPane, 
				new isPassTalk(mf, p, talkArr, imgAdd, this));
		System.out.println("GameManager - 성공적 호출");
	} //end constr

	public void changPanel(isPassTalk isPt) {
		switch(level) {
		case 1:
			if(isPass) { //1단계에서 통과했을 때 2단계 문지기 화면으로 넘어가기
				ChangePanel.changePanel(mf, isPt, 
						new BeforTalk(mf, p, 2));
			} else { //불통했을 때 1단계 문지기 화면 으로 가기
				ChangePanel.changePanel(mf, isPt, 
						new BeforTalk(mf, p, 1));
				//수정!양갱 한개 뺏기
				//양갱 한개 뺏기 추가
				p.setLife(p.getLife()-1);
			}
			break;
		case 2:
			if(isPass) { //2단계에서 통과했을 때 3단계 문지기 화면으로 넘어가기
				ChangePanel.changePanel(mf, isPt, 
						new BeforTalk(mf, p, 3));
			} else { //2단계에서 불통했을 때 2단계 문지기 화면으로 넘어가기
				ChangePanel.changePanel(mf, isPt, 
						new BeforTalk(mf, p, 2));
				//수정! 양갱 한 개 뺏기
				//양갱 한개 뺏기 추가
				p.setLife(p.getLife()-1);
			}
			break;
		case 3:
			if(isPass) { //3단계에서 통과 했을 때
				
			} else { //3단계 불통 했을 때 3단계 문지기 화면으로 넘어가기
				ChangePanel.changePanel(mf, isPt, 
						new BeforTalk(mf, p, 3));
				//수정! 양갱 한 개 뺏기
				//양갱 한개 뺏기 추가
				p.setLife(p.getLife()-1);
			}
			break;
		} //end switch
	} //end method

} //end class
