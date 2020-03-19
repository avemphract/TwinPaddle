package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class SpeedUpUprage extends Uprage {

	public static int level=0;
	public SpeedUpUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image=Resources.ballSpeedUpU;
	}

	@Override
	public void collide() {
		state.ball.speed*=1.05;
		level++;
		disBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		return 100/(level+2)*4;
	}

}
