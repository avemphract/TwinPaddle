package com.katafrakt.game.state;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import com.katafrakt.framework.util.AudioClip;
import com.katafrakt.framework.util.CoorTrans;
import com.katafrakt.game.UI.Text;
import com.katafrakt.game.main.GameMain;
import com.katafrakt.game.main.Resources;
import com.katafrakt.game.model.Ball;
import com.katafrakt.game.model.Gravity;
import com.katafrakt.game.model.Paddle;
import com.katafrakt.model.uprage.Uprage;

public class PlayState extends State {
	private float score=0;
	public float multiplier=1;
	private Font scoreFont;
	public static PlayState playState;
	
	Text scoreText;
	
	public static Paddle paddleLeft, paddleRight;
	private static final int PADDLE_WIDTH = 15;
	private static final int PADDLE_HEIGHT = 100;
	
	public Ball ball;
	
	public Gravity gravity;
	
	public ArrayList<Uprage> uprageList;
	private static int diameter=40;
	
	public static float width=800;
	public static float height=450;
	public int remain=0;
	
	AudioClip musicClip;
	AudioClip hitClip;
	
	int lastScore=0;
	int lastUprage=0;
	
	@Override
	public void init() {
		width=800;
		height=450;
		uprageList= new ArrayList<Uprage>();
		int unit=GameMain.GAME_WIDTH/16;
		paddleLeft = new Paddle(-width/2, -PADDLE_HEIGHT/2, PADDLE_WIDTH, PADDLE_HEIGHT,this,+1);
		paddleRight = new Paddle(width/2-PADDLE_WIDTH,-PADDLE_HEIGHT/2, PADDLE_WIDTH, PADDLE_HEIGHT,this,-1);
		scoreText=new Text(unit*7,(int)(unit/2),new Font("SansSerif",Font.BOLD,20),Float.toString(score),Text.Align.center);
		scoreFont= new Font("SansSerif",Font.BOLD,40);
		ball=new Ball(0,0,diameter,this);
		gravity=new Gravity();


		AudioClip.menuMusic.stop();
		musicClip=AudioClip.playBackgroundClip;
		hitClip=AudioClip.hitClip;
		musicClip.loop();
	
		playState=this;
	}

	@Override
	public void lateInýt() {
		// TODO Auto-generated method stubRandomNumberGenerator.getRandIntBetween(-100, 100-Uprage.size)
		
	}
	public void quit(){
		
	}

	@Override
	public void update() {
		paddleLeft.update();
		paddleRight.update();
		gravity.update();
		ball.update();
		expanding();
		
		if(uprageList.size()!=0)
		{
			Iterator<Uprage> var=uprageList.iterator();
			while(var.hasNext()){
				Uprage u= var.next();
				u.update();
				//u.update();
				if(ballCollides(u)){
					u.collide();
					var.remove();
				}
			}
		}
		if(ballCollides(paddleLeft)){
			setScore(getScore() + 5f*multiplier);
			ball.onCollideWith(paddleLeft);
			hitClip.start();
			}
		else if(ballCollides(paddleRight)){
			setScore(getScore() + 5f*multiplier);
			ball.onCollideWith(paddleRight);
			hitClip.start();
		}
		else if(ball.isDead()){
			ball.reset();
			setCurrentState(new EndGameState());
			musicClip.stop();
			
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Resources.darkBlue);
		g.fillRect(0, 0, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT);
		g.setColor(Resources.darkRed);
		g.fillRect(GameMain.GAME_WIDTH / 2, 0, GameMain.GAME_WIDTH / 2,GameMain.GAME_HEIGHT);
		// Draw Separator Line
		//g.drawImage(Resources.line, (GameMain.GAME_WIDTH / 2) - 2, 0, null);
		CoorTrans.drawImage(g, Resources.line, -8, -Resources.line.getHeight()/1.3f, 16, GameMain.GAME_HEIGHT*4);
		// Draw Paddle
		paddleLeft.render(g);
		paddleRight.render(g);
		//Gravity Render
		gravity.render(g);
		// Draw Ball
		ball.render(g);
		//Draw UI
		scoreText.render(g);
		if(uprageList.size()!=0)
			for(Uprage var:uprageList){
				var.render(g);
			}
	}

	@Override
	public void onClick(MouseEvent e) {
		Uprage.Create();

	}

	@Override
	public void onKeyPress(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			paddleLeft.accelUp();
			paddleRight.accelDown();
			//Yazdýr.onlyStr("PressedUp");
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			paddleLeft.accelDown();
			paddleRight.accelUp();
		}

	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_DOWN){
			if(paddleLeft.getVelY()>0&&e.getKeyCode()==KeyEvent.VK_DOWN)
				paddleLeft.stop();
			if(paddleLeft.getVelY()<0&&e.getKeyCode()==KeyEvent.VK_UP)
				paddleLeft.stop();
			if(paddleRight.getVelY()<0&&e.getKeyCode()==KeyEvent.VK_DOWN)
				paddleRight.stop();
			if(paddleRight.getVelY()>0&&e.getKeyCode()==KeyEvent.VK_UP)
				paddleRight.stop();
		}

	}

	private boolean ballCollides(Paddle p){
		return ball.getRect().intersects(p.getRect());}
	
	public boolean ballCollides(Uprage u){
		return ball.getRect().intersects(u.getRect());
	}

	public void expanding(){
		if(remain!=0){
			float k=10f;
			setWidth(getWidth()+k);
			//width=width+k*16;
			setHeight(getHeight()+k*9/16);
			//height=height+k*9;
			remain--;
		}
	}
	
	public static float getWidth() {
		return width;
	}

	public static void setWidth(float width) {
		PlayState.width = width;
		paddleLeft.x=-width/2;
		paddleRight.x=width/2-PADDLE_WIDTH;
	}

	public static float getHeight() {
		return height;
	}

	public static void setHeight(float height) {
		PlayState.height = height;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
		scoreText.textChange(Float.toString(score));
		if(score!=0&&score>(1+lastScore)*100){
			remain=remain+50;
			lastScore++;}
		if(score!=00&&score>(1+lastUprage)*25){
			Uprage.Create();
			lastUprage++;}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
