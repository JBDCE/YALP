package jbdce.YALP.engine.game.Scenes;

import jbdce.YALP.engine.game.*;
import jbdce.YALP.engine.game.GameObjects.*;
import jbdce.YALP.engine.game.Menues.*;
import jbdce.YALP.engine.game.Scenes.Levels.*;
import jbdce.YALP.engine.utils.*;
import jbdce.YALP.engine.utils.text.*;

public class MainMenue extends Scene{	
	private SelectionMenue menue;
	private Image image;
	
	private TextObject startGame;
	private TextObject options;
	private TextObject exitGame;
	
	public MainMenue(Game game) {
		initScene(game);
		setBackground("res/wall.png");

		image = new Image(new Position(400, 500), 500, 200, "res/grandia_logo.png");
		startGame = new TextObject(null, "Start Game");
		options = new TextObject(null, "Options");
		exitGame = new TextObject(null, "Exit Game");
		
		menue = new SelectionMenue(new Position(50, 50));
		menue.addOption(exitGame);
		menue.addOption(options);
		menue.addOption(startGame);
		
		this.addElement(image);
		this.addElement(menue);
	}	
	
	@Override
	public void getInputs() {
		GameObject returned = menue.getInputs();
		if(returned!=null){
			if(returned.equals(exitGame)){
				Game.exitGame();
			}else
			if(returned.equals(options)){
				menue.addOption(new Image(null, 32, 32, "res/Dickbutt.png"));
			}else if(returned.equals(startGame)){
				game.setScene(new Level1(game));
			}else{
				System.out.println(returned.toString());
			}
		}
	}	
}
