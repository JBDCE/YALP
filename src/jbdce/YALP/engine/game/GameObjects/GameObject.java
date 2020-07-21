package jbdce.YALP.engine.game.GameObjects;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import jbdce.YALP.engine.game.*;
import jbdce.YALP.engine.game.Scenes.Scene;
import jbdce.YALP.engine.utils.*;

public abstract class GameObject {
	protected Position position;
	protected Scene scene;
	
	private Sprite sprite;
		
	private RenderMethod renderMethod = RenderMethod.Regular;
	private int[] renderParameter = new int[4];
	
	public GameObject(Position position, float sizeX, float sizeY, String texturePath){
		this.scene = Game.getScene();
		this.position = position;
		this.sprite = new Sprite(new Texture(texturePath),sizeX,sizeY);
	}
	public GameObject(Position position, float sizeX, float sizeY, Texture texture){
		this.scene = Game.getScene();
		this.position = position;
		this.sprite = new Sprite(texture,sizeX,sizeY);
	}
	public GameObject(Position position, float sizeX, float sizeY) {
		this.scene = Game.getScene();
		this.position = position;
		this.sprite = new Sprite(null,sizeX,sizeY);
	}
	
	
	
	public void update(){
	}
	
	public void render(){
		if(renderMethod.equals(RenderMethod.Regular)){
			glPushMatrix();
			glTranslatef(position.getX(), position.getY(), 0);
			sprite.render();
			glPopMatrix();
		}else 
		if(renderMethod.equals(RenderMethod.Repeat)){
			glPushMatrix();
			glTranslatef(position.getX(), position.getY(), 0);
			sprite.render(renderParameter[0], renderParameter[1]);
			glPopMatrix();
		}else
		if(renderMethod.equals(RenderMethod.Area)){
			glPushMatrix();
			glTranslatef(position.getX(), position.getY(), 0);
			sprite.render(renderParameter[0], renderParameter[1], renderParameter[2], renderParameter[3]);
			glPopMatrix();
		}
	}

	public void setRenderParameters(int[] parameters){
		this.renderParameter = parameters;
	}
	public void setRenderParameters(int repeatsX, int repeatsY){
		this.renderParameter[0] = repeatsX;
		this.renderParameter[1] = repeatsY;
	}
	public void setRenderParameters(int startX, int startY, int sizeX, int sizeY){
		this.renderParameter[0] = startX;
		this.renderParameter[1] = startY;
		this.renderParameter[2] = sizeX;
		this.renderParameter[3] = sizeY;
	}
	
	public void setRenderMethod(RenderMethod r){
		this.renderMethod = r;
	}
	public RenderMethod getRenderMethod(){
		return renderMethod;
	}
	public void setSizeX(float sizeX){
		sprite.setSizeX(sizeX);
	}
	public void setSizeY(float sizeY){
		sprite.setSizeY(sizeY);
	}
	public float getSizeX(){
		return sprite.getSizeX();
	}
	public float getSizeY(){
		return sprite.getSizeY();
	}
	public void setTexture(Texture texture){
		sprite.setTexture(texture);
	}
	public void setPosition(Position p){
		this.position = p;
	}
	public Position getPosition(){
		return position;
	}
}
