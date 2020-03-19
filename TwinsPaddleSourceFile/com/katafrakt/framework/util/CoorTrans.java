package com.katafrakt.framework.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.katafrakt.game.main.GameMain;
import com.katafrakt.game.state.PlayState;

public class CoorTrans {
	public static int xToPix(float x){
		float k=(float)GameMain.GAME_WIDTH/(float)PlayState.width;
		float res=((float)PlayState.width/2+x)*k;
		//Yazdýr.onlyStr("X: "+x);
		return (int)res;
	}
	public static int yToPix(float y){
		float k=(float) GameMain.GAME_HEIGHT/(float)PlayState.height;
		float res=((float)PlayState.height/2+y)*k;
		return (int)res;
	}
	public static int xLenToPix(float lenght){
		float k=(float)GameMain.GAME_WIDTH/(float)PlayState.width;
		float res=lenght*k;
		return (int)res;
	}
	public static int yLenToPix(float lenght){
		float k=(float)GameMain.GAME_HEIGHT/(float)PlayState.height;
		float res=lenght*k;
		//Yazdýr.onlyStr(res+"");
		//Yazdýr.onlyStr(k+"");
		return (int)res;
	}
	
	public static void drawRect(Graphics g,float x,float y,float width,float height){
		g.drawRect(xToPix(x), yToPix(y), xLenToPix(width), yLenToPix(height));
	}
	public static void fillRect(Graphics g,float x,float y,float width,float height){
		g.fillRect(xToPix(x), yToPix(y), xLenToPix(width), yLenToPix(height));
	}
	public static void drawImage(Graphics g,BufferedImage image,float x,float y){
		g.drawImage(image, xToPix(x), yToPix(y), null);
	}
	public static void drawImage(Graphics g,BufferedImage image,float x,float y,float width,float height){
		g.drawImage(image, xToPix(x), yToPix(y), xLenToPix(width), yLenToPix(height),null);
	}

}
