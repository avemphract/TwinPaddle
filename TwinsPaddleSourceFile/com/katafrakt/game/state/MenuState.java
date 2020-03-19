package com.katafrakt.game.state;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.katafrakt.framework.util.AudioClip;
import com.katafrakt.game.UI.Button;
import com.katafrakt.game.UI.Text;
import com.katafrakt.game.main.GameMain;
import com.katafrakt.game.main.Resources;

public class MenuState extends State {

	Font scoreFont;
	Font astera;
	Button playButton;
	Button optionsButton;
	Button infoButton;
	Text headLine;

	@Override
	public void init() {
		int unit=GameMain.GAME_WIDTH/16;
		scoreFont= new Font("SansSerif",Font.BOLD,GameMain.GAME_WIDTH/40);
		playButton=new Button(5*unit,(int)(4*unit),6*unit,unit,"Play",this){public void pressed(){setCurrentState(new PlayState());}};
		infoButton=new Button(5*unit,(int)(5.5*unit),6*unit,unit,"Tutorial",this){public void pressed(){setCurrentState(new TutorialState());}};
		optionsButton=new Button(5*unit,(int)(7*unit),6*unit,unit,"Options",this){public void pressed(){setCurrentState(new OptionsState());}};
		headLine=new Text(8*unit, (int)(2f*unit),new Font("SansSerif",Font.BOLD,100), "TwinPaddles",Text.Align.center);
		AudioClip.menuMusic.loop();
		
		
	}

	@Override
	public void lateInýt() {
		
		
	}
	public void quit(){
		AudioClip.menuMusic.pause();
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.background,0,0,null);
		playButton.render(g);
		infoButton.render(g);
		optionsButton.render(g);
		headLine.render(g);
		
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
		System.out.println("Key pressed"+e);
		
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		System.out.println("Key release"+e);
		
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
