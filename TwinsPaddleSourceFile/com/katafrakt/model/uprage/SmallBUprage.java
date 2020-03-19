package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class SmallBUprage extends Uprage {

	public static int level=0;
	public SmallBUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image=Resources.smallBallU;
	}

	@Override
	public void collide() {
		state.ball.setSize(state.ball.getSize()*0.9f);
		level++;
		state.multiplier+=0.3f;
		disBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		return 100/(level+2)*6;
	}

}
