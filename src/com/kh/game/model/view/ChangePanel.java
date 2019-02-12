package com.kh.game.model.view;

import javax.swing.JPanel;

public class ChangePanel { //패널 교체 클래스
 
	public static void changePanel(MainFrame mf, JPanel op, JPanel np) {
		mf.remove(op); //프레임에서 패널이 사라짐
		mf.add(np); //프레임에 새로운 패널 추가
		
		mf.repaint(); //컴포넌트를 다시 그려줌
	} //end method

} //end class
