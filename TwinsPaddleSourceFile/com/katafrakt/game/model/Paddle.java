package com.katafrakt.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.katafrakt.game.state.PlayState;
import com.katafrakt.framework.util.*;

public class Paddle {
	
	private float width,height;
	public float x;
	public float y;
	private float velY;
	private Rectangle rect;
	int direction;
	
	PlayState state;
	
	public float speed=3;

	public Paddle(float x, float y, int width, int height,PlayState state,int direction) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.state=state;
		this.direction=direction;
		rect=new Rectangle((int)x,(int)y,width,height);
	}
	public void update(){
		y+=velY;
		//Yazdýr.onlyStr("y: "+y+"  "+PlayState.height);
		if(y<-PlayState.height/2){
			y=-PlayState.height/2;}
		else if(y>PlayState.height/2-height)
			y=PlayState.height/2-height;
		updateRect();
	}
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		//g.fillRect(CoorTrans.xToPix(x), (int)y, (int)width, (int)height);
		CoorTrans.fillRect(g, x, y, width, height);
	}
	public void updateRect(){
		rect.setBounds((int)x, (int)y, (int)width, (int)height);
	}
	public void accelUp(){
		velY=-speed-state.getScore()/200;
	}
	public void accelDown(){
		velY=speed+state.getScore()/200;
	}
	public void stop(){
		velY=0;
	}
	public float getVelY() {
		return velY;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}
	public Rectangle getRect() {
		return rect;
	}
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	
	
}
