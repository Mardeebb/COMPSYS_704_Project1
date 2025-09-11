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
				int pos = TurnTable.RT_PS;
				pos++;
				if (pos == 6) {
					pos = 0;
				}
				TurnTable.RT_PS = pos;
		        if (status && value != null) {
		            int[] val = (int[]) value;
		            TurnTable.RT = val;
		        }
			}
			break;
			
		case "bottleAtPos5":
			TurnTable.bottleAtPos5 = status;
			break;
			
		case "capOnBottleAtPos1":
			TurnTable.capOnBottleAtPos1 = status;
			break;

		case "tableAlignedWithSensor":
			TurnTable.tableAlignedWithSensor = status;
			break;
			
		case "recieveTwin":
			System.err.println("recieveTwin");
			if (status) {
				States.recieveTwin = false;
			}
			break;
		
		case "pos0":
	        if (status && value != null) {
	            int id = (int) value;
				Conveyor.posZeroID = id;
	        }
			break;
			
		case "pos1":
	        if (status && value != null) {
	            int id = (int) value;
				Conveyor.posOneID = id;
	        }
			break;
		case "pos5":
	        if (status && value != null) {
	            int id = (int) value;
				Conveyor.posFiveID = id;
	        }
			break;
		case "pos7":
	        if (status && value != null) {
	            int id = (int) value;
				Conveyor.posSevenID = id;
	        }
			break;
		case "conveyorMoving":
			if (status) {
				Conveyor.moving = true;
			}
			break;
		case "conveyorStop":
			if (status) {
				Conveyor.moving = false;
			}
			break;

			
		default: 
			System.err.println("Wrong sig name : "+signame);
			System.exit(1);
		}
	}
	
	static final List<String> signames = Arrays.asList("pusherRetractedE","pusherExtendedE","WPgrippedE","armAtSourceE","armAtDestE","emptyE","rotTurn","rotContent", "bottleAtPos5", "tableAlignedWithSensor", "capOnBottleAtPos1","recieveTwin","pos0","pos1","pos5","pos7","conveyorMoving","conveyorStop");
	
	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	}

}
