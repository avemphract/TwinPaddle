package com.katafrakt.game.main;

import javax.swing.JFrame;

public class GameMain {

	public static final String GAME_TITLE="Lone Ball";
	public static final int GAME_WIDTH=1200;
	public static final int GAME_HEIGHT=900/4*3;
	public static Game sGame;
	public static void main(String[] args){
		JFrame jFrame=new JFrame(GAME_TITLE);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(false);
		sGame =new Game(GAME_WIDTH,GAME_HEIGHT);
		jFrame.add(sGame);
		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setIconImage(Resources.iconimage);
	}
}
