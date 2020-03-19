package com.katafrakt.game.model;

import java.awt.Color;
import java.awt.Graphics;

import com.katafrakt.framework.util.CoorTrans;

public class Particle {

	float x;
	float y;
	float size;
	public float life;
	Animation animation;
	
	float velX=0;
	float velY=0;
	
	int opacity=255;
	Color color;
	public Particle(float x, float y, float size, float life,Animation animation) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
		this.life = life;
		this.animation=animation;
		animation.particleList.add(this);
		color=new Color(255, 255, 255, 255);
		
	}
	public void update(){
		x+=velX;
		y+=velY;
		velX+=animation.ball.state.gravity.getAccX();
		velY+=animation.ball.state.gravity.getAccY();
	}
	public void render(Graphics g){
		g.setColor(color);
		CoorTrans.fillRect(g, x, y, size, size);
	}

}
