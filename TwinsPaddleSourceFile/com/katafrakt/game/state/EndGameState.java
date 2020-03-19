package com.katafrakt.game.state;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.katafrakt.game.UI.Button;
import com.katafrakt.game.UI.Text;
import com.katafrakt.game.main.GameMain;
import com.katafrakt.game.main.Resources;
import com.katafrakt.game.main.SavedValues;
import com.katafrakt.model.uprage.Uprage;

public class EndGameState extends State {

	Text scoreText;
	Text multiText;
	Text nerfText;
	Text buffText;
	Text mapSizeText;
	Button replayButton;
	Button menuButton;
	
	@Override
	public void init() {
		int unit=GameMain.GAME_WIDTH/16;
		if(PlayState.playState.getScore()<SavedValues.highScore)
			scoreText=new Text(unit*8, unit, new Font("SansSerif",Font.BOLD,50), "Score: "+Float.toString(PlayState.playState.getScore()),Text.Align.center);
		else{
			scoreText=new Text(unit*8, unit, new Font("SansSerif",Font.BOLD,50), "!New High Score: "+Float.toString(PlayState.playState.getScore()),Text.Align.center);
			SavedValues.highScore=PlayState.playState.getScore();
		}
		multiText=new Text(unit*8,unit*2,new Font("SansSerif",Font.BOLD,50),"Multipier: "+Float.toString(PlayState.playState.multiplier),Text.Align.center);
		nerfText=new Text(unit*4,unit*3,new Font("SansSerif",Font.BOLD,50),"Nerfs: "+Float.toString(Uprage.disBuff),Text.Align.center);
		buffText=new Text(unit*12,unit*3,new Font("SansSerif",Font.BOLD,50),"Buffs: "+Float.toString(Uprage.advBuff),Text.Align.center);
		mapSizeText=new Text(unit*8,unit*4,new Font("SansSerif",Font.BOLD,50),"Map Width: "+Float.toString(PlayState.playState.width),Text.Align.center);
		replayButton=new Button(4*unit, (int)(4.5f*unit), 8*unit, (int)(1.5f*unit), "RePlay", this){public void pressed(){setCurrentState(new PlayState());}};
		menuButton=new Button(6*unit, 7*unit, 4*unit, unit, "Menu", this){public void pressed(){setCurrentState(new MenuState());}};
		

	}

	@Override
	public void lateInýt() {
		// TODO Auto-generated method stub

	}
	public void quit(){
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.background, 0, 0, null);
		int k=0;
		int l=1;
		for(Uprage u:Uprage.uprageList){
			g.drawImage(u.image,k*Uprage.size,GameMain.GAME_HEIGHT-l*Uprage.size,Uprage.size,Uprage.size,null);
			k++;
			if(k>(GameMain.GAME_WIDTH/Uprage.size-1)){
				l++;
				k=0;
			}
		}
		if(buttonList.size()>0)
			for(Button button:buttonList){
				button.render(g);
			}
		scoreText.render(g);
		multiText.render(g);
		nerfText.render(g);
		buffText.render(g);
		mapSizeText.render(g);
		

	}

	@Override
	public void onClick(MouseEvent e) {
		if(buttonList.size()>0)
			for(Button button:buttonList){
				if(button.boundary(e))
					button.pressed();
			}
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
		if(buttonList.size()>0)
			for(Button button:buttonList){
				if(button.boundary(e))
					button.mouseEntered();
				else
					button.mouseExit();
			}

	}

}
