package run;

import java.io.Serializable;

public class BottleTwin implements Serializable {
	
	public volatile int ID =0;
	public volatile String order;
	public volatile String name = "Name";
	public volatile String status;
	public volatile boolean Faulty = false;
	public volatile boolean isFilled = false;
	public volatile boolean isCapOn = false;
	public volatile boolean isCapped = false;
	public volatile int[] recipe =new int[5];
	public volatile boolean isLarge = false; // isLarge is false means that the bottle size is 100ml
	
	public BottleTwin(int id, String name, String orderName, int[] recipe, boolean isLarge){
		this.ID = id;
		this.name = name;
		this.status = "scheduled";
		this.order = orderName;
		this.recipe = recipe;
		this.isLarge = isLarge;
	}
	
    public boolean isCompleted() { return "completed".equals(status); }
    
    public int getGUIint() {
    	if(this.isCapped) {
    		return 3;
    	}else if(this.isCapOn) {
    		return 2;
    	}else if(this.isFilled) { 
    		return 1;
    	}else {
	    	return 0;
    	}
    }
    public String getRecipeString() {
    	String message = "\n";
    	for(int i = 0; i < 5; i++) {
    		int v = this.recipe[i];
    		if(v > 0) {
    			message += "Liquid " + i + ": " + v + "ml";
    			message += "\n";
    		}
    	}
        return message;
    }

}