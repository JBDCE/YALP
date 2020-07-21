package jbdce.YALP.engine.utils.text;

import java.util.ArrayList;

import jbdce.YALP.engine.game.GameObjects.*;
import jbdce.YALP.engine.utils.*;

public class Cursor extends GameObject{

	private final float DISTANCE_FROM_TEXT = 15;
	private static final float DEFAULT_SIZEX = 50;
	private static final float DEFAULT_SIZEY = 50;
	
	private ArrayList<GameObject> options;
	private int attachedTo;
	
	
	public Cursor(ArrayList<GameObject> options) {
		super(new Position(-100, -100), DEFAULT_SIZEX, DEFAULT_SIZEY, "res/cursor.png");
		this.options = options;
		attachedTo = 0;
	}
	
	@Override
	public void update() {
		setPosition(new Position(options.get(attachedTo).getPosition().getX() - DISTANCE_FROM_TEXT - DEFAULT_SIZEX,   options.get(attachedTo).getPosition().getY() + options.get(attachedTo).getSizeY()/2 - DEFAULT_SIZEY/2));
	}
	
	public void moveUp(){
		if(attachedTo < options.size()-1)
			attachedTo++;	
	}	
	public void moveDown(){
		if(attachedTo > 0)
			attachedTo--;
	}
	
	public void updateOptions(ArrayList<GameObject> options){
		this.options = options;
		this.attachedTo = options.size();
	}
	
	public void setSelected(GameObject go) {
		if(this.options.contains(go)){
			this.attachedTo = this.options.indexOf(go);
		}
	}
	public GameObject getSelected(){
		return options.get(attachedTo);
	}
	public int getSelectedId(){
		return attachedTo;
	}
	
}
