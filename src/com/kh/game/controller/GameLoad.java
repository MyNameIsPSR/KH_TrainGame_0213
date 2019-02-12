package com.kh.game.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;

import com.kh.game.model.view.ChangePanel;
import com.kh.game.model.view.CrossPanel;
import com.kh.game.model.view.MainFrame;
import com.kh.game.model.view.OXResult;
import com.kh.game.model.view.Player;

public class GameLoad {
	private Player p;
	private JPanel op;
	private MainFrame mf;
	
	public GameLoad() {}
	
	public void load(Player p, JPanel op, MainFrame mf) {
		//플레이어 객체를 받아와서 스테이지 넘버에 따라 패널을 불러온다
		try(ObjectInputStream load = new ObjectInputStream(new FileInputStream("player.dat"))){

			p = (Player)load.readObject();
			
			if(p.getStage() == 1) {
				OXResult loadStage = (OXResult)load.readObject();
				ChangePanel.changePanel(mf, op, loadStage = new OXResult(mf, p));
			}else if(p.getStage() == 2) {
				CrossPanel loadStage = (CrossPanel)load.readObject();
				ChangePanel.changePanel(mf, op, loadStage = new CrossPanel(mf, p));
			}else if(p.getStage() == 3) {
				DifferenceSpot loadStage = (DifferenceSpot)load.readObject();
				ChangePanel.changePanel(mf, op, loadStage = new DifferenceSpot(mf, p));
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

}
