package org.compsys704;

import java.util.Arrays;
import java.util.List;

public class SysJWorker extends Worker{

	@Override
	public void setSignal(boolean status, Object value) {
//		System.out.println(signame+"  "+status);
		switch(signame){
		case "pusherRetractedE":
			States.PUSHER_RETRACTED = status;
			break;
		case "pusherExtendedE":
			if(!States.MAG_EMPTY && !States.PUSHER_EXTENDED)
				States.CAP_READY = true;
			States.PUSHER_EXTENDED = status;
			break;
		case "WPgrippedE":
			if(States.GRIPPED && States.ARM_AT_SOURCE){
				if(!status)
					States.CAP_READY = true;
			}
			States.GRIPPED = status;
			if(States.GRIPPED && States.ARM_AT_SOURCE){
				States.CAP_READY = false;
			}
			break;
		case "armAtSourceE":
			States.ARM_AT_SOURCE = status;
			break;
		case "armAtDestE":
			States.ARM_AT_DEST = status;
			break;
		case "emptyE":
			States.MAG_EMPTY = status;
			break;
		case"rotContent":
	        break;
	        
		case"rotTurn":
			System.err.println(signame);
			if (status) {
				int pos = States.RT_PS;
				pos++;
				if (pos == 6) {
					pos = 0;
				}
				States.RT_PS = pos;
		        if (status && value != null) {
		            int[] val = (int[]) value;
		            States.RT = val;
		        }
			}
			break;
			
		case "bottleAtPos5":
			States.bottleAtPos5 = status;
			break;
			
		case "capOnBottleAtPos1":
			States.capOnBottleAtPos1 = status;
			break;

		case "tableAlignedWithSensor":
			States.tableAlignedWithSensor = status;
			break;
			
		default: 
			System.err.println("Wrong sig name : "+signame);
			System.exit(1);
		}
	}
	
	static final List<String> signames = Arrays.asList("pusherRetractedE","pusherExtendedE","WPgrippedE","armAtSourceE","armAtDestE","emptyE","rotTurn","rotContent", "bottleAtPos5", "tableAlignedWithSensor", "capOnBottleAtPos1");
	
	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	}

}
