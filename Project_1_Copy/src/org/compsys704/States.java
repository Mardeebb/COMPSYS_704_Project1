package org.compsys704;

public class States {
	
	public static volatile boolean ARM_AT_DEST = true;
	public static volatile boolean ARM_AT_SOURCE = !ARM_AT_DEST;
	public static volatile boolean PUSHER_RETRACTED = true;
	public static volatile boolean PUSHER_EXTENDED = !PUSHER_RETRACTED;
	public static volatile boolean GRIPPED = false;
	public static volatile boolean MAG_EMPTY = false;
	public static volatile boolean CAP_READY = false;
	public static volatile int[] RT = {0, 0, 1, 0, 0, 5};
	public static volatile int RT_PS = 0;
	public static volatile boolean bottleAtPos5;
	public static volatile boolean tableAlignedWithSensor;
	public static volatile boolean capOnBottleAtPos1;

}
