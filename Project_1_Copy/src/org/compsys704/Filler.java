
package org.compsys704;

public class Filler {
	
	public static volatile boolean filler_on;
	public static volatile boolean filler_off;
	public static volatile int workingBottleID;
	public static volatile int process;
	public static volatile String firstRecipe;
	public static volatile String secondRecipe;
	
	public static volatile String liquidMessage = "";

	
	public Filler(int p){
	}
	public String getRecipe() {
		if (process == 0) {
			return null;
		}
		
		return null;
	}
	
}