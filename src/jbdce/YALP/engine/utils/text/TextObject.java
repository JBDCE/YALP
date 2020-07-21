package jbdce.YALP.engine.utils.text;

import java.awt.*;

import jbdce.YALP.engine.game.GameObjects.*;
import jbdce.YALP.engine.utils.*;

public class TextObject extends GameObject{

	private final TextRender TR = new TextRender("Arial", Font.PLAIN, Color.BLACK);
	private String text;
	
	private boolean textChanged = false;
	
	public TextObject(Position pos, String text){
		super(pos, 0, 0);
		this.setText(text);
	}
	
	public TextObject(Position pos, String text, Color color){
		super(pos, 0, 0);
		this.setText(text);
	}
	
	public TextObject(Position pos, float sizeX, float sizeY, String text){
		super(pos, 0, 0);
		this.setText(text);
	}
	
	public TextObject(Position pos, float sizeX, float sizeY, String text, Color color){
		super(pos, 0, 0);
		this.setText(text);
	}
	
	public void setText(String text){
		this.textChanged = true;
		this.text = text;
		update();
	}
	
	public String getText(){
		return this.text;
	}
	
	@Override
	public void update() {
		if(textChanged){
			Texture newTex = new Texture(TR.generateImage(this.text));
			this.setSizeX(newTex.getWidth());
			this.setSizeY(newTex.getHeight());
			this.setTexture(newTex);
			textChanged = false;
		}
		super.update();
	}
}
