package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class BounceUpUprage extends Uprage {

	public static int level=0;
	public BounceUpUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image=Resources.bounceUpU;
	}

	@Override
	public void collide() {
		state.ball.bounce*=1.05f;
		state.multiplier+=0.2f;
		level++;
		disBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		return 100/(level+2)*3;
	}

}
