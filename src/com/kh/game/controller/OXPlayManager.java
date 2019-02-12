package com.kh.game.controller;

import java.util.ArrayList;

public class OXPlayManager {
	
	private ArrayList<String> userAnswer; //����ڰ� �Է��� ����
	private ArrayList<String> answer = new ArrayList<String>();
	private int cnt = 0; //Ʋ������

	public OXPlayManager() {
		
		userAnswer = new ArrayList<String>(); //����Ʈ ��ü ����
				
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

	public void addUserAnswer(String str) { //����ڰ� ������ �Է����� ��
		userAnswer.add(str); //���޹��� ���� �迭�� ����
	} //end method

	public void chAnswer() { //�Է��� ���� ������ ���ϱ�
		for(int i = 0; i < answer.size(); i++) {
			if(userAnswer.get(i).equals(answer.get(i))) {
				continue;
			}else {
				cnt++;
			} //end if
		} //end for
		System.out.println("Ʋ�� ���� : " + cnt);
		setCnt(cnt);
	} //end method

	public int getCnt() {
		System.out.println("getCnt() ȣ��...");
		return cnt;
	}

	public void setCnt(int cnt) {
		System.out.println("setCnt() ȣ��...");
		this.cnt = cnt;
	}
	

} //end class
