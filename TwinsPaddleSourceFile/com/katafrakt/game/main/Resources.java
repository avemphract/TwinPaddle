package com.katafrakt.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Resources {
	public static BufferedImage welcome,iconimage,line,optionBg,background;

	public static BufferedImage[] gravityIndicator;
	
	public static Color darkBlue;
	public static Color darkRed;
	
	public static BufferedImage largePaddleU;
	public static BufferedImage smallPaddleU;
	public static BufferedImage largeBallU;
	public static BufferedImage smallBallU;
	public static BufferedImage gravityLevelU;
	public static BufferedImage gravityPowerU;
	public static BufferedImage ballSpeedUpU;
	public static BufferedImage ballSpeedDownU;
	public static BufferedImage paddleAngleDownU;
	public static BufferedImage paddleAngleUpU;
	public static BufferedImage paddleSpeedU;
	public static BufferedImage bounceUpU;
	public static BufferedImage bounceDownU;
	public static BufferedImage[] offOn;
	
	public static AudioInputStream backgroundMusic;
	public static AudioInputStream hit,bounce;
	public static AudioInputStream menuMusic;
	
	public static void load(){
		welcome=loadImage("menutp.png");
		iconimage=loadImage("iconimage.png");
		line=loadImage("line.png");
		optionBg=loadImage("optiontp.png");
		
		backgroundMusic=loadAudioStream("winterland.wav");
		hit=loadAudioStream("hit.wav");
		bounce=loadAudioStream("bounce.wav");
		menuMusic=loadAudioStream("menumusic.wav");
		
		offOn=new SpriteSheet(loadImage("onoff.png"),32).cropArray(0, 1, 0, 0);
		
		gravityIndicator=new SpriteSheet(loadImage("lonepaddlegravity.png"),64).cropArray(0, 7, 0, 1);
		SpriteSheet uprageSheet= new SpriteSheet(loadImage("lonepaddle.png"),32);
		
		largePaddleU=  uprageSheet.crop(0, 0);
		smallPaddleU= uprageSheet.crop(1, 0);
		largeBallU=uprageSheet.crop(2,0);
		smallBallU=uprageSheet.crop(3,0);
		gravityLevelU=uprageSheet.crop(4,0);
		gravityPowerU=uprageSheet.crop(5,0);
		ballSpeedUpU=uprageSheet.crop(6,0);
		ballSpeedDownU=uprageSheet.crop(7,0);
		paddleAngleDownU=uprageSheet.crop(8,0);
		paddleAngleUpU=uprageSheet.crop(9,0);
		paddleSpeedU=uprageSheet.crop(0,1);
		bounceUpU=uprageSheet.crop(2,1);
		bounceDownU=uprageSheet.crop(3,1);
		
		darkBlue=new Color(25, 83, 105);
		darkRed=new Color(105,13,13);
		
		//astera=loadFont("ASTERA v2.ttf");
		
		background=loadImage("background.png");
	}
	private static AudioInputStream loadAudioStream(String filename){
		AudioInputStream ais=null;
		try {
			URL url=Resources.class.getResource("/resources/"+filename);
			ais=AudioSystem.getAudioInputStream(url);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ais;
	}
	private static BufferedImage loadImage(String filename){
		BufferedImage img = null;
		try {
			img = ImageIO.read(Resources.class.getResourceAsStream("/resources/"+filename));
		} catch (IOException e) {
			System.out.println("Error while reading: " + filename);
			e.printStackTrace();
		}
		return img;
	}
	
}
