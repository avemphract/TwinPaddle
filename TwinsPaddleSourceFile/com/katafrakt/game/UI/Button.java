package com.katafrakt.game.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.katafrakt.game.state.State;

public class Button {

	private int x,y;
	private int width,height;
	private Rectangle rect;
	private String str;
	
	private Color colorNatural=new Color(0, 0, 0, 63);
	private Color colorEntered=new Color(255,255,255,191);
	private Color color;
	
	private Font font;
	private int fontX;
	private int fontY;
	
	private State state;
	
	public Button(int x,int y,int width,int height,String str,State state) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.str=str;
		this.state=state;
		state.buttonList.add(this);
		rect=new Rectangle(x,y,width,height);
		color=colorNatural;
		font=new Font("SansSerif",Font.BOLD,50);
	}
	public void render(Graphics g){
		g.setColor(color);
		g.fillRect(x,y,width,height);
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);
		if(str!=null){
		g.setFont(font);
		int fontWidth=g.getFontMetrics().stringWidth(str);
		int fontHeight=g.getFontMetrics().getMaxAscent();
		g.drawString(str, x+width/2-fontWidth/2, y+fontHeight);}
	}
	public boolean boundary(MouseEvent e){
		if(x<e.getX()&&x+width>e.getX())
			if(y<e.getY()&&y+height>e.getY())
				return true;
		return false;
	}
	public void mouseEntered(){
		color=colorEntered;
	}
	public void mouseExit(){
		color=colorNatural;
	}
	public void pressed(){}

}
