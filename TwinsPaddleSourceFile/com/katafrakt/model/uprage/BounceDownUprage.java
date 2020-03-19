package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class BounceDownUprage extends Uprage {

	public static int level=0;
	public BounceDownUprage(int x, int y, PlayState state) {
		super(x,y,state);
		image=Resources.bounceDownU;
	}

	@Override
	public void collide() {
		state.ball.bounce*=0.95f;
		level++;
		advBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		return 100/(level+2)*3;
	}

}
