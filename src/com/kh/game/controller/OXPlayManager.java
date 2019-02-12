package com.kh.game.controller;

import java.util.ArrayList;

public class OXPlayManager {
	
	private ArrayList<String> userAnswer; //사용자가 입력한 정답
	private ArrayList<String> answer = new ArrayList<String>();
	private int cnt = 0; //틀린갯수

	public OXPlayManager() {
		
		userAnswer = new ArrayList<String>(); //리스트 객체 생성
				
		answer.add("X");
		answer.add("O");
		answer.add("X");
		answer.add("X");
		answer.add("O");
		answer.add("X");
		answer.add("X");
		answer.add("X");
		answer.add("O");
		answer.add("O");
	
	} //end constr

	public void addUserAnswer(String str) { //사용자가 정답을 입력했을 때
		userAnswer.add(str); //전달받은 값을 배열에 저장
	} //end method

	public void chAnswer() { //입력한 값과 정답을 비교하기
		for(int i = 0; i < answer.size(); i++) {
			if(userAnswer.get(i).equals(answer.get(i))) {
				continue;
			}else {
				cnt++;
			} //end if
		} //end for
		System.out.println("틀린 갯수 : " + cnt);
		setCnt(cnt);
	} //end method

	public int getCnt() {
		System.out.println("getCnt() 호출...");
		return cnt;
	}

	public void setCnt(int cnt) {
		System.out.println("setCnt() 호출...");
		this.cnt = cnt;
	}
	

} //end class
