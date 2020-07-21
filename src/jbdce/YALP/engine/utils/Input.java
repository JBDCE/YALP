package jbdce.YALP.engine.utils;

import org.lwjgl.glfw.*;

public class Input extends GLFWKeyCallback{	
	private static boolean disabled = false;
	private static boolean[] keys = new boolean[65536];
	
	public static boolean allReleased(){
		boolean allReleased = true;
		for(boolean key : keys){
			if(key){
				allReleased = false;
				//if(!allReleased)
				break;
			}
		}
		return allReleased;
	}

	//TODO Input Handle Button Cooldown
	
	public static boolean isPressed(int key){		
		if(disabled){
			if(allReleased()){
				disabled = false;
			}
			return false;
		}else{
			if(keys[key]){
				disabled = true;
			}
			return keys[key];
		}
	}
	
	public static boolean isDisabled(){
		return disabled;
	}
	
	public void invoke(long window, int key, int scancode, int action, int mods) {
		keys[key] = action != GLFW.GLFW_RELEASE;
	}
}
