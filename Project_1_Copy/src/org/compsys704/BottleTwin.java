package org.compsys704;

import java.io.Serializable;

public class BottleTwin implements Serializable {
	
	public volatile int ID =0;
	public volatile String name = "Name";
	public volatile String status;
	public BottleTwin(int id, String name){
		this.ID = id;
		this.name = name;
		this.status = "scheduled";
	}
	
}