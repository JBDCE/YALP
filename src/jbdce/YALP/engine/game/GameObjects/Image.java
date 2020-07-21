package jbdce.YALP.engine.game.GameObjects;

import jbdce.YALP.engine.utils.Position;

public class Image extends GameObject{
	
	public Image(Position position, float sizeX, float sizeY, String imagePath) {
		super(position, sizeX, sizeY, imagePath);
	}
	
	public void setRenderArea(int startX, int startY, int sizeX, int sizeY){
		this.setRenderParameters(startX, startY, sizeX, sizeY);
	}	
}
