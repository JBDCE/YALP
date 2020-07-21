package jbdce.YALP.engine.game.Menues;

import org.lwjgl.glfw.*;

import jbdce.YALP.engine.game.GameObjects.*;
import jbdce.YALP.engine.utils.*;
import jbdce.YALP.engine.utils.text.*;

public class SelectionMenue extends Container{
	private Cursor cursor;
	
	public SelectionMenue(Position pos){
		super(pos, "res/Selection Box.png");
		this.cursor = new Cursor(this.elements);
	}
	
	@Override
	public void render() {
		super.render();
		cursor.render();
	}
	@Override
	public void update() {
		super.update();
		cursor.update();
	}
	
	@Override
	public void addOption(GameObject gameObject) {
		super.addOption(gameObject);
		cursor.setSelected(gameObject);
	}
	
	public GameObject getInputs(){
		if(Input.isPressed(GLFW.GLFW_KEY_W)||Input.isPressed(GLFW.GLFW_KEY_UP)){
			cursor.moveUp();
		}
			
		if(Input.isPressed(GLFW.GLFW_KEY_S)||Input.isPressed(GLFW.GLFW_KEY_DOWN)){
			cursor.moveDown();
		}
		
		if(Input.isPressed(GLFW.GLFW_KEY_ENTER)||Input.isPressed(GLFW.GLFW_KEY_SPACE)){
			return cursor.getSelected();
		}
		return null;
	}
}
