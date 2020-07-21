package jbdce.YALP.engine.game.GameObjects;

import jbdce.YALP.engine.utils.*;

public abstract class Mob extends GameObject{	
	private float velX = 0;
	private float velY = 0;
	
	private boolean obGravity = false;
	
	
	public Mob(Position position, float sizeX, float sizeY) {
		super(position, sizeX, sizeY);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		this.position.setX(this.position.getX()+velX);
		this.position.setY(this.position.getY()+velY);
		
		if(velX<0){
			velX += 0.1;
		}else if(velY>0) {
			velX -= 0.1;
		}
		if(obGravity) {
			
		}else {
			if(velY<0){
				velY += 0.1;
			}else if(velY>0) {
				velY -= 0.1;
			}
		}
	}
	
	
	
}
