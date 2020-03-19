package com.katafrakt.game.model;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.katafrakt.framework.util.AudioClip;
import com.katafrakt.framework.util.CoorTrans;
import com.katafrakt.framework.util.RandomNumberGenerator;
import com.katafrakt.framework.util.Trigonometri;
import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class Ball {
	private float size;
	private float x,y,velX,velY;
	private Rectangle rect;

	public float angle=35;
	public int direction=1;
	
	public float bounce=1;
	
	public PlayState state;
	
	public float speed;
	
	AudioClip bounceClip;
	Animation animation;
	
	
	public Ball(float x,float y,int size,PlayState state){
		this.x=x;
		this.y=y;
		this.size=size;
		this.state=state;
		velX=5;
		velY=RandomNumberGenerator.getRandIntBetween(-4, 5);
		rect=new Rectangle((int)x,(int)y,size,size);
		speed=6;
		bounceClip=new AudioClip(Resources.bounce, 1);
		animation=new Animation(this);
	}
	public void update(){
		x+=velX;
		y+=velY;
		velX+=state.gravity.getAccX();
		velY+=state.gravity.getAccY();
		correctYCollisions();
		updateRect();
		animation.update();
		animation.addParitcle((int)x, (int)y, (int)size, (int)size);
		
	}
	public void render(Graphics g) {
		animation.render(g);
		CoorTrans.fillRect(g,x, y, size, size);
		//g.drawRect((int)x,(int)y,(int)size,(int)size);
	}
	private void correctYCollisions(){
		if(y<-PlayState.height/2)
			y=-PlayState.height/2;
		else if(y>PlayState.height/2-size)
			y=PlayState.height/2-size;
		else return;
		velY=-velY*bounce;
		bounceClip.start();
	}
	private void updateRect(){
		rect.setBounds((int)x,(int)y,(int)size,(int)size);
	}
	public void onCollideWith(Paddle p){

		float ang=RandomNumberGenerator.getRandFloatBetween(Trigonometri.angleToRadian(-angle),Trigonometri.angleToRadian(angle));
		velX=(float) ((float)p.direction * Math.cos(ang)*(speed+state.getScore()/100));
		velY=(float) ((float) Math.sin(ang)*speed-Math.sin(state.gravity.angle)*state.gravity.power*200/speed);
	}
	public boolean isDead(){
		return(x<-PlayState.width/2 ||x+size>PlayState.width/2);
	}
	public void reset(){
		x=0;
		y=0;
		velX=5;
		velY=RandomNumberGenerator.getRandIntBetween(-4,5);
	}
	public float getX() {
		return x;
	}
	public float getY() {	
		return y;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float f) {
		this.size = f;
	}
	public Rectangle getRect(){
		return rect;
	}
	

}