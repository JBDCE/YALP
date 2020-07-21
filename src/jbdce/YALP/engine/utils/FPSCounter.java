package jbdce.YALP.engine.utils;

import jbdce.YALP.engine.game.Game;
import jbdce.YALP.engine.utils.text.TextObject;

public class FPSCounter extends TextObject{
	private long spf;
	private long start;
	
	private boolean isRendered = true;
	
	public FPSCounter() {
		super(new Position(Game.SIZEX-100, Game.SIZEY-80), 0, 0, "");
	}
		
	public void start(){
		start = System.nanoTime();
	}
	
	public void stop(){
		spf = System.nanoTime() - start;
		this.setText(String.valueOf(getFPS()));
		this.update();
	}
	
	@Override
	public void render() {
		if(isRendered)
			super.render();
	}
	
	public float getFPS(){
		float fps = 1000000000 / spf;
		return fps;
	}
}
