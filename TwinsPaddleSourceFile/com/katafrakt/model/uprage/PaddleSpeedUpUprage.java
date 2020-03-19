package com.katafrakt.model.uprage;

import com.katafrakt.game.main.GameMain;
import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class PaddleSpeedUpUprage extends Uprage {

	public static int level=0;
	public PaddleSpeedUpUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image= Resources.paddleSpeedU;
	}
	
	public void collide(){
		if(x<GameMain.GAME_WIDTH/2+size/2)
			state.paddleLeft.speed*=1.05;
		else
			state.paddleRight.speed*=1.05;
		level++;
		advBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		return 100/(level+2)*4;
	}

}
