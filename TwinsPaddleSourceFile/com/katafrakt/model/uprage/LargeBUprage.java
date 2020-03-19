package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class LargeBUprage extends Uprage {

	public static int level=0;
	public LargeBUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image=Resources.largeBallU;
	}

	@Override
	public void collide() {
		state.ball.setSize(state.ball.getSize()*1.1f);
		level++;
		advBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		return 100/(level+2)*2;
	}

	
}
