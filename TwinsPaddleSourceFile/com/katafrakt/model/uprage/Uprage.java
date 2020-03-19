package com.katafrakt.model.uprage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.katafrakt.framework.util.CoorTrans;
import com.katafrakt.framework.util.RandomNumberGenerator;
import com.katafrakt.game.state.PlayState;

public abstract class Uprage {

	public static final int size=64;
	public static int advBuff=0;
	public static int disBuff=0;
	protected float x;
	protected float y;
	private int velX,velY;
	private Rectangle rect;
	protected PlayState state;
	public BufferedImage image;
	public static ArrayList<Uprage> uprageList=new ArrayList<Uprage>();
	
	public Uprage(int x, int y, PlayState state) {
		this.x=x;
		this.y=y;
		this.state=state;
		velX=RandomNumberGenerator.getRandIntBetween(-1,2);
		velY=RandomNumberGenerator.getRandIntBetween(-3, 4);
		rect=new Rectangle(x,y,size,size);
		state.uprageList.add(this);
	}
	public void update(){
		if(x>(100-size+velX)){
			velX=-velX;
			x=+100-size;
		}
		else if(x<(-100+velX)){
			velX=-velX;
			x=-100+velX;
		}
		if(y>(PlayState.height/2-size+velY)){
			velY=-velY;
			y=PlayState.height/2-size+velY;
		}
		else if(y<-PlayState.height/2+velY){
			velY=-velY;
			y=-PlayState.height/2+velY;
		}
		x+=velX;
		y+=velY;
		rect.setBounds((int)x, (int)y, size, size);
		
	}
	public void render(Graphics g){
		CoorTrans.drawImage(g,image, x, y,size,size);
	}
	public Rectangle getRect() {
		return rect;
	}
	public void collide(){
	}
	
	public static void Create( ){
		int creX=-size/2;int creY=RandomNumberGenerator.getRandIntBetween((int)-PlayState.height/2, (int)PlayState.height/2-size);
		float random = RandomNumberGenerator.getRandFloatBetween(0, maxRandom());
		Uprage up;
		//AngleDownUprage
		float max=AngleDownUprage.getRandom();
		float min=0;
		if(random>min&&random<max){
			up= new AngleDownUprage(creX,creY,PlayState.playState);
			return;
		}
		//AngleUpUprage
		min=max;
		max+=AngleUpUprage.getRandom();
		if(random>min&&random<max){
			up= new AngleUpUprage(creX,creY,PlayState.playState);
			return;
		}
		//BounceDownUprage
		min=max;
		max+=BounceDownUprage.getRandom();
		if(random>min&&random<max){
			up= new BounceDownUprage(creX,creY,PlayState.playState);
			return;
		}
		//BounceUpUprage
		min=max;
		max+=BounceUpUprage.getRandom();
		if(random>min&&random<max){
			up=new BounceUpUprage(creX,creY,PlayState.playState);
		}
		//GravityLUprage
		min=max;
		max+=GravityLUprage.getRandom();
		if(random>min&&random<max){
			up= new GravityLUprage(creX,creY,PlayState.playState);
			return;
		}
		//GravityPUprage
		min=max;
		max+=GravityPUprage.getRandom();
		if(random>min&&random<max){
			up= new GravityPUprage(creX,creY,PlayState.playState);
			return;
		}
		//LargeBUprage
		min=max;
		max+=LargeBUprage.getRandom();
		if(random>min&&random<max){
			up= new LargeBUprage(creX,creY,PlayState.playState);
			return;
		}
		//LargePUprage
		min=max;
		max+=LargePUprage.getRandom();
		if(random>min&&random<max){
			up= new LargePUprage(creX,creY,PlayState.playState);
			return;
		}
		//PaddleSpeedUpUprage
		min=max;
		max+=PaddleSpeedUpUprage.getRandom();
		if(random>min&&random<max){
			up= new PaddleSpeedUpUprage(creX,creY,PlayState.playState);
			return;
		}
		//SmallBUprage
		min=max;
		max+=SmallBUprage.getRandom();
		if(random>min&&random<max){
			up= new SmallBUprage(creX,creY,PlayState.playState);
			return;
		}
		//SmallPUprage
		min=max;
		max+=SmallPUprage.getRandom();
		if(random>min&&random<max){
			up= new SmallPUprage(creX,creY,PlayState.playState);
			return;
		}
		//SpeedDownUprage
		/*min=max;
		max+=SpeedDownUprage.getRandom();
		if(random>min&&random<max){
			up= new SpeedDownUprage(creX,creY,PlayState.playState);
			return;
		}*/
		//SpeedUpUprage
		min=max;
		max+=SpeedUpUprage.getRandom();
		if(random>min&&random<max){
			up= new SpeedUpUprage(creX,creY,PlayState.playState);
			return;
		}

	}
	public static float maxRandom(){
		float i=0;
		i+=AngleDownUprage.getRandom();
		i+=AngleUpUprage.getRandom();
		i+=BounceDownUprage.getRandom();
		i+=BounceUpUprage.getRandom();
		i+=GravityLUprage.getRandom();
		i+=GravityPUprage.getRandom();
		i+=LargeBUprage.getRandom();
		i+=LargePUprage.getRandom();
		i+=PaddleSpeedUpUprage.getRandom();
		i+=SmallBUprage.getRandom();
		i+=SmallPUprage.getRandom();
		//i+=SpeedDownUprage.getRandom();
		i+=SpeedUpUprage.getRandom();
		return i;
	}
	public static float getRandom(){return 0;}
	
}
