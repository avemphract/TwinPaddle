package com.katafrakt.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.katafrakt.game.UI.Button;
import com.katafrakt.game.main.GameMain;

public abstract class State {
	public ArrayList<Button> buttonList=new ArrayList<Button>();

	public abstract void init();
	
	public abstract void lateInýt();
	
	public abstract void quit();
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick(MouseEvent e);
	
	public abstract void onKeyPress(KeyEvent e);
	
	public abstract void onKeyRelease(KeyEvent e);
	
	public abstract void mouseMoved(MouseEvent e);
	
	public void setCurrentState(State newState){
		GameMain.sGame.setCurrentState(newState);
	}
}


