package com.katafrakt.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.katafrakt.framework.util.AudioClip;
import com.katafrakt.game.main.Resources;

public class LoadState extends State {

	@Override
	public void lateInýt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		Resources.load();
		AudioClip.Init();
		
	}
	public void quit(){
		
	}

	@Override
	public void update() {
		setCurrentState(new MenuState());
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
