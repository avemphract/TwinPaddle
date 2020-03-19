package com.katafrakt.framework.util;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.main.SavedValues;

public class AudioClip {

	AudioInputStream audio;
	Clip clip;
	FloatControl volumeControl;
	
	public static AudioClip playBackgroundClip;
	public static AudioClip menuMusic;
	public static AudioClip hitClip;
	public static AudioClip bounceClip;
	
	public AudioClip(AudioInputStream audio,float volume) {
		this.audio=audio;
		
		//create clip
		try {
			clip=AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//openclip
		try {
			clip.open(audio);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		volumeControl=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		setVolume(volume);
	}
	
	public static void Init(){
		playBackgroundClip=new AudioClip(Resources.backgroundMusic,SavedValues.musicVolume);
		hitClip=new AudioClip(Resources.hit,SavedValues.soundVolume);
		bounceClip=new AudioClip(Resources.bounce,SavedValues.soundVolume);
		menuMusic=new AudioClip(Resources.menuMusic,SavedValues.musicVolume);
	}
	
	public void start(){
		clip.loop(1);
	}
	public void loop(){
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void setVolume(float volume){
		float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
		volumeControl.setValue(dB);
		
	}
	public float getVolume(){
		return (float) (Math.log(volumeControl.getValue()) / Math.log(10.0) * 20.0);
	}
	public void stop(){
		clip.stop();
		clip.setMicrosecondPosition(0);
	}
	public void pause(){
		clip.stop();
	}

}
