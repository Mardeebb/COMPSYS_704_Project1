package org.compsys704;

import java.util.Arrays;
import java.util.List;

import run.BottleTwin;

public class SysJWorker extends Worker{

	@Override
	public void setSignal(boolean status, Object value) {
//		System.out.println(signame+"  "+status);
		switch(signame){
		case "pusherRetractedE":
			Caploader.PUSHER_RETRACTED = status;
			break;
		case "pusherExtendedE":
			if(!Caploader.MAG_EMPTY && !Caploader.PUSHER_EXTENDED)
				Caploader.CAP_READY = true;
			Caploader.PUSHER_EXTENDED = status;
			break;
		case "WPgrippedE":
			if(Caploader.GRIPPED && Caploader.ARM_AT_SOURCE){
				if(!status)
					Caploader.CAP_READY = true;
			}
			Caploader.GRIPPED = status;
			if(Caploader.GRIPPED && Caploader.ARM_AT_SOURCE){
				Caploader.CAP_READY = false;
			}
			break;
		case "armAtSourceE":
			Caploader.ARM_AT_SOURCE = status;
			break;
		case "armAtDestE":
			Caploader.ARM_AT_DEST = status;
			break;
		case "emptyE":
			Caploader.MAG_EMPTY = status;
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
				Caploader.recieveTwin = false;
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
			
		case "dosUnitEvacE":
			Filler.filler_on = status;
			break;			
			
		case "dosUnitFilledE":
			Filler.filler_off = status;
			break;
			
		case "fillID":
	        if (status && value != null) {
	            int id = (int) value;
	            BottleTwin bottle = EABSBackend.getBottleFromID(id);
	            bottle.isFilled = true;
	            bottle.status = "Filled";
	        }
			break;
		case "capOnID":
	        if (status && value != null) {
	            int id = (int) value;
	            BottleTwin bottle = EABSBackend.getBottleFromID(id);
	            bottle.isCapOn = true;
	            bottle.status = "Filled";
	        }
			break;
			
		case "gripperZAxisLoweredE":
			Capper.capper_lowered = status;
			System.err.println(Capper.capper_lowered);
			break;
		
		case "gripperZAxisLiftedE":
			Capper.capper_lifted = status;
			break;
		
		case "gripperTurnHomePosE":
			Capper.gripper_initialpos = status;
			break;
		
		case "gripperTurnFinalPosE":
			Capper.gripper_fullyturned = status;
			break;

		default: 
			System.err.println("Wrong sig name : "+signame);
			System.exit(1);
		}
	}
	
	static final List<String> signames = Arrays.asList("gripperTurnFinalPosE", "gripperTurnHomePosE", "gripperZAxisLiftedE", "gripperZAxisLoweredE", "capOnID", "dosUnitEvacE","dosUnitFilledE","pusherRetractedE","pusherExtendedE","WPgrippedE","armAtSourceE","armAtDestE","emptyE","rotTurn","rotContent", "bottleAtPos5", "tableAlignedWithSensor", "capOnBottleAtPos1","recieveTwin","pos0","pos1","pos5","pos7","conveyorMoving","conveyorStop","fillID");
	
	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	}

}
