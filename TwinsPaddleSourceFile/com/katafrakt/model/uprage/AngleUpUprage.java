package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class AngleUpUprage extends Uprage {

	public static int level=0;
	public AngleUpUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image=Resources.paddleAngleUpU;
	}
	public void collide(){
		state.ball.angle+=5;
		level++;
		state.multiplier+=0.2f;
		disBuff++;
		uprageList.add(this);
	}

	public static float getRandom(){
		return 100/(level+2)*3;
	}
}
