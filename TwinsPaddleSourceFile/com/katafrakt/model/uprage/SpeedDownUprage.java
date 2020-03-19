package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class SpeedDownUprage extends Uprage {

	public static int level=0;
	public SpeedDownUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image=Resources.ballSpeedDownU;
	}

	@Override
	public void collide() {
		state.ball.speed*=0.95;
		level++;
		advBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		return 100/(level+2)*1;
	}
	
}
