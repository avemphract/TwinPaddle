package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class AngleDownUprage extends Uprage {

	public static int level=0;
	public AngleDownUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image=Resources.paddleAngleDownU;
	}
	public void collide(){
		state.ball.angle-=5;
		level++;
		advBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		return 100/(level+2);
	}

}
