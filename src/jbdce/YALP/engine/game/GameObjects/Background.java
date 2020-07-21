package jbdce.YALP.engine.game.GameObjects;

import jbdce.YALP.engine.game.*;
import jbdce.YALP.engine.utils.*;

public class Background extends GameObject{

	public Background(String backgroundPath) {
		super(new Position(0, 0), Game.SIZEX, Game.SIZEY, backgroundPath);
	}
	
}
