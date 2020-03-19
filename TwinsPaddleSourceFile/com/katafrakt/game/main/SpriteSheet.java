package com.katafrakt.game.main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpriteSheet {
	private BufferedImage sheet;
	public int size;
	public SpriteSheet(BufferedImage sheet,int size){
		this.sheet=sheet;
		this.size=size;
	}
	public BufferedImage crop(int x,int y){
		return sheet.getSubimage(x*size, y*size, size, size); 
	}
	public BufferedImage[] cropArray(int x1,int x2, int y1,int y2){
		ArrayList<BufferedImage> list=new ArrayList<BufferedImage>();
		for(int i=y1;i<=y2;i++){
			if(y1==y2)
				for(int j=x1;j<=x2;j++){
					list.add(crop(j,i));
				}
			else
				for(int j=y1;j<sheet.getWidth()/size;j++){
					list.add(crop(j,i));
				}
		}
		BufferedImage[] array= new BufferedImage[list.size()];
		for (int i=0; i<list.size(); i++) 
		{ 
			array[i]=list.get(i);
		}
		
		return array;
	}
	
}
