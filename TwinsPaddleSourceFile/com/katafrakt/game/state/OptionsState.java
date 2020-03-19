package com.katafrakt.game.state;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.katafrakt.framework.util.AudioClip;
import com.katafrakt.game.UI.Button;
import com.katafrakt.game.UI.FilledBar;
import com.katafrakt.game.UI.Text;
import com.katafrakt.game.main.GameMain;
import com.katafrakt.game.main.Resources;
import com.katafrakt.game.main.SavedValues;

public class OptionsState extends State {

	Text headLine;
	FilledBar musicVolumeFill;
	FilledBar soundVolumeFill;
	Button backButton;
	Button saveButton;
	
	float tempMusicVolume;
	float tempSoundVolume;
	

	@Override
	public void init() {
		int unit=GameMain.GAME_WIDTH/16;
		tempMusicVolume=SavedValues.musicVolume;
		tempSoundVolume=SavedValues.soundVolume;
		musicVolumeFill=new FilledBar(3*unit,3*unit,10*unit,unit,this,SavedValues.musicVolume){public void fillChange(){tempMusicVolume=musicVolumeFill.getCurrentRatio();}};
		soundVolumeFill=new FilledBar(3*unit,5*unit,10*unit,unit,this,SavedValues.soundVolume){public void fillChange(){tempSoundVolume=soundVolumeFill.getCurrentRatio();}};
		backButton=new Button(1*unit,7*unit,(int)(2.5f*unit),unit, "Back", this){public void pressed(){setCurrentState(new MenuState());}};
		saveButton=new Button(12*unit,7*unit,(int)(2.5f*unit),unit,"Save",this){public void pressed(){SavedValues.musicVolume=tempMusicVolume;
																								  SavedValues.soundVolume=tempSoundVolume;
																								  AudioClip.bounceClip.setVolume(SavedValues.soundVolume);
																								  AudioClip.hitClip.setVolume(SavedValues.soundVolume);
																								  AudioClip.playBackgroundClip.setVolume(SavedValues.musicVolume);
																								  AudioClip.menuMusic.setVolume(SavedValues.musicVolume);}};;
		headLine=new Text(8*unit, (int)(1.5f*unit),new Font("SansSerif",Font.BOLD,80), "Options",Text.Align.center);
	
		AudioClip.menuMusic.loop();
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
		musicVolumeFill.render(g);
		soundVolumeFill.render(g);
		headLine.render(g);
		if(buttonList.size()>0)
			for(Button button:buttonList){
				button.render(g);
			}

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
