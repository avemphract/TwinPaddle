package com.katafrakt.game.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TextBox {
	
	int x,y;
	int width,height;
	
	String str;
	Font font;
	Color color;
	public TextBox(int x, int y, int width, int height, String str, Font font,
			Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.str = str;
		this.font = font;
		this.color = color;
	}
	public void render(Graphics g){
		g.setColor(color);
		g.setFont(font);
		int fontWidth=g.getFontMetrics().stringWidth(str);
		if(fontWidth>width){
			char[] c=str.toCharArray();
			String tempStr = new String();
			int k=0;
			for(int i=0;i<c.length+k;i++){
				if(g.getFontMetrics().stringWidth(tempStr+c[i])>width){
					tempStr=tempStr+"\n";
					k++;
				}
				tempStr=tempStr+c[i];
			}
			
		}
		int fontHeight=g.getFontMetrics().getMaxAscent();
		g.drawString(str, x-fontWidth/2, y-fontHeight/2);
	}
}
