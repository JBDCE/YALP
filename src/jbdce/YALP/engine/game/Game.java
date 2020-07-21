package jbdce.YALP.engine.game;

import jbdce.YALP.engine.*;
import jbdce.YALP.engine.game.Scenes.*;
import jbdce.YALP.engine.utils.*;

public class Game {	
	public static final String GAME_TITLE = "Yet Another LWJGL Project";
	
	public static final int SIZEX = 1280;
	public static final int SIZEY = 720;
		
	private static Scene scene;
	private Scene lastScene;
	
	private FPSCounter fps;
	
	public Game() {
		fps = new FPSCounter();
		scene = new MainMenue(this);
	}
	
	public void getInputs() {
		scene.getInputs();
	}

	public void update() {
		scene.update();
	}

	public void render() {
		fps.start();
		scene.render();
		fps.stop();
		fps.render();
	}
	
	public void previousScene(){
		Scene previousScene = lastScene;
		this.lastScene = scene;
		scene = null;
		scene = previousScene;
	}

	public static Scene getScene(){
		return scene;
	}
	public void setScene(Scene newScene){
		this.lastScene = scene;
		scene = null;
		scene = newScene;
	}
	public static void exitGame(){
		Main.closeWindow();
	}
}
