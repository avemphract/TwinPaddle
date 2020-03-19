package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class LargePUprage extends Uprage {

	public static int level=0;
	public LargePUprage(int x, int y,PlayState state) {
		super(x, y, state);
		image=Resources.largePaddleU;
	}
	public void collide(){
		if(x<(-size/2))
			state.paddleLeft.setHeight(state.paddleLeft.getHeight()*1.1f);
		else
			state.paddleRight.setHeight(state.paddleRight.getHeight()*1.1f);
		level++;
		advBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		return 100/(level+2)*2;
	}

}
