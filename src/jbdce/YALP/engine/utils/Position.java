package jbdce.YALP.engine.utils;

import jbdce.YALP.engine.game.*;

public class Position {
	
	public static final String MIDDLE = "middle";
	
	
	private float x;
	private float y;
	
	public Position(String x, float y){
		this.x = calculatePositionX(x);
		this.y = y;
	}
	
	public Position(float x, String y){
		this.x = x;
		this.y = calculatePositionY(y);
	}
	
	public Position(String x, String y){
		this.x = calculatePositionX(x);
		this.y = calculatePositionY(y);
	}
	
	public Position(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	
	private float calculatePositionX(String param){
		switch (param) {
		case MIDDLE:
			return Game.SIZEX/2;

		default:
			return 0;
		}
	}
	
	private float calculatePositionY(String param){
		
		
		return 0;
	}
	
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
}
