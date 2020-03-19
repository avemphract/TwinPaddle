package com.katafrakt.model.uprage;

import com.katafrakt.game.main.Resources;
import com.katafrakt.game.state.PlayState;

public class GravityLUprage extends Uprage {
	public static int level;

	public GravityLUprage(int x, int y, PlayState state) {
		super(x, y, state);
		image=Resources.gravityLevelU;
	}
	public void collide(){
		state.gravity.level++;
		state.multiplier+=0.5f;
		disBuff++;
		uprageList.add(this);
	}
	public static float getRandom(){
		if(PlayState.playState.getScore()<=50)
			return 0;
		if(PlayState.playState.getScore()>=50||PlayState.playState.getScore()<=150||PlayState.playState.gravity.level==0)
			return 100/(level+2)*3;
		if(PlayState.playState.getScore()>=150||PlayState.playState.gravity.level==0)
			return 100/(level+2)*9;
		if(PlayState.playState.getScore()>=50||PlayState.playState.getScore()<=150||PlayState.playState.gravity.level==1)
			return 0;
		if(PlayState.playState.getScore()>=150||PlayState.playState.getScore()<=350||PlayState.playState.gravity.level==1)
			return 100/(level+2)*3;
		if(PlayState.playState.getScore()>=350||PlayState.playState.gravity.level==1)
			return 100/(level+2)*9;
		return 0;
	}
	

}
