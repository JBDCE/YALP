package jbdce.YALP.engine.utils;

public class Vector {

	private float[] component;
	
	public Vector(float x0, float x1) {
		this.component = new float[2];
		this.component[0] = x0;
		this.component[1] = x1;
	}
	
	
	
	public void setComponent(int dimension, float value){
		if(dimension<=component.length){
			this.component[dimension] = value;
		}else{
			printError(0);
		}
	}
	
	public void setVector(float[] components){
		this.component = components;
	}
	
	public float[] getVector(){
		return this.component;
	}
	
	public float getComponent(int dimension){
		if(dimension<=component.length)
			return this.component[dimension];
		else
			printError(1);
			return 0;
	}
	
	private void printError(int i){
		if(i==0){
			System.err.println("Error setting Vector component... Dimension out of range. No change made..");
		}else
		if(i==1){
			System.err.println("Error getting Vector component... Dimension out of range. Returned: 0");
		}
	}
}
