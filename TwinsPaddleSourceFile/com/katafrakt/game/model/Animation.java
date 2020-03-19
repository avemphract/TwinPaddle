package com.katafrakt.game.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import com.katafrakt.framework.util.RandomNumberGenerator;

public class Animation {

	int lifeSpan=4;
	int size=2;
	public ArrayList<Particle> particleList=new ArrayList<Particle>();
	Ball ball;
	
	public Animation(Ball ball) {
		this.ball=ball;
	}
	public void addParitcle(int x,int y,int width,int height){
		int particleX=RandomNumberGenerator.getRandIntBetween(x, x+width-size);
		int particleY=RandomNumberGenerator.getRandIntBetween(y, y+height-size);
		int particleLifeSpan=RandomNumberGenerator.getRandIntBetween(lifeSpan-3, lifeSpan+3);
		new Particle(particleX, particleY, size, particleLifeSpan, this);
		
		
	}
	public void update(){
		if(particleList.size()>0){
			Iterator<Particle> var =particleList.iterator();
			while(var.hasNext()){
				Particle p=var.next();
				p.life-=0.1f;
				p.update();
				if(p.life<0)
					var.remove();
			}
		}
	}
	public void render(Graphics g){
		for(Particle particle:particleList)
			particle.render(g);
	}

}
