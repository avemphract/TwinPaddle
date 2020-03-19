package com.katafrakt.game.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Text {
	public enum Align{left,center,right};
	
	int x,y;
	
	String str;
	Font font;
	Color color;
	int totalColon=0;
	
	Align align;
	
	public Text(int x,int y,Font font,String str,Align align) {
		this.x=x;
		this.y=y;
		this.str=str;
		this.font=font;
		color=Color.LIGHT_GRAY;
		this.align=align;
		for(String line:str.split("\n"))
			totalColon++;
	}
	public Text(int x,int y,Font font,Color color,String str,Align align) {
		this.x=x;
		this.y=y;
		this.str=str;
		this.font=font;
		this.color=color;
		this.align=align;
		for(String line:str.split("\n"))
			totalColon++;
	}
	public void changeAling(Align aling){
		this.align=aling;
	}
	public void render(Graphics g){
		if(align==Align.center){
			int i=0;
			for(String line:str.split("\n")){
				drawCenterString(line,g,i);
				i++;
				}
		}
		if(align==Align.left){
			int i=0;
			for(String line:str.split("\n")){
				drawLeftString(line,g,i);
				i++;
				}
		}
	}
	public void drawCenterString(String line,Graphics g,int coulumb){
		g.setColor(color);
		g.setFont(font);
		int fontWidth=g.getFontMetrics().stringWidth(line);
		int fontHeight=g.getFontMetrics().getMaxAscent();
		g.drawString(line, x-fontWidth/2, y-fontHeight/2+(-totalColon/2+coulumb)*fontHeight);
	}
	public void drawLeftString(String line,Graphics g, int coulumb){
		g.setColor(color);
		g.setFont(font);
		int fontHeight=g.getFontMetrics().getMaxAscent();
		g.drawString(line, x, y+fontHeight/2+(-totalColon/2+coulumb)*fontHeight);
		
	}
	public void textChange(String str){
		this.str=str;
	}

}
