import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1

public class rPlant extends ClockDomain{
  public rPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.OUTPUT);
  public Signal tableAlignedWithSensorC = new Signal("tableAlignedWithSensorC", Signal.OUTPUT);
  public Signal rotTurn = new Signal("rotTurn", Signal.OUTPUT);
  public Signal rotContent = new Signal("rotContent", Signal.OUTPUT);
  private Signal posOne_14;
  private Signal posFive_14;
  private Signal turn_14;
  private int[] packedArray_thread_15;//sysj\plant.sysj line: 125, column: 3
  private int pos_thread_15;//sysj\plant.sysj line: 126, column: 3
  private int pos1_thread_15;//sysj\plant.sysj line: 138, column: 5
  private int pos5_thread_15;//sysj\plant.sysj line: 139, column: 5
  private int[] newPackedArray_thread_15;//sysj\plant.sysj line: 143, column: 5
  private int S2426 = 1;
  private int S2407 = 1;
  private int S2354 = 1;
  private int S2424 = 1;
  
  private int[] ends = new int[17];
  private int[] tdone = new int[17];
  
  public void thread2460(int [] tdone, int [] ends){
        switch(S2424){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        if((Integer)(posOne_14.getpreval() == null ? 0 : ((Integer)posOne_14.getpreval()).intValue()) == 5){//sysj\plant.sysj line: 159, column: 7
          capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 160, column: 5
          currsigs.addElement(capOnBottleAtPos1);
          if((Integer)(posFive_14.getpreval() == null ? 0 : ((Integer)posFive_14.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 162, column: 7
            bottleAtPos5.setPresent();//sysj\plant.sysj line: 163, column: 5
            currsigs.addElement(bottleAtPos5);
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
          }
          else {
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
          }
        }
        else {
          if((Integer)(posFive_14.getpreval() == null ? 0 : ((Integer)posFive_14.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 162, column: 7
            bottleAtPos5.setPresent();//sysj\plant.sysj line: 163, column: 5
            currsigs.addElement(bottleAtPos5);
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
          }
          else {
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
          }
        }
        break;
      
    }
  }

  public void thread2459(int [] tdone, int [] ends){
        switch(S2407){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 135, column: 10
          S2354=0;
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
        else {
          switch(S2354){
            case 0 : 
              if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 136, column: 11
                pos1_thread_15 = packedArray_thread_15[0];//sysj\plant.sysj line: 138, column: 5
                pos5_thread_15 = packedArray_thread_15[4];//sysj\plant.sysj line: 139, column: 5
                rotTurn.setPresent();//sysj\plant.sysj line: 140, column: 5
                currsigs.addElement(rotTurn);
                rotTurn.setValue(packedArray_thread_15);//sysj\plant.sysj line: 140, column: 5
                posOne_14.setPresent();//sysj\plant.sysj line: 141, column: 5
                currsigs.addElement(posOne_14);
                posOne_14.setValue(pos1_thread_15);//sysj\plant.sysj line: 141, column: 5
                posFive_14.setPresent();//sysj\plant.sysj line: 142, column: 5
                currsigs.addElement(posFive_14);
                posFive_14.setValue(pos5_thread_15);//sysj\plant.sysj line: 142, column: 5
                newPackedArray_thread_15 = new int[6];//sysj\plant.sysj line: 143, column: 5
                newPackedArray_thread_15[0] = packedArray_thread_15[5];//sysj\plant.sysj line: 144, column: 5
                for(int i_thread_15 = 1; i_thread_15 < 6; i_thread_15 = i_thread_15 + 1) {//sysj\plant.sysj line: 146, column: 31
                  newPackedArray_thread_15[i_thread_15] = packedArray_thread_15[i_thread_15 - 1];//sysj\plant.sysj line: 147, column: 6
                }
                packedArray_thread_15 = newPackedArray_thread_15;//sysj\plant.sysj line: 149, column: 5
                S2354=1;
                tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 150, column: 5
                currsigs.addElement(tableAlignedWithSensorC);
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              else {
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              break;
            
            case 1 : 
              tableAlignedWithSensorC.setPresent();//sysj\plant.sysj line: 150, column: 5
              currsigs.addElement(tableAlignedWithSensorC);
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread2457(int [] tdone, int [] ends){
        S2424=1;
    if((Integer)(posOne_14.getpreval() == null ? 0 : ((Integer)posOne_14.getpreval()).intValue()) == 5){//sysj\plant.sysj line: 159, column: 7
      capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 160, column: 5
      currsigs.addElement(capOnBottleAtPos1);
      if((Integer)(posFive_14.getpreval() == null ? 0 : ((Integer)posFive_14.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 162, column: 7
        bottleAtPos5.setPresent();//sysj\plant.sysj line: 163, column: 5
        currsigs.addElement(bottleAtPos5);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
      }
      else {
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
      }
    }
    else {
      if((Integer)(posFive_14.getpreval() == null ? 0 : ((Integer)posFive_14.getpreval()).intValue()) != 0){//sysj\plant.sysj line: 162, column: 7
        bottleAtPos5.setPresent();//sysj\plant.sysj line: 163, column: 5
        currsigs.addElement(bottleAtPos5);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
      }
      else {
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
      }
    }
  }

  public void thread2456(int [] tdone, int [] ends){
        S2407=1;
    packedArray_thread_15 = new int[6];//sysj\plant.sysj line: 125, column: 3
    pos_thread_15 = 0;//sysj\plant.sysj line: 126, column: 3
    for(int i_thread_15 = 0; i_thread_15 < 6; i_thread_15 = i_thread_15 + 1) {//sysj\plant.sysj line: 127, column: 29
      packedArray_thread_15[i_thread_15] = 0;//sysj\plant.sysj line: 128, column: 7
    }
    packedArray_thread_15[0] = 5;//sysj\plant.sysj line: 131, column: 6
    packedArray_thread_15[3] = 1;//sysj\plant.sysj line: 132, column: 6
    S2354=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2426){
        case 0 : 
          S2426=0;
          break RUN;
        
        case 1 : 
          S2426=2;
          S2426=2;
          posOne_14.setClear();//sysj\plant.sysj line: 123, column: 2
          posFive_14.setClear();//sysj\plant.sysj line: 123, column: 2
          turn_14.setClear();//sysj\plant.sysj line: 123, column: 2
          thread2456(tdone,ends);
          thread2457(tdone,ends);
          int biggest2458 = 0;
          if(ends[15]>=biggest2458){
            biggest2458=ends[15];
          }
          if(ends[16]>=biggest2458){
            biggest2458=ends[16];
          }
          if(biggest2458 == 1){
            active[14]=1;
            ends[14]=1;
            break RUN;
          }
        
        case 2 : 
          posOne_14.setClear();//sysj\plant.sysj line: 123, column: 2
          posFive_14.setClear();//sysj\plant.sysj line: 123, column: 2
          turn_14.setClear();//sysj\plant.sysj line: 123, column: 2
          thread2459(tdone,ends);
          thread2460(tdone,ends);
          int biggest2461 = 0;
          if(ends[15]>=biggest2461){
            biggest2461=ends[15];
          }
          if(ends[16]>=biggest2461){
            biggest2461=ends[16];
          }
          if(biggest2461 == 1){
            active[14]=1;
            ends[14]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2461 == 0){
            S2426=0;
            active[14]=0;
            ends[14]=0;
            S2426=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    posOne_14 = new Signal();
    posFive_14 = new Signal();
    turn_14 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[14] != 0){
      int index = 14;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[14]!=0 || suspended[14]!=0 || active[14]!=1);
      else{
        if(!df){
          rotaryTableTrigger.gethook();
          df = true;
        }
        runClockDomain();
      }
      rotaryTableTrigger.setpreclear();
      bottleAtPos5.setpreclear();
      tableAlignedWithSensor.setpreclear();
      capOnBottleAtPos1.setpreclear();
      tableAlignedWithSensorC.setpreclear();
      rotTurn.setpreclear();
      rotContent.setpreclear();
      posOne_14.setpreclear();
      posFive_14.setpreclear();
      turn_14.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = rotaryTableTrigger.getStatus() ? rotaryTableTrigger.setprepresent() : rotaryTableTrigger.setpreclear();
      rotaryTableTrigger.setpreval(rotaryTableTrigger.getValue());
      rotaryTableTrigger.setClear();
      bottleAtPos5.sethook();
      bottleAtPos5.setClear();
      tableAlignedWithSensor.sethook();
      tableAlignedWithSensor.setClear();
      capOnBottleAtPos1.sethook();
      capOnBottleAtPos1.setClear();
      tableAlignedWithSensorC.sethook();
      tableAlignedWithSensorC.setClear();
      rotTurn.sethook();
      rotTurn.setClear();
      rotContent.sethook();
      rotContent.setClear();
      posOne_14.setClear();
      posFive_14.setClear();
      turn_14.setClear();
      if(paused[14]!=0 || suspended[14]!=0 || active[14]!=1);
      else{
        rotaryTableTrigger.gethook();
      }
      runFinisher();
      if(active[14] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
