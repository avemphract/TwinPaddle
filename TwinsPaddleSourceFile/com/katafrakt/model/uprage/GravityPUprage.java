package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class GravityPUprage extends Uprage {

	public static int level;
	
	public GravityPUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image=Resources.gravityPowerU;
	}
	public void collide(){
		PlayState.playState.gravity.power+=0.01;
		state.multiplier+=0.5f;
		disBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		if(PlayState.playState.gravity.level==0)
			return 0;
		else
			return 100/(level+2)*1;
	}

}
