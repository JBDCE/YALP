package jbdce.YALP.engine.game.GameObjects;

import java.util.*;

import jbdce.YALP.engine.utils.*;

public abstract class Container extends GameObject{	
	protected ArrayList<GameObject> elements;
	
	private int lastId = -1;
	
	public Container(Position position) {
		super(position, 0, 0);
		elements = new ArrayList<GameObject>();
	}
	public Container(Position position, String backgroundImagePath) {
		super(position, 0, 0, backgroundImagePath);
		elements = new ArrayList<GameObject>();
	}
	public Container(Position position, float objectSizeX, float objectSizeY) {
		super(position, 0, 0);
		elements = new ArrayList<GameObject>();
	}
	public Container(Position position, float objectSizeX, float objectSizeY, String backgroundImagePath) {
		super(position, 0, 0, backgroundImagePath);
		elements = new ArrayList<GameObject>();
	}
	
	public void addOption(GameObject gameObject){
		if(elements.size()!=0){
			gameObject.setPosition(new Position(elements.get(lastId).getPosition().getX(), elements.get(lastId).getPosition().getY()+elements.get(lastId).getSizeY()));		
		}else{
			gameObject.setPosition(new Position((this.getPosition().getX() + 80), this.getPosition().getY()+5));
		}
		this.elements.add(gameObject);
		lastId++;
		updateFrame();
	}

	private void updateFrame(){
		float sumY = 0;
		
		for(GameObject go : elements) {
			sumY += go.getSizeY()+5;
		}
		
		this.setSizeY(sumY);

		float largestX = 0;
		for(GameObject go : elements){
			if(go.getSizeX()>largestX)
				largestX = go.getSizeX();
		}
		this.setSizeX(largestX + 90);
	}
	
	@Override
	public void render() {
		super.render();
		for(GameObject go : elements){
			go.render();
		}
	}
	@Override
	public void update() {
		for(GameObject go : elements){
			go.update();
		}
	}
}
