package com.katafrakt.game.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.katafrakt.framework.util.Trigonometri;
import com.katafrakt.game.main.GameMain;
import com.katafrakt.game.main.Resources;

public class Gravity {
	public int level=0;
	public float angle=90;
	public float power=0.01f;
	
	private float accX;
	private float accY;
	
	public Gravity() {
		
	}
	public void render(Graphics g){
		if(level!=0){
			g.drawImage(getGravity(),32 , GameMain.GAME_HEIGHT-64,null);
		}
	}
	public void update(){
		if(level==0)
			return;
		if(level>1)
			angle=angle+(float)level/50;
		//Yazdýr.strAndDou("angle", angle);
		accX=(float) (power*Math.cos(Trigonometri.angleToRadian(angle)));
		accY=(float) (power*Math.sin(Trigonometri.angleToRadian(angle)));
		
	}
	private BufferedImage getGravity(){
		int cur=(int)((-angle+45/4)/(45/2)+4);
		while(cur<0)
			cur+=16;
		cur=cur%16;
		return Resources.gravityIndicator[cur];
	}
	public float getAccX() {
		return accX;
	}
	public void setAccX(float accX) {
		this.accX = accX;
	}
	public float getAccY() {
		return accY;
	}
	public void setAccY(float accY) {
		this.accY = accY;
	}

}
