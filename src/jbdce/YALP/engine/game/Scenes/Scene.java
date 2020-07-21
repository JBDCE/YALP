package jbdce.YALP.engine.game.Scenes;

import java.util.*;

import jbdce.YALP.engine.game.*;
import jbdce.YALP.engine.game.GameObjects.*;

public abstract class Scene {
	protected Game game;
	
	protected int frame;

	private ArrayList<GameObject> objects;
	private ArrayList<GameObject> objectsToRemove;
	private Background background;

	public void render(){
		if(background!=null)
			background.render();
		for(GameObject go : objects){
			go.render();
		}
		this.frame++;
	}
	public void update(){
		for(GameObject go : objects){
			go.update();
		}
		for(GameObject go : objectsToRemove){
			objects.remove(go);
		}
	}
	
	protected void initScene(Game game){
		objects = new ArrayList<GameObject>();
		objectsToRemove = new ArrayList<GameObject>();
		this.game = game;
		this.frame = 0;
	}
	public void setBackground(String texturePath){
		background = new Background(texturePath);
	}
	public void addElement(GameObject go){
		objects.add(go);
	}
	public void removeElement(GameObject go){
		objectsToRemove.add(go);
	}
	
	public int getFrame() {
		return frame;
	}	
	public Game getGame(){
		return game;
	}
	public abstract void getInputs();
}
