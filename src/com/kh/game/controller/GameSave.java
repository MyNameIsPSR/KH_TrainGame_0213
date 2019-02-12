package com.kh.game.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JPanel;

import com.kh.game.model.view.Player;

public class GameSave {
	
	public GameSave() {}
	
	
	public void save(Player p, JPanel panel) {
		//���̺� ���
		//���޹��� �÷��̾� ��ü�� ���޹��� �г��� ����
		try(ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("player.dat"));) {

			
			save.writeObject(p);
			save.writeObject(panel);
			save.flush();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
