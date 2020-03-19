package com.katafrakt.game.UI;

import java.awt.Color;
import java.awt.Graphics;

import com.katafrakt.game.state.State;

public class FilledBar {

	int x;
	int y;
	int width;
	int height;
	
	int max=10;
	int current;
	Button up;
	Button down;
	
	State state;
	public FilledBar(int x,int y,int width,int height,State state, float current) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.state=state;
		this.current=(int) (current*10);
		up=new Button(x+width+10+height, y, height, height, null,state){public void pressed(){fillUp();}};
		down=new Button(x-10-height*2, y, height, height, null,state){public void pressed(){fillDown();}};
	}
	public void render(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x-10, y-5, width+20, height+10);
		g.setColor(Color.GREEN);
		for(int i=0;i<current;i++){
			g.fillRect(x+width/max*i, y, width/max, height);
		}
	}
	public void fillUp(){
		if(current<max)
		current++;
		fillChange();
	}
	public void fillDown(){
		if(current>=0)
		current--;
		fillChange();
	}
	public void fillChange(){}
	public float getCurrentRatio() {
		return (float)current/(float)max;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
}
