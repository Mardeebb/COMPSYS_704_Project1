package org.compsys704;

public class robot {
	public static volatile String cmdL;
	public static volatile String leftArmPosition ="A";
	public static volatile boolean leftArmgrip=true;
	public static volatile String rightArmState ="A";

	public robot(int p){
		robot.leftArmPosition="A";
		robot.leftArmgrip = false;
		

	}
	public static int leftImage (String cmd) {
		
		if(cmd != null) {
//			System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			String[] parts = cmd.split(" ");   // split by space
		    String action = parts[0];          // "limb_moveto"
		    System.err.println(" Action= "+action  );  
		    String target = parts[2];  	       // "B"
		    System.err.println("Target= "+ target);	
		    if(action.equals( "limb_moveto")) {
		    	robot.leftArmPosition=target;
		    }else { // limb_gripper
		    	if (target.equals("open") ){
		    		robot.leftArmgrip=true;
		    	}else {
		    		robot.leftArmgrip=false;
		    	}		    	
		    }
		}
		switch(robot.leftArmPosition) {
		case "A":
			System.err.println("00000000000000000 ");  
			return 0;
		case "B":
			if(robot.leftArmgrip) {
				System.err.println("11111111111111111111111 ");  
				return 1;				
			}else {
				System.err.println("22222222222222222222222222 ");  
				return 2;
			}
		case "C":
			if(robot.leftArmgrip) {
				System.err.println("3333333333333333333333333 ");  
				return 3;
			}else {
				System.err.println("4444444444444444444444444 ");  
				return 4;
			}
		
		}
		return 0;
	}
	
}