package com.katafrakt.framework.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.katafrakt.game.state.State;

public class InputHandler implements KeyListener, MouseListener,MouseMotionListener {

	private State currentState;
	public void setCurrentState(State currentState){
		this.currentState=currentState;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		currentState.onClick(arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		currentState.onKeyPress(arg0);
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		currentState.onKeyRelease(arg0);
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		currentState.mouseMoved(arg0);
		
	}

}
