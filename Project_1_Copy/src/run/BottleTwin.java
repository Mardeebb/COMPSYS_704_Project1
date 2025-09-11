package run;

import java.io.Serializable;

public class BottleTwin implements Serializable {
	
	public volatile int ID =0;
	public volatile String order;
	public volatile String name = "Name";
	public volatile String status;
	public volatile boolean isFilled = false;
	public volatile boolean isCapOn = false;
	public volatile boolean isCapped = false;
	
	public BottleTwin(int id, String name, String orderName){
		this.ID = id;
		this.name = name;
		this.status = "scheduled";
		this.order = orderName;
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

}