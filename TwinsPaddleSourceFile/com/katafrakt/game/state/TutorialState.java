package com.katafrakt.game.state;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.katafrakt.framework.util.AudioClip;
import com.katafrakt.game.UI.Button;
import com.katafrakt.game.UI.Text;
import com.katafrakt.game.main.GameMain;
import com.katafrakt.game.main.Resources;

public class TutorialState extends State {

	Button menuButton;
	int unit;
	
	Text angleUp;
	Text angleDown;
	
	Text bounceUp;
	Text bounceDown;
	
	Text gravityL;
	Text gravityP;
	
	Text largeB;
	Text smallB;
	
	Text largeP;
	Text smallP;
	
	Text paddleS;
	Text ballS;
	
	Text intro;
	@Override
	public void init() {
		unit = GameMain.GAME_WIDTH/16;
		menuButton =new Button((int)(0.5f*unit),(int)(7.5*unit),(int)(2.5f*unit),unit, "Back", this){public void pressed(){setCurrentState(new MenuState());}};

		Font font =new Font("SansSerif",Font.BOLD,GameMain.GAME_WIDTH/60);
		
		angleUp=new Text((int)(1.5f*unit), (int)(1f*unit), font, "Increases angle \nof the paddle \nhit",Text.Align.left);
		angleDown=new Text((int)(5.5f*unit), (int)(1f*unit), font, "Decreases angle \nof the paddle \nhit",Text.Align.left);
		
		bounceUp=new Text((int)(9.5f*unit), (int)(1f*unit), font, "Increase	s speed \nof the ball when \nhit boundary",Text.Align.left);
		bounceDown=new Text((int)(13.5f*unit), (int)(1f*unit), font, "Decreases speed \nof the ball when \nhit boundary",Text.Align.left);
		
		gravityL=new Text((int)(1.5f*unit), (int)(3f*unit), font, "Increases gravity level\nIt change gravity \nrotation speed",Text.Align.left);
		gravityP=new Text((int)(5.5f*unit), (int)(3f*unit), font, "Increases gravity \npower",Text.Align.left);
		
		largeB=new Text((int)(9.5f*unit), (int)(3f*unit), font, "Increases size \nof the ball",Text.Align.left);
		smallB=new Text((int)(13.5f*unit), (int)(3f*unit), font, "Decreases size \nof the ball",Text.Align.left);
		
		largeP=new Text((int)(1.5f*unit), (int)(5f*unit), font, "Increases lenght \nof paddle",Text.Align.left);
		smallP=new Text((int)(5.5f*unit), (int)(5f*unit), font, "Decreases lenght \nof paddle",Text.Align.left);
		
		paddleS=new Text((int)(9.5f*unit), (int)(5f*unit), font, "Increases speed \nof the paddle",Text.Align.left);
		ballS=new Text((int)(13.5f*unit), (int)(5f*unit), font, "Increases speed \nof the ball",Text.Align.left);
		
		intro=new Text((int)(0.5f*unit), (int)(6.5f*unit), font, "Aim of the game is to bounce ball with peddals.    \nAs you gain score area of the game will expand and various improvements will be appeared.",Text.Align.left);
		AudioClip.menuMusic.loop();
	}	

	@Override
	public void lateInýt() {
		// TODO Auto-generated method stub

	}
	public void quit(){
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.background,0,0,null);
		//
		g.drawImage(Resources.paddleAngleUpU, (int)(unit*0.5f), (int)(unit*0.5f), unit, unit, null);
		angleUp.render(g);
		g.drawImage(Resources.paddleAngleDownU, (int)(unit*4.5f), (int)(unit*0.5f), unit, unit, null);
		angleDown.render(g);
		//
		g.drawImage(Resources.bounceUpU, (int)(unit*8.5f), (int)(unit*0.5f), unit, unit, null);
		bounceUp.render(g);
		g.drawImage(Resources.bounceDownU, (int)(unit*12.5f), (int)(unit*0.5f), unit, unit, null);
		bounceDown.render(g);
		//
		g.drawImage(Resources.gravityLevelU, (int)(unit*0.5f), (int)(unit*2.5f), unit, unit, null);
		gravityL.render(g);
		g.drawImage(Resources.gravityPowerU, (int)(unit*4.5f), (int)(unit*2.5f), unit, unit, null);
		gravityP.render(g);
		//
		g.drawImage(Resources.largeBallU, (int)(unit*8.5f), (int)(unit*2.5f), unit, unit, null);
		largeB.render(g);
		g.drawImage(Resources.smallBallU, (int)(unit*12.5f), (int)(unit*2.5f), unit, unit, null);
		smallB.render(g);
		//
		g.drawImage(Resources.largePaddleU, (int)(unit*0.5f), (int)(unit*4.5f), unit, unit, null);
		largeP.render(g);
		g.drawImage(Resources.smallPaddleU, (int)(unit*4.5f), (int)(unit*4.5f), unit, unit, null);
		smallP.render(g);
		//
		g.drawImage(Resources.paddleSpeedU, (int)(unit*8.5f), (int)(unit*4.5f), unit, unit, null);
		paddleS.render(g);
		g.drawImage(Resources.ballSpeedUpU, (int)(unit*12.5f), (int)(unit*4.5f), unit, unit, null);
		ballS.render(g);
		
		intro.render(g);
		if(buttonList.size()>0)
			for(Button button:buttonList){
				button.render(g);
			}
	}

	@Override
	public void onClick(MouseEvent e) {
		if(buttonList.size()>0)
			for(Button button:buttonList){
				if(button.boundary(e))
					button.pressed();
			}

	}

	@Override
	public void onKeyPress(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(buttonList.size()>0)
			for(Button button:buttonList){
				if(button.boundary(e))
					button.mouseEntered();
				else
					button.mouseExit();
			}

	}

}
