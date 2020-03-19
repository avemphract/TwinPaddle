package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class SmallPUprage extends Uprage {

	public static int level=0;
	public SmallPUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image=Resources.smallPaddleU;
	}

	@Override
	public void collide() {
		if(x<(-size/2))
			state.paddleLeft.setHeight(state.paddleLeft.getHeight()*0.9f);
		else
			state.paddleRight.setHeight(state.paddleRight.getHeight()*0.9f);
		state.multiplier+=0.3f;
		level++;
		state.multiplier+=0.5f;
		disBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		return 100/(level+2)*6;
	}

}
